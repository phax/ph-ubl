/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubltr;

import com.helger.sbdh.CSBDH;
import com.helger.ubl21.UBL21NamespaceContext;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
public class UBLTRNamespaceContext extends UBL21NamespaceContext
{
  public UBLTRNamespaceContext ()
  {
    addMapping ("sh", CSBDH.SBDH_NS);
    addMapping ("ef", CUBLTR.XML_NS_EFATURA);
    addMapping ("hr", CUBLTR.XML_NS_HRXML);
    addMapping ("oa", CUBLTR.XML_NS_OAGIS);
  }
}
