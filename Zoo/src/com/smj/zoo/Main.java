package com.smj.zoo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        int userInput;

        printMenu();

        while (run) {

            if(scan.hasNextInt()) {
                userInput = scan.nextInt();
                switch (userInput) {
                    case 1:
                        addAnimal();
                        break;
                    case 2:
                        updateAnimal();
                        break;
                    case 3:
                        removeAnimal();
                        break;
                    case 4:
                        searchAnimal();
                        break;
                    case 5:
                        displayAllAnimals();
                        break;
                    case 6:
                        printMenu();
                        break;
                    case 7:
                        run = false;
                        break;
                }

            }
            else{
                System.out.println("Invalid input, please enter a valid integer input from 1-7");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tZoo Menu");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t--------");
        System.out.println("\t\t\t\t\t\t1. Press 1 to add a new animal to the zoo\n" +
                           "\t\t\t\t\t\t2. Press 2 to update the information of any existing animal\n"+
                           "\t\t\t\t\t\t3. Press 3 to remove any existing animal from the zoo\n"+
                           "\t\t\t\t\t\t4. Press 4 to display information of any existing animal\n"+
                           "\t\t\t\t\t\t5. Press 5 to display information of all the animals currently in the zoo\n"+
                           "\t\t\t\t\t\t6. Press 6 to print the menu\n"+
                           "\t\t\t\t\t\t7. Press 7 to quit the program");

        System.out.print("\nChoose an option from the Zoo Menu : ");
    }

    public static void addAnimal() {
        Animal animal = null;
        boolean animalAdded = false;
        Scanner input = new Scanner(System.in);
        Date dateOfBirth = null;
        boolean valid = false;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        int choice = whichSpecie();

        System.out.println("Enter the name of the animal : ");
        String name = input.nextLine();

        while(!valid) {
            try {
                System.out.println("Enter the birth date of the animal in the following format (day-month-year): ");
                String date = input.nextLine();
                dateOfBirth = df.parse(date);
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format");
            }
        }

        System.out.println("Enter the age of the animal : ");
        while(!input.hasNextInt()) {
            System.out.println("Invalid age input, age should be in an integer");
            System.out.println("Enter the age of birth of the animal : ");
        }
        int age = input.nextInt();

        switch (choice) {
            case 1:
                animal = new Goat(name, dateOfBirth, age, "Goat");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 2:
                animal = new Lion(name, dateOfBirth, age, "Lion");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 3:
                animal = new Pig(name, dateOfBirth, age, "Pig");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 4:
                animal = new Turtle(name, dateOfBirth, age, "Turtle");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 5:
                animal = new Iguana(name, dateOfBirth, age, "Iguana");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 6:
                animal = new Eagle(name, dateOfBirth, age, "Eagle");
                animalAdded = Zoo.addAnimal(animal);
                break;
            case 7:
                animal = new Hawk(name, dateOfBirth, age, "Hawk");
                animalAdded = Zoo.addAnimal(animal);
                break;
        }

        if(animalAdded) {
            System.out.println("New animal added successfully");
            System.out.println("\nChoose an option from the Zoo Menu : ");
        }
        else {
            System.out.println("Error while adding new animal");
        }
    }

    public static void updateAnimal() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animalList = DataStore.readZooAnimalsData();

        System.out.println("Enter the name of the animal that you want to update : ");
        String animalName = scan.nextLine();

        if(Zoo.checkIfExists(animalName, animalList)) {
            Zoo.updateAnimalInfo(animalName);
        }
        else {
            System.out.println("No animal named "+animalName+" found in the zoo");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
    }

    public static void displayAllAnimals() {
        Zoo.displayZooAnimals();
    }

    public static int whichSpecie() {
        int input;

        System.out.println("Which specie do you want to add?");
        System.out.println("--------------------------------");
        System.out.println("1. Press 1 to add a new Goat\n" +
                "2. Press 2 to add a new Lion\n"+
                "3. Press 3 to add a new Pig\n"+
                "4. Press 4 to add a new Turtle\n"+
                "5. Press 5 to add a new Iguana\n"+
                "6. Press 6 to add a new Eagle\n"+
                "7. Press 7 to add a new Hawk");

        input = validUserChoice();

        while(input < 1 || input > 7) {
            System.out.println("Enter valid input between 1-7 : ");
            input = validUserChoice();
        }

        return input;
    }

    public static void searchAnimal() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animalList = DataStore.readZooAnimalsData();

        System.out.println("Enter the name of the animal that you want to search : ");
        String animalName = scan.nextLine();

        if(Zoo.checkIfExists(animalName, animalList)) {
            Animal an = Zoo.getAnimal(animalName);
            Zoo.displayAnimalInfo(an);

            //ask user to choose an option from menu once
            //desired animal's information has been displayed
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
        else {
            System.out.println("No animal named "+animalName+" found in the zoo");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
    }

    public static void removeAnimal() {
        Scanner scan = new Scanner(System.in);
        boolean removed = false;
        ArrayList<Animal> animalList = DataStore.readZooAnimalsData();

        System.out.println("Enter the name of the animal that you want to remove : ");
        String animalName = scan.nextLine();

        if(Zoo.checkIfExists(animalName, animalList)) {
            Animal an = Zoo.getAnimal(animalName);
            removed = Zoo.removeAnimal(an, animalList);
        }
        else {
            System.out.println("No animal named "+animalName+" found in the zoo");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }

        if(removed){
            System.out.println(animalName + " removed from the zoo");
            System.out.print("\nChoose an option from the Zoo Menu : ");
        }
    }

    public static int validUserChoice() {
        Scanner scan = new Scanner(System.in);
        int input;

        while(!scan.hasNextInt()) {
            System.out.println("Enter Valid input between 1-7 : ");
            scan.next();
        }

        input = scan.nextInt();
        return input;
    }
}
