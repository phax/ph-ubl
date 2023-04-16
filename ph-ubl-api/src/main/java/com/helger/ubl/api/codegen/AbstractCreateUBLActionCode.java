/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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

import java.util.Locale;

import javax.annotation.Nonnull;

import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;

/**
 * Base class for internal code generation. You should not care too much about
 * this one...
 *
 * @author Philip Helger
 */
@SuppressWarnings ("removal")
public abstract class AbstractCreateUBLActionCode
{
  @Deprecated (forRemoval = true, since = "8.0.0")
  public enum EPhase
  {
    READ,
    WRITE,
    VALIDATE;
  }

  @Deprecated (forRemoval = true, since = "8.0.0")
  protected static void append (@Nonnull final IJAXBDocumentType e,
                                @Nonnull final EPhase ePhase,
                                @Nonnull final StringBuilder aSB,
                                @Nonnull final String sBuilderClass)
  {
    final String sType = ClassHelper.getClassLocalName (e.getImplementationClass ());
    final String sName = StringHelper.trimEnd (sType, "Type");
    final String sBuilderMethodName = Character.toLowerCase (sName.charAt (0)) + sName.substring (1);

    switch (ePhase)
    {
      case READ:
        // Builder<T> read ()
        aSB.append ("/** Create a reader builder for " +
                    sName +
                    ".\n" +
                    "@return The builder and never <code>null</code> */\n");
        aSB.append ("@Nonnull public static ")
           .append (sBuilderClass)
           .append ('<')
           .append (sType)
           .append ("> ")
           .append (sBuilderMethodName)
           .append ("(){return ")
           .append (sBuilderClass)
           .append (".create(")
           .append (sType)
           .append (".class);}\n");
        break;
      case WRITE:
        // Builder<T> write ()
        aSB.append ("/** Create a writer builder for " +
                    sName +
                    ".\n" +
                    "@return The builder and never <code>null</code> */\n");
        aSB.append ("@Nonnull public static ")
           .append (sBuilderClass)
           .append ('<')
           .append (sType)
           .append ("> ")
           .append (sBuilderMethodName)
           .append ("(){return ")
           .append (sBuilderClass)
           .append (".create(")
           .append (sType)
           .append (".class);}\n");
        break;
      case VALIDATE:
        // Builder<T> validate ()
        aSB.append ("/** Create a validation builder for " +
                    sName +
                    ".\n" +
                    "@return The builder and never <code>null</code> */\n");
        aSB.append ("@Nonnull public static ")
           .append (sBuilderClass)
           .append ('<')
           .append (sType)
           .append ("> ")
           .append (sBuilderMethodName)
           .append ("(){return ")
           .append (sBuilderClass)
           .append (".create(")
           .append (sType)
           .append (".class);}\n");
        break;
    }
  }

  @Nonnull
  private static String lcFirst (@Nonnull final String s)
  {
    return s.substring (0, 1).toLowerCase (Locale.ROOT) + s.substring (1);
  }

  public static void appendMarshaller (@Nonnull final String sMarshallerClassName,
                                       @Nonnull final IUBLDocTypeEnumSimple e,
                                       @Nonnull final StringBuilder aSB)
  {
    final String sClassName = e.getClazz ().getSimpleName ();
    final String sNoTypeName = StringHelper.trimEnd (sClassName, "Type");
    final String sMethodName = lcFirst (sNoTypeName);
    aSB.append ("@Nonnull\n");
    aSB.append ("public static ")
       .append (sMarshallerClassName)
       .append (" <")
       .append (sClassName)
       .append ("> ")
       .append (sMethodName)
       .append (" ()\n");
    aSB.append ("{\n");
    aSB.append ("  return new ")
       .append (sMarshallerClassName)
       .append (" <> (")
       .append (sClassName)
       .append (".class, _getCPR (\"")
       .append (e.getXSDPath ())
       .append ("\"), ")
       .append (e.getClazz ().getPackage ().getName ())
       .append (".ObjectFactory._")
       .append (sNoTypeName)
       .append ("_QNAME);\n");
    aSB.append ("}\n\n");
  }
}
