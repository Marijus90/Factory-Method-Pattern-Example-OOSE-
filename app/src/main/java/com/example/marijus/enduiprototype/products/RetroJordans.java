package com.example.marijus.enduiprototype.products;

/**
 * Created by Marijus on 22/03/2017.
 */

public class RetroJordans extends PlaceholderProduct implements Product{
    @Override
    public String getName() {
        return "Retro Jordans";
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public String getImage() {
        return null;
    }
}
