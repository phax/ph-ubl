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
package com.helger.ubl.api.codegen;

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
public abstract class AbstractCreateUBLActionCode
{
  protected static enum EPhase
  {
    READ,
    WRITE,
    VALIDATE;
  }

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
}
