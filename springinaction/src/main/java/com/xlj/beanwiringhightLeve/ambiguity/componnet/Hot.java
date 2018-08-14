package com.xlj.beanwiringhightLeve.ambiguity.componnet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public @interface Hot {
}
