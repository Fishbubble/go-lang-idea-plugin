/*
 * Copyright 2013-2014 Sergey Ignatov, Alexander Zolotov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.inspections;

import com.goide.psi.GoFile;
import com.goide.psi.GoVisitor;
import com.intellij.codeInspection.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract public class GoInspectionBase extends LocalInspectionTool {
  private static final PsiElementVisitor DUMMY_VISITOR = new PsiElementVisitor() { };

  @NotNull
  @Override
  public final PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
    GoFile file = ObjectUtils.tryCast(session.getFile(), GoFile.class);
    return file != null && canRunOn(file) ? buildGoVisitor(holder, session) : DUMMY_VISITOR;
  }

  @NotNull
  @Override
  public final PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
    throw new IllegalStateException();
  }

  @Nullable
  @Override
  public final ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull InspectionManager manager, boolean isOnTheFly) {
    throw new IllegalStateException();
  }

  protected boolean canRunOn(@SuppressWarnings({"UnusedParameters", "For future"}) @NotNull GoFile file) {
    return true;
  }

  @NotNull
  protected GoVisitor buildGoVisitor(@NotNull final ProblemsHolder holder, @SuppressWarnings({"UnusedParameters", "For future"}) @NotNull LocalInspectionToolSession session) {
    return new GoVisitor() {
      @Override
      public void visitFile(PsiFile file) {
        checkFile((GoFile)file, holder);
      }
    };
  }

  protected void checkFile(@NotNull GoFile file, @NotNull ProblemsHolder problemsHolder) {
  }
}