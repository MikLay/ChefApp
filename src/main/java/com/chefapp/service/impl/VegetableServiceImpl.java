package com.chefapp.service.impl;

import com.chefapp.entity.vegetables.Vegetable;
import com.chefapp.repository.VegetableRepository;
import com.chefapp.service.VegetableService;

import java.util.List;

public class VegetableServiceImpl implements VegetableService {
    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findByCalories(double start, double end) {
        return vegetableRepository.findByCalories(start, end);
    }

    @Override
    public List<Vegetable> findByCalories(double calories) {
        return vegetableRepository.findByCalories(calories);
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.findByName(name);
    }

    @Override
    public boolean addVegetable(Vegetable vegetable) {
        return vegetableRepository.addVegetable(vegetable);
    }

    @Override
    public boolean removeVegetable(Vegetable vegetable) {
        return vegetableRepository.removeVegetable(vegetable);
    }
}
