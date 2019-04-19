package com.chefapp.service;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.Vegetable;

import java.util.List;

public interface SaladService {
    List<Salad<Vegetable>> findByCalories(double start, double end);
    List<Salad<Vegetable>> findByCalories(double calories);

    List<Salad<Vegetable>> sortByProperty(Salad.sortingProperties sortingProperty);
    List<Salad<Vegetable>> findByName(String name);

    boolean createSalad(Salad<Vegetable> salad);
    boolean removeSalad(Salad<Vegetable> salad);

}
