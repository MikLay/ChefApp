package com.chefapp.entity.vegetables;

public class Spicy extends Vegetable {

    private int spicyLevel;

    public int getSpicyLevel() {
        return spicyLevel;
    }

    private void setSpicyLevel(int spicyLevel) {
        this.spicyLevel = spicyLevel;
    }

    public static class SpicyBuilder extends VegetableBuilder<Spicy, SpicyBuilder> {

        public SpicyBuilder spicyLevel(int spiceLevel)
        {
            actualVegetable.setSpicyLevel(spiceLevel);
            return this;
        }

        @Override
        protected Spicy getActuall() {
            return new Spicy();
        }

        @Override
        protected SpicyBuilder getActualBuilder() {
            return this;
        }
    }
}
