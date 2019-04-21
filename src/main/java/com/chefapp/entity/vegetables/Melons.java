package com.chefapp.entity.vegetables;

public class Melons extends Vegetable {
    public static class MelonsBuilder extends VegetableBuilder<Melons, MelonsBuilder> {
        @Override
        protected Melons getActuall() {
            return new Melons();
        }

        @Override
        protected MelonsBuilder getActualBuilder() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Melons{"+super.toString()+"}";
    }
}