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
package com.helger.ubl22.supplementary.tools;

import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl22.EUBL22DocumentTypeSimple;

public final class MainCreateUBL22VESID extends AbstractCreateUBLActionCode
{
  public static void main (final String [] args)
  {
    final StringBuilder aSB1 = new StringBuilder ();
    final StringBuilder aSB2 = new StringBuilder ();

    for (final EUBL22DocumentTypeSimple e : EUBL22DocumentTypeSimple.values ())
    {
      appendVESIDCode (e, aSB1, aSB2, "22");
    }
    aSB1.append ('\n').append (aSB2);
    System.out.println (aSB1.toString ());
    // Insert into UBL20Marshaller
  }
}