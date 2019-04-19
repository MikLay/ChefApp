package com.chefapp.entity.vegetables;

public class RootCrop extends Vegetable {
    public static class RootCropBuilder extends VegetableBuilder<RootCrop,RootCropBuilder>
    {
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
