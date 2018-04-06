package com.smj.zoo;

import java.util.Date;

public class Turtle extends Reptile {

    public Turtle(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return 110 - this.getAge();
    }
}
