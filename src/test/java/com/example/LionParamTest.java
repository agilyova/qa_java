package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class LionParamTest {
    String sex;
    Boolean gasMane;
    Lion lion;
    Feline feline;

    public LionParamTest(String sex, Boolean gasMane) {
        this.sex = sex;
        this.gasMane = gasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setParams() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        lion = new Lion(feline, sex);

        assertEquals(gasMane, lion.doesHaveMane());
    }
}


