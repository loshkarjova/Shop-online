package org.example.app.views.employees;

import org.example.app.entities.Employee;

import java.util.Scanner;

public class EmployeeCreateView {

    public Employee getData() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Enter Last name:");
        employee.setLastName(scanner.nextLine().trim());
        System.out.println("Enter First name:");
        employee.setFirstName(scanner.nextLine().trim());
        System.out.println("Enter Birth Date(yyyy.mm.dd):");
        employee.setBirthDate(scanner.nextLine().trim());
        System.out.println("Enter Phone:");
        employee.setPhone(scanner.nextLine().trim());
        System.out.println("Enter Salary:");
        employee.setSalary(scanner.nextDouble());
        System.out.println("Enter Position Id or Name:");
        scanner.nextLine();
        String input = scanner.nextLine().trim();
        try {
            int positionId = Integer.parseInt(input);
            employee.setPositionId(positionId);
        } catch (Exception e) {
            employee.setPositionName(input);
        }
        return employee;
    }


    public void getOutput(String output) {
        System.out.println(output);
    }
}
