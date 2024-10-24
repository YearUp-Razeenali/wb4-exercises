package com.pluralsight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    @Test
    @DisplayName("Test for calculating hours worked when timeIn and timeOut are set correctly")
    public void punchTimeCard_should_addCorrectHoursWorked() {
        // arrange
        Employees employee = new Employees(1, "John Doe", "IT", 20.0, 0);
        employee.punchIn();
        // Simulate the employee punches out 8 hours later
        employee.punchOut();
        employee.timeIn = employee.timeIn.minusHours(8);  // Manually adjust timeIn for testing

        // act
        double addedHours = employee.punchTimeCard();

        // assert
        assertEquals(8.0, addedHours, 0.001);
        assertEquals(8.0, employee.getHoursWorked(), 0.001);
    }

    @Test
    @DisplayName("Test for returning zero when timeIn or timeOut is not set")
    public void punchTimeCard_should_returnZero_when_timeInOrTimeOutNotSet() {
        // arrange
        Employees employee = new Employees(2, "Jane Doe", "HR", 25.0, 0);

        // Only punch in, but not punch out
        employee.punchIn();

        // act
        double addedHours = employee.punchTimeCard();

        // assert
        assertEquals(0.0, addedHours, 0.001);
        assertEquals(0.0, employee.getHoursWorked(), 0.001);
    }

    @Test
    @DisplayName("Test for correctly updating total hours worked after multiple punches")
    public void punchTimeCard_should_updateTotalHoursWorked_afterMultiplePunches() {
        // arrange
        Employees employee = new Employees(3, "Mark Lee", "Finance", 30.0, 0);

        // First punch-in for 4 hours
        employee.punchIn();
        employee.punchOut();
        employee.timeIn = employee.timeIn.minusHours(4);
        double firstPunchHours = employee.punchTimeCard(); 

        // Second punch-in for 6 hours
        employee.punchIn();
        employee.punchOut();
        employee.timeIn = employee.timeIn.minusHours(6);
        double secondPunchHours = employee.punchTimeCard();

        // act
        double totalHoursWorked = employee.getHoursWorked();

        // assert
        assertEquals(10.0, totalHoursWorked, 0.001);
    }

    @Test
    @DisplayName("Test for zero added hours when timeIn and timeOut are the same")
    public void punchTimeCard_should_notAddHoursWorked_when_timeInEqualsTimeOut() {
        // arrange
        Employees employee = new Employees(4, "Alice Smith", "Operations", 22.0, 0);
        employee.punchIn();
        employee.punchOut();
        employee.timeOut = employee.timeIn;  // No time difference

        // act
        double addedHours = employee.punchTimeCard();

        // assert
        assertEquals(0.0, addedHours, 0.001);
        assertEquals(0.0, employee.getHoursWorked(), 0.001);
    }

    @Test
    @DisplayName("Valid Time Input")
    public void punchTimeCard_should_addCorrectHoursWorked_withValidTimeInput() {
        // arrange
        Employees employee = new Employees(1, "John Doe", "IT", 20.0, 0.0);
        double timeIn = 9.0;
        double timeOut = 17.0;

        // act
        double addedHours = employee.punchTimeCard(timeIn, timeOut);

        // assert
        assertEquals(8.0, addedHours, 0.001);
        assertEquals(8.0, employee.getHoursWorked(), 0.001);
    }

    @Test
    @DisplayName(" No Time Difference so 0 hours added")
    public void punchTimeCard_should_notAddHoursWorked_when_timeInSameTimeOut() {
        // arrange
        Employees employee = new Employees(2, "Jane Smith", "HR", 25.0, 0.0);
        double timeIn = 10.0;
        double timeOut = 10.0;

        // act
        double addedHours = employee.punchTimeCard(timeIn, timeOut);

        // assert
        assertEquals(0.0, addedHours, 0.001);
        assertEquals(0.0, employee.getHoursWorked(), 0.001);
    }

    @Test
    @DisplayName("Multiple Time Entries")
    public void punchTimeCard_should_accumulateHoursWorked_afterMultipleCalls() {
        // arrange
        Employees employee = new Employees(4, "Emily Davis", "Marketing", 22.0, 0.0);
        double firstTimeIn = 8.0;
        double firstTimeOut = 12.0;

        double secondTimeIn = 13.0;
        double secondTimeOut = 17.0;

        // act
        employee.punchTimeCard(firstTimeIn, firstTimeOut);
        employee.punchTimeCard(secondTimeIn, secondTimeOut);
        // assert
        assertEquals(8.0, employee.getHoursWorked(), 0.001);
    }
}