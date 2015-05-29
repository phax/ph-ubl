#ph-ubl

Set of Java libraries for reading and writing OASIS UBL 2.0 and 2.1 documents.
This is the successor of the phloc-ubl library.
The following projects are contained:

  * **ph-ubl-jaxb-plugin** a special JAXB 2.2 plugin that creates additional methods for easier usage.
  * **ph-ubl20** contains ONLY the generated JAXB files for UBL 2.0.
  * **ph-ubl20-codelists** contains the generated enums for the UBL 2.0 codelists
  * **ph-ubl21** contains ONLY the generated JAXB files for UBL 2.1
  * **ph-ubl21-codelists** contains the generated enums for the UBL 2.1 codelists
  * **ph-ubl** is the main project and contains the glue that combines all these JAR files (e.g. UBL20Reader, UBL20Writer etc.)
  
#Examples

An example for reading and writing UBL 2.0 files can be found in the test file [FuncTestUBL20.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl/src/test/java/com/helger/ubl/FuncTestUBL20.java).

An example for reading and writing UBL 2.1 files can be found in the test file [FuncTestUBL21.java](https://github.com/phax/ph-ubl/blob/master/ph-ubl/src/test/java/com/helger/ubl/FuncTestUBL21.java).

#Maven usage
Add the following to your pom.xml to use this artifact:

```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl</artifactId>
  <version>3.3.0</version>
</dependency>
```

#Download
Binary versions of the artefacts can be downloaded from Maven Central:

  * [http://repo1.maven.org/maven2/com/helger/ph-ubl-jaxb-plugin/]
  * [http://repo1.maven.org/maven2/com/helger/ph-ubl20/]
  * [http://repo1.maven.org/maven2/com/helger/ph-ubl20-codelists/]
  * [http://repo1.maven.org/maven2/com/helger/ph-ubl21/]
  * [http://repo1.maven.org/maven2/com/helger/ph-ubl21-codelists/]
  * [http://repo1.maven.org/maven2/com/helger/ph-ubl/]

---

On Twitter: <a href="https://twitter.com/philiphelger">Follow @philiphelger</a>
