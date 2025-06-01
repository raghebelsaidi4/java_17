package lambda_and_streamAPI;

import java.util.*;
import java.util.stream.*;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ahmed", "IT", 75000, 28),
                new Employee(2, "Mohamed", "HR", 65000, 32),
                new Employee(3, "Ali", "Finance", 82000, 35),
                new Employee(4, "Sara", "IT", 78000, 26),
                new Employee(5, "Huda", "HR", 60000, 30),
                new Employee(6, "Omar", "Finance", 90000, 40),
                new Employee(7, "Layla", "IT", 85000, 29),
                new Employee(8, "Noor", "Marketing", 55000, 25)
        );

        // 1. Display all employees
        System.out.println("All Employees:");
        employees.forEach(System.out::println);

        // 2. Filter employees in IT department
        System.out.println("\nIT Department Employees:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .forEach(System.out::println);

        // 3. Sort employees by salary (descending)
        System.out.println("\nEmployees Sorted by Salary (Descending):");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

        // 4. Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.printf("\nAverage Salary: %.2f\n", averageSalary);

        // 5. Group employees by department
        System.out.println("\nEmployees Grouped by Department:");
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDept.forEach((dept, empList) -> {
            System.out.println("\nDepartment: " + dept);
            empList.forEach(System.out::println);
        });

        // 6. Find highest paid employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        highestPaid.ifPresent(e -> System.out.println("\nHighest Paid: " + e.getName() + " - " + e.getSalary()));

        // 7. Calculate total salaries
        double totalSalaries = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("\nTotal Salaries: " + totalSalaries);

        // 8. Filter employees older than 30 with salary > 70000
        System.out.println("\nEmployees over 30 years with salary > 70000:");
        employees.stream()
                .filter(e -> e.getAge() > 30 && e.getSalary() > 70000)
                .forEach(System.out::println);

        // 9. Give IT employees 10% salary raise
        System.out.println("\nIT Employees after 10% salary raise:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .map(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return e;
                })
                .forEach(System.out::println);

        // 10. Create list of all employee names
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("\nAll Employee Names: " + employeeNames);
    }
}
