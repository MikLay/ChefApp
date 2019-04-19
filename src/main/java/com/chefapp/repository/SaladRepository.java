package com.chefapp.repository;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.Vegetable;

import java.util.List;

public interface SaladRepository {

    List<Salad<Vegetable>> findByCalories(double start, double end);

    default List<Salad<Vegetable>> findByCalories(double calories) {
        return findByCalories(calories, calories);
    }

    List<Salad<Vegetable>> findByName(String name);

    List<Salad<Vegetable>> getSalads();


    boolean addSalad(Salad<Vegetable> salad);
    boolean removeSalad(Salad<Vegetable> salad);
}
