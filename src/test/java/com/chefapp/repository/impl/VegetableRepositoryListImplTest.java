package com.chefapp.repository.impl;

import com.chefapp.entity.vegetables.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class VegetableRepositoryListImplTest {

    @Test
    public void shouldGetVegetables() {
        VegetableRepositoryListImpl vegetableImpl = new VegetableRepositoryListImpl(generateVegetableList());
        List<Vegetable> expected = generateVegetableList();
        List<Vegetable> actual = vegetableImpl.getVegetables();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByCalories() {
        VegetableRepositoryListImpl vegetableImpl = new VegetableRepositoryListImpl(generateVegetableList());
        List<Vegetable> expected = new ArrayList<>(generateVegetableList());
        expected.remove(createCabbage(63, 100));
        List<Vegetable> actual = vegetableImpl.findByCalories(10, 40);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByCalories1() {
        VegetableRepositoryListImpl vegetableImpl = new VegetableRepositoryListImpl(generateVegetableList());
        List<Vegetable> expected = new ArrayList<>(Collections.singletonList(createCabbage(63, 100)));
        List<Vegetable> actual = vegetableImpl.findByCalories(63);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        VegetableRepositoryListImpl vegetableImpl = new VegetableRepositoryListImpl(generateVegetableList());
        List<Vegetable> expected = asList(
                createPotato(20, 100),
                createPotato(30, 100),
                createPotato(20, 100));
        List<Vegetable> actual = vegetableImpl.findByName("Potato");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddVegetable() {
        VegetableRepositoryListImpl vegetableImpl =
                new VegetableRepositoryListImpl(new ArrayList<>(generateVegetableList()));
        Vegetable addedVegetable = createCabbage(41, 200);
        List<Vegetable> expected = new ArrayList<>(generateVegetableList());
        expected.add(addedVegetable);
        vegetableImpl.addVegetable(addedVegetable);
        List<Vegetable> actual = vegetableImpl.getVegetables();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveVegetable() {
        VegetableRepositoryListImpl vegetableImpl =
                new VegetableRepositoryListImpl(new ArrayList<>(generateVegetableList()));
        Vegetable removedVegetable = createBulbous(40, 100);
        List<Vegetable> expected = new ArrayList<>(generateVegetableList());
        expected.remove(removedVegetable);
        vegetableImpl.removeVegetable(removedVegetable);
        List<Vegetable> actual = vegetableImpl.getVegetables();
        assertEquals(expected, actual);
    }


    private List<Vegetable> generateVegetableList() {
        return asList(
                createBulbous(10, 100),
                createBulbous(20, 100),
                createBulbous(40, 100),
                createBulbous(10, 100),
                createCabbage(23, 100),
                createCabbage(10, 100),
                createCabbage(63, 100),
                createPotato(20, 100),
                createPotato(30, 100),
                createPotato(20, 100)
        );
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
