package com.helger.dianubl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import dian.gov.co.facturaelectronica.structures_2_1.DianExtensionsType;
import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * The class provides all the Dian UBL marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class DianUBLMarshaller
{
  public static class DianUBLJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private static final ICommonsList <ClassPathResource> DIAN_XSDS = new CommonsArrayList <> (CUBL21.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                               CUBL21.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                                               CDianUBL.XSD_DIAN_UBL_STRUCTURE);

    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nonnull final ICommonsList <ClassPathResource> aList)
    {
      final ICommonsList <ClassPathResource> ret = new CommonsArrayList <> ();
      // Copy everything EXCEPT the last item
      if (aList.size () > 1)
        ret.addAll (aList.subList (0, aList.size () - 1));
      // Inject DIAN stuff in the middle
      ret.addAll (DIAN_XSDS);
      // Add the root element last
      ret.add (aList.getLast ());
      return ret;
    }

    public DianUBLJAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                  @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                  @Nonnull final QName aRootElementQName)
    {
      super (aType,
             aSourceXSDs == null ? DIAN_XSDS : getAllXSDs (aSourceXSDs),
             createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = DianUBLNamespaceContext.getInstance ().getClone ();
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

  private DianUBLMarshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CDianUBL.SCHEMA_DIRECTORY + sXSDPath, CDianUBL.getCL ());
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new DianUBLJAXBMarshaller <> (ApplicationResponseType.class,
                                         UBL21Marshaller.applicationResponse ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new DianUBLJAXBMarshaller <> (AttachedDocumentType.class,
                                         UBL21Marshaller.attachedDocument ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.attacheddocument_21.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new DianUBLJAXBMarshaller <> (CreditNoteType.class,
                                         UBL21Marshaller.creditNote ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.creditnote_21.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new DianUBLJAXBMarshaller <> (DebitNoteType.class,
                                         UBL21Marshaller.debitNote ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.debitnote_21.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <DianExtensionsType> dianExtensions ()
  {
    return new DianUBLJAXBMarshaller <> (DianExtensionsType.class,
                                         null,
                                         dian.gov.co.facturaelectronica.structures_2_1.ObjectFactory._DianExtensions_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <InvoiceType> invoice ()
  {
    return new DianUBLJAXBMarshaller <> (InvoiceType.class,
                                         UBL21Marshaller.invoice ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.invoice_21.ObjectFactory._Invoice_QNAME);
  }
}
