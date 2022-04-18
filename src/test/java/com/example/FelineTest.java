package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void getFamilyFeline() {
        String expected = "Кошачьи";
        Feline feline = new Feline();

        String actual = feline.getFamily();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое: ",expected,actual);
    }

    @Test
    public void getKittensWithoutCountHasOne() {
        int expected = 1;
        Feline feline = new Feline();

        int actual = feline.getKittens();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expected,actual);
    }

    @Test
    public void eatMeatEatMeatBirdFish() throws Exception {
        List<String> expected = List.of("Животные","Птицы","Рыба");
        Feline feline = new Feline();

        List<String> actual = feline.eatMeat();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expected,actual);
    }

    @Test()
    public void getFoodFromFelinePredatorEatMeatBirdFish() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные","Птицы","Рыба");

        List<String> actual = feline.getFood("Хищник");

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ",expected,actual);
    }

    @Test()
    public void getFoodFromFelineIfHerbivorousEatGrass() throws Exception {

        Feline feline = new Feline();
        List<String> expected = List.of("Трава", "Различные растения");

        List<String> actual = feline.getFood("Травоядное");

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expected,actual);
    }

    @Test
    public void getFoodFromFelineOtherVariantExpectedException() {

        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Feline feline = new Feline();

        Exception exception = Assert.assertThrows(Exception.class,() -> feline.getFood("Другое"));
        String actualExceptionMessage = exception.getMessage();
        Assert.assertEquals("Текст ошибки отличается от ожидаемого: ",expectedExceptionMessage,actualExceptionMessage);
    }
}