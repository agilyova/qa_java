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
    private Feline feline;

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
        int expectedAmountOfKittens = 1;

        assertEquals(expectedAmountOfKittens, feline.getKittens(1));
    }

    @Test
    public void getKittensWithZeroArgumentReturnArgument() {
        int expectedAmountOfKittens = 0;

        assertEquals(expectedAmountOfKittens, feline.getKittens(0));
    }

    @Ignore("Не реализовано")
    @Test
    public void getKittensWithNegativeArgumentReturnError() {
        assertEquals("Число котят не может быть отрицательным", feline.getKittens(-1) );
    }

    @Test
    public void getKittensWithoutArgumentReturnOne() {
        int expectedAmountOfDefaultKittens = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(1);

        assertEquals(expectedAmountOfDefaultKittens, feline.getKittens());
        Mockito.verify(feline).getKittens(1);
    }
}
