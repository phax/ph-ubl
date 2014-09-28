#ph-ubl

Java library for reading and writing UBL 2.0 and 2.1 documents. The following projects are related:

  * phloc-ubl20 contains ONLY the generated JAXB files for UBL 2.0.
  * phloc-ubl20-codelists contains the generated enums for the UBL 2.0 codelists
  * phloc-ubl21 contains ONLY the generated JAXB files for UBL 2.1
  * phloc-ubl21-codelists contains the generated enums for the UBL 2.1 codelists
  * phloc-ubl (this project) contains the glue that combines all these JAR files (e.g. UBL20Reader, UBL20Writer etc.)
  
#Examples

An example for reading and writing UBL 2.0 files can be found in the test file [FuncTestUBL20.java](https://github.com/phax/ph-ubl/blob/master/src/test/java/com/helger/ubl/FuncTestUBL20.java).

An example for reading and writing UBL 2.1 files can be found in the test file [FuncTestUBL21.java](https://github.com/phax/ph-ubl/blob/master/src/test/java/com/helger/ubl/FuncTestUBL21.java).

#Maven usage
Add the following to your pom.xml to use this artifact:
```
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-ubl</artifactId>
  <version>3.3.0</version>
</dependency>
```

---

On Twitter: <a href="https://twitter.com/philiphelger">Follow @philiphelger</a>
