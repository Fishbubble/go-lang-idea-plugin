// This is a generated file. Not intended for manual editing.
package com.goide.gotemplate.psi;

import org.jetbrains.annotations.*;

public interface GoTemplateBlockStatement extends GoTemplateStatement {

  @Nullable
  GoTemplateEndStatement getEndStatement();

  @Nullable
  GoTemplatePipeline getPipeline();

  @Nullable
  GoTemplateStatementList getStatementList();

}