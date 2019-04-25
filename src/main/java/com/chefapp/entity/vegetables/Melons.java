package com.chefapp.entity.vegetables;

public class Melons extends Vegetable {
    @Override
    public String toString() {
        return "Melons{" + super.toString() + "}";
    }

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
}