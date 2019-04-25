package com.chefapp.entity.vegetables;

public class RootCrop extends Vegetable {
    @Override
    public String toString() {
        return "RootCrop{" + super.toString() + "}";
    }

    public static class RootCropBuilder extends VegetableBuilder<RootCrop, RootCropBuilder> {
        @Override
        protected RootCrop getActuall() {
            return new RootCrop();
        }

        @Override
        protected RootCropBuilder getActualBuilder() {
            return this;
        }


    }
}
