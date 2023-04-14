/*
 * Copyright (C) 2021-2023 Jonatan Sunden
 * Copyright (C) 2021-2023 Philip Helger (www.helger.com)
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
package com.helger.eforms;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;

/**
 * Document types
 *
 * @author Jonatan Sunden
 * @author Philip Helger
 * @since 6.7.0
 */
@Immutable
@Deprecated (forRemoval = true, since = "8.0.0")
public final class EformsUBLDocumentTypes
{
  /** Maps local names to document types */
  private static final ICommonsMap <String, EFormsUBLDocumentType> LOCAL_NAME_TO_DOC_TYPE = new CommonsHashMap <> ();

  static
  {
    // Does not contain a namespace-to-doctype map because the namespace is not
    // unique!

    // Register all UBLPE document types
    for (final EFormsUBLDocumentType eDocType : EFormsUBLDocumentType.values ())
    {
      // add to local name map
      final String sLocalName = eDocType.getLocalName ();
      if (LOCAL_NAME_TO_DOC_TYPE.containsKey (sLocalName))
        throw new IllegalArgumentException ("The local name '" + sLocalName + "' is already mapped!");
      LOCAL_NAME_TO_DOC_TYPE.put (sLocalName, eDocType);
    }
  }

  @PresentForCodeCoverage
  private static final EformsUBLDocumentTypes INSTANCE = new EformsUBLDocumentTypes ();

  private EformsUBLDocumentTypes ()
  {}

  @Nullable
  public static EFormsUBLDocumentType getDocumentTypeOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    if (aImplClass == null)
      return null;
    return ArrayHelper.findFirst (EFormsUBLDocumentType.values (),
                                  eDocType -> eDocType.getImplementationClass ().equals (aImplClass));
  }
}
