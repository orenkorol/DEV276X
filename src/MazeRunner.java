import java.util.Scanner;

public class MazeRunner {
    public static Maze myMap = new Maze();
    public static String selection = "";
    public static Scanner scanner = new Scanner(System.in);
    public static boolean pit;

    public static void main(String[] args) {

        int totalMoves = 0;
        intro();


        while (totalMoves < 100 && !myMap.didIWin()) {
            selection = "";
            totalMoves++;
            selection = userMove();
            navigatePit(selection);
            if (!pit) {
                canIMove(selection);
            }
            movesMessage(totalMoves);
        }

        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + totalMoves + " moves");
        } else {
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        }

        scanner.close();
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!\nHere is your current position:");
        myMap.printMap();
    }

    public static String userMove() {

        while (!selection.equalsIgnoreCase("R") && !selection.equalsIgnoreCase("L") &&
                !selection.equalsIgnoreCase("U") && !selection.equalsIgnoreCase("D")) {
            System.out.printf("Where would you like to move? (R, L, U, D) ");
            selection = scanner.next();
        }
        return selection;
    }


    public static void canIMove(String direction) {
        boolean possible = false;

        if (direction.equalsIgnoreCase("R")) {
            possible = myMap.canIMoveRight();
            if (possible) {
                myMap.moveRight();
            }
        } else if (direction.equalsIgnoreCase("L")) {
            possible = myMap.canIMoveLeft();
            if (possible) {
                myMap.moveLeft();
            }
        } else if (direction.equalsIgnoreCase("U")) {
            possible = myMap.canIMoveUp();
            if (possible) {
                myMap.moveUp();
            }
        } else if (direction.equalsIgnoreCase("D")) {
            possible = myMap.canIMoveDown();
            if (possible) {
                myMap.moveDown();
            }
        }
        if (!possible) {
            System.out.println("Sorry, you’ve hit a wall.");
        } else {
            myMap.printMap();
        }
    }

    public static void movesMessage(int moves) {
        if (moves >= 50) {
            switch (moves) {
                case 50:
                    System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                    break;
                case 75:
                    System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                    break;
                case 90:
                    System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                    break;
                case 100:
                    System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                    break;
            }
        }
    }

    public static void navigatePit(String direction) {

        if (myMap.isThereAPit(direction.toUpperCase())) {
            pit = true;
            System.out.printf("Watch out! There's a pit ahead, jump it?");
            if (scanner.next().equalsIgnoreCase("Y")) {
                myMap.jumpOverPit(direction.toUpperCase());
            }
            myMap.printMap();
        } else {
            pit = false;
        }
    }

}
