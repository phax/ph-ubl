#ph-ubl 4.5.0

[![Build Status](https://travis-ci.org/phax/ph-ubl.svg?branch=master)](https://travis-ci.org/phax/ph-ubl)
﻿

This is the readme file for the current version 5.x - for the old version 3.3.x please see [README-v3.3.md](https://github.com/phax/ph-ubl/blob/master/README-v3.3.md).

Set of Java libraries for reading and writing OASIS UBL 2.0 and 2.1 documents.
This is the successor of the phloc-ubl library.
The following projects are contained:

  * **ph-ubl-jaxb-plugin** a special JAXB 2.2 plugin that creates additional methods for easier usage (used only in Maven generate-sources phase) 
  * **ph-ubl-testfiles** contains all UBL 2.0 and 2.1 test files (used only in Maven test scope)
  * **ph-ubl-api** base library containing common stuff for UBL 2.0 and 2.1.
  * **ph-ubl20** contains the generated JAXB files for UBL 2.0 as well as the helper classes.
  * **ph-ubl20-codelists** contains the generated enums for the UBL 2.0 codelists (optional artefact)
  * **ph-ubl21** contains the generated JAXB files for UBL 2.1 as well as the helper classes.
  * **ph-ubl21-codelists** contains the generated enums for the UBL 2.1 codelists (optional artefact)
  
##News and noteworthy

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

#Examples

An example for reading and writing UBL 2.0 files can be found in the test file [UBL20FuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl20/src/test/java/com/helger/ubl20/UBL20FuncTest.java).

An example for reading and writing UBL 2.1 files can be found in the test file [UBL21FuncTest.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl21/src/test/java/com/helger/ubl21/UBL21FuncTest.java).

#Maven usage generic
You can use ph-ubl as a BOM (bill of material) when you include the following in the `dependencyManagement` section of your POM:
```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl-parent-pom</artifactId>
  <version>5.1.0</version>
  <type>pom</type>
  <scope>import</scope>
</dependency>
```

#Maven usage UBL 2.0
To read and write UBL 2.0 documents add the following to your pom.xml to use this artifact:

```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl20</artifactId>
  <version>5.1.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.0 codelists add the following artifact:

```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl20-codelists</artifactId>
  <version>5.1.0</version>
</dependency>
```

#Maven usage UBL 2.1
To read and write UBL 2.1 documents add the following to your pom.xml to use this artifact:

```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl21</artifactId>
  <version>5.1.0</version>
</dependency>
```

To also use the generated enums for the UBL 2.1 codelists add the following artifact:

```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl21-codelists</artifactId>
  <version>5.1.0</version>
</dependency>
```

#Download
Binary versions of the artefacts can be downloaded from Maven Central:

  * http://repo1.maven.org/maven2/com/helger/ph-ubl-jaxb-plugin/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl-testfiles/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl-api/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl20/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl20-codelists/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl21/
  * http://repo1.maven.org/maven2/com/helger/ph-ubl21-codelists/
  
The following projects are required at runtime. The exact version depends on the ph-ubl version you are using:

  * http://repo1.maven.org/maven2/com/helger/ph-commons/
  * http://repo1.maven.org/maven2/org/slf4j/slf4j-api/
  * http://repo1.maven.org/maven2/com/google/code/findbugs/annotations/ (optional - annotations only)

#Other UBL sites

For further information on the Universal Business Language can be found on the following pages:

  * https://www.oasis-open.org/committees/ubl/
  * http://ubl.xml.org
  * http://goubl.com

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodeingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
