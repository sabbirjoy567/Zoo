package com.smj.zoo;

import java.util.Date;

public class Reptile extends Animal {

    public Reptile(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return super.calculateLifeExpectancy();
    }
}
