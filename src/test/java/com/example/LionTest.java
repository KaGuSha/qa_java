package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesHaveManeMaleTrue() throws Exception {
        boolean expected = true;
        Lion lion = new Lion("Самец", feline);

        boolean actual = lion.doesHaveMane();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение результата функции: ",expected, actual);
    }

    @Test
    public void doesHaveManeFemaleFalse() throws Exception {
        boolean expected = false;
        Lion lion = new Lion("Самка", feline);

        boolean actual = lion.doesHaveMane();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение результата функции: ",expected, actual);
    }

    @Test
    public void getKittensLionHasOne() throws Exception {
        int expected = 1;
        Lion lion = new Lion("Самка", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ",expected, actual);
    }

    @Test
    public void getFoodLionMeatBirdFish() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expected, actual);
    }

    @Test
    public void constructorLionMaleAndFelineObjectNotNullHasManeTrue() throws Exception {
        boolean hasManeExpected = true;

        Lion lion = new Lion("Самец", feline);
        boolean hasManeActual = lion.hasMane;

        Assert.assertNotNull(lion);
        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение переменной hasMane: ", hasManeExpected, hasManeActual);
    }

    @Test
    public void constructorLionWithFemaleAndFelineObjectNotNullHasManeFalse() throws Exception {
        boolean hasManeExpected = false;

        Lion lion = new Lion("Самка", feline);
        boolean hasManeActual = lion.hasMane;

        Assert.assertNotNull(lion);
        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение переменной hasMane: ", hasManeExpected, hasManeActual);
    }

    @Test
    public void constructorLionOtherVariantReturnException() {
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = null;

        try {
            Lion lion = new Lion("Котенок", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        String actualExceptionMessage = exception.getMessage();

        Assert.assertNotNull(exception);
        Assert.assertEquals("Текст ошибки отличается от ожидаемого: ",expectedExceptionMessage, actualExceptionMessage);
    }
}