package com.chefapp.repository.impl;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SaladRepositoryListImplTest {


    @Test
    public void shouldGetSalads() {
        List<Salad<Vegetable>> whole = generateList();
        SaladRepositoryListImpl saladsImp = new SaladRepositoryListImpl(whole);
        List<Salad<Vegetable>> actual = saladsImp.getSalads();
        assertEquals(actual, whole);
    }

    @Test
    public void shouldFindByCalories() {
        SaladRepositoryListImpl saladsImpl = new SaladRepositoryListImpl(generateList());
        List<Salad<Vegetable>> actual = saladsImpl.findByCalories(43, 200);
        List<Salad<Vegetable>> expected = Collections.singletonList(
                new Salad<>(1L, "S1", asList(
                        createBulbous(20, 100),
                        createBulbous(20, 100),
                        createCabbage(40, 140)
                )));

        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindByCalories1() {
        SaladRepositoryListImpl saladsImpl = new SaladRepositoryListImpl(generateList());
        List<Salad<Vegetable>> actual = saladsImpl.findByCalories(96D);
        List<Salad<Vegetable>> expected = Collections.singletonList(
                new Salad<>(1L, "S1", asList(
                        createBulbous(20, 100),
                        createBulbous(20, 100),
                        createCabbage(40, 140)
                )));

        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindByName() {
        SaladRepositoryListImpl saladsImpl = new SaladRepositoryListImpl(generateList());
        List<Salad<Vegetable>> actual = saladsImpl.findByName("S2");
        List<Salad<Vegetable>> expected = Collections.singletonList(
                new Salad<>(1L, "S2", asList(
                        createPotato(41, 150),
                        createPotato(21, 150),
                        createPotato(10, 50),
                        createCabbage(32, 500)

                )));
        assertEquals(actual, expected);

    }

    @Test
    public void shouldAddSalad() {
        SaladRepositoryListImpl saladsImpl = new SaladRepositoryListImpl(new ArrayList<>(generateList()));
        Salad<Vegetable> addedSalad = new Salad<>(1L, "NewSalad", asList(
                createPotato(41, 150),
                createBulbous(21, 150),
                createCabbage(32, 500)

        ));
        saladsImpl.addSalad(addedSalad);
        List<Salad<Vegetable>> expected = new ArrayList<>(generateList());
        expected.add(addedSalad);
        List<Salad<Vegetable>> actual = saladsImpl.getSalads();
        assertEquals(expected,actual);
    }

    @Test
    public void shouldRemoveSalad() {
        SaladRepositoryListImpl saladsImpl = new SaladRepositoryListImpl(new ArrayList<>(generateList()));
        Salad<Vegetable> removedSalad = new Salad<>(1L, "S2", asList(
                createPotato(41, 150),
                createPotato(21, 150),
                createPotato(10, 50),
                createCabbage(32, 500)

        ));
        List<Salad<Vegetable>> expected = new ArrayList<>(generateList());
        expected.remove(removedSalad);
        saladsImpl.removeSalad(removedSalad);
        List<Salad<Vegetable>> actual = saladsImpl.getSalads();
        assertEquals(expected,actual);

    }

    private List<Salad<Vegetable>> generateList() {
        return asList(
                new Salad<>(1L, "S1", asList(
                        createBulbous(20, 100),
                        createBulbous(20, 100),
                        createCabbage(40, 140)
                )),

                new Salad<>(1L, "S2", asList(
                        createPotato(41, 150),
                        createPotato(21, 150),
                        createPotato(10, 50),
                        createCabbage(32, 500)

                )),

                new Salad<>(1L, "S3", asList(
                        createPotato(10, 150),
                        createPotato(21, 100),
                        createBulbous(10, 50)
                )));
    }

    private Vegetable createPotato(int caloriesIn100, int weight) {
        return new RootCrop.RootCropBuilder()
                .name("Potato")
                .wayOfCooking(
                        new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.BOIL, VegetableWayOfCooking.MASH})
                .caloriesH(caloriesIn100)
                .weight(weight)
                .build();
    }

    private Vegetable createCabbage(int caloriesIn100, int weight) {
        return new Cabbage.CabbageBuilder()
                .name("Pickled cucumber")
                .wayOfCooking(
                        new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.SLICE})
                .caloriesH(caloriesIn100)
                .weight(weight)
                .build();
    }

    private Vegetable createBulbous(int caloriesIn100, int weight) {
        return new Bulbous.BulbousBuilder()
                .name("Onion")
                .wayOfCooking(
                        new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.SLICE})
                .caloriesH(caloriesIn100)
                .weight(weight)
                .build();
    }
}