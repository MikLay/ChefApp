package com.chefapp.service.impl;

import com.chefapp.entity.vegetables.*;
import com.chefapp.repository.VegetableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VegetableServiceImplTest {

    @Mock
    private VegetableRepository vegetableRepository;

    @InjectMocks
    private VegetableServiceImpl vegetableService;


    @Test
    public void findByCalories() {
        List<Vegetable> expected = generateVegetables();
        when(vegetableRepository.findByCalories(40, 100)).thenReturn(generateVegetables());
        List<Vegetable> actual = vegetableService.findByCalories(40,100);
        assertEquals(expected,actual);
    }

    @Test
    public void findByCalories1() {
        List<Vegetable> expected = generateVegetables();
        when(vegetableRepository.findByCalories(100)).thenReturn(generateVegetables());
        List<Vegetable> actual = vegetableService.findByCalories(100);
        assertEquals(expected,actual);
    }

    @Test
    public void findByName() {
        List<Vegetable> expected = Collections.singletonList(generateSingleVegetable(1L, "Cucamber"));
        when(vegetableRepository.findByCalories(100)).thenReturn(asList(generateSingleVegetable(1L,"Cucamber")));
        List<Vegetable> actual = vegetableService.findByCalories(100);
        assertEquals(expected,actual);
    }

    @Test
    public void addVegetable() {
        Vegetable vegetable = generateSingleVegetable(1L, "TestVegetable");
        when(vegetableRepository.addVegetable(vegetable)).thenReturn(true);
        boolean actual = vegetableService.addVegetable(vegetable);
        assertTrue(actual);

    }

    @Test
    public void removeVegetable() {
        Vegetable vegetable = generateSingleVegetable(1L, "TestVegetable");
        when(vegetableRepository.removeVegetable(vegetable)).thenReturn(true);
        boolean actual = vegetableService.removeVegetable(vegetable);
        assertTrue(actual);

    }

    List<Vegetable> generateVegetables()
    {
        return asList(
                new Melons
                        .MelonsBuilder()
                        .id(1L)
                        .name("Melon")
                        .caloriesH(200)
                        .weight(500)
                        .wayOfCooking(new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.BOIL, VegetableWayOfCooking.MASH})
                        .build(),
                new Spicy
                        .SpicyBuilder()
                        .id(2L)
                        .name("Pepper")
                        .caloriesH(60)
                        .weight(120)
                        .wayOfCooking(new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.BOIL, VegetableWayOfCooking.MASH})
                        .spicyLevel(1)
                        .build(),
                new RootCrop
                        .RootCropBuilder()
                        .id(3L)
                        .name("Potato")
                        .caloriesH(200)
                        .weight(500)
                        .wayOfCooking(new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.BOIL, VegetableWayOfCooking.MASH})
                        .build()

        );

    }

    Vegetable generateSingleVegetable(Long id,String name)
    {
        return new Melons
                        .MelonsBuilder()
                        .id(id)
                        .name(name)
                        .caloriesH(100)
                        .weight(500)
                        .wayOfCooking(new VegetableWayOfCooking[]{VegetableWayOfCooking.CUT, VegetableWayOfCooking.DICE, VegetableWayOfCooking.BOIL, VegetableWayOfCooking.MASH})
                        .build();
    }
}