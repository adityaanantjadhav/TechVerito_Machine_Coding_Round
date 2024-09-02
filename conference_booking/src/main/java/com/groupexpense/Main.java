package com.groupexpense;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomBooking roomBooking=new RoomBooking();

        roomBooking.addARoom("A1", 10);
        roomBooking.addARoom("B1", 8);
        roomBooking.addARoom("C1", 5);
        roomBooking.addARoom("D1", 2);

        roomBooking.printAllRooms();

        boolean isContinue=true;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\n1. Book Room\n2. List Bookings\n3. Exit");
            int option=sc.nextInt();
            System.out.println();
            
            switch (option) {
                case 1:
                    System.out.print("Enter Room ID to book:");
                    String room_id=sc.next();
                    System.out.print("Enter the start time(HH:MM):");
                    String start_time=sc.next();
                    System.out.print("Enter the end time(HH:MM):");
                    String end_time=sc.next();
                    System.out.print("Enter the no. of attendees:");
                    int no_of_attendes=sc.nextInt();
                    
                    roomBooking.bookARoom(room_id,start_time,end_time,no_of_attendes);
                    break;
            
                case 2:
                    System.out.print("Enter Room Id to list bookings:");
                    String id=sc.next();
                    roomBooking.printAllBookings(id);
                    break;
                default:
                    isContinue=false;
                    break;
            }
        }while(isContinue);
        sc.close();
    }
}