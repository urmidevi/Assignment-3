import java.util.Random;
import java.util.Scanner;

public class TortoiseAndHareRace {

    public static final int RACE_LENGTH = 70;

    public static final char TORTOISE = 'T';
    public static final char HARE = 'H';
    public static final char OUCH = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int raceLength = RACE_LENGTH;
        System.out.println("Welcome to the Tortoise and Hare Race Simulator!");
        System.out.println("Press 1 to start a new race or any other key to quit.");
        String userInput = scanner.nextLine();
        while (userInput.equals("1")) {
            int tortoisePosition = 1;
            int harePosition = 1;
            Random random = new Random();
            System.out.println("Enter the desired length of the race (default is 70):");
            try {
                raceLength = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Default race length of 70 will be used.");
            }
            System.out.println("BANG !!!!!");
            System.out.println("AND THEY'RE OFF !!!!!");

            while (tortoisePosition < raceLength && harePosition < raceLength) {

                int tortoiseMove = random.nextInt(10) + 1;
                int hareMove = random.nextInt(10) + 1;

                if (tortoiseMove <= 5) {
                    tortoisePosition += 3; // fast plod
                } else if (tortoiseMove <= 7) {
                    tortoisePosition -= 6; // slip
                    if (tortoisePosition < 1) {
                        tortoisePosition = 1;
                    }
                } else {
                    tortoisePosition += 1; // slow plod
                }

                if (hareMove <= 2) {
                    // no move, sleep
                } else if (hareMove <= 4) {
                    harePosition += 9; // big hop
                } else if (hareMove == 5) {
                    harePosition -= 12; // big slip
                    if (harePosition < 1) {
                        harePosition = 1;
                    }
                } else if (hareMove <= 8) {
                    harePosition += 1; // small hop
                } else {
                    harePosition -= 2; // small slip
                    if (harePosition < 1) {
                        harePosition = 1;
                    }
                }

                // check for collision
                if (tortoisePosition == harePosition) {
                    if (tortoisePosition == raceLength) {
                        System.out.print("OUCH!!! Tortoise and Hare both win the race!");
                    } else {
                        System.out.print("OUCH!!! ");
                    }
                } else if (tortoisePosition == raceLength) {
                    System.out.print("TORTOISE WINS!!! YAY!!!");
                } else if (harePosition == raceLength) {
                    System.out.print("Hare wins. Yuch.");
                } else {
                    System.out.print(new String(new char[tortoisePosition - 1]).replace('\0', ' '));
                    System.out.print(TORTOISE);
                    System.out.print(new String(new char[harePosition - tortoisePosition - 1]).replace('\0', ' '));
                    System.out.print(HARE);
                }

                System.out.println();
            }
            System.out.println("Press 1 to start a new race or any other key to quit.");
            userInput = scanner.nextLine();
        }
        System.out.println
