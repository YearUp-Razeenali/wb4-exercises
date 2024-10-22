package com.pluralsight;

public class Employees {
    private String employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employees(String employeeID, String name, String department, double payRate, double hoursWorks) {
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
        return (this.getRegularHours() * this.payRate) + (this.getOvertimeHours() * (1.5 * this.payRate));
    }

    public double getRegularHours(){
        if(this.hoursWorked <= 40){
            return this.hoursWorked;
        }
        //if greater than 40 then returns 40
        return 40;
    }

    public double getOvertimeHours(){
        if(this.hoursWorked > 40){
            return this.hoursWorked - 40;
        }
        //means no overtime
        return 0;
    }
}
