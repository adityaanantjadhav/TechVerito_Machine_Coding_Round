package com.groupexpense;
import java.util.*;

public class Room {
    String room_id;
    int capacity;
    ArrayList<BookingSlot>bookedSlots;

    Room(String room_id,int capacity){
        this.room_id=room_id;
        this.capacity=capacity;
        bookedSlots=new ArrayList<BookingSlot>();
    }

    public String getRoom_id() {
        return room_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<BookingSlot> getBookedSlots() {
        return bookedSlots;
    }
}
