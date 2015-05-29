/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.ubl.jaxb.plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.xml.sax.ErrorHandler;

import com.helger.commons.annotations.IsSPIImplementation;
import com.helger.commons.collections.CollectionHelper;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JOp;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.Outline;

/**
 * Add special "value" constructors, setters and getters for UBL JAXB generated
 * elements.
 *
 * @author Philip Helger
 */
@IsSPIImplementation
public class PluginUBLValue extends Plugin
{
  public static final String OPT = "Xph-ubl-value";
  // @author is only valid for file comments
  public static final String AUTHOR = "\nCreated by ph-ubl-jaxb-plugin -" + OPT;

  @Override
  public String getOptionName ()
  {
    return OPT;
  }

  @Override
  public String getUsage ()
  {
    return "  -" +
           OPT +
           "    :  create additional constructors with the 'value' as argument + getter and setter for the value";
  }

  @Override
  public List <String> getCustomizationURIs ()
  {
    return CollectionHelper.newUnmodifiableList (CUBLJAXB.NSURI_PH_UBL);
  }

  private void _recursiveAddValueConstructorToDerivedClasses (@Nonnull final Outline aOutline,
                                                              @Nonnull final JDefinedClass jParentClass,
                                                              @Nonnull final JType aValueType,
                                                              @Nonnull final Set <JDefinedClass> aAllRelevantClasses)
  {
    for (final ClassOutline aClassOutline : aOutline.getClasses ())
    {
      final JDefinedClass jClass = aClassOutline.implClass;
      if (jClass._extends () == jParentClass)
      {
        aAllRelevantClasses.add (jClass);
        final JMethod aValueCtor = jClass.constructor (JMod.PUBLIC);
        final JVar aParam = aValueCtor.param (JMod.FINAL, aValueType, "valueParam");
        if (!aValueType.isPrimitive ())
          aParam.annotate (Nullable.class);
        aValueCtor.body ().invoke ("super").arg (aParam);
        aValueCtor.javadoc ().add ("Constructor for value of type " +
                                   aValueType.name () +
                                   " calling super class constructor.");
        aValueCtor.javadoc ()
                  .addParam (aParam)
                  .add ("The value to be set." + (aValueType.isPrimitive () ? "" : " May be <code>null</code>."));
        aValueCtor.javadoc ().add (AUTHOR);

        // Set in all derived classes
        _recursiveAddValueConstructorToDerivedClasses (aOutline, jClass, aValueType, aAllRelevantClasses);
      }
    }
  }

  private void _addValueSetterInUsingClasses (@Nonnull final Outline aOutline,
                                              @Nonnull final JType aValueType,
                                              @Nonnull final Set <JDefinedClass> aAllRelevantClasses)
  {
    for (final ClassOutline aClassOutline : aOutline.getClasses ())
    {
      final JDefinedClass jClass = aClassOutline.implClass;
      for (final JMethod aMethod : CollectionHelper.newList (jClass.methods ()))
        if (aMethod.name ().startsWith ("set"))
        {
          final List <JVar> aParams = aMethod.params ();
          if (aParams.size () == 1 && aAllRelevantClasses.contains (aParams.get (0).type ()))
          {
            final JType aImplType = aParams.get (0).type ();
            final JMethod aSetter = jClass.method (JMod.PUBLIC, aImplType, aMethod.name ());
            aSetter.annotate (Nonnull.class);
            final JVar aParam = aSetter.param (JMod.FINAL, aValueType, "valueParam");
            if (!aValueType.isPrimitive ())
              aParam.annotate (Nullable.class);
            final JVar aObj = aSetter.body ().decl (aImplType,
                                                    "aObj",
                                                    JExpr.invoke ("get" + aMethod.name ().substring (3)));
            final JConditional aIf = aSetter.body ()._if (aObj.eq (JExpr._null ()));
            aIf._then ().assign (aObj, JExpr._new (aImplType).arg (aParam));
            aIf._then ().invoke (aMethod).arg (aObj);
            aIf._else ().invoke (aObj, "setValue").arg (aParam);
            aSetter.body ()._return (aObj);
            aSetter.javadoc ().add ("Special setter with value of type " + aParam.type ().name ());
            aSetter.javadoc ()
                   .addParam (aParam)
                   .add ("The value to be set." + (aValueType.isPrimitive () ? "" : " May be <code>null</code>."));
            aSetter.javadoc ()
                   .addReturn ()
                   .add ("The created intermediary object of type " +
                         aImplType.name () +
                         " and never <code>null</code>");
            aSetter.javadoc ().add (AUTHOR);
          }
        }
    }
  }

