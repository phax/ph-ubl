/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.collection.impl.ICommonsSet;

/**
 * UBL document type map. Provides sanity methods for accessing UBL 2.0 document
 * types based on different information items.
 *
 * @author Philip Helger
 */
@Immutable
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBL20DocumentTypes
{
  /** Maps namespaces to document types */
  private static final ICommonsMap <String, EUBL20DocumentType> NS2DOCTYPE = new CommonsHashMap <> ();

  /** Maps local names to document types */
  private static final ICommonsMap <String, EUBL20DocumentType> LOCALNAME2DOCTYPE = new CommonsHashMap <> ();

  static
  {
    // Register all UBL 2.0 document types
    for (final EUBL20DocumentType eDocType : EUBL20DocumentType.values ())
    {
      // add to namespace map
      final String sNamespace = eDocType.getNamespaceURI ();
      if (NS2DOCTYPE.containsKey (sNamespace))
        throw new IllegalArgumentException ("The namespace '" + sNamespace + "' is already mapped!");
      NS2DOCTYPE.put (sNamespace, eDocType);

      // add to local name map
      final String sLocalName = eDocType.getLocalName ();
      if (LOCALNAME2DOCTYPE.containsKey (sLocalName))
        throw new IllegalArgumentException ("The local name '" + sLocalName + "' is already mapped!");
      LOCALNAME2DOCTYPE.put (sLocalName, eDocType);
    }
  }

  @PresentForCodeCoverage
  private static final UBL20DocumentTypes INSTANCE = new UBL20DocumentTypes ();

  private UBL20DocumentTypes ()
  {}

  /**
   * @return A non-<code>null</code> set of all supported UBL 2.0 namespaces.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsSet <String> getAllNamespaces ()
  {
    return NS2DOCTYPE.copyOfKeySet ();
  }

  /**
   * Get the document type matching the passed namespace.
   *
   * @param sNamespace
   *        The namespace URI of any UBL 2.0 document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no UBL 2.0 document type matching the
   *         specified namespace URI exists.
   */
  @Nullable
  public static EUBL20DocumentType getDocumentTypeOfNamespace (@Nullable final String sNamespace)
  {
    return NS2DOCTYPE.get (sNamespace);
  }

  /**
   * Get the domain object class of the passed namespace.
   *
   * @param sNamespace
   *        The namespace URI of any UBL 2.0 document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Class <?> getImplementationClassOfNamespace (@Nullable final String sNamespace)
  {
    final EUBL20DocumentType eDocType = getDocumentTypeOfNamespace (sNamespace);
    return eDocType == null ? null : eDocType.getImplementationClass ();
  }

  /**
   * Get the XSD Schema object for the UBL 2.0 document type of the passed
   * namespace.
   *
   * @param sNamespace
   *        The namespace URI of any UBL 2.0 document type. May be
   *        <code>null</code>.
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
  @ReturnsMutableCopy
  public static ICommonsSet <String> getAllLocalNames ()
  {
    return LOCALNAME2DOCTYPE.copyOfKeySet ();
  }

  /**
   * Get the document type matching the passed document element local name.
   *
   * @param sLocalName
   *        The document element local name of any UBL 2.0 document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no UBL 2.0 document type matching the
   *         specified local name exists.
   */
  @Nullable
  public static EUBL20DocumentType getDocumentTypeOfLocalName (@Nullable final String sLocalName)
  {
    return LOCALNAME2DOCTYPE.get (sLocalName);
  }

  /**
   * Get the domain object class of the passed document element local name.
   *
   * @param sLocalName
   *        The document element local name of any UBL 2.0 document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such implementation class exists.
   */
  @Nullable
  public static Class <?> getImplementationClassOfLocalName (@Nullable final String sLocalName)
  {
    final EUBL20DocumentType eDocType = getDocumentTypeOfLocalName (sLocalName);
    return eDocType == null ? null : eDocType.getImplementationClass ();
  }

  /**
   * Get the UBL 2.0 document type matching the passed implementation class.
   *
   * @param aImplClass
   *        The implementation class to use. May be <code>null</code>.
   * @return <code>null</code> if the implementation class is <code>null</code>
   *         or if no UBL 2.0 document type has the specified implementation
   *         class.
   */
  @Nullable
  public static EUBL20DocumentType getDocumentTypeOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    if (aImplClass == null)
      return null;
    return ArrayHelper.findFirst (EUBL20DocumentType.values (),
                                  eDocType -> eDocType.getImplementationClass ().equals (aImplClass));
  }

  /**
   * Get the XSD Schema object for the UBL 2.0 document type of the passed
   * document element local name.
   *
   * @param sLocalName
   *        The document element local name of any UBL 2.0 document type. May be
   *        <code>null</code>.
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
   *        The implementation class of any UBL 2.0 document type. May be
   *        <code>null</code>.
   * @return <code>null</code> if no such UBL 2.0 document type exists.
   */
  @Nullable
  public static Schema getSchemaOfImplementationClass (@Nullable final Class <?> aImplClass)
  {
    final EUBL20DocumentType eDocType = getDocumentTypeOfImplementationClass (aImplClass);
    return eDocType == null ? null : eDocType.getSchema ();
  }
}
