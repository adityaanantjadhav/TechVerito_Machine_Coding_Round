package com.groupexpense;

import java.util.HashMap;
import java.util.ArrayList;

public class RoomBooking {
    
    HashMap<String,Room>rooms;
    
    public RoomBooking(){
        rooms=new HashMap<>();
    }
    
    void addARoom(String room_id,int capacity){
        Room newRoom=new Room(room_id, capacity);
        rooms.put(room_id, newRoom);
    }

    public void bookARoom(String room_id,String s,String e,int no_of_attendes){
        int start_time=convertTimeStringtoInt(s);
        int end_time=convertTimeStringtoInt(e);
        boolean isInputValid=validateTheInput(room_id, start_time, end_time, no_of_attendes);

        if(isInputValid){
            Room bookRoom=rooms.get(room_id);
            ArrayList<BookingSlot>bookedSlots=bookRoom.getBookedSlots();
            for(BookingSlot i:bookedSlots){
                if(i.start_time<=end_time || i.end_time>=start_time){
                    System.out.println("Room "+room_id+" is already booked from "+start_time+" to "+end_time);
                    return;
                }
            }
            String bookingId=room_id+bookedSlots.size();
            bookedSlots.add(new BookingSlot(bookingId,start_time, end_time, no_of_attendes));
            System.out.println("Room "+room_id+" booked");
        }
        else{
            System.out.println("\nSorry! You have entered wrong input");
        }
        
    }

    boolean validateTheInput(String room_id,int start_time,int end_time,int no_of_attendes){

        if(start_time<end_time && rooms.containsKey(room_id) && end_time<2400 && start_time<2400){
            if(rooms.get(room_id).getCapacity()>=no_of_attendes)
                return true;
            }
        return false;
    }



    void printAllBookings(String room_id){
        if(!rooms.containsKey(room_id)){
            System.out.println("No such room available");
            return ;
        }
        Room room=rooms.get(room_id);
        if (room.getBookedSlots().isEmpty()){
            System.out.println("No slots are booked in room");
            return ;
        }
        
        System.out.println("Listing all bookings for Room "+room_id+" :");
        for(BookingSlot bookedSlot:room.getBookedSlots()){
            System.out.println("Booking ID: "+bookedSlot.getId()+", Start: "+convertTimeIntToString(bookedSlot.getStart_time())+",End: "+convertTimeIntToString(bookedSlot.getEnd_time())+", Attendees: "+bookedSlot.getNo_of_attendes());
        }
    }

    int convertTimeStringtoInt(String time){
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<time.length();i++){
            if(time.charAt(i)!=':')
               stb.append(time.charAt(i));
        }
        return Integer.parseInt(stb.toString());
    }

    String convertTimeIntToString(int time){
        String ans=""+time/100;
        ans=ans+":";
        ans=ans+time%100;
        return ans;
    }


    void printAllRooms(){
        System.out.println("Welcome to the Conference Room Booking System");
        System.out.println("Rooms available are:");
        for(String room_id:rooms.keySet()){
            Room room=rooms.get(room_id);
            System.out.println("Room id: "+room_id+", Capacity "+room.capacity);
        }
    }
}
