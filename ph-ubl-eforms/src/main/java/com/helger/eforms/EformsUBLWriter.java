/*
 * Copyright (C) 2021-2022 Jonatan Sunden
 * Copyright (C) 2021-2022 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.eforms.jaxb.brin.BusinessRegistrationInformationNoticeType;

import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;

/**
 * eForms XML writer
 *
 * @author Jonatan Sunden
 * @author Philip Helger
 * @since 6.7.0
 */
@NotThreadSafe
public final class EformsUBLWriter
{
  @PresentForCodeCoverage
  private static final EformsUBLWriter INSTANCE = new EformsUBLWriter ();

  private EformsUBLWriter ()
  {}

  @Nonnull
  public static EformsUBLWriterBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return EformsUBLWriterBuilder.create (ContractAwardNoticeType.class);
  }

  @Nonnull
  public static EformsUBLWriterBuilder <ContractNoticeType> contractNotice ()
  {
    return EformsUBLWriterBuilder.create (ContractNoticeType.class);
  }

  @Nonnull
  public static EformsUBLWriterBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return EformsUBLWriterBuilder.create (PriorInformationNoticeType.class);
  }

  @Nonnull
  public static EformsUBLWriterBuilder <BusinessRegistrationInformationNoticeType> businessRegistrationInformationNotice ()
  {
    return EformsUBLWriterBuilder.create (BusinessRegistrationInformationNoticeType.class);
  }
}
