package com.xlj.beanwiringhightLeve.ambiguity.componnet;

import org.springframework.stereotype.Component;

@Component
@Hot
public class Cake implements Dessert {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
