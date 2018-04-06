package com.smj.zoo;

import java.util.Date;

public class Pig extends Mammal {

    public Pig(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return super.calculateLifeExpectancy();
    }
}
