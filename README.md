# ph-ubl

[![Build Status](https://travis-ci.org/phax/ph-ubl.svg?branch=master)](https://travis-ci.org/phax/ph-ubl)
﻿
This is the readme file for version 5.x or later.

Set of Java libraries for reading and writing OASIS UBL 2.0, 2.1, 2.2 and 2.3 documents.
The following projects are contained:

* **ph-ubl-testfiles** contains all UBL test files (used only in Maven test scope)
* **ph-ubl-api** base library containing common stuff for UBL 2.0 and 2.1.
* **ph-ubl20** contains the generated JAXB files for UBL 2.0 as well as the helper classes.
* **ph-ubl20-codelists** contains the generated enums for the UBL 2.0 codelists (optional artefact)
* **ph-ubl21** contains the generated JAXB files for UBL 2.1 as well as the helper classes.
* **ph-ubl21-codelists** contains the generated enums for the UBL 2.1 codelists (optional artefact)
* **ph-ubl22** contains the generated JAXB files for UBL 2.2 as well as the helper classes.
* **ph-ubl22-codelists** contains the generated enums for the UBL 2.2 codelists (optional artefact)
* **ph-ubl23** contains the generated JAXB files for UBL 2.3 as well as the helper classes.
* **ph-ubl23-codelists** contains the generated enums for the UBL 2.3 codelists (optional artefact)
* **ph-ubltr** contains the generated JAXB files UBL-tr - the Turkish e-Invoice (optional artefact)
* **ph-ublpe** contains the generated JAXB files for UBLPE #openinvoiceperu (optional artefact)
* **ph-ubl-dian** contains the generated JAXB files for the Colombian e-Invoice (optional artefact)

Old projects:

* **ph-ubl-jaxb-plugin** a special JAXB 2.2 plugin that creates additional methods for easier usage
    (used only in Maven generate-sources phase) - this plugin was only available until v6.1.0.
    It was moved to [ph-jaxb22-plugin]() v2.3.1.3. The option `ph-ubl-value` was
    renamed to `ph-value-extender` in the new project so that it can be used in other projects.
  
# News and noteworthy

* v6.2.1 - work in progress
    * Added predefined constants for shared XSDs in the `CUBL..` classes
    * Fixed a classloader issue in ph-ublpe in OSGI environments
    * Started new subproject `ph-ubl-dian` for the Colombian eInvoice
        * Based on https://www.dian.gov.co/fizcalizacioncontrol/herramienconsulta/FacturaElectronica/Documents/Caja_de_herramientas_Factura_Electronica_Validacion_Previa.zip
* v6.2.0 - 2019-11-05
    * Added support for UBL 2.3 CSPRD01
* v6.1.3 - 2019-10-17
    * Added classes `UBL20InvoiceHelper`, `UBL20CreditNoteHelper`, `UBL21InvoiceHelper`, `UBL21CreditNoteHelper`, `UBL22InvoiceHelper` and `UBL22CreditNoteHelper` to allow for easy "type conversion"
* v6.1.2 - 2019-05-07
    * Added Java 12 support
* v6.1.1 - 2019-01-26
    * The `ph-ubl-jaxb-plugin` was moved to `ph-jaxb22-plugin` and is discontinued in here
* v6.1.0 - 2018-11-22
    * Requires at least ph-commons 9.2.0
* v6.0.2 - 2018-07-17
    * Added ph-ublpe suppport
    * Updated to UBL 2.2 final (from http://docs.oasis-open.org/ubl/os-UBL-2.2/UBL-2.2.zip)
* v6.0.1 - 2018-04-03
    * Updated to UBL 2.2 CS 01
* v6.0.0 - 2018-01-09
    * Binds to ph-commons 9.0.0
    * Added initial UBL 2.2 CSPRD02 support
    * Fixes issues #11
* v5.1.0 - 2016-09-09
    * Binds to ph-commons 8.5.x
* v5.0.3 - 2016-07-26
* v5.0.1 - 2016-07-22 
* v5.0.0 - 2016-06-11
    * Binds to ph-commons 8.x 
* v4.5.0 - 2015-11-30
    * New API that this more flexible and contains less overloads - see the examples
    * Added the possibility to easily customize the namespace prefix mapping and other things
* v4.0.0 - 2015-07-28
    * Restructured artefacts to use an "include on demand" instead of an "exclude on demand" pattern
    * Improved OSGI support

# Examples

An example for reading and writing UBL 2.0 files can be found in the test file [UBL20FuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl20/src/test/java/com/helger/ubl20/UBL20FuncTest.java).
An example to create an invoice from scratch can be found in the test code [CreateInvoiceFromScratchFuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl20/src/test/java/com/helger/ubl20/CreateInvoiceFromScratchFuncTest.java).

An example for reading and writing UBL 2.1 files can be found in the test file [UBL21FuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl21/src/test/java/com/helger/ubl21/UBL21FuncTest.java).
An example to create an invoice from scratch can be found in the test code [CreateInvoiceFromScratchFuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl21/src/test/java/com/helger/ubl21/CreateInvoiceFromScratchFuncTest.java).

# Maven usage generic

You can use ph-ubl as a BOM (bill of material) when you include the following in the `dependencyManagement` section of your POM:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl-parent-pom</artifactId>
  <version>6.2.0</version>
  <type>pom</type>
  <scope>import</scope>
</dependency>
```

# Maven usage UBL 2.0

To read and write UBL 2.0 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl20</artifactId>
  <version>6.2.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.0 codelists add the following artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl20-codelists</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage UBL 2.1

To read and write UBL 2.1 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl21</artifactId>
  <version>6.2.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.1 codelists add the following artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl21-codelists</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage UBL 2.2

To read and write UBL 2.2 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl22</artifactId>
  <version>6.2.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.2 codelists add the following artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl22-codelists</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage UBL 2.3

To read and write UBL 2.3 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl23</artifactId>
  <version>6.2.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.3 codelists add the following artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl23-codelists</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage UBL-tr

To read and write UBL-tr (http://www.ubltr.com/) documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubltr</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage UBL-PE

To read and write UBL-PE 2.0 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ublpe</artifactId>
  <version>6.2.0</version>
</dependency>
```

# Maven usage Dian UBL

To read and write Dian UBL 2.1 documents add the following to your pom.xml to use this artifact:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl-dian</artifactId>
  <version>6.2.1-SNAPSHOT</version>
</dependency>
```

# Gradle considerations

This project relies on JDK version based Maven profile activation.
See https://github.com/phax/ph-jaxb-pom#gradle-usage for help on this specific issue. 

# Download
Binary versions of the artefacts can be downloaded from Maven Central:

* https://repo1.maven.org/maven2/com/helger/ph-ubl-testfiles/
* https://repo1.maven.org/maven2/com/helger/ph-ubl-api/
* https://repo1.maven.org/maven2/com/helger/ph-ubl20/
* https://repo1.maven.org/maven2/com/helger/ph-ubl20-codelists/
* https://repo1.maven.org/maven2/com/helger/ph-ubl21/
* https://repo1.maven.org/maven2/com/helger/ph-ubl21-codelists/
* https://repo1.maven.org/maven2/com/helger/ph-ubl22/
* https://repo1.maven.org/maven2/com/helger/ph-ubl22-codelists/
* https://repo1.maven.org/maven2/com/helger/ph-ubl23/
* https://repo1.maven.org/maven2/com/helger/ph-ubl23-codelists/
* https://repo1.maven.org/maven2/com/helger/ph-ublpe/
* https://repo1.maven.org/maven2/com/helger/ph-ubltr/
* https://repo1.maven.org/maven2/com/helger/ph-ubl-dian/

Old artefacts:

* http://repo1.maven.org/maven2/com/helger/ph-ubl-jaxb-plugin/
  
The following projects are required at runtime. The exact version depends on the ph-ubl version you are using:

* https://repo1.maven.org/maven2/com/helger/ph-commons/
* https://repo1.maven.org/maven2/org/slf4j/slf4j-api/
* https://repo1.maven.org/maven2/com/google/code/findbugs/annotations/ (optional - annotations only)

# Other UBL sites

For further information on the Universal Business Language can be found on the following pages:

* https://www.oasis-open.org/committees/ubl/
    * UBL 2.0: https://docs.oasis-open.org/ubl/os-UBL-2.0/ 
    * UBL 2.1: https://docs.oasis-open.org/ubl/os-UBL-2.1/ 
    * UBL 2.2: https://docs.oasis-open.org/ubl/os-UBL-2.2/ 
    * UBL 2.3: https://docs.oasis-open.org/ubl/csprd01-UBL-2.3/ 
* http://ubl.xml.org
* http://goubl.com
* http://www.ubltr.com/

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a> |
Kindly supported by [YourKit Java Profiler](https://www.yourkit.com)