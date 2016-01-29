/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.ubl.api.builder;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.helger.commons.annotation.OverrideOnDemand;
import com.helger.jaxb.JAXBContextCache;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for writing and validating UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *        The UBL implementation class to be handled
 * @param <IMPLTYPE>
 *        The implementation class implementing this abstract class.
 */
@NotThreadSafe
public abstract class AbstractWritingUBLBuilder <T, IMPLTYPE extends AbstractWritingUBLBuilder <T, IMPLTYPE>>
                                                extends AbstractUBLBuilder <IMPLTYPE>
{
  public AbstractWritingUBLBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  /**
   * Create the main marshaller with the contained settings.
   *
   * @return The Marshaller and never <code>null</code>.
   * @throws JAXBException
   *         In case creation fails
   */
  @Nonnull
  @OverrideOnDemand
  protected Marshaller createMarshaller () throws JAXBException
  {
    // Since creating the JAXB context is quite cost intensive this is done
    // only once!
    final JAXBContext aJAXBContext = JAXBContextCache.getInstance ().getFromCache (m_aDocType.getImplementationClass (),
                                                                                   m_aClassLoader);

    // create a Marshaller
    final Marshaller aMarshaller = aJAXBContext.createMarshaller ();

    // Validating!
    aMarshaller.setSchema (m_aDocType.getSchema (m_aClassLoader));

    return aMarshaller;
  }

  /**
   * Customize the marshaller
   *
   * @param aMarshaller
   *        The marshaller to customize. Never <code>null</code>.
   */
  @OverrideOnDemand
  protected void customizeMarshaller (@Nonnull final Marshaller aMarshaller)
  {}

  @SuppressWarnings ("unchecked")
  @Nonnull
  protected static final JAXBElement <?> _createJAXBElement (@Nonnull final QName aQName, @Nonnull final Object aValue)
  {
    return new JAXBElement <Object> (aQName, (Class <Object>) aValue.getClass (), null, aValue);
  }
}
