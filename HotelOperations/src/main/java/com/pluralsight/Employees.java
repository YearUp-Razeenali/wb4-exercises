package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employees {
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    LocalDateTime timeIn;
    LocalDateTime timeOut;


    public Employees(int employeeID, String name, String department, double payRate, double hoursWorks) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorks;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay(){
        return (getRegularHours() * getPayRate()) + (getOvertimeHours() * (1.5 * getPayRate()));
    }

    public double getRegularHours(){
        if(getHoursWorked() < 40){
            return getHoursWorked();
        }
        //if greater than 40 then returns 40
        return 40;
    }

    public double getOvertimeHours(){
        if(getHoursWorked() > 40){
            return getHoursWorked() - 40;
        }
        //means no overtime
        return 0;
    }

    public double punchTimeCard(double timeIn, double timeOut){
        return this.hoursWorked += timeOut - timeIn;
    }

    public void punchIn(){
        this.timeIn = LocalDateTime.now();
    }

    public void punchOut(){
        this.timeOut = LocalDateTime.now();
    }

    public double punchTimeCard(){
        if (timeIn == null || timeOut == null) {
            System.out.println("Error: TimeIn or TimeOut is not set.");
            return 0;
        }
        Duration duration = Duration.between(timeIn,timeOut);
        double hours = duration.toMinutes() / 60.0;
        return this.hoursWorked += hours;
    }
}
