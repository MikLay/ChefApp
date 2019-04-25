package com.chefapp.entity.vegetables;

public class Cabbage extends Vegetable {
    @Override
    public String toString() {
        return "Cabbage{" + super.toString() + "}";
    }

    public static class CabbageBuilder extends VegetableBuilder<Cabbage, CabbageBuilder> {
        @Override
        protected Cabbage getActuall() {
            return new Cabbage();
        }

        @Override
        protected CabbageBuilder getActualBuilder() {
            return this;
        }
    }
}
