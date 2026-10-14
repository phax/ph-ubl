/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.hrubl;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.w3c.dom.Element;

import com.helger.annotation.concurrent.Immutable;
import com.helger.base.enforce.ValueEnforcer;
import com.helger.base.state.ESuccess;

import hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.HRFISK20DataType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;

/**
 * Helper to read and write the Croatian extension <code>HRFISK20Data</code> from and to the content of a UBL
 * extension.
 */
@Immutable
public final class HrUBLHelper
{
  private HrUBLHelper ()
  {}

  /**
   * Get the {@link HRFISK20DataType} from the provided {@link ExtensionContentType}.
   *
   * @param aExt
   *        The extension content. May not be <code>null</code>.
   * @return <code>null</code> if the content is no Croatian extension.
   */
  @Nullable
  public static HRFISK20DataType getHrExtension (@NonNull final ExtensionContentType aExt)
  {
    ValueEnforcer.notNull (aExt, "Ext");

    final Object aAny = aExt.getAny ();
    if (aAny instanceof final Element aElement)
    {
      // Don't try to read foreign extensions like the document signature
      if (CHrUBL.XML_SCHEMA_HREXTAC_NAMESPACE_URL.equals (aElement.getNamespaceURI ()))
        return HrUBLMarshaller.hrExtension ().read (aElement);
    }
    return null;
  }

  /**
   * Set the {@link HRFISK20DataType} to the provided {@link ExtensionContentType}.
   *
   * @param aExt
   *        The extension content. May not be <code>null</code>.
   * @param aHrExtension
   *        The Croatian extension content itself. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} if the extension was set, {@link ESuccess#FAILURE} otherwise.
   */
  @NonNull
  public static ESuccess setHrExtension (@NonNull final ExtensionContentType aExt,
                                         @NonNull final HRFISK20DataType aHrExtension)
  {
    ValueEnforcer.notNull (aExt, "Ext");
    ValueEnforcer.notNull (aHrExtension, "HrExtension");

    final Element aElement = HrUBLMarshaller.hrExtension ().getAsElement (aHrExtension);
    if (aElement == null)
      return ESuccess.FAILURE;
    aExt.setAny (aElement);
    return ESuccess.SUCCESS;
  }
}
