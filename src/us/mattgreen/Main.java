package us.mattgreen;


import java.io.*;
import java.util.*;
/**
 * The run class of the animals project
 * @author Matt Green
 * @version 1.0.0
 */

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");
    public static void main(String[] args) throws Exception {

        ArrayList<Talkable> zoo = new ArrayList<>();
        AnimalIO animalIO = new AnimalIO();

        animalIO.animalLoop();

        zoo = animalIO.getZoo();


        for (Talkable thing: zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();
        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * A method to print the name and sound made of a Talkable to the console and write them to a file
     * @param p the Talkable for the operation to be ran on
     */
    public static void printOut(Talkable p)  {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }


}
