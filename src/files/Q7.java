package files;

import java.io.*;
import java.util.ArrayList;

public class Q7 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Read using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("file2.txt"))) {
            String line;
            System.out.println("Numbers read from file2.txt:");
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                numbers.add(num);
                System.out.println(num);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
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