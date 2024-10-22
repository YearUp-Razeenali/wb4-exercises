package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        //empTestCases();

    }

    public static void empTestCases(){
        Employees employee1 = new Employees(101, "John Doe", "Sales", 20.0, 0);
        employee1.punchTimeCard(9.0, 17.0);  // Punch in at 9:00 AM and punch out at 5:00 PM (8 hours)

        System.out.println(employee1.getHoursWorked());
        System.out.println(employee1.getTotalPay());

        Employees employee2 = new Employees(102, "Jane Smith", "Engineering", 25.0, 0);
        employee2.punchTimeCard(9.0, 19.0);  // Punch in at 9:00 AM, punch out at 7:00 PM (10 hours)
        employee2.punchTimeCard(9.0, 19.0);  // Another 10-hour day

        System.out.println(employee2.getHoursWorked());
        System.out.println(employee2.getTotalPay());

        Employees employee3 = new Employees(103, "Alice Johnson", "Marketing", 30.0, 38.0);  // Already worked 38 hours
        employee3.punchTimeCard(9.0, 19.0);  // Another 10-hour workday

        System.out.println(employee3.getHoursWorked());
        System.out.println(employee3.getTotalPay());

        Employees employee5 = new Employees(105, "Charlie Davis", "HR", 22.0, 0);
        employee5.punchTimeCard(9.0, 12.0);  // Punch in at 9:00 AM, punch out at 12:00 PM (3 hours)
        employee5.punchTimeCard(13.0, 17.0);  // Punch in again at 1:00 PM, punch out at 5:00 PM (4 hours)

        System.out.println(employee5.getHoursWorked());
        System.out.println(employee5.getTotalPay());


    }
}