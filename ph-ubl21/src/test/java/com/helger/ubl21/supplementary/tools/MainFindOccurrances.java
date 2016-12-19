package com.helger.ubl21.supplementary.tools;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.ext.CommonsArrayList;
import com.helger.commons.collection.ext.CommonsHashMap;
import com.helger.commons.collection.ext.CommonsHashSet;
import com.helger.commons.collection.ext.ICommonsList;
import com.helger.commons.collection.ext.ICommonsMap;
import com.helger.commons.collection.impl.NonBlockingStack;
import com.helger.commons.string.StringHelper;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;

public class MainFindOccurrances
{
  private static boolean _isSystemClass (@Nonnull final Class <?> aMemberClass)
  {
    final Package aPackage = aMemberClass.getPackage ();
    if (aPackage == null)
    {
      // E.g. for primitive type
      return true;
    }
    final String sPackageName = aPackage.getName ();
    return sPackageName.startsWith ("java.");
  }

  // Cache for all fields of a class (incl. all fields of all super-classes)
  private static ICommonsMap <Class <?>, ICommonsList <Field>> s_aAllFields = new CommonsHashMap<> ();

  /**
   * Get all fields of the specified class and all super classes.
   *
   * @param aClass
   *        Base class
   * @param aList
   *        List to be filled
   */
  private static void _getAllFields (@Nonnull final Class <?> aClass, @Nonnull final ICommonsList <Field> aList)
  {
    aList.addAll (aClass.getDeclaredFields ());

    final Class <?> aSuperClass = aClass.getSuperclass ();
    if (aSuperClass != null && !_isSystemClass (aSuperClass))
      _getAllFields (aSuperClass, aList);
  }

  /**
   * Get all fields of the specified class and all its super classes. This
   * method uses a cache to avoid retrieving the data over and over again.
   *
   * @param aClass
   *        The class to get all fields from
   * @return Never <code>null</code> but maybe empty.
   */
  @Nonnull
  private static ICommonsList <Field> getAllFields (@Nonnull final Class <?> aClass)
  {
    ICommonsList <Field> ret = s_aAllFields.get (aClass);
    if (ret == null)
    {
      ret = new CommonsArrayList<> ();
      _getAllFields (aClass, ret);
      s_aAllFields.put (aClass, ret);
    }
    return ret;
  }

  /**
   * Create an XML name from the passed field. It uses the {@link XmlElement},
   * {@link XmlAttribute} and {@link XmlValue} annotations to differentiate.
   *
   * @param aField
   *        Source field
   * @return Never <code>null</code>.
   */
  @Nonnull
  public static String _getXMLName (@Nonnull final Field aField)
  {
    final XmlElement aElement = aField.getAnnotation (XmlElement.class);
    if (aElement != null)
      return "/" + aElement.name ();
    final XmlAttribute aAttr = aField.getAnnotation (XmlAttribute.class);
    if (aAttr != null)
      return "/@" + aAttr.name ();
    if (aField.getAnnotation (XmlValue.class) != null)
      return "/value()";
    throw new IllegalStateException ("Field is neither XML element nor attribute nor value: " + aField);
  }

  private static final class PerClassData
  {
    private static final class MemberData
    {
      private final Class <?> m_aClass;
      private final String m_sXMLName;

      public MemberData (@Nonnull final Field aField, @Nonnull final Class <?> aClass)
      {
        m_aClass = aClass;
        m_sXMLName = _getXMLName (aField);
      }
    }

    ICommonsList <Field> m_aMatches = new CommonsArrayList<> ();
    ICommonsList <MemberData> m_aMembers = new CommonsArrayList<> ();
  }

  private static ICommonsMap <Class <?>, PerClassData> s_aClassCache = new CommonsHashMap<> ();

  private static final class StackElement
  {
    @SuppressWarnings ("unused")
    final Class <?> m_aClass;
    final String m_sXMLName;

    public StackElement (@Nonnull final Class <?> aClass, @Nonnull final String sXMLName)
    {
      m_aClass = ValueEnforcer.notNull (aClass, "Class");
      m_sXMLName = ValueEnforcer.notEmpty (sXMLName, "XMLName");
    }
  }

  @Nonnull
  public static PerClassData _createPerClassData (@Nonnull final Class <?> aStartClass,
                                                  @Nonnull final Class <?> aFindClass)
  {
    final PerClassData aPerClassData = new PerClassData ();
    for (final Field aField : getAllFields (aStartClass))
    {
      Class <?> aMemberClass = aField.getType ();
      if (List.class.isAssignableFrom (aMemberClass))
      {
        // Get type of List
        final Type aGenericFieldType = aField.getGenericType ();
        aMemberClass = (Class <?>) ((ParameterizedType) aGenericFieldType).getActualTypeArguments ()[0];
      }

      // Matching class?
      if (aMemberClass.equals (aFindClass))
        aPerClassData.m_aMatches.add (aField);

      // Recurse into class?
      if (!_isSystemClass (aMemberClass))
        aPerClassData.m_aMembers.add (new PerClassData.MemberData (aField, aMemberClass));
    }
    return aPerClassData;
  }

  private static int i = 0;

  private static void _findAllRecursive (@Nonnull final Class <?> aStartClass,
                                         @Nonnull final Class <?> aFindClass,
                                         @Nonnull @Nonempty final String sXMLName,
                                         @Nonnull final NonBlockingStack <StackElement> aStack,
                                         @Nonnull final Set <Class <?>> aUniqueClasses)
  {
    // Avoid endless loop, if the same type is already part of the stack
    if (aUniqueClasses.add (aStartClass))
    {
      aStack.push (new StackElement (aStartClass, sXMLName));

      // Find per-class data
      PerClassData aPerClassData = s_aClassCache.get (aStartClass);
      if (aPerClassData == null)
      {
        aPerClassData = _createPerClassData (aStartClass, aFindClass);
        s_aClassCache.put (aStartClass, aPerClassData);
      }

      // Recursive always, even if data is from cache
      for (final PerClassData.MemberData aMemberData : aPerClassData.m_aMembers)
        _findAllRecursive (aMemberData.m_aClass, aFindClass, aMemberData.m_sXMLName, aStack, aUniqueClasses);

      if (aPerClassData.m_aMatches.isNotEmpty ())
      {
        // Found matching members
        final String sPrefix = StringHelper.getImplodedMapped (aStack, x -> x.m_sXMLName);
        if (false)
          for (final Field aField : aPerClassData.m_aMatches)
            System.out.println (++i + sPrefix + _getXMLName (aField));
      }

      aStack.pop ();
      aUniqueClasses.remove (aStartClass);
    }
  }

  public static void findAll (final Class <?> aStartClass, final Class <?> aFindClass)
  {
    final NonBlockingStack <StackElement> aStack = new NonBlockingStack<> ();
    _findAllRecursive (aStartClass,
                       aFindClass,
                       StringHelper.trimEnd (aStartClass.getSimpleName (), "Type"),
                       aStack,
                       new CommonsHashSet<> ());
  }

  public static void main (final String [] args)
  {
    findAll (OrderType.class, TaxSchemeType.class);
  }
}
