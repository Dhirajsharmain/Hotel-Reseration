/**
 * ****************************************************************************
 * Purpose: The purpose of this class to create hotel reservation system.
 *
 * @author Dhiraj
 * @version 1.0
 * @since 26-06-2021 **********************************************************
 */
package bridgelabz;

import bridgelabz.model.Hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelReservationMain {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String,Hotel> hotelsMap = new  HashMap<>();
    public static void main(String[] args) {
        boolean exit = false;
        do {
            System.out.println("\n\t\tWelcome To Hotel Reservation");
            System.out.println("\n\t\tEnter A to Add Hotel ");
            System.out.println("\t\tEnter F to Find Cheapest Hotel ");
            System.out.print("\t\tPlease Select One Option : ");
            char userInput = scanner.nextLine().toUpperCase().charAt(0);
            switch (userInput) {
                case 'A':
                    //add
                    addHotel();
                    break;
                case 'E':
                    //edit
                    break;
                case 'Q':
                    //quit
                    exit = true;
                    break;
                default:
                    System.out.println("Please select correct option");
            }
        } while (!exit);
    }

    /**
     * Method for adding hotel detail.
     */
    private static void addHotel(){
        Hotel hotel = new Hotel();
        System.out.print("Enter Hotel Name : ");
        hotel.setHotelName(scanner.nextLine());
        System.out.print("Enter Weekdays Regular Rate : ");
        hotel.setwDayRegularRate(scanner.nextLine());
        System.out.print("Enter Weekdays Reward Rate : ");
        hotel.setwDayRewardRate(scanner.nextLine());
        System.out.print("Enter Weekend Regular Rate : ");
        hotel.setwEndRegularRate(scanner.nextLine());
        System.out.print("Enter Weekend Reward Rate : ");
        hotel.setwEndRewardRate(scanner.nextLine());

        hotelsMap.put(hotel.getHotelName(),hotel);
    }
}
