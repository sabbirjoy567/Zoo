package com.smj.zoo;

import java.util.Date;

public class Hawk extends Bird {

    public Hawk(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return super.calculateLifeExpectancy();
    }
}
