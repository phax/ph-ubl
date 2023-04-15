package com.helger.ubltr;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;

import tr.gov.efatura.package_12.TRPackage;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * The class provides all the UBL TR marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBLTRMarshaller
{
  public static class UBLTRJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    public UBLTRJAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBLTRNamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @Nullable
    public Schema getSchema ()
    {
      return createValidationSchema ();
    }
  }

  private UBLTRMarshaller ()
  {}

  private static final ICommonsList <ClassPathResource> XSD_HRXML_USER_ACCOUNT = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                                          new ClassPathResource (CUBLTR.SCHEMA_DIRECTORY +
                                                                                                                                 "HRXML/UserAccount.xsd",
                                                                                                                                 CUBLTR.getCL ()));

  @Nonnull
  public static UBLTRJAXBMarshaller <CancelUserAccountType> cancelUserAccount ()
  {
    return new UBLTRJAXBMarshaller <> (CancelUserAccountType.class,
                                       XSD_HRXML_USER_ACCOUNT,
                                       tr.gov.efatura.useraccount.ObjectFactory._CancelUserAccount_QNAME);
  }

  @Nonnull
  public static UBLTRJAXBMarshaller <ProcessUserAccountType> processUserAccount ()
  {
    return new UBLTRJAXBMarshaller <> (ProcessUserAccountType.class,
                                       XSD_HRXML_USER_ACCOUNT,
                                       tr.gov.efatura.useraccount.ObjectFactory._ProcessUserAccount_QNAME);
  }

  private static final ICommonsList <ClassPathResource> XSD_PACKAGE = new CommonsArrayList <> ();

  static
  {
    XSD_PACKAGE.addAll (UBL21Marshaller.invoice ().getOriginalXSDs ());
    XSD_PACKAGE.addAll (UBL21Marshaller.applicationResponse ().getOriginalXSDs ());
    XSD_PACKAGE.add (new ClassPathResource (CUBLTR.SCHEMA_DIRECTORY + "Envelope/Package_1_2.xsd", CUBLTR.getCL ()));
  }

  private static final QName QNAME_PACKAGE = new QName (CUBLTR.XML_NS_EFATURA, "Package");

  @Nonnull
  public static UBLTRJAXBMarshaller <TRPackage> trPackage ()
  {
    return new UBLTRJAXBMarshaller <> (TRPackage.class, XSD_PACKAGE, QNAME_PACKAGE);
  }
}
