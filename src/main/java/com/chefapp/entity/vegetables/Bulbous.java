package com.chefapp.entity.vegetables;

public class Bulbous extends Vegetable {

    private boolean isSweet;

    public boolean getIfIsSweet() {
        return isSweet;
    }

    private void setSweet(boolean isSweet) {
        this.isSweet = isSweet;
    }

    @Override
    public String toString() {
        return "Bulbous{" + super.toString() +
                "isSweet=" + isSweet +
                '}';
    }

    public static class BulbousBuilder extends VegetableBuilder<Bulbous, BulbousBuilder> {

        public BulbousBuilder isSweet(boolean isSweet) {
            actualVegetable.setSweet(isSweet);
            return this;
        }

        @Override
        protected Bulbous getActuall() {
            return new Bulbous();
        }

        @Override
        protected BulbousBuilder getActualBuilder() {
            return this;
        }
    }
}
