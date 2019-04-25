package com.chefapp.repository.impl;

import com.chefapp.entity.vegetables.Vegetable;
import com.chefapp.repository.VegetableRepository;

import java.util.List;
import java.util.stream.Collectors;

public class VegetableRepositoryListImpl implements VegetableRepository {
    private List<Vegetable> vegetables;

    public VegetableRepositoryListImpl(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    @Override
    public List<Vegetable> findByCalories(double start, double end) {
        return vegetables.stream()
                .filter(vegetable -> vegetable.getCalories() >= start && vegetable.getCalories() <= end)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vegetable> findByCalories(double calories) {
        return findByCalories(calories, calories);
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetables.stream().filter(vegetable -> vegetable.getName()
                .equals(name)).collect(Collectors.toList());
    }

    @Override
    public boolean addVegetable(Vegetable vegetable) {
        return vegetables.add(vegetable);
    }

    @Override
    public boolean removeVegetable(Vegetable vegetable) {
        return vegetables.remove(vegetable);
    }


}
