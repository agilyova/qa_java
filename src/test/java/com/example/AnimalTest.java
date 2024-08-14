package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodPredatorReturnPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    public void getFoodHerbivoreReturnHerbivoreFood() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodInsectivorousReturnErrorString() throws Exception {
        try {
            animal.getFood("Насекомоядные");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
