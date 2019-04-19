package com.chefapp.service;

import com.chefapp.entity.vegetables.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findByCalories(double start, double end);

    List<Vegetable> findByCalories(double calories);

    List<Vegetable> findByName(String name);

    boolean addVegetable(Vegetable vegetable);

    boolean removeVegetable(Vegetable vegetable);

}
