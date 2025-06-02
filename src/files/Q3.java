package files;

import java.io.*;
public class Q3 {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("file2.txt")) {
            for (int i = 1; i <= 10; i++) {
                writer.println(i);
            }
            System.out.println("File with numbers created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
