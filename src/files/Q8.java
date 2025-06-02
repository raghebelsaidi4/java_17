package files;

import java.io.*;

public class Q8 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file1.txt"))) {
            System.out.println("Contents of file1.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}