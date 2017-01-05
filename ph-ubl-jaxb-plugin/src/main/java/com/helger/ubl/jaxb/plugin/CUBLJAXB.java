/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
package com.helger.ubl.jaxb.plugin;

import javax.annotation.concurrent.Immutable;

/**
 * JAXB plugin constants.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBLJAXB
{
  public static final String NSURI_PH_UBL = "http://www.helger.com/namespaces/jaxb22/ubl-plugin";
  public static final String PLUGIN_NAME = "ph-ubl-jaxb-plugin";

  private CUBLJAXB ()
  {}
}
