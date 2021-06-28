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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static bridgelabz.utility.Util.dayBetweenDates;
import static bridgelabz.utility.Util.findWeekDay;

public class HotelReservationMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Hotel> hotelList = new ArrayList<>();

    /**
     * Main Method or starting point of this program
     *
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
                    System.out.print("Enter Rating Out of 5 : ");
                    hotel.setRating(scanner.nextInt());
                    System.out.print("Enter Weekdays Regular Rate : ");
                    hotel.setwDayRegularRate(scanner.nextInt());
                    System.out.print("Enter Weekdays Reward Rate : ");
                    hotel.setwDayRewardRate(scanner.nextInt());
                    System.out.print("Enter Weekend Regular Rate : ");
                    hotel.setwEndRegularRate(scanner.nextInt());
                    System.out.print("Enter Weekend Reward Rate : ");
                    hotel.setwEndRewardRate(scanner.nextInt());
                    addHotel(hotel);
                    scanner.nextLine();
                    break;
                case 'F':
                    System.out.print("\nEnter First Date : ");
                    String userIn1 = scanner.nextLine();
                    System.out.print("Enter Second Date : ");
                    String userIn2 = scanner.nextLine();
                    System.out.print("Enter Customer Type : ");
                    String customerType = scanner.nextLine().toUpperCase();
                    System.out.println(customerType);

                    findCheapestHotel(customerType, userIn1, userIn2);
                    break;
                case 'Q':
                    //quit
                    exit = true;
                    break;
                default:
                    System.out.println("Please select correct option");

            }
        } while (!exit);

        scanner.close();
    }

    /**
     * Method for adding hotel detail.
     */
    private static void addHotel(Hotel hotel) throws validationException {
        try {
            hotelList.add(hotel);
        } catch (Exception e) {
            throw new validationException(e.getMessage());
        }
    }

    /**
     * Method for finding the cheapest hotel in between given dates.
     *
     * @param startingDate : Starting date of range
     * @param endDate      : End date of range
     */
    public static void findCheapestHotel(String customerType, String startingDate, String endDate) throws validationException {
        int temp;
        String dayFirst = findWeekDay(startingDate);
        String daySecond = findWeekDay(endDate);
        long difference = dayBetweenDates(startingDate, endDate);
        switch (customerType) {
            case "REGULAR":
                try {

                    if (dayFirst.equals("Saturday") || daySecond.equals("Sunday") || dayFirst.equals("Sunday")) {
                        temp = hotelList.stream().min(Comparator.comparing(Hotel::getwEndRegularRate)).get().getwEndRegularRate();
                    } else {
                        temp = hotelList.stream().min(Comparator.comparing(Hotel::getwDayRegularRate)).get().getwDayRegularRate();
                    }
                } catch (Exception e) {
                    throw new validationException(e.getMessage());
                }
                break;
            case "REWARDS":
                try {
                    if (dayFirst.equals("Sunday")) {
                        temp = hotelList.stream().min(Comparator.comparing(Hotel::getwEndRewardRate)).get().getwEndRewardRate();
                    } else if (dayFirst.equals("Saturday") || daySecond.equals("Sunday")) {
                        temp = hotelList.stream().min(Comparator.comparing(Hotel::getwEndRewardRate)).get().getwEndRewardRate();
                    } else {
                        temp = hotelList.stream().min(Comparator.comparing(Hotel::getwDayRewardRate)).get().getwDayRewardRate();
                    }
                } catch (Exception e) {
                    throw new validationException(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
