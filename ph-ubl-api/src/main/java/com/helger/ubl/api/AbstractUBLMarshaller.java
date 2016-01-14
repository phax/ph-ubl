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
package com.helger.ubl.api;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;

import com.helger.jaxb.JAXBContextCache;
import com.helger.jaxb.validation.LoggingValidationEventHandler;

/**
 * Base class for the generic UBL marshaller.
 *
 * @author Philip Helger
 */
@Deprecated
public abstract class AbstractUBLMarshaller
{
  @Nonnull
  protected static Unmarshaller createFullUnmarshaller (@Nonnull final Class <?> aClass,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nonnull final Schema aSchema,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler) throws JAXBException
  {
    // Since creating the JAXB context is quite cost intensive this is done
    // only once!
    final JAXBContext aJAXBContext = JAXBContextCache.getInstance ().getFromCache (aClass, aClassLoader);

    // create an Unmarshaller
    final Unmarshaller aUnmarshaller = aJAXBContext.createUnmarshaller ();
    aUnmarshaller.setEventHandler (aCustomEventHandler != null ? aCustomEventHandler
                                                               : new LoggingValidationEventHandler (aUnmarshaller.getEventHandler ()));

    // Validating!
    aUnmarshaller.setSchema (aSchema);

    return aUnmarshaller;
  }

  @Nonnull
  protected static Marshaller createBasicMarshaller (@Nonnull final Class <?> aClass,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Schema aSchema,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler) throws JAXBException
  {
    // Since creating the JAXB context is quite cost intensive this is done
    // only once!
    final JAXBContext aJAXBContext = JAXBContextCache.getInstance ().getFromCache (aClass, aClassLoader);

    // create a Marshaller
    final Marshaller aMarshaller = aJAXBContext.createMarshaller ();
    aMarshaller.setEventHandler (aCustomEventHandler != null ? aCustomEventHandler
                                                             : new LoggingValidationEventHandler (aMarshaller.getEventHandler ()));

    // Validating!
    aMarshaller.setSchema (aSchema);

    return aMarshaller;
  }
}
