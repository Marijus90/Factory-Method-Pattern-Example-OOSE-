package com.example.marijus.enduiprototype.products;

import com.example.marijus.enduiprototype.R;

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
    public int getImage() {
        return R.drawable.retro_jordan;
    }
}
