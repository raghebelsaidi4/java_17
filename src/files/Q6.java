package files;

import java.io.*;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        // Read from file2.txt
        try (Scanner scanner = new Scanner(new File("file2.txt"))) {
            System.out.println("Numbers read from file2.txt:");
            for (int i = 0; i < 10; i++) {
                numbers[i] = scanner.nextInt();
                System.out.println(numbers[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // Write to arrayCont.txt
        try (PrintWriter writer = new PrintWriter("arrayCont.txt")) {
            for (int num : numbers) {
                writer.println(num);
            }
            System.out.println("Array saved to arrayCont.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}