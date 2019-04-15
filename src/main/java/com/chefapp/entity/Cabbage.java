package com.chefapp.entity;

public class Cabbage extends Vegetable {
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
