package files;

import java.io.*;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("file1.txt"))) {
            System.out.println("Contents of file1.txt:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
