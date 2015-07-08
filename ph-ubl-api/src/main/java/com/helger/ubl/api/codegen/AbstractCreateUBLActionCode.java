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
package com.helger.ubl.api.codegen;

import javax.annotation.Nonnull;

import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;
import com.helger.ubl.api.IUBLDocumentType;

public abstract class AbstractCreateUBLActionCode
{
  protected static enum EPhase
  {
   READ,
   WRITE,
   VALIDATE;
  }

  protected static void append (@Nonnull final IUBLDocumentType e,
                                @Nonnull final EPhase ePhase,
                                @Nonnull final StringBuilder aSB,
                                @Nonnull final String sMarshallerClass,
                                @Nonnull final String sEnumName)
  {
    final String sType = ClassHelper.getClassLocalName (e.getImplementationClass ());
    final String sName = StringHelper.trimEnd (sType, "Type");
    final String sParam = "a" + sName;
    final String sReadMethod = "read" + sName;
    final String sWriteMethod = "write" + sName;
    final String sValidateMethod = "validate" + sName;
    final String sIsValidMethod = "isValid" + sName;

    switch (ePhase)
    {
      case READ:
        // read (Node)
        aSB.append ("/** Interpret the passed DOM {@link Node} as a " +
                    sName +
                    " using the global validation event handler.\n" +
                    "@param aNode the DOM node. May not be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final Node aNode){return ")
           .append (sReadMethod)
           .append ("(aNode, getGlobalValidationEventHandler ());}\n");

        // read (Node, ValidationEventHandler)
        aSB.append ("/** Interpret the passed DOM {@link Node} as a " +
                    sName +
                    " using a custom validation event handler.\n" +
                    "@param aNode the DOM node. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final Node aNode, @Nullable ValidationEventHandler aCustomEventHandler){return ")
           .append (sMarshallerClass)
           .append (".readUBLDocument (aNode, (ClassLoader) null, ")
           .append (sType)
           .append (".class, aCustomEventHandler);}\n");

        // read (File)
        aSB.append ("/** Interpret the passed {@link File} as a " +
                    sName +
                    " using the global validation event handler.\n" +
                    "@param aSource the source file to read from. May not be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final File aSource){return ")
           .append (sReadMethod)
           .append ("(TransformSourceFactory.create(aSource));}\n");

        // read (File, ValidationEventHandler)
        aSB.append ("/** Interpret the passed {@link File} as a " +
                    sName +
                    " using a custom validation event handler.\n" +
                    "@param aSource the source file to read from. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final File aSource, @Nullable ValidationEventHandler aCustomEventHandler){return ")
           .append (sReadMethod)
           .append ("(TransformSourceFactory.create(aSource), aCustomEventHandler);}\n");

        // read (IReadableResource)
        aSB.append ("/** Interpret the passed {@link IReadableResource} as a " +
                    sName +
                    " using the global validation event handler.\n" +
                    "@param aSource the resource to read from. May not be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final IReadableResource aSource){return ")
           .append (sReadMethod)
           .append ("(TransformSourceFactory.create (aSource));}\n");

        // read (IReadableResource, ValidationEventHandler)
        aSB.append ("/** Interpret the passed {@link IReadableResource} as a " +
                    sName +
                    " using a custom validation event handler.\n" +
                    "@param aSource the resource to read from. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final IReadableResource aSource, @Nullable ValidationEventHandler aCustomEventHandler){return ")
           .append (sReadMethod)
           .append ("(TransformSourceFactory.create (aSource), aCustomEventHandler);}\n");

        // read (Source)
        aSB.append ("/** Interpret the passed {@link Source} as a " +
                    sName +
                    " using the global validation event handler.\n" +
                    "@param aSource the source to read from. May not be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final Source aSource){return ")
           .append (sReadMethod)
           .append ("(aSource, getGlobalValidationEventHandler ());}\n");

        // read (Source, ValidationEventHandler)
        aSB.append ("/** Interpret the passed {@link Source} as a " +
                    sName +
                    " using a custom validation event handler.\n" +
                    "@param aSource the source to read from. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@return The evaluated " +
                    sType +
                    " or <code>null</code> in case of a parsing error */\n");
        aSB.append ("@Nullable public static ")
           .append (sType)
           .append (" ")
           .append (sReadMethod)
           .append ("(@Nonnull final Source aSource, @Nullable ValidationEventHandler aCustomEventHandler){return ")
           .append (sMarshallerClass)
           .append (".readUBLDocument (aSource, (ClassLoader) null, ")
           .append (sType)
           .append (".class, aCustomEventHandler);}\n");
        break;
      case WRITE:
        // Document write (Object)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a DOM {@link Document} using the global validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@return The created DOM document or <code>null</code> in case of conversion error */\n");
        aSB.append ("@Nullable public static Document ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append ("){return ")
           .append (sWriteMethod)
           .append (" (")
           .append (sParam)
           .append (", getGlobalValidationEventHandler ());}\n");

        // Document write (Object, ValidationEventHandler)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a DOM {@link Document} using a custom validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@return The created DOM document or <code>null</code> in case of conversion error */\n");
        aSB.append ("@Nullable public static Document ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (", @Nullable ValidationEventHandler aCustomEventHandler){return ")
           .append (sMarshallerClass)
           .append (".writeUBLDocument (")
           .append (sParam)
           .append (", (ClassLoader) null, ")
           .append (sEnumName)
           .append (", aCustomEventHandler);}\n");

        // ESuccess write (Object, File)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a {@link File} using the global validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@param aResult the file to write to. May not be <code>null</code>.\n" +
                    "@return {@link ESuccess#SUCCESS} in case of success, {@link ESuccess#FAILURE} in case of an error */\n");
        aSB.append ("@Nonnull public static ESuccess ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (",@Nonnull final File aResult){return ")
           .append (sWriteMethod)
           .append ("(")
           .append (sParam)
           .append (", new StreamResult (aResult));}\n");

        // ESuccess write (Object, ValidationEventHandler, File)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a {@link File} using a custom validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@param aResult the file to write to. May not be <code>null</code>.\n" +
                    "@return {@link ESuccess#SUCCESS} in case of success, {@link ESuccess#FAILURE} in case of an error */\n");
        aSB.append ("@Nonnull public static ESuccess ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (", @Nullable final ValidationEventHandler aCustomEventHandler,@Nonnull final File aResult){return ")
           .append (sWriteMethod)
           .append (" (")
           .append (sParam)
           .append (", aCustomEventHandler, new StreamResult (aResult));}\n");

        // ESuccess write (Object, Result)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a custom {@link Result} using the global validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@param aResult the result object to write to. May not be <code>null</code>.\n" +
                    "@return {@link ESuccess#SUCCESS} in case of success, {@link ESuccess#FAILURE} in case of an error */\n");
        aSB.append ("@Nonnull public static ESuccess ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (",@Nonnull final Result aResult){return ")
           .append (sWriteMethod)
           .append ("(")
           .append (sParam)
           .append (", getGlobalValidationEventHandler (), aResult);}\n");

        // ESuccess write (Object, ValidationEventHandler, Result)
        aSB.append ("/** Convert the passed {@link " +
                    sType +
                    "} to a custom {@link Result} using a custom validation event handler.\n" +
                    "@param " +
                    sParam +
                    " the source object to convert. May not be <code>null</code>.\n" +
                    "@param aCustomEventHandler The custom event handler to use. May be <code>null</code>.\n" +
                    "@param aResult the result object to write to. May not be <code>null</code>.\n" +
                    "@return {@link ESuccess#SUCCESS} in case of success, {@link ESuccess#FAILURE} in case of an error */\n");
        aSB.append ("@Nonnull public static ESuccess ")
           .append (sWriteMethod)
           .append ("(@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (", @Nullable final ValidationEventHandler aCustomEventHandler,@Nonnull final Result aResult){return ")
           .append (sMarshallerClass)
           .append (".writeUBLDocument (")
           .append (sParam)
           .append (", (ClassLoader) null, ")
           .append (sEnumName)
           .append (", aCustomEventHandler, aResult);}\n");
        break;
      case VALIDATE:
        // IResourceErrorGroup validate (Object)
        aSB.append ("/** Validate the passed {@link " +
                    sType +
                    "} object.\n" +
                    "@param sParam the source object to validate. May not be <code>null</code>.\n" +
                    "@return The collected messages during validation. Never<code>null</code>. */\n");
        aSB.append ("@Nullable public static IResourceErrorGroup ")
           .append (sValidateMethod)
           .append (" (@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append ("){return ")
           .append (sMarshallerClass)
           .append (".validateUBLObject (")
           .append (sParam)
           .append (", (ClassLoader) null, ")
           .append (sEnumName)
           .append (");}\n");

        // IResourceErrorGroup validate (Object, ClassLoader)
        aSB.append ("/** Validate the passed {@link " +
                    sType +
                    "} object.\n" +
                    "@param sParam the source object to validate. May not be <code>null</code>.\n" +
                    "@param aClassLoader Optional class loader to be used for JAXBContext. May be <code>null</code> to indicate to use the default class loader.\n" +
                    "@return The collected messages during validation. Never<code>null</code>. */\n");
        aSB.append ("@Nullable public static IResourceErrorGroup ")
           .append (sValidateMethod)
           .append (" (@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (", @Nullable ClassLoader aClassLoader){return ")
           .append (sMarshallerClass)
           .append (".validateUBLObject (")
           .append (sParam)
           .append (", aClassLoader, ")
           .append (sEnumName)
           .append (");}\n");

        // boolean isValid (Object)
        aSB.append ("/** Validate the passed {@link " +
                    sType +
                    "} object.\n" +
                    "@param sParam the source object to validate. May not be <code>null</code>.\n" +
                    "@return <code>true</code> if the object is valid, <code>false</code> otherwise. */\n");
        aSB.append ("public static boolean ")
           .append (sIsValidMethod)
           .append (" (@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append ("){return ")
           .append (sValidateMethod)
           .append ("(")
           .append (sParam)
           .append (", (ClassLoader) null).containsNoError ();}\n");

        // boolean isValid (Object, ClassLoader)
        aSB.append ("/** Validate the passed {@link " +
                    sType +
                    "} object.\n" +
                    "@param sParam the source object to validate. May not be <code>null</code>.\n" +
                    "@param aClassLoader Optional class loader to be used for JAXBContext. May be <code>null</code> to indicate to use the default class loader.\n" +
                    "@return <code>true</code> if the object is valid, <code>false</code> otherwise. */\n");
        aSB.append ("public static boolean ")
           .append (sIsValidMethod)
           .append (" (@Nonnull final ")
           .append (sType)
           .append (" ")
           .append (sParam)
           .append (", @Nullable ClassLoader aClassLoader){return ")
           .append (sValidateMethod)
           .append ("(")
           .append (sParam)
           .append (", aClassLoader).containsNoError ();}\n");
        break;
    }
  }
}
