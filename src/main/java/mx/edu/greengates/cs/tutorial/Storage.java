package mx.edu.greengates.cs.tutorial;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {

    private File file;

    //Create a java program that opens a simple text file for writing and if doesn't exists create it
    // The file should be named records.txt
    public Storage() {
        file = new File("records.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // This method should add the string to the end of the file
    public void save(String string) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(string + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
