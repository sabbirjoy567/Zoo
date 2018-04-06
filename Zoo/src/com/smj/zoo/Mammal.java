package com.smj.zoo;

import java.util.Date;

public class Mammal extends Animal {

    public Mammal(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {
        return 15 - this.getAge();
    }
}
