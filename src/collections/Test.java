package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        int count = 0;
        while (true) {
            if (count != 0) {
                System.out.println("\n\n\n Do you want to continue, then press 'yes'");
                String continues = scanner.next();
                if (continues.equalsIgnoreCase("yes")) {
                } else {
                    System.exit(0);
                }
            }
            count++;
            System.out.println("\t\t\t\t\tStudent Project Management");
            System.out.println("\t\t\t\t\t===========================");
            System.out.println("1.Add Student\n2.Update Student\n3.Display All Student\n4.Delete Student\n5.Exit");
            System.out.print("Please select operation: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // add student
                    Student student = StudentUtility.addStudent();
                    studentList.add(student);
                    System.out.println("Student added successfully");
                    break;
                case 2:
                    // update student
                    StudentUtility.updateStudent(studentList);
                    System.out.println("Student updated successfully");
                    break;
                case 3:
                    // display student
                    StudentUtility.displayStudent(studentList);
                    break;
                case 4:
                    // delete student
                    System.out.println("Delete Student option is proceed?");
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    StudentUtility.deleteStudent(studentList, id);
                    System.out.println("Student deleted successfully");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid option");
            }
        }
    }
}
