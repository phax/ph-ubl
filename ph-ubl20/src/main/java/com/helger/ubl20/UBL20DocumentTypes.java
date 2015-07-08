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
package com.helger.ubl20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.annotation.ReturnsImmutableObject;
import com.helger.commons.collection.CollectionHelper;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * UBL document type map. Provides sanity methods for accessing UBL 2.0 document
 * types based on different information items.
 *
 * @author Philip Helger
 */
@Immutable
public final class UBL20DocumentTypes
{
  /** Maps namespaces to document types */
  private static final Map <String, EUBL20DocumentType> s_aNamespace2DocType = new HashMap <String, EUBL20DocumentType> ();

  /** Maps local names to document types */
  private static final Map <String, EUBL20DocumentType> s_aLocalName2DocType = new HashMap <String, EUBL20DocumentType> ();

  static
  {
    // Register all UBL 2.0 document types
    for (final EUBL20DocumentType eDocType : EUBL20DocumentType.values ())
    {
      // add to namespace map
      final String sNamespace = eDocType.getNamespaceURI ();
      if (s_aNamespace2DocType.containsKey (sNamespace))
        throw new IllegalArgumentException ("The namespace '" + sNamespace + "' is already mapped!");
      s_aNamespace2DocType.put (sNamespace, eDocType);

      // add to local name map
      final String sLocalName = eDocType.getLocalName ();
      if (s_aLocalName2DocType.containsKey (sLocalName))
        throw new IllegalArgumentException ("The local name '" + sLocalName + "' is already mapped!");
      s_aLocalName2DocType.put (sLocalName, eDocType);
    }
  }

  @PresentForCodeCoverage
  private static final UBL20DocumentTypes s_aInstance = new UBL20DocumentTypes ();

  private UBL20DocumentTypes ()
  {}

  /**
   * @return A non-<code>null</code> set of all supported UBL 2.0 namespaces.
   */
  @Nonnull
  @ReturnsImmutableObject
  public static Set <String> getAllNamespaces ()
  {
    return CollectionHelper.makeUnmodifiable (s_aNamespace2DocType.keySet ());
  }

  /**
   * Get the document type matching the passed namespace.
   *
   * @param sNamespace
   *          The namespace URI of any UBL 2.0 document type. May be
   *          <code>null</code>.
   * @return <code>null</code> if no UBL 2.0 document type matching the
   *         specified namespace URI exists.
   */
  @Nullable
  public static EUBL20DocumentType getDocumentTypeOfNamespace (@Nullable final String sNamespace)
  {
    return s_aNamespace2DocType.get (sNamespace);
  }

  /**
   * Get the domain object class of the passed namespace.
   *
   * @param sNamespace
   *          The namespace URI of any UBL 2.0 document type. May be
   *          <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Class <?> getImplementationClassOfNamespace (@Nullable final String sNamespace)
  {
    final IUBLDocumentType eDocType = getDocumentTypeOfNamespace (sNamespace);
    return eDocType == null ? null : eDocType.getImplementationClass ();
  }

  /**
   * Get the XSD Schema object for the UBL 2.0 document type of the passed
   * namespace.
   *
   * @param sNamespace
   *          The namespace URI of any UBL 2.0 document type. May be
   *          <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Schema getSchemaOfNamespace (@Nullable final String sNamespace)
  {
    final EUBL20DocumentType eDocType = getDocumentTypeOfNamespace (sNamespace);
    return eDocType == null ? null : eDocType.getSchema ();
  }

  /**
   * @return A non-<code>null</code> set of all supported UBL 2.0 document
   *         element local names.
   */
  @Nonnull
  @ReturnsImmutableObject
  public static Set <String> getAllLocalNames ()
  {
    return CollectionHelper.makeUnmodifiable (s_aLocalName2DocType.keySet ());
  }

  /**
   * Get the document type matching the passed document element local name.
   *
   * @param sLocalName
   *          The document element local name of any UBL 2.0 document type. May
   *          be <code>null</code>.
   * @return <code>null</code> if no UBL 2.0 document type matching the
   *         specified local name exists.
   */
  @Nullable
  public static EUBL20DocumentType getDocumentTypeOfLocalName (@Nullable final String sLocalName)
  {
    return s_aLocalName2DocType.get (sLocalName);
  }

  /**
   * Get the domain object class of the passed document element local name.
   *
   * @param sLocalName
   *          The document element local name of any UBL 2.0 document type. May
   *          be <code>null</code>.
   * @return <code>null</code> if no such implementation class exists.
   */
  @Nullable
  public static Class <?> getImplementationClassOfLocalName (@Nullable final String sLocalName)
  {
    final IUBLDocumentType eDocType = getDocumentTypeOfLocalName (sLocalName);
    return eDocType == null ? null : eDocType.getImplementationClass ();
  }

  /**
   * Get the XSD Schema object for the UBL 2.0 document type of the passed
   * document element local name.
   *
   * @param sLocalName
   *          The document element local name of any UBL 2.0 document type. May
   *          be <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Schema getSchemaOfLocalName (@Nullable final String sLocalName)
  {
    final EUBL20DocumentType eDocType = getDocumentTypeOfLocalName (sLocalName);
    return eDocType == null ? null : eDocType.getSchema ();
  }

  /**
   * Get the XSD Schema object for the UBL 2.0 document type of the passed
   * implementation class.
   *
   * @param aImplClass
   *          The implementation class of any UBL 2.0 document type. May be
   *          <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Schema getSchemaOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    if (aImplClass != null)
      for (final EUBL20DocumentType eDocType : EUBL20DocumentType.values ())
        if (eDocType.getImplementationClass ().equals (aImplClass))
          return eDocType.getSchema ();
    return null;
  }
}
