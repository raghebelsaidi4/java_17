package files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Q2 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("file1.txt", true);
             PrintWriter writer = new PrintWriter(fw)) {
            writer.println("555-123-4567"); // Replace with your phone number
            System.out.println("Telephone number appended successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
