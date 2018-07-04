package com.xlj.chapter2_builder;

public class Run {

    public static void main(String[] args) {

        NutritionFacts nutritionFacts =
                new NutritionFacts.Builder(240, 8)
                        .setCalories(1)
                        .setCarbohybreate(2)
                        .setFat(3)
                        .setSodium(4).build();

    }

}
