package com.smj.zoo;

import java.util.Date;

public class Eagle extends Bird {

    public Eagle(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return super.calculateLifeExpectancy();
    }
}

