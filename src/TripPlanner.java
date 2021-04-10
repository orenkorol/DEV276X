import java.util.Scanner;

public class TripPlanner {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        greeting();
        timeAndBudget();
        timeDifference();
        countryArea();
        haversineFormula();
        scanner.close();
    }

    private static void greeting() {
        System.out.println("Welcome to vacation planner");
        System.out.printf("What is your name? ");
        String name = scanner.nextLine();
        System.out.printf("Nice to meet you %s, where are you travelling to? ", name);
        String destination = scanner.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");
        System.out.println("********");
    }

    private static void timeAndBudget() {
        System.out.println();
        System.out.printf("How many days are you going to spend travelling? ");
        int days = scanner.nextInt();
        System.out.printf("How much money, in USD, are you planning to spend on your trip? ");
        int cash = scanner.nextInt();
        System.out.printf("What is the three letter currency symbol for your travel destination? ");
        String currency = scanner.next();
        System.out.printf("How many %s are there is 1 USD? ", currency);
        double valueRate = scanner.nextDouble();

        System.out.println("If you are travelling for " + days + " days that is the same as " + (days * 24) + " hours or " + (days * 24 * 60) + " minutes");
        System.out.println("If you are going to spend $" + cash + " USD that means per day you can spend up to $" + String.format("%.2f", ((double) cash / days)) + " USD");
        System.out.println("Your total budget in " + currency + " is " + String.format("%.1f", (cash * valueRate)) + " " + currency + ", which per day is " + String.format("%.2f", (cash * valueRate / days)) + " " + currency);
        System.out.println("********");

    }

    private static void timeDifference() {
        System.out.println();
        System.out.printf("What is the time difference, in hours, between your home and your destination? ");
        int timeDifference = scanner.nextInt();
        System.out.println("That means that when it is midnight at home it will be " + ((timeDifference) % 24) + ":00 in your travel destination" +
                "\nand when it is noon at home it will be " + (12 + (timeDifference % 12)) + ":00");
        System.out.println("********");
    }

    private static void countryArea() {
        System.out.println();
        double kmToMile = 0.3861; //0215854245;
        System.out.printf("What is the square area of your destination country in km2? ");
        int area = scanner.nextInt();
        System.out.printf("In miles2 that is %.1f", area * kmToMile);
        System.out.println("********");
    }

    private static void haversineFormula() {
        System.out.println();
        System.out.printf("Enter home longitude: ");
        double homeLongitude = scanner.nextDouble();
        System.out.printf("Enter home latitude: ");
        double homeLatitude = scanner.nextDouble();
        System.out.printf("Enter destination longitude: ");
        double destinationLongitude = scanner.nextDouble();
        System.out.printf("Enter destination latitude: ");
        double destinationLatitude = scanner.nextDouble();

        double latDistance = ((destinationLatitude - homeLatitude) * Math.PI) / 180;
        double lonDistance = ((destinationLongitude - homeLongitude) * Math.PI) / 180;
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos((homeLatitude * Math.PI) / 180) * Math.cos((destinationLatitude * Math.PI) / 180) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        int R = 6371;
        Double distance = R * c;
        System.out.println("Distance between home and destination is: " + String.format("%.2f", (distance)) + " Km");
        System.out.println("Distance between home and destination is: " + String.format("%.2f", (distance * 0.621371)) + " miles");

    }


}
