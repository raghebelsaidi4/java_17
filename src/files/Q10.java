package files;

import java.io.*;

public class Q10 {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("numbers.bin"))) {
            System.out.println("Numbers from binary file:");
            for (int i = 1; i <= 50; i++) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
