import java.util.*;

public class OddsAndEvens {

    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static String choice = "";
    private static int userFingers;
    private static int compFingers;
    private static int sum;
    private static boolean oddOrEven;


    public static void main(String[] args) {
        System.out.println("S" + Math.ceil(2.1));
        getNameAndSelection();
        playGame();
        winResult();
        scanner.close();
    }

    private static void getNameAndSelection() {
        System.out.println("Let’s play a game called “Odds and Evens”");
        System.out.printf("What is your name? ");
        name = scanner.nextLine();

        while (choice.equals("") || !choice.equalsIgnoreCase("O") && !choice.equalsIgnoreCase("E")) {
            System.out.printf("Hi %s, which do you choose? (O)dds or (E)vens? ", name);
            choice = scanner.next();
        }

        if (choice.equalsIgnoreCase("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }

        System.out.println("-------------------------------------------------------");
    }

    private static void playGame() {
        System.out.printf("How many “fingers” do you put out? ");
        userFingers = scanner.nextInt();
        Random random = new Random();
        compFingers = random.nextInt(6);
        System.out.println("The computer plays " + compFingers + " \"fingers\".");
        System.out.println("-------------------------------------------------------");
        sum += compFingers + userFingers;
        System.out.println(userFingers + " + " + compFingers + " = " + sum);
        oddOrEven = sum % 2 == 0;
        if (oddOrEven) {
            System.out.println(sum + " is Even!");
        } else {
            System.out.println(sum + " is Odd!");
        }
        System.out.println("-------------------------------------------------------");

    }

    private static void winResult() {
        if (oddOrEven && choice.equalsIgnoreCase("E") || !oddOrEven && choice.equalsIgnoreCase("O")) {
            System.out.println("That means " + name + " wins!");
        } else {
            System.out.println("That means computer wins!");
        }
    }
}
