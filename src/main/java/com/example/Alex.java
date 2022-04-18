package com.example;

import java.util.*;

public class Alex extends Lion{
    private boolean hasMane;
    private Feline feline;

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends(){

        /*
        List<String> friendName= new ArrayList<>();
        Map<String,String>  friends = new HashMap<>();
        friends.put("Зебра", "Марти");
        friends.put("Бегемот", "Глория");
        friends.put("Жираф", "Мелман");
        for (String friend: friends.values()){
            friendName.add(friend);
        }
        return friendName;
        */

        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens(){
        return 0;
    }
}
