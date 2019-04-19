package com.chefapp.repository.impl;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.Vegetable;
import com.chefapp.repository.SaladRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SaladRepositoryListImpl implements SaladRepository {
    private List<Salad<Vegetable>> salads;

    public SaladRepositoryListImpl(List<Salad<Vegetable>> salads) {
        this.salads = salads;
    }

    @Override
    public List<Salad<Vegetable>> getSalads() {
        return salads;
    }

    @Override
    public List<Salad<Vegetable>> findByCalories(double start, double end) {
        return salads.stream()
                .filter(salad -> salad.getCaloric() <= end && salad.getCaloric() >= start)
                .collect(Collectors.toList());
    }

    @Override
    public List<Salad<Vegetable>> findByCalories(double calories) {
        return findByCalories(calories, calories);
    }

    @Override
    public List<Salad<Vegetable>> findByName(String name) {
        return salads.stream().filter(salad -> salad.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public boolean addSalad(Salad salad) {
        return salads.add(salad);
    }

    @Override
    public boolean removeSalad(Salad salad) {
        return salads.remove(salad);
    }
}