  /**
   * Create all getter
   *
   * @param aOutline
   *        JAXB outline
   * @param aAllCtorClasses
   *        Map from class with value (direct and derived) to value type
   */
  private void _addValueGetter (@Nonnull final Outline aOutline,
                                @Nonnull final Map <JDefinedClass, JType> aAllCtorClasses)
  {
    final JCodeModel aCodeModel = aOutline.getCodeModel ();
    for (final ClassOutline aClassOutline : aOutline.getClasses ())
    {
      final JDefinedClass jClass = aClassOutline.implClass;
      for (final JMethod aMethod : CollectionHelper.newList (jClass.methods ()))
        if (aMethod.name ().startsWith ("get") && aMethod.params ().isEmpty ())
        {
          final JType aReturnType = aMethod.type ();
          final JType aValueType = aAllCtorClasses.get (aReturnType);
          if (aValueType != null)
          {
            if (aValueType.isPrimitive ())
            {
              JMethod aGetter;
              JVar aParam;
              if (aValueType == aCodeModel.BOOLEAN)
              {
                // Create the boolean is...Value() method
                aGetter = jClass.method (JMod.PUBLIC, aValueType, "is" + aMethod.name ().substring (3) + "Value");
                aParam = aGetter.param (JMod.FINAL, aValueType, "nullValue");
                final JVar aObj = aGetter.body ().decl (aReturnType, "aObj", JExpr.invoke (aMethod));
                aGetter.body ()._return (JOp.cond (aObj.eq (JExpr._null ()), aParam, aObj.invoke ("isValue")));
              }
              else
              {
                // Create the byte/char/double/float/int/long/short
                // get...Value() method
                aGetter = jClass.method (JMod.PUBLIC, aValueType, aMethod.name () + "Value");
                aParam = aGetter.param (JMod.FINAL, aValueType, "nullValue");
                final JVar aObj = aGetter.body ().decl (aReturnType, "aObj", JExpr.invoke (aMethod));
                aGetter.body ()._return (JOp.cond (aObj.eq (JExpr._null ()), aParam, aObj.invoke ("getValue")));
              }

              // Javadoc
              aGetter.javadoc ().add ("Get the value of the contained " + aReturnType.name () + " object");
              aGetter.javadoc ()
                     .addParam (aParam)
                     .add ("The value to be returned, if the owning object is <code>null</code");
              aGetter.javadoc ()
                     .addReturn ()
                     .add ("Either the value of the contained " +
                           aReturnType.name () +
                           " object or the passed " +
                           aParam.name ());
              aGetter.javadoc ().add (AUTHOR);
            }
            else
            {
              // Create the Object get...Value() method
              final JMethod aGetter = jClass.method (JMod.PUBLIC, aValueType, aMethod.name () + "Value");
              aGetter.annotate (Nullable.class);
              final JVar aObj = aGetter.body ().decl (aReturnType, "aObj", JExpr.invoke (aMethod));
              aGetter.body ()._return (JOp.cond (aObj.eq (JExpr._null ()), JExpr._null (), aObj.invoke ("getValue")));
              aGetter.javadoc ().add ("Get the value of the contained " + aReturnType.name () + " object");
              aGetter.javadoc ()
                     .addReturn ()
                     .add ("Either the value of the contained " + aReturnType.name () + " object or <code>null</code>");
              aGetter.javadoc ().add (AUTHOR);
            }
          }
        }
    }
  }

  /**
   * Main method to create methods for value: constructors, derived
   * constructors, setter and getter.
   *
   * @param aOutline
   *        JAXB Outline
   * @param aOpts
   *        Options
   * @param aErrorHandler
   *        Error handler
   */
  @Override
  public boolean run (@Nonnull final Outline aOutline,
                      @Nonnull final Options aOpts,
                      @Nonnull final ErrorHandler aErrorHandler)
  {
    final Map <JDefinedClass, JType> aAllCtorClasses = new HashMap <JDefinedClass, JType> ();
    for (final ClassOutline aClassOutline : aOutline.getClasses ())
    {
      final JDefinedClass jClass = aClassOutline.implClass;

      // Always add default constructor
      {
        final JMethod aDefCtor = jClass.constructor (JMod.PUBLIC);
        aDefCtor.javadoc ().add ("Default constructor");
        aDefCtor.javadoc ().add (AUTHOR);
      }

      // Create constructor with value (if available)
      JFieldVar aValueField = null;
      for (final JFieldVar aField : jClass.fields ().values ())
        if (aField.name ().equals ("value"))
        {
          aValueField = aField;
          break;
        }
      if (aValueField != null)
      {
        final JType aValueType = aValueField.type ();
        final JMethod aValueCtor = jClass.constructor (JMod.PUBLIC);
        final JVar aParam = aValueCtor.param (JMod.FINAL, aValueType, "valueParam");
        if (!aValueType.isPrimitive ())
          aParam.annotate (Nullable.class);
        aValueCtor.body ().invoke ("setValue").arg (aParam);
        aValueCtor.javadoc ().add ("Constructor for value of type " + aValueType.name ());
        aValueCtor.javadoc ()
                  .addParam (aParam)
                  .add ("The value to be set." + (aValueType.isPrimitive () ? "" : " May be <code>null</code>."));
        aValueCtor.javadoc ().add (AUTHOR);

        // Set constructor in all derived classes
        final Set <JDefinedClass> aAllRelevantClasses = new HashSet <JDefinedClass> ();
        aAllRelevantClasses.add (jClass);
        _recursiveAddValueConstructorToDerivedClasses (aOutline, jClass, aValueType, aAllRelevantClasses);

        for (final JDefinedClass jRelevantClass : aAllRelevantClasses)
          aAllCtorClasses.put (jRelevantClass, aValueType);

        // Add additional setters in all classes that have a setter with one of
        // the relevant classes
        _addValueSetterInUsingClasses (aOutline, aValueType, aAllRelevantClasses);
      }
    }

    // Create all getters
    _addValueGetter (aOutline, aAllCtorClasses);
    return true;
  }
}
