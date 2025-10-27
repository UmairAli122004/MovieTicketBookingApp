package JDBCJAVAproject;

import java.util.*;

class MovieName {
    Scanner sc = new Scanner(System.in);

    public String Movie() {
        System.out.println("Select Movie Name : ");
        System.out.println("1. Super30  ||  2. 3Idiots  ||  3. 12th Fail  ||  4. Dangal ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Super 30 selected.");
                return "Super 30";
            case 2:
                System.out.println("3 Idiots selected.");
                return "3 Idiots";
            case 3:
                System.out.println("12th Fail selected.");
                return "12th Fail";
            case 4:
                System.out.println("Dangal selected.");
                return "Dangal";
            default:
                System.out.println("You have entered the wrong input.");
                return null;
        }
    }
}

public class MovieTicketBookingApp {
    static Scanner sc = new Scanner(System.in);
    static int seat;
    private boolean movieSelected = false;
    private String selectedMovie = null;

    static int[] totalSeats = new int[15];

    public void Booking() {
        if (!movieSelected) {
            System.out.println("Sorry! You must select a movie first before booking seats.");
            return;
        }
        System.out.println("-----Seats Arrangement-----");
        System.out.println(""" 
                             | [0]  || [1]  || [2]  || [3]  || [4]  |
                             | [5]  || [6]  || [7]  || [8]  || [9]  |
                             | [10] || [11] || [12] || [13] || [14] |
                             """);
        System.out.println("Enter seat number for booking");
        seat=sc.nextInt();
        if(seat<0 || seat>15){
            System.out.println("Invalid input! please try again");
            return;
        }
        if(totalSeats[seat]==0){
            totalSeats[seat]=1;
            System.out.println("Ticket has been booked successfully");
            System.out.println("Your seat number "+seat);
        }else{
            System.out.println("seat is already booked");
            System.out.println("Please select the another seat");
        }
    }

    public void checkSeatAvailability() {
        System.out.println("Seats List are");
        for(int i=0; i<totalSeats.length; i++){
            System.out.println("Seat "+(i+1)+" is "+(totalSeats[i]==0 ? "available" : "Reserved"));
        }
    }

    public void CancelTicket(){
        int seat;
        System.out.println("Enter your seat number");
        seat=sc.nextInt();
        if(seat<0 || seat>15){
            System.out.println("Invalid input! please try again");
            return;
        }

        if(totalSeats[seat]==1){
            totalSeats[seat]=0;
            System.out.println("Ticket has been cancelled successfully");
        }else{
            System.out.println("Seat is not booked yet");
            System.out.println("Please enter the correct seat number for cancellation");
        }
    }

    public static void main(String[] args) {
        MovieTicketBookingApp movieApp = new MovieTicketBookingApp();
        MovieName movieName = new MovieName();
        System.out.println("-----WELCOME TO THE MovieTicketBooking App-----");
        int choice;
        do {
            System.out.println("""
                               \nChoose option according to yourself
                               1. Press 1 to show the movie names
                               2. Book your movie ticket
                               3. Cancel Ticket
                               4. Check seat availability 
                               5. Exit
                               """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Select movie
                    movieApp.selectedMovie = movieName.Movie();
                    if (movieApp.selectedMovie != null) {
                        movieApp.movieSelected = true;
                    }
                    break;
                case 2:
                    movieApp.Booking();
                    break;
                case 3:
                    movieApp.CancelTicket();
                    break;
                case 4:
                    movieApp.checkSeatAvailability();
                    break;
                case 5:
                    System.out.println("Thank you for visiting !");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (choice != 5);
    }
}



