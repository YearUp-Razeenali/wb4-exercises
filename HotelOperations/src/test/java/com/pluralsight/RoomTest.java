package com.pluralsight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    @DisplayName("Test for successfully checking in when the room is available")
    public void checkIn_should_markRoomAsOccupied_andDirty() throws Exception {
        // arrange
        Room room = new Room(2, 150.0, false, false);
        boolean expectedOccupied = true;
        boolean expectedDirty = true;

        // act
        room.checkIn();

        // assert
        assertEquals(expectedOccupied, room.isOccupied());
        assertEquals(expectedDirty, room.isDirty());
    }

    @Test
    @DisplayName("Test for throwing an exception when the room is already occupied")
    public void checkIn_should_throwException_when_roomIsAlreadyOccupied() {
        // arrange
        Room room = new Room(2, 150.0, true, false);
        String expectedMessage = "Cannot check in: The room is occupied";

        // act
        Exception exception = assertThrows(Exception.class, room::checkIn);
        // assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Test for throwing an exception when the room is dirty")
    public void checkIn_should_throwException_when_roomIsDirty(){
        // arrange
        Room room = new Room(2, 150.0, false, true);
        String expectedMessage = "Cannot check in: The room is dirty";

        // act
        Exception exception = assertThrows(Exception.class, room::checkIn);
        // assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Test for successfully checking out when the room is occupied")
    public void checkOut_should_markRoomAsNotOccupied() throws Exception {
        // arrange
        Room room = new Room(2, 150.0, true, true);  // Room is occupied
        boolean expectedOccupied = false;

        // act
        room.checkOut();

        // assert
        assertEquals(expectedOccupied, room.isOccupied());
    }

    @Test
    @DisplayName("Test for throwing an exception when trying to check out of a room that is not occupied")
    public void checkOut_should_throwException_when_roomIsNotOccupied() {
        // arrange
        Room room = new Room(2, 150.0, false, true);  // Room is not occupied
        String expectedMessage = "Cannot check out: The room is not occupied";

        // act
        Exception exception = assertThrows(Exception.class, room::checkOut);

        // assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Test for successfully cleaning the room when it is dirty")
    public void cleanroom_should_markRoomAsNotDirty() throws Exception {
        // arrange
        Room room = new Room(2, 150.0, false, true);  // Room is dirty
        boolean expectedDirty = false;

        // act
        room.cleanroom();

        // assert
        assertEquals(expectedDirty, room.isDirty());
    }

    @Test
    @DisplayName("Test for throwing an exception when trying to clean a room that is already clean")
    public void cleanroom_should_throwException_when_roomIsAlreadyClean() {
        // arrange
        Room room = new Room(2, 150.0, false, false);  // Room is already clean
        String expectedMessage = "Cannot clean: The room is already clean";

        // act & assert
        Exception exception = assertThrows(Exception.class, room::cleanroom);
        assertEquals(expectedMessage, exception.getMessage());
    }

}