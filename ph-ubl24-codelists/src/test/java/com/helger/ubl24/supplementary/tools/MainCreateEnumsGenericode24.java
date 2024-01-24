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
package com.helger.ubl24.supplementary.tools;

import java.io.IOException;

import com.helger.jcodemodel.JCodeModelException;
import com.helger.ubl.api.codegen.AbstractCreateUBLCodeListCodeGen;

/**
 * Utility class to create:
 * <ul>
 * <li>src/main/java/com/helger/ubl/codelists - generated Java Code for the
 * codelists</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateEnumsGenericode24 extends AbstractCreateUBLCodeListCodeGen
{
  public static void main (final String [] args) throws JCodeModelException, IOException
  {
    new MainCreateEnumsGenericode24 ().run ("com.helger.ubl24.codelist");
  }
}
