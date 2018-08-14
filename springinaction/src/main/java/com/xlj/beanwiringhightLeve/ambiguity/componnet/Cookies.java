package com.xlj.beanwiringhightLeve.ambiguity.componnet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cold")
public class Cookies implements Dessert {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
