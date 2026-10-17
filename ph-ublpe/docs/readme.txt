Sources (SUNAT - Peruvian tax authority):

* Facturador SUNAT (SFS), a free application distributed by SUNAT. It validates the XML documents
  against the UBL 2.0 / UBLPE XSDs that are shipped inside the application
  (folder sunat_archivos/sfs/VALI/commons/xsd/{2.0,2.1}/)
  - Download page: https://orientacion.sunat.gob.pe/6790-07-descarga-del-facturador
  - Direct download: http://www2.sunat.gob.pe/facturador/SFS_v1.3.2.zip (93 MB, last modified 2024-08-10)
  - Overview:      https://cpe.sunat.gob.pe/sistema_emision/facturador_sunat
  - Structures:    https://orientacion.sunat.gob.pe/sites/default/files/inline-files/AnexosIyII_Formato1.3.4.xlsx
    (flat file layouts, not XSDs)

SFS_v1.3.2-xsd.zip in this folder is a stripped copy of the original ZIP: only the *.xsd files below
SFS_v1.3.2/sunat_archivos/sfs/VALI/commons/ were kept, and only of the folders xsd/2.0/{common,maindoc}
and xsd/2.1/{common,maindoc}. Not copied: the application itself, the older duplicates in
xsd/2.0/main (2016) and everything else. Files are unmodified.
Note: SUNAT does not label these as "the official schemas" on a download page of their own. They are the
validation schemas of SUNAT's own application, and no other SUNAT source for the UBLPE XSDs was found.

Why the SUNAT schemas are based on UBL 2.0 (checked 2026-10-17):

* SUNAT has no UBL 2.1 version of SummaryDocuments/VoidedDocuments. Apart from the plain UBL 2.1 XSDs, the
  "2.1" folder of the SFS ZIP only contains common/UBLPE-SunatAggregateComponents-1.1.xsd (2016-09-15),
  which is not usable: it references the undefined type "PartyType".
* UBLPE-SunatAggregateComponents (both 2.0 and 2.1 folder) uses components that exist in the UBL 2.0
  CommonBasicComponents only (cbc:Indicator, cbc:IndicatorType, cbc:DeliveryDate, cbc:DeliveryTimeType).
  They are missing in UBL 2.1, so the schema cannot be compiled against ph-ubl21.
* Therefore the module is split: Invoice, CreditNote, DebitNote and ApplicationResponse are UBL 2.1
  (ph-ubl21) and SummaryDocuments/VoidedDocuments including the SUNAT extension are UBL 2.0 (ph-ubl20).
  Both episodes cannot be used in the JAXB code generation (conflicting bindings of the same namespaces),
  so the pom only uses ph-ubl20 as an episode.

Changes to the original files in src/main/resources/external/schemas/ublpe20:

* common/UBLPE-SunatAggregateComponents-1.1.xsd (from the "2.0" folder, replaces the old
  UBLPE-SunatAggregateComponents-1.0.xsd of 2012)
  - the "schemaLocation" attributes of its 4 xsd:import elements were removed, because the JAXB code
    generation resolves these namespaces via src/main/jaxb/catalog-ublpe20.txt
  - the line endings were changed from CRLF to LF
* maindoc/UBLPE-SummaryDocuments-1.0.xsd and maindoc/UBLPE-VoidedDocuments-1.0.xsd:
  - the "schemaLocation" attributes of the UBL xsd:import elements were removed (as above)
  - the xsd:import of the SUNAT extension schema points to UBLPE-SunatAggregateComponents-1.1.xsd
    instead of 1.0
* src/main/jaxb/bindings-ublpe20.xjb renames the SAC complexType "DocumentReferenceType" to
  "SunatDocumentReferenceType", because it clashes with cac:DocumentReferenceType in the generated
  ObjectFactory (JSpecify annotations are not possible on the resulting fully qualified names)

Differences between the SUNAT SunatAggregateComponents and the previously bundled file:

* The previously bundled file had 19 element/complexType declarations, SUNAT's 1.1 has 105
  (despatch advice, transport, perception/retention information, gold trading, aquatic resources,
  SoftwareID, ...). Nothing of the old file is missing in SUNAT's.
* 1.1 does not contain the element "SUNATTotalPaidBeforeRounding" of 1.0 (same namespace
  "...SunatAggregateComponents-1")
* Not bundled at all: maindoc/UBLPE-Invoice, -CreditNote, -DebitNote, -Perception, -Retention,
  -ApplicationResponse (all 1.0)

How to check for an update:

1. Download SFS_vX.Y.Z.zip from the download page above (the version number is part of the file name).
2. Compare sunat_archivos/sfs/VALI/commons/xsd/{2.0,2.1}/{common,maindoc}/*.xsd with the ZIP in this folder.
3. Only if the XSDs changed, update src/main/resources/external/schemas/ublpe20 and add a new stripped ZIP.
