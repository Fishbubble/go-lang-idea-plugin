// This is a generated file. Not intended for manual editing.
package com.plan9.intel.lang.core.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plan9.intel.lang.core.psi.AsmIntelTypes.*;
import com.plan9.intel.lang.core.psi.*;

public class AsmIntelLiteralImpl extends AsmIntelElementImpl implements AsmIntelLiteral {

  public AsmIntelLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsmIntelVisitor) ((AsmIntelVisitor)visitor).visitLiteral(this);
    else super.accept(visitor);
  }

}
