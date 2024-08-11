package com.example;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void getFamilyReturnStringFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatReturnListOfPredatorFood() throws Exception {
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(list);
        List<String> expectedFood = list;
        List<String> factFood = feline.eatMeat();

        assertEquals(expectedFood, factFood);
    }

    @Test
    public void getKittensWithPositiveArgumentReturnArgument() {
        assertEquals(1, feline.getKittens(1));
    }

    @Test
    public void getKittensWithZeroArgumentReturnArgument() {
        assertEquals(0, feline.getKittens(0));
    }

    @Ignore("Не реализовано")
    @Test
    public void getKittensWithNegativeArgumentReturnError() {
        assertEquals("Число котят не может быть отрицательным", feline.getKittens(-1) );
    }

    @Test
    public void getKittensWithoutArgumentReturnOne() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);

        assertEquals(1, feline.getKittens());
        Mockito.verify(feline).getKittens(1);
    }
}
