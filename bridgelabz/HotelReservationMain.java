/**
 * ****************************************************************************
 * Purpose: The purpose of this class to create hotel reservation system.
 *
 * @author Dhiraj
 * @version 1.0
 * @since 26-06-2021 **********************************************************
 */
package bridgelabz;

import bridgelabz.exception.validationException;
import bridgelabz.model.Hotel;

import java.util.*;

import static bridgelabz.utility.Util.findWeekDay;

public class HotelReservationMain {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Hotel> hotelsMap = new ArrayList<>();

    /**
     * Main Method or starting point of this program
     * @param args
     * @throws validationException
     */
    public static void main(String[] args) throws validationException {
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
                    Hotel hotel = new Hotel();
                    System.out.print("\nEnter Hotel Name : ");
                    hotel.setHotelName(scanner.nextLine());
                    System.out.print("Enter Weekdays Regular Rate : ");
                    hotel.setwDayRegularRate(scanner.nextLine());
                    System.out.print("Enter Weekdays Reward Rate : ");
                    hotel.setwDayRewardRate(scanner.nextLine());
                    System.out.print("Enter Weekend Regular Rate : ");
                    hotel.setwEndRegularRate(scanner.nextLine());
                    System.out.print("Enter Weekend Reward Rate : ");
                    hotel.setwEndRewardRate(scanner.nextLine());
                    addHotel(hotel);
                    break;
                case 'F':
                    System.out.print("\nEnter First Date : ");
                    String userIn1 = scanner.nextLine();
                    System.out.print("Enter Second Date : ");
                    String userIn2 = scanner.nextLine();
                    findCheapestHotel(userIn1,userIn2);
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
    private static void addHotel(Hotel hotel) throws validationException {
        try {
            hotelsMap.add(hotel);
        } catch (Exception e) {
            throw new validationException(e.getMessage());
        }
    }

    /**
     * Method for finding the cheapest hotel in between given dates.
     * @param startingDate : Starting date of range
     * @param endDate : End date of range
     */
    public static void findCheapestHotel(String startingDate, String endDate) throws validationException {
        try {
            String resultFirst = findWeekDay(startingDate);
            String resultSecond = findWeekDay(endDate);
            if (resultFirst == "SATURDAY" || resultSecond == "SUNDAY") {
                Hotel temp = hotelsMap.stream().min(Comparator.comparing(Hotel::getwEndRegularRate)).get();
                System.out.println(temp);
            } else {
                Hotel temp2 = hotelsMap.stream().min(Comparator.comparing(Hotel::getwDayRegularRate)).get();
                System.out.println(temp2);
            }
        } catch (Exception e) {
            throw new validationException(e.getMessage());
        }
    }


}
