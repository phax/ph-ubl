/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ubl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.xml.CXML;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

/**
 * A special namespace prefix mapper for the Sun JAXB2 implementation. It
 * ensures that the cac and cbc namespace prefixes are used in generated code.<br>
 * Important note: this class works only, if the com.sun.xml.bind:jaxb-impl
 * artifact is in your classpath, because this class extends
 * <code>com.sun.xml.bind.marshaller.NamespacePrefixMapper</code> which is not
 * available in the runtime JAXB, where the class is called
 * <code>com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper</code>
 *
 * @author Philip Helger
 */
@SuppressWarnings ("restriction")
public class UBL21NamespacePrefixMapperOracleRT extends NamespacePrefixMapper
{
  private static final class SingletonHolder
  {
    static final UBL21NamespacePrefixMapperOracleRT s_aInstance = new UBL21NamespacePrefixMapperOracleRT ();
  }

  protected UBL21NamespacePrefixMapperOracleRT ()
  {}

  @Nonnull
  public static UBL21NamespacePrefixMapperOracleRT getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }

  @Override
  @Nullable
  public String getPreferredPrefix (@Nonnull final String sNamespaceUri,
                                    @Nullable final String sSuggestion,
                                    final boolean bRequirePrefix)
  {
    // XSI prefix
    if (sNamespaceUri.equals (CXML.XML_NS_XSI))
      return "xsi";

    // XS prefix
    if (sNamespaceUri.equals (CXML.XML_NS_XSD))
      return "xs";

    // UBL specific prefixes
    if (sNamespaceUri.equals (CUBL21.XML_SCHEMA_CAC_NAMESPACE_URL))
      return "cac";
    if (sNamespaceUri.equals (CUBL21.XML_SCHEMA_CBC_NAMESPACE_URL))
      return "cbc";
    if (sNamespaceUri.equals (CUBL21.XML_SCHEMA_CEC_NAMESPACE_URL))
      return "cec";
    return sSuggestion;
  }
}
