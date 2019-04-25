package com.chefapp.entity.vegetables;

import java.util.Arrays;
import java.util.Objects;

public abstract class Vegetable {

    private Long vegetableId;
    private double calories;
    private double caloriesH;
    private String name;
    private int weight;
    private VegetableWayOfCooking[] wayOfCooking;

    public double getCalories() {
        return calories;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    protected void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCaloriesH() {
        return caloriesH;
    }

    protected void setCaloriesH(double caloriesH) {
        this.caloriesH = caloriesH;
    }

    public VegetableWayOfCooking[] getWayOfCooking() {
        return wayOfCooking;
    }

    protected void setWayOfCooking(VegetableWayOfCooking[] wayOfCooking) {
        this.wayOfCooking = wayOfCooking;
    }

    protected void setCalories() {
        this.calories = this.caloriesH / 100 * this.weight;
    }

    @Override
    public String toString() {
        return "vegetableId=" + vegetableId +
                ", calories=" + calories +
                ", caloriesH=" + caloriesH +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", wayOfCooking=" + Arrays.toString(wayOfCooking);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vegetable)) {
            return false;
        }
        Vegetable vegetable = (Vegetable) o;
        return Objects.equals(getName(), vegetable.getName()) &&
                Arrays.equals(getWayOfCooking(), vegetable.getWayOfCooking());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName());
        result = 31 * result + Arrays.hashCode(getWayOfCooking());
        return result;
    }

    protected static abstract class VegetableBuilder<T extends Vegetable, B extends VegetableBuilder> {

        protected T actualVegetable;
        protected B actualBuilder;

        protected VegetableBuilder() {
            actualVegetable = getActuall();
            actualBuilder = getActualBuilder();
        }

        protected abstract T getActuall();

        protected abstract B getActualBuilder();

        public B id(Long id) {
            actualVegetable.setVegetableId(id);
            return actualBuilder;
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
