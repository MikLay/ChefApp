package com.chefapp.entity;

public abstract class Vegetable {

    private double calories;
    private double caloriesH;
    private String name;
    private int weight;
    private VegetableWayOfCooking[] wayOfCooking;

    public double getCalories() {
        return caloriesH;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getCaloriesH() {
        return caloriesH;
    }

    public VegetableWayOfCooking[] getWayOfCooking() {
        return wayOfCooking;
    }

    protected void setCaloriesH(double caloriesH) {
        this.caloriesH = caloriesH;
    }

    protected void setCalories() {
        this.calories = this.caloriesH / 100 * this.weight;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    protected void setWayOfCooking(VegetableWayOfCooking[] wayOfCooking) {
        this.wayOfCooking = wayOfCooking;
    }


    protected static abstract class VegetableBuilder<T extends Vegetable, B extends VegetableBuilder> {

        protected T actualVegetable;
        protected B actualBuilder;

        protected abstract T getActuall();

        protected abstract B getActualBuilder();

        protected VegetableBuilder() {
            actualVegetable = getActuall();
            actualBuilder = getActualBuilder();
        }

        public B name(String name) {
            actualVegetable.setName(name);
            return actualBuilder;
        }

        public B wayOfCooking(VegetableWayOfCooking[] wayOfCooking) {
            actualVegetable.setWayOfCooking(wayOfCooking);
            return actualBuilder;
        }

        public B weight(int weight) {
            actualVegetable.setWeight(weight);
            return actualBuilder;
        }

        public B caloriesH(double caloriesH) {
            actualVegetable.setCaloriesH(caloriesH);
            return actualBuilder;
        }

        public T build() {
            actualVegetable.setCalories();
            return actualVegetable;
        }


    }
}
