import java.util.Scanner;

public class BaseballStats {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int teamCount = 0; // keep track of the number of teams processed
        boolean done = false; // flag to indicate when all teams have been processed

        while (!done) {
            // read in the team's id number, number of wins, and number of losses
            System.out.print("Enter team ID, number of wins, and number of losses (or enter -1 to quit): ");
            int teamID = input.nextInt();
            if (teamID == -1) {
                done = true;
                continue; // skip to the end of the loop
            }
            int wins = input.nextInt();
            int losses = input.nextInt();

            // print out the team's data
            System.out.println("team " + teamID);
            System.out.println(wins + " wins   " + losses + " losses");

            // compute and print out the total number of games played
            int totalGames = wins + losses;
            System.out.println("total number of games played is " + totalGames);

            // compute and print out the number of games remaining in the season
            int gamesRemaining = 25 - totalGames;
            if (gamesRemaining == 0) {
                System.out.println("the season is finished");
            } else {
                System.out.println(gamesRemaining + " games remaining");
            }

            // compute and print out the winning average
            double winningAverage = (double) wins / totalGames;
            System.out.printf("the winning average is %.4f\n", winningAverage);

            // compare the number of games remaining to the number won and the number lost
            if (gamesRemaining >= wins) {
                System.out.println("number of games remaining is greater than or equal to number won");
            } else {
                System.out.println("number of games remaining is less than number won");
            }
            if (gamesRemaining > losses) {
                System.out.println("number of games remaining is greater than number lost");
            } else {
                System.out.println("number of games remaining is not greater than number lost");
            }

            System.out.println(); // skip a few lines of output

            teamCount++; // increment the team count
        }

        System.out.println("total number of teams in the league: " + teamCount);
    }
}
