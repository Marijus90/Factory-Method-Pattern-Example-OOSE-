package com.example.marijus.enduiprototype.products;

import com.example.marijus.enduiprototype.R;

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
    public int getImage() {
        return R.drawable.gym_trainers;
    }
}
