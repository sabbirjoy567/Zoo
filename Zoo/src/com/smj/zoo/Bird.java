package com.smj.zoo;

import java.util.Date;

public class Bird extends Animal {

    public Bird(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return 5;
    }
}
