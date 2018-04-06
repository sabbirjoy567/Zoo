package com.smj.zoo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Zoo {

    public static boolean addAnimal(Animal animal) {

        if(animal != null) {

            ArrayList<Animal> animalList = DataStore.readZooAnimalsData();
            animalList.add(animal);
            DataStore.saveZooAnimalsData(animalList);
            return true;
        }

        return false;
    }

    public static boolean removeAnimal(Animal animal, ArrayList<Animal> list) {

        if(animal != null) {
            for(Animal a : list) {
                if(a.getName().equals(animal.getName())) {
                    list.remove(a);
                    DataStore.saveZooAnimalsData(list);
                    return true;
                }
            }
        }
        return false;
    }

    public  static Animal updateAnimalInfo(String name) {

        ArrayList<Animal> animalList = DataStore.readZooAnimalsData();

        if(name != null && checkIfExists(name, animalList)) {
            for(Animal a : animalList) {
                if(a.getName().equals(name)) {
                    displayAnimalInfo(a);
                    takeUpdatedInfo(a, animalList);
                }
            }
        }
        return null;
    }

    public static void displayZooAnimals() {

        ArrayList<Animal> animalList = DataStore.readZooAnimalsData();

        if(animalList != null && animalList.size() > 0) {
            System.out.println("\t\t\t\t\t\t\t\tList of animals currently in the Zoo");
            System.out.println("\t\t\t\t\t\t\t\t------------------------------------");

            animalList.forEach(animal -> {
                System.out.println("\t\t\t\t\t\t\t\tAnimal Name = "+animal.getName());
                System.out.println("\t\t\t\t\t\t\t\tAnimal Age = "+animal.getAge());
                System.out.println("\t\t\t\t\t\t\t\tAnimal Birth Date = "+displayFormattedDate(animal));
                System.out.println("\t\t\t\t\t\t\t\tAnimal Species = "+animal.getSpecies());
                System.out.println("\t\t\t\t\t\t\t\tAnimal Life Expectancy = "+animal.getLifeExpectancy()+" years");
                System.out.println("\t\t\t\t\t\t\t\t------------------------------------");
            });

            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
        else if(animalList != null && animalList.size() <= 0){
            System.out.println("Currently there are no animals in the zoo.");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
    }

    public static void displayAnimalInfo(Animal animal) {

        System.out.println("Current information of "+animal.getName());
        System.out.println("------------------------------------");
        System.out.println("Animal Name = "+animal.getName());
        System.out.println("Animal Age = "+animal.getAge());
        System.out.println("Animal Birth Date = "+displayFormattedDate(animal));
        System.out.println("Animal Species = "+animal.getSpecies());
        System.out.println("Animal Life Expectancy = "+animal.getLifeExpectancy()+" years");
        System.out.println("------------------------------------");
    }

    public static boolean checkIfExists(String name, ArrayList<Animal> list) {
        if(name != null && list.size() > 0) {
            for(Animal animal : list) {
                if(animal.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void takeUpdatedInfo(Animal a, ArrayList<Animal> animalList) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = null;

        System.out.println("Update Animal "+ a.getName());
        System.out.println("--------------------------------");

        System.out.println("Enter the name of the animal : ");
        a.setName(scan.nextLine());

        while(!valid) {
            try {
                System.out.println("Enter the birth date of the animal in the following format (day-month-year): ");
                String date = scan.nextLine();
                dateOfBirth = df.parse(date);
                a.setBirthDate(dateOfBirth);
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format");
            }
        }

        System.out.println("Enter the age of the animal : ");
        while(!scan.hasNextInt()) {
            System.out.println("Invalid age input, age should be in an integer");
            System.out.println("Enter the age of birth of the animal : ");
        }
        int age = scan.nextInt();
        a.setAge(age);

        a.setLifeExpectancy(a.calculateLifeExpectancy());

        DataStore.saveZooAnimalsData(animalList);

        System.out.println("Animal information updated successfully");
        System.out.print("\nChoose an option from the Zoo Menu : ");
    }

    private static String displayFormattedDate(Animal animal) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String birthDate = df.format(animal.getBirthDate());
        return birthDate;
    }

    public static Animal getAnimal(String name) {

        ArrayList<Animal> list = DataStore.readZooAnimalsData();

        if(checkIfExists(name, list)) {

            for(Animal a : list) {
                if(a.getName().equals(name)) {
                    return a;
                }
            }
        }
        else {
            System.out.println("No such animal exists in the zoo");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
        return null;
    }
}
