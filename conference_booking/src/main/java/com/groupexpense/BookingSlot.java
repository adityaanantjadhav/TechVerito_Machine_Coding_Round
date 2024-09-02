package com.groupexpense;

public class BookingSlot {
    String id;
    int start_time;
    int end_time;

    
    int no_of_attendes;

    public BookingSlot(String id,int start_time,int end_time,int no_of_attendes){
        this.id=id;
        this.end_time=end_time;
        this.start_time=start_time;
        this.no_of_attendes=no_of_attendes;
    }
    
    public String getId() {
        return id;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public int getNo_of_attendes() {
        return no_of_attendes;
    }

}
