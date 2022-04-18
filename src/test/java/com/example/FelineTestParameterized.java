package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineTestParameterized {

    private final int kittenCount;
    private final int expectedKittenCount;

    public FelineTestParameterized(int kittenCount, int expectedKittenCount) {
        this.kittenCount = kittenCount;
        this.expectedKittenCount = expectedKittenCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][]{
                {10, 10},
                {0, 0},
                {1, 1},
                {5, 5},
        };
    }

    @Test
    public void getKittensWithKittenCountReturnKittenCount() {
        Feline feline = new Feline();

        int actualKittenCount = feline.getKittens(kittenCount);

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expectedKittenCount, actualKittenCount);
    }
}
