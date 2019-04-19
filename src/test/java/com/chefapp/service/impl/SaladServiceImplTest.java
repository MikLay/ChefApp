package com.chefapp.service.impl;

import com.chefapp.entity.salads.Salad;
import com.chefapp.entity.vegetables.RootCrop;
import com.chefapp.entity.vegetables.Vegetable;
import com.chefapp.entity.vegetables.VegetableWayOfCooking;
import com.chefapp.repository.SaladRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaladServiceImplTest {

    @Mock
    private SaladRepository saladRepository;

    @InjectMocks
    private SaladServiceImpl saladService;


    @Test
    public void shouldFindByCalories() {
        when(saladRepository.findByCalories(40, 100)).thenReturn(Collections.singletonList(generateSalad(1L, "Venegret", 100)));
        List<Salad<Vegetable>> actual = saladService.findByCalories(40, 100);
        List<Salad<Vegetable>> expected = Collections.singletonList(generateSalad(1L, "Venegret", 100));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByCalories1() {
        when(saladRepository.findByCalories(100)).thenReturn(Collections.singletonList(generateSalad(1L, "Venegret", 100)));

        List<Salad<Vegetable>> actual = saladService.findByCalories(100);
        List<Salad<Vegetable>> expected = Collections.singletonList(generateSalad(1L, "Venegret", 100));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPropertyId() {
        when(saladRepository.getSalads()).thenReturn(generateSalads());
        List<Salad<Vegetable>> actual = saladService.sortByProperty(Salad.sortingProperties.ID);
        List<Salad<Vegetable>> expected = asList(
                generateSalad(1L, "Baligo", 300),
                generateSalad(2L, "Cancada", 100),
                generateSalad(3L, "Astrouse", 200));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPropertyName() {
        when(saladRepository.getSalads()).thenReturn(generateSalads());
        List<Salad<Vegetable>> actual = saladService.sortByProperty(Salad.sortingProperties.NAME);
        List<Salad<Vegetable>> expected = generateSalads();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPropertyCalories() {
        when(saladRepository.getSalads()).thenReturn(generateSalads());
        List<Salad<Vegetable>> actual = saladService.sortByProperty(Salad.sortingProperties.CALORITY);
        List<Salad<Vegetable>> expected = asList(
                generateSalad(2L, "Cancada", 100),
                generateSalad(3L, "Astrouse", 200),
                generateSalad(1L, "Baligo", 300));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPropertyVegetablesAmount() {
        when(saladRepository.getSalads()).thenReturn(generateSalads());
        List<Salad<Vegetable>> actual = saladService.sortByProperty(Salad.sortingProperties.NAME);
        List<Salad<Vegetable>> expected = generateSalads();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        when(saladRepository.findByName("Venegret")).thenReturn(Collections.singletonList(generateSalad(1L, "Venegret", 100)));
        List<Salad<Vegetable>> actual = saladService.findByName("Venegret");
        List<Salad<Vegetable>> expected = Collections.singletonList(generateSalad(1L, "Venegret", 100));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateSalad() {
        Salad<Vegetable> salad = generateSalad(1L, "Cacururs", 510);
        when(saladRepository.addSalad(salad)).thenReturn(true);
        boolean actual = saladService.createSalad(salad);
        assertTrue(actual);
    }

    @Test
    public void shouldRemoveSalad() {
        Salad<Vegetable> salad = generateSalad(1L, "Cacururs", 510);
        when(saladRepository.removeSalad(salad)).thenReturn(true);
        boolean actual = saladService.removeSalad(salad);
        assertTrue(actual);
    }


    private Salad<Vegetable> generateSalad(Long id, String name, int weight) {
        return
                new Salad<>(id, name,
                        asList(
                                createPotato(50, weight),
                                createPotato(20, weight)
                        ))
                ;
    }

    private List<Salad<Vegetable>> generateSalads() {
        return asList(generateSalad(3L, "Astrouse", 200),
                generateSalad(1L, "Baligo", 300),
                generateSalad(2L, "Cancada", 100));
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
}