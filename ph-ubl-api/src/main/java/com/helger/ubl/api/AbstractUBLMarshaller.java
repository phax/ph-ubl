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
