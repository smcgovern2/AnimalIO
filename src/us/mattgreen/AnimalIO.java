package us.mattgreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalIO {


    private static ArrayList<Talkable> zoo;


    public AnimalIO() {
        zoo = new ArrayList<Talkable>();
    }

    public static ArrayList<Talkable> getZoo() {
        return zoo;
    }

    public static void setZoo(ArrayList<Talkable> zoo) {
        AnimalIO.zoo = zoo;
    }

    public static void animalLoop () throws Exception{
        String continueLoop = "y";
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        while(continueLoop.equals("y") || continueLoop.equals("Y")){
            System.out.println("Would you like to add a Dog, Cat, or Student?");
            String type = inStream.readLine();
            zoo.add(addAnimal(type));
            System.out.println("would you like to add another animal? (y/n)");
            continueLoop = inStream.readLine();
        }
    }

    public static Talkable addAnimal(String type) throws Exception {
        switch (type){
            case "Cat":
            case "cat":
                return addCat();
            case "Dog":
            case "dog":
                return addDog();
            case "student":
            case "Student":
                return addStudent();
            default:
                throw new IllegalArgumentException("Invalid argument, only accept Dog, Cat, or Student");
        }


    }

    public static Cat addCat() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        int miceKilled;

        System.out.println("What is the name of the cat?");

        String name = inStream.readLine();

        System.out.println("How many mice has the cat killed?");

        try {
            miceKilled = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter an integer");
        }

        return new Cat(miceKilled, name);
    }

    public static Student addStudent() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        int age;

        System.out.println("What is the name of the Student?");

        String name = inStream.readLine();

        System.out.println("How old is the student?");

        try {
            age = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter an integer");
        }

        return new Student(age, name);
    }

    public static Dog addDog() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        boolean isFriendly;

        System.out.println("What is the name of the dog?");

        String name = inStream.readLine();

        System.out.println("Is the dog friendly?(true/false)");

        try {
            isFriendly = scanner.nextBoolean();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter true or False");
        }

        return new Dog(isFriendly, name);
    }


}
