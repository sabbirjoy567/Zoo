package com.smj.zoo;

import java.io.*;
import java.util.ArrayList;

public class DataStore {

    private static File file = new File("zoo animals.txt");

    public static void saveZooAnimalsData(ArrayList<Animal> zooAnimals) {

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(zooAnimals);

            oos.reset();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Animal> readZooAnimalsData() {

        if(!fileExists(file)) {
            return new ArrayList<>();
        }

        if(!isFileEmpty(file)) {

            try(FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

                return (ArrayList<Animal>) ois.readObject();

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Currently there are no animals in the zoo......");
            }
        }

        return new ArrayList<>();
    }

    private static boolean isFileEmpty(File file) {

        try( FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr) ) {

            if(br.readLine() == null) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static boolean fileExists(File file) {
        try{
            if(file.exists()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
