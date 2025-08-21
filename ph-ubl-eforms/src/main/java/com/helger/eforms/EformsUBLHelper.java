/*
 * Copyright (C) 2021-2025 Jonatan Sunden
 * Copyright (C) 2021-2025 Philip Helger (www.helger.com)
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

import org.w3c.dom.Element;

import com.helger.annotation.concurrent.Immutable;
import com.helger.base.enforce.ValueEnforcer;
import com.helger.base.state.ESuccess;
import com.helger.eforms.jaxb.ext.EformsExtension;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_23.ExtensionContentType;

/**
 * Helper for encapsulating the EForms extension correctly
 *
 * @author Philip Helger
 * @since 6.7.0
 */
@Immutable
public final class EformsUBLHelper
{
  private EformsUBLHelper ()
  {}

  /**
   * Get the {@link EformsExtension} from the provided
   * {@link ExtensionContentType}.
   *
   * @param aExt
   *        The extension content. May not be <code>null</code>.
   * @return <code>null</code> if the content is no {@link EformsExtension}.
   */
  @Nullable
  public static EformsExtension getFormsExtension (@Nonnull final ExtensionContentType aExt)
  {
    ValueEnforcer.notNull (aExt, "Ext");

    final Object aAny = aExt.getAny ();
    if (aAny instanceof Element)
      return EformsUBLMarshaller.eFormsExtension ().read ((Element) aAny);
    return null;
  }

  /**
   * Set the {@link EformsExtension} to the provided
   * {@link ExtensionContentType}.
   *
   * @param aExt
   *        The extension content. May not be <code>null</code>.
   * @param aEformsExtension
   *        The EForms Extension content itself.
   * @return Never <code>null</code>.
   */
  @Nonnull
  public static ESuccess setFormsExtension (@Nonnull final ExtensionContentType aExt,
                                            @Nonnull final EformsExtension aEformsExtension)
  {
    ValueEnforcer.notNull (aExt, "Ext");
    ValueEnforcer.notNull (aEformsExtension, "EformsExtension");

    final Element aElement = EformsUBLMarshaller.eFormsExtension ().getAsElement (aEformsExtension);
    if (aElement == null)
      return ESuccess.FAILURE;
    aExt.setAny (aElement);
    return ESuccess.SUCCESS;
  }
}
