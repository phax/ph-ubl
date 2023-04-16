package com.helger.ubl.api.codegen;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

public interface IUBLDocTypeEnumSimple
{
  @Nonnull
  Class <?> getClazz ();

  @Nonnull
  String getXSDPath ();

  @Nonnull
  Schema getSchema ();
}
