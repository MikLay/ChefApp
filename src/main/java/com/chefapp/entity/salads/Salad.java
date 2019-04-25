package com.chefapp.entity.salads;

import com.chefapp.entity.vegetables.Vegetable;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Salad<T extends Vegetable> {
    public static final Comparator<Salad> SaladIdComparator = (o1, o2) -> {
        Long id1 = o1.getSaladId();
        Long id2 = o2.getSaladId();

        return id1.compareTo(id2);
    };
    public static final Comparator<Salad> SaladCalorityComparator = (o1, o2) -> {
        double caloric1 = o1.getCaloric();
        double caloric2 = o2.getCaloric();

        return Double.compare(caloric1, caloric2);
    };
    public static final Comparator<Salad> SaladNameComparator = (o1, o2) -> {
        String name1 = o1.getName().toUpperCase();
        String name2 = o2.getName().toUpperCase();

        return name1.compareTo(name2);
    };
    public static final Comparator<Salad> SaladVegetablesQuantityComparator = (o1, o2) -> {
        int name1 = o1.getVegetables().size();
        int name2 = o2.getVegetables().size();

        return Integer.compare(name1, name2);
    };
    private Long saladId;
    private List<T> vegetables;
    private String name;
    private double caloric;

    public Salad(Long saladId, String name, List<T> vegetables) {
        this.saladId = saladId;
        caloric = vegetables.stream().mapToDouble(Vegetable::getCalories).sum();
        this.vegetables = vegetables;
        this.name = name;
    }

    public List<T> getVegetables() {
        return vegetables;
    }

    public String getName() {
        return name;
    }

    public double getCaloric() {
        return caloric;
    }

    public Long getSaladId() {
        return saladId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salad)) {
            return false;
        }
        Salad<?> salad = (Salad<?>) o;
        return Double.compare(salad.getCaloric(), getCaloric()) == 0 &&
                Objects.equals(getVegetables(), salad.getVegetables()) &&
                Objects.equals(getName(), salad.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVegetables(), getName(), getCaloric());
    }

    @Override
    public String toString() {
        return "Salad{" +
                "saladId=" + saladId +
                ", name='" + name + '\'' +
                ", caloric=" + caloric +
                ", vegetables=" + vegetables +
                '}';
    }

    public enum sortingProperties {
        CALORITY, ID, NAME, VEGETABLES_AMOUNT
    }
}
