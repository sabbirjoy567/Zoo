package com.smj.zoo;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Serializable{

    private String name;
    private Date birthDate;
    private int age;
    private String species;
    private double lifeExpectancy;

    public Animal(String name, Date birthday, int age, String species) {
        this.name = name;
        this.birthDate = birthday;
        this.age = age;
        this.species = species;
        this.lifeExpectancy = calculateLifeExpectancy();
    }

    public double calculateLifeExpectancy() {
        return 15-this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}
