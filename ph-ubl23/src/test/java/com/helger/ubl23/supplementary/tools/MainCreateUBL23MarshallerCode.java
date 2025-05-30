/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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
package com.helger.ubl23.supplementary.tools;

import com.helger.commons.io.file.FilenameHelper;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl23.EUBL23DocumentType;

public final class MainCreateUBL23MarshallerCode extends AbstractCreateUBLActionCode
{
  public static void main (final String [] args)
  {
    final StringBuilder aSB = new StringBuilder ();

    for (final EUBL23DocumentType e : EUBL23DocumentType.values ())
      appendMarshaller ("UBL23JAXBMarshaller",
                        FilenameHelper.getWithoutPath (e.getAllXSDResources ().getLastOrNull ().getPath ()),
                        e.getImplementationClass (),
                        aSB);

    System.out.println (aSB.toString ());
    // Insert into UBL23Marshaller
  }
}
