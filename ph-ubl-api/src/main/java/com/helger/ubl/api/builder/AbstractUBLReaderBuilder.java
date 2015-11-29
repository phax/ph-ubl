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

import java.io.File;
import java.io.InputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.OverrideOnDemand;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.xml.EXMLParserFeature;
import com.helger.commons.xml.sax.InputSourceFactory;
import com.helger.commons.xml.serialize.read.SAXReaderFactory;
import com.helger.commons.xml.serialize.read.SAXReaderSettings;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for reading UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL implementation class to be read
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
public abstract class AbstractUBLReaderBuilder <T, IMPLTYPE extends AbstractUBLReaderBuilder <T, IMPLTYPE>>
                                               extends AbstractUBLBuilder <IMPLTYPE>
{
  protected ValidationEventHandler m_aEventHandler;

  public AbstractUBLReaderBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  /**
   * @return The special JAXB validation event handler to be used.
   *         <code>null</code> by default.
   */
  @Nullable
  public ValidationEventHandler getValidationEventHandler ()
  {
    return m_aEventHandler;
  }

  /**
   * Set the JAXB validation event handler to be used. May be <code>null</code>.
   *
   * @param aEventHandler
   *          The event handler to be used. May be <code>null</code>.
   * @return this
   */
  @Nonnull
  public IMPLTYPE setValidationEventHandler (@Nullable final ValidationEventHandler aEventHandler)
  {
    m_aEventHandler = aEventHandler;
    return thisAsT ();
  }

  @Nullable
  public T read (@Nonnull final SAXReaderSettings aSettings, @Nonnull final InputSource aInputSource)
  {
    ValueEnforcer.notNull (aSettings, "Settings");
    ValueEnforcer.notNull (aInputSource, "InputSource");

    // Create new XML reader
    final XMLReader aParser = SAXReaderFactory.createXMLReader ();

    // Apply settings
    aSettings.applyToSAXReader (aParser);

    return read (new SAXSource (aParser, aInputSource));
  }

  @Nonnull
  @OverrideOnDemand
  protected SAXReaderSettings createDefaultSAXReaderSettings ()
  {
    // Initialize settings with defaults
    final SAXReaderSettings aSettings = new SAXReaderSettings ();
    // Apply settings that make reading more secure
    aSettings.setFeatureValues (EXMLParserFeature.AVOID_XML_ATTACKS);
    return aSettings;
  }

  @Nullable
  private T _readSecurelyFromInputSource (@Nonnull final InputSource aInputSource)
  {
    // Initialize settings with defaults
    final SAXReaderSettings aSettings = createDefaultSAXReaderSettings ();

    return read (aSettings, aInputSource);
  }

  /**
   * Interpret the passed {@link File} as a UBL document.
   *
   * @param aSource
   *          The source to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public T read (@Nonnull final File aSource)
  {
    return _readSecurelyFromInputSource (InputSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UBL document.
   *
   * @param aSource
   *          The source to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public T read (@Nonnull final IReadableResource aSource)
  {
    return _readSecurelyFromInputSource (InputSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link InputStream} as a UBL document.
   *
   * @param aSource
   *          The stream to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public T read (@Nonnull final InputStream aSource)
  {
    return _readSecurelyFromInputSource (InputSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link byte[]} as a UBL document.
   *
   * @param aSource
   *          The source to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public T read (@Nonnull final byte [] aSource)
  {
    return _readSecurelyFromInputSource (InputSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link byte[]} as a UBL document.
   *
   * @param sSource
   *          The source to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public T read (@Nonnull final String sSource)
  {
    return _readSecurelyFromInputSource (InputSourceFactory.create (sSource));
  }

  /**
   * Interpret the passed {@link Source} as a UBL document.
   *
   * @param sSource
   *          The source to read from. May not be <code>null</code>.
   * @return The evaluated UBL document or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public abstract T read (@Nonnull Source aSource);
}
