package com.smj.zoo;

import java.util.Date;

public class Iguana extends Reptile {

    public Iguana(String name, Date birthday, int age, String species) {
        super(name, birthday, age, species);
    }

    @Override
    public double calculateLifeExpectancy() {

        //cast 1 to double to avoid integer division which will give zero
        // if divisor is bigger than the dividend
        return ((double)1/this.getAge()) * 10;
    }
}
