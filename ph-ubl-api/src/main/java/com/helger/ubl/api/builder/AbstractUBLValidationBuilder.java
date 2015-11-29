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
package com.helger.ubl.api.builder;

import javax.annotation.Nonnull;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.xml.sax.helpers.DefaultHandler;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.jaxb.validation.CollectingValidationEventHandler;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for validating UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL implementation class to be validated
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
public abstract class AbstractUBLValidationBuilder <T, IMPLTYPE extends AbstractUBLValidationBuilder <T, IMPLTYPE>>
                                                   extends AbstractWritingUBLBuilder <T, IMPLTYPE>
{
  public AbstractUBLValidationBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  /**
   * Check if the passed UBL document is valid according to the XSD or not.
   *
   * @param aUBLDocument
   *          The UBL document to be validated. May not be <code>null</code>.
   * @return <code>true</code> if the document is valid, <code>false</code> if
   *         not.
   * @see #validate(Object)
   */
  public boolean isValid (@Nonnull final T aUBLDocument)
  {
    return validate (aUBLDocument).containsNoError ();
  }

  /**
   * Validate the passed UBL document.
   *
   * @param aUBLDocument
   *          The UBL document to be validated. May not be <code>null</code>.
   * @return The validation results. Never <code>null</code>.
   */
  @Nonnull
  public IResourceErrorGroup validate (@Nonnull final T aUBLDocument)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");

    // Avoid class cast exception later on
    if (!m_aDocType.getPackage ().equals (aUBLDocument.getClass ().getPackage ()))
    {
      throw new IllegalArgumentException ("You cannot validate a '" +
                                          aUBLDocument.getClass () +
                                          "' as a " +
                                          m_aDocType.getPackage ().getName ());
    }

    final CollectingValidationEventHandler aEventHandler = new CollectingValidationEventHandler ();
    try
    {
      // create a Marshaller
      final Marshaller aMarshaller = createMarshaller ();
      aMarshaller.setEventHandler (aEventHandler);

      // Customize on demand
      customizeMarshaller (aMarshaller);

      // start marshalling
      final JAXBElement <?> aJAXBElement = _createJAXBElement (m_aDocType.getQName (), aUBLDocument);
      // DefaultHandler has very little overhead
      aMarshaller.marshal (aJAXBElement, new DefaultHandler ());
    }
    catch (final JAXBException ex)
    {
      // Should already be contained as an entry in the event handler
    }
    return aEventHandler.getResourceErrors ();
  }

}
