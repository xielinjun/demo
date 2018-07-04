package com.xlj.chapter2_builder;

public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int carbohybreate;
    private final int sodium;

    private NutritionFacts(Builder builder)
    {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.carbohybreate = builder.carbohybreate;
        this.sodium = builder.sodium;
    }

    public static class Builder
    {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int carbohybreate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;

            return this;
        }

        public Builder setCarbohybreate(int carbohybreate) {
            this.carbohybreate = carbohybreate;

            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;

            return this;
        }

        public NutritionFacts build()
        {
            return new NutritionFacts(this);
        }

    }
}
