package com.example.marijus.enduiprototype.products;

/**
 * Created by Marijus on 22/03/2017.
 */

public class GymTrainers extends PlaceholderProduct implements Product {
    @Override
    public String getName() {
        return "Gym Trainers";
    }

    @Override
    public int getPrice() {
        return 80;
    }

    @Override
    public String getImage() {
        return null;
    }
}
