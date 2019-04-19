package com.chefapp.service.impl;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.Vegetable;
import com.chefapp.repository.SaladRepository;
import com.chefapp.service.SaladService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SaladServiceImpl implements SaladService {
    private SaladRepository saladRepository;

    public SaladServiceImpl(SaladRepository saladRepository) {
        this.saladRepository = saladRepository;
    }

    @Override
    public List<Salad<Vegetable>> findByCalories(double start, double end) {
        return saladRepository.findByCalories(start, end);
    }

    @Override
    public List<Salad<Vegetable>> findByCalories(double calories) {
        return saladRepository.findByCalories(calories);
    }

    @Override
    public List<Salad<Vegetable>> sortByProperty(Salad.sortingProperties sortingProperty) {
        Comparator<Salad> comparator;
        switch (sortingProperty) {
            case ID:
                comparator = Salad.SaladIdComparator;
                break;
            case CALORITY:
                comparator = Salad.SaladCalorityComparator;
                break;
            case VEGETABLESaMOUNT:
                comparator = Salad.SaladVegetablesQuantityComparator;
                break;
            default:
                comparator = Salad.SaladNameComparator;
        }
        return saladRepository.getSalads().stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<Salad<Vegetable>> findByName(String name) {
        return saladRepository.findByName(name);
    }

    @Override
    public boolean createSalad(Salad<Vegetable> salad) {
        return saladRepository.addSalad(salad);
    }

    @Override
    public boolean removeSalad(Salad<Vegetable> salad) {
        return saladRepository.removeSalad(salad);
    }
}
