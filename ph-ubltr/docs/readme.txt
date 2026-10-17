Sources (Turkish Revenue Administration, GIB e-Belge portal):

https://ebelge.gib.gov.tr/anasayfa.html
https://ebelge.gib.gov.tr/duyurular.html   (announcements; search for "Fatura" and find the correct ZIP)

Current packages (always the latest version, no version in the file name):

* https://ebelge.gib.gov.tr/dosyalar/kilavuzlar/e-FaturaPaketi.zip
  - contains xsd/ (the XSDs used by this module), schematron/ (incl. History.txt), wsdl/, xml/ (samples)
  - saved here as e-FaturaPaketi-YYYYMMDD.zip, YYYYMMDD = last entry in schematron/History.txt
* https://ebelge.gib.gov.tr/dosyalar/kilavuzlar/UBL-TR1.2.1_Paketi.zip
  - contains xsdrt/ (UBL 2.1 runtime XSDs), xml/ (samples)
  - saved here under the same name (replaced in place)

How to check for an update:

1. Download both ZIPs and compare them with the files in this folder (shasum).
2. Extract with "ditto -x -k" (unzip and Python zipfile choke on the non-ASCII file names).
3. Diff e-FaturaPaketi/xsd and UBLTR_1.2.1_Paketi/xsdrt against the previous package.
   Only if the XSDs changed, update src/main/resources/external/schemas/ubltr.
   Bundled changes to the originals: Envelope/Package_1_2.xsd has the "schemaLocation" attributes
   of its 4 UBL xs:import elements removed.

Checked against the portal on 2026-10-17:

* XSDs unchanged since e-FaturaPaketi-20230101 (only Schematron, code lists and samples changed)
