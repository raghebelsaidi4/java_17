package files;

import java.io.*;

public class Q9 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("numbers.bin"))) {
            for (int i = 1; i <= 50; i++) {
                dos.writeInt(i);
            }
            System.out.println("Binary file created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}