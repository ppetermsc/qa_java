package com.example;

import java.util.List;

public class AlexLion extends Lion {

    public AlexLion(String sex, Feline feline) throws Exception {
        super("Самец", feline);
    }
    public List<String> getFriends(){
       return List.of("Marty zebra ", "Melman giraffe", "Gloria hippo");
    }

    public String getPlaceOfLiving(){
        return "New York Zoo";
    }

    @Override
    public int getKittens(){
        return 0;
    }
}
