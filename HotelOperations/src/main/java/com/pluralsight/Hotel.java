package com.pluralsight;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }



    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if(isSuite){
            if(numberOfRooms > getAvailableSuites()){
                return false;
            }else{
                bookedSuites += numberOfRooms;
                return true;
            }
        }else{
            if(numberOfRooms > getAvailableRooms()){
                return false;
            }else{
                bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
    }

    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms(){
        return numberOfRooms - bookedBasicRooms;
    }
}
