/*
 * Copyright (C) 2021-2023 Jonatan Sunden
 * Copyright (C) 2021-2023 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.eforms;

import javax.xml.namespace.QName;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.eforms.jaxb.ext.EformsExtension;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl23.CUBL23;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * A specific JAXB marshaller for the EForms extension. This class is only used
 * internally, but it may be helpful for external callers in rare circumstances.
 *
 * @author Philip Helger
 * @since 6.7.0
 * @deprecated Use {@link EformsUBLMarshaller#eFormsExtension()} instead
 */
@Deprecated (forRemoval = true, since = "8.0.0")
public class EFormsExtensionMarshaller extends GenericJAXBMarshaller <EformsExtension>
{
  public EFormsExtensionMarshaller ()
  {
    super (EformsExtension.class,
           new CommonsArrayList <> (CCCTS.getXSDResource (),
                                    CXMLDSig.getXSDResource (),
                                    CXAdES132.getXSDResource (),
                                    CXAdES141.getXSDResource (),
                                    CUBL23.XSD_COMMON_AGGREGATE_COMPONENTS,
                                    CEformsUBL.XSD_EFORMS_EXTENSION_BASIC_COMPONENTS,
                                    CEformsUBL.XSD_EFORMS_EXTENSION_AGGREGATE_COMPONENTS,
                                    CEformsUBL.XSD_EFORMS_EXTENSION_APEX),
           createSimpleJAXBElement (new QName (CEformsUBL.XML_SCHEMA_EFEXT_NAMESPACE_URL, "EformsExtension"),
                                    EformsExtension.class));
    setNamespaceContext (EformsUBLNamespaceContext.getInstance ());
  }
}
