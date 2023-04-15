package com.helger.ublpe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl20.CUBL20;
import com.helger.ubl20.UBL20Marshaller;
import com.helger.ubl20.UBL20Marshaller.UBL20JAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

/**
 * The class provides all the UBL PE marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBLPEMarshaller
{
  public static class UBLPEJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    public UBLPEJAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBLPENamespaceContext.getInstance ().getClone ();
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

  private UBLPEMarshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY + sXSDPath, CUBLPE.getCL ());
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return UBL20Marshaller.applicationResponse ();
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return UBL20Marshaller.creditNote ();
  }

  @Nonnull
  public static UBL20JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return UBL20Marshaller.debitNote ();
  }

  @Nonnull
  public static UBL20JAXBMarshaller <InvoiceType> invoice ()
  {
    return UBL20Marshaller.invoice ();
  }

  @Nonnull
  public static UBLPEJAXBMarshaller <SummaryDocumentsType> summaryDocuments ()
  {
    return new UBLPEJAXBMarshaller <> (SummaryDocumentsType.class,
                                       new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
                                                                CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE,
                                                                CUBL20.XSD_CODELIST_CURRENCY_CODE,
                                                                CUBL20.XSD_CODELIST_LANGUAGE_CODE,
                                                                CUBL20.XSD_UNQUALIFIED_DATA_TYPES,
                                                                CUBL20.XSD_QUALIFIED_DATA_TYPES,
                                                                CUBL20.XSD_COMMON_BASIC_COMPONENTS,
                                                                CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                CUBL20.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                       "common/UBLPE-SunatAggregateComponents-1.0.xsd",
                                                                                       CUBLPE.getCL ()),
                                                                new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                       "maindoc/UBLPE-SummaryDocuments-1.0.xsd",
                                                                                       CUBLPE.getCL ())),
                                       sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.ObjectFactory._SummaryDocuments_QNAME);
  }

  @Nonnull
  public static UBLPEJAXBMarshaller <VoidedDocumentsType> voidedDocuments ()
  {
    return new UBLPEJAXBMarshaller <> (VoidedDocumentsType.class,
                                       new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
                                                                CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE,
                                                                CUBL20.XSD_CODELIST_CURRENCY_CODE,
                                                                CUBL20.XSD_CODELIST_LANGUAGE_CODE,
                                                                CUBL20.XSD_UNQUALIFIED_DATA_TYPES,
                                                                CUBL20.XSD_QUALIFIED_DATA_TYPES,
                                                                CUBL20.XSD_COMMON_BASIC_COMPONENTS,
                                                                CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                CUBL20.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                       "common/UBLPE-SunatAggregateComponents-1.0.xsd",
                                                                                       CUBLPE.getCL ()),
                                                                new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                       "maindoc/UBLPE-VoidedDocuments-1.0.xsd",
                                                                                       CUBLPE.getCL ())),
                                       sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory._VoidedDocuments_QNAME);
  }
}
