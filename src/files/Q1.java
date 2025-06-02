package files;

import java.io.IOException;
import java.io.PrintWriter;

public class Q1 {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("file1.txt")) {
            writer.println("Ahmed Amr"); // Replace with your name
            writer.println("ID12345");  // Replace with your ID
            System.out.println("File created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
