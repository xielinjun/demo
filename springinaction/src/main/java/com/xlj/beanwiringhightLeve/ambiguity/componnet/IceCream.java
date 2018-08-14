package com.xlj.beanwiringhightLeve.ambiguity.componnet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {
    @Override
    public String getName() {

        return this.getClass().getName();

    }
}
