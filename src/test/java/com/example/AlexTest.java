package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void getFriendMartyGloriaMelman() throws Exception {

        List<String> expectedNameFriend = List.of("Марти", "Глория", "Мелман");
        Feline feline = new Feline();
        Alex alex = new Alex(feline);

        List<String> actualNameFriend = alex.getFriends();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое: ", expectedNameFriend, actualNameFriend);
    }

    @Test
    public void getPlaceOfLivingNewYorkZoo() throws Exception {

        String expected = "Нью-Йоркский зоопарк";
        Feline feline = new Feline();
        Alex alex = new Alex(feline);

        String actual = alex.getPlaceOfLiving();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое: ", expected, actual);
    }

    @Test
    public void getKittensAlexHasNot() throws Exception {

        int expected = 0;
        Feline feline = new Feline();
        Alex alex = new Alex(feline);

        int actual = alex.getKittens();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое: ", expected, actual);
    }

    @Test
    public void doesHaveManeFromAlexHasMane() throws Exception {

        Feline feline = new Feline();
        Alex alex = new Alex(feline);

        boolean actual = alex.doesHaveMane();

        Assert.assertTrue("Результат отличается от ожидаемого значения. Ожидаемое: true", actual);
    }

    @Test
    public void getFoodAlexMeatBirdFish() throws Exception {

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Alex alex = new Alex(feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = alex.getFood();

        Assert.assertEquals("Результат отличается от ожидаемого значения. Ожидаемое значение: ", expected, actual);
    }
}