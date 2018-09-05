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

    /**
     * A method to get the zoo arraylist from instance of animalIO
     * @return an arraylist of talkables
     */
    public static ArrayList<Talkable> getZoo() {
        return zoo;
    }

    /**
     * Sets the zoo arraylist
     * @param zoo the arraylist to be assigned to this instance of animalIO
     * @returns void
     */
    public static void setZoo(ArrayList<Talkable> zoo) {
        AnimalIO.zoo = zoo;
    }

    /**
     * Loops through addAnimal method until prompted to stop
     * @throws Exception inherited from contained methods
     */
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

    /**
     * Adds animal of type passed as argument
     * @param type the type of animal desired, (Student, Cat, or Dog)
     * @return a Talkable object of type selected
     * @throws Exception Illegal argument if incorrect type, otherwise inherits from contained methods
     */
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

    /**
     * A method to prompt user for info on cat and create a cat object from said info
     * @return a cat object
     * @throws Exception non integer value entered in mice killed
     */
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

    /**
     * method to add new student using data gathered from user in console
     * @return a new student object
     * @throws Exception when non integer entered for students age
     */
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

    /**
     * A method to create a new dog from data gathered from user in console
     * @return a new dog object
     * @throws Exception when non boolean entered when asked if dog is friendly
     */
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
