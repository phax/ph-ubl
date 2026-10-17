Sources (Croatian Tax Administration, Fiskalizacija 2.0 - https://porezna.gov.hr/fiskalizacija/bezgotovinski-racuni/eracun):

* "UBL2.1 eRacun" (published 15.04.2026), downloaded on 2026-10-14 from
  https://porezna.gov.hr/fiskalizacija/api/dokumenti/198
  - contains the UBL 2.1 XSDs adapted for the Croatian eRacun plus the XSD of the Croatian extension
    "HRExtensionAggregateComponents-1.xsd" (namespace urn:mfin.gov.hr:schema:xsd:HRExtensionAggregateComponents-1)
  - only the XSD of the extension is used by this module; the UBL itself comes from ph-ubl21

* "Primjeri eRacuna" (published 12.12.2025), downloaded on 2026-10-14 from
  https://porezna.gov.hr/fiskalizacija/api/dokumenti/158
  - the example files in src/test/resources/external/test-hr are unmodified copies of the examples of this package that
    contain the extension (plus the credit note "Odobrenje.xml")

* "Specifikacija osnovne uporabe eRacuna s prosirenjima" (published 12.03.2026)
  https://porezna.gov.hr/fiskalizacija/api/dokumenti/196
  - the specification of the CIUS-HR and the extension EXT-HR (customization ID
    urn:cen.eu:en16931:2017#compliant#urn:mfin.gov.hr:cius-2025:1.0#conformant#urn:mfin.gov.hr:ext-2025:1.0)

Changes to the original files:

* src/main/resources/external/schemas/hr/common/HRExtensionAggregateComponents-1.xsd
  The 2 "schemaLocation" attributes of the xsd:import elements for UBL-CommonBasicComponents-2.1.xsd and
  UBL-UnqualifiedDataTypes-2.1.xsd were removed, because the JAXB code generation resolves these namespaces to the
  files of ph-ubl21 via src/main/jaxb/catalog-hr.txt (the same way as for the other modules). Nothing else was changed.
