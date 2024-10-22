package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty){
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public double getPrice(){
        return  this.price;
    }

    public boolean isDirty(){
        return this.dirty;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isAvailable() {
        return ( !this.isDirty() && !this.isOccupied() );
    }

    public void checkIn() throws Exception {
        if(isOccupied()){
            throw new Exception("Cannot check in: The room is occupied");
        }
        if(isDirty()){
            throw new Exception("Cannot check in: The room is dirty");
        }

        occupied = true;
        dirty = true;
    }

    public void checkOut() throws Exception {
        if (!isOccupied()){
            throw new Exception("Cannot check out: The room is not occupied");
        }

        occupied = false;
    }

    public void cleanroom() throws Exception {
        if (!isDirty()){
            throw new Exception("Cannot clean: The room is already clean");
        }
        dirty = false;
    }

}
