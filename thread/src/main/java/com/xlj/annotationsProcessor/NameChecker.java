package com.xlj.annotationsProcessor;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner6;
import javax.tools.Diagnostic;
import java.util.EnumSet;

public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment)
    {
        this.messager = processingEnvironment.getMessager();
    }

    public void checkNames(Element element)
    {
        this.nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner6<Void, Void>
    {
        @Override
        public Void visitType(TypeElement e, Void aVoid) {

            scan(e.getTypeParameters(), aVoid);

            this.checkCamelCase(e, true);

            super.visitType(e, aVoid);

            return null;
        }

        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if(e.getKind() == ElementKind.METHOD)
            {
                Name name = e.getSimpleName();
                if(name.contentEquals(e.getEnclosingElement().getSimpleName()))
                {
                    messager.printMessage(Diagnostic.Kind.WARNING,
                            "一个普通的方法 " + name + " 不应当与类名重复.", e);
                }
            }
            super.visitExecutable(e, aVoid);
            return null;
        }

        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {

            if(e.getKind() == ElementKind.ENUM_CONSTANT
                    || e.getConstantValue() != null
                    || this.heuristicallyConstant(e))
            {
                this.checkAllCaps(e);
            }
            else
            {
                this.checkCamelCase(e, false);
            }

            super.visitVariable(e, aVoid);
            return null;
        }

        private boolean heuristicallyConstant(VariableElement e)
        {
            if(e.getEnclosingElement().getKind() == ElementKind.INTERFACE)
            {
                return true;
            }
            else if(e.getKind() == ElementKind.FIELD &&
                    e.getModifiers().containsAll(
                            EnumSet.of(Modifier.PUBLIC,
                                    Modifier.STATIC,
                                    Modifier.FINAL)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * 检查传入的 element 是否符合
         * @param e
         * @param initialCaps
         */
        private void checkCamelCase(Element e, boolean initialCaps)
        {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);

            if(Character.isUpperCase(firstCodePoint))
            {
                previousUpper = true;
                if(!initialCaps)
                {
                    messager.printMessage(Diagnostic.Kind.WARNING,
                            "名称 " + name + "应当以小写字母开头", e);
                    return;
                }
            }
            else if(Character.isLowerCase(firstCodePoint))
            {
                if(initialCaps)
                {
                    messager.printMessage(Diagnostic.Kind.WARNING,
                            "名称 " + name + "应当以大写字母开头", e);
                    return;
                }
            }
            else
            {
                conventional = false;
            }

            if(conventional)
            {
                int cp = firstCodePoint;
                for(int i = Character.charCount(cp);
                    i < name.length();
                    i += Character.charCount(cp))
                {
                    cp = name.codePointAt(i);
                    if(Character.isUpperCase(cp))
                    {
                        if(Character.isUpperCase(cp))
                        {
                            if(previousUpper)
                            {
                                conventional = false;
                                break;
                            }
                            previousUpper = true;
                        }
                        else
                        {
                            previousUpper = false;
                        }
                    }
                }

                if(!conventional)
                {
                    messager.printMessage(Diagnostic.Kind.WARNING,
                            "名称 " + name + "应当符合 Camel Case Names", e);
                }
            }
        }

        private void checkAllCaps(Element e)
        {
            String name = e.getSimpleName().toString();
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);

            if(!Character.isUpperCase(firstCodePoint))
            {
                conventional = false;
            }
            else
            {
                boolean previousUnderscore = false;
                int cp = firstCodePoint;
                for(int i = Character.charCount(cp);
                        i < name.length();
                        i += Character.charCount(cp))
                {
                    cp = name.codePointAt(i);
                    if(cp == (int)'_')
                    {
                        conventional = false;
                        break;
                    }
                    else
                    {
                        previousUnderscore = true;
                        if(!Character.isUpperCase(cp) &&
                                !Character.isDigit(cp))
                        {
                            conventional = false;
                            break;
                        }
                    }
                }
            }

            if(!conventional)
            {
                messager.printMessage(Diagnostic.Kind.WARNING,
                        "常量 " + name + "应当全部以大写或下划线命名,并且字母开头", e);
            }
        }

    }
}
