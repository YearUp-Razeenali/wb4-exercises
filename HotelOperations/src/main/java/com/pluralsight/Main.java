package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Create an employee
        Employees emp = new Employees("12345", "John Doe", "Engineering", 20.0, 45);

        System.out.println("Pay Rate: " + emp.getPayRate());
        System.out.println("Hours Worked: " + emp.getHoursWorked());

        System.out.println("Total Pay: " + emp.getTotalPay());

    }
}