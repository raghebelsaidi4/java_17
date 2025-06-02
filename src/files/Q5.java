package files;

import java.io.*;
import java.util.Scanner;
public class Q5 {

    public class Question5 {
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(new File("file1.txt"))) {
                System.out.println("Contents of file1.txt:");
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
                System.out.println("End of file reached.");
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }
        }
    }
}
