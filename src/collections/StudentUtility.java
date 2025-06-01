package collections;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentUtility {

    // 1. Add Student
    public static Student addStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Enter Student ID: ");
        student.setId(scanner.nextInt());
        System.out.print("Enter Student Name: ");
        student.setName(scanner.next());
        System.out.print("Enter Student Age: ");
        student.setAge(scanner.nextInt());
        return student;
    }

    // 2. Display Student
    public static void displayStudent(List<Student> students) {
        // use iterator
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
        }
    }

    // 3. Update Student
    public static void updateStudent(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter update Student ID: ");
        System.out.println("Enter Student Name: ");
        System.out.println("Enter Student Age: ");
        int id = scanner.nextInt();
        String name = scanner.next();
        int age = scanner.nextInt();

        int count = 0;
        for (Student student : students) {
            if (id == student.getId()) {
                break;
            }
            count++;
        }
        students.get(count).setName(name);
        students.get(count).setAge(age);
        System.out.println("Student updated successfully");
    }

    // 4. Delete Student
    public static void deleteStudent(List<Student> students, int id) {
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getId() == id) {
                studentIterator.remove();
            }
        }
    }
}
