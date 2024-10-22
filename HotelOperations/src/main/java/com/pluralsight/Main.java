package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        //empTestCases();
        TestCaseforRoom();


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

    public static void TestCaseforRoom(){
        Room room1 = new Room(2, 150.0, false, false);
        try {
            room1.checkIn();
            System.out.println("Test Case 1: Room checked in successfully.");
        } catch (Exception e) {
            System.out.println("Test Case 1 Failed: " + e.getMessage());
        }

        // Test Case 2: Try to check in when the room is already occupied (Expected to throw Exception)
        try {
            room1.checkIn();  // This should fail since the room is already occupied
        } catch (Exception e) {
            System.out.println("Test Case 2 Passed: " + e.getMessage());  // Expected: "Cannot check in: The room is occupied"
        }

        // Test Case 3: Try to check out when the room is occupied (Success case)
        try {
            room1.checkOut();
            System.out.println("Test Case 3: Room checked out successfully.");
        } catch (Exception e) {
            System.out.println("Test Case 3 Failed: " + e.getMessage());
        }

        // Test Case 4: Try to check out when the room is not occupied (Expected to throw Exception)
        try {
            room1.checkOut();  // This should fail since the room is not occupied
        } catch (Exception e) {
            System.out.println("Test Case 4 Passed: " + e.getMessage());  // Expected: "Cannot check out: The room is not occupied"
        }

        // Test Case 5: Try to clean a dirty room (Success case)
        Room room2 = new Room(1, 100.0, false, true);  // Create a new dirty room
        try {
            room2.cleanroom();
            System.out.println("Test Case 5: Room cleaned successfully.");
        } catch (Exception e) {
            System.out.println("Test Case 5 Failed: " + e.getMessage());
        }

        // Test Case 6: Try to clean an already clean room (Expected to throw Exception)
        try {
            room2.cleanroom();  // This should fail since the room is already clean
        } catch (Exception e) {
            System.out.println("Test Case 6 Passed: " + e.getMessage());  // Expected: "Cannot clean: The room is already clean"
        }

        // Test Case 7: Try to check in when the room is dirty (Expected to throw Exception)
        Room room3 = new Room(1, 120.0, false, true);  // Dirty but unoccupied room
        try {
            room3.checkIn();  // This should fail since the room is dirty
        } catch (Exception e) {
            System.out.println("Test Case 7 Passed: " + e.getMessage());  // Expected: "Cannot check in: The room is dirty"
        }
    }
}