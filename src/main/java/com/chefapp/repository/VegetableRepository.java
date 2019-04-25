package com.chefapp.repository;

import com.chefapp.entity.vegetables.Vegetable;

import java.util.List;

public interface VegetableRepository {

    List<Vegetable> findByCalories(double start, double end);

    List<Vegetable> findByCalories(double calories);

    List<Vegetable> findByName(String name);

    List<Vegetable> getVegetables();

    boolean addVegetable(Vegetable vegetable);

    boolean removeVegetable(Vegetable vegetable);
}
