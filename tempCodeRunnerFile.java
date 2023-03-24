import java.util.Scanner;

public class BaseballStats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int teamsProcessed = 0; // keep track of how many teams have been processed

        // read in data for each team until there is no more input
        while (input.hasNextInt()) {
            int teamId = input.nextInt();
            int wins = input.nextInt();
            int losses = input.nextInt();
            int totalGames = wins + losses;
            double winningAverage = (double) wins / totalGames;

            // print out the team's data
            System.out.println("team " + teamId);
            System.out.println(wins + " wins\t" + losses + " losses");
            System.out.println("total number of games played is " + totalGames + "\t" + (25 - totalGames) + " games remaining");
            
            // check if the season is finished
            if (totalGames == 25) {
                System.out.println("the season is finished");
            } else {
                System.out.println("the winning average is " + String.format("%.4f", winningAverage));

                // check if there are enough games left for the team to win or lose
                if (25 - totalGames >= wins) {
                    System.out.println("number of games remaining is greater than or equal to number won");
                } else {
                    System.out.println("number of games remaining is not greater than number won");
                }

                if (25 - totalGames >= losses) {
                    System.out.println("number of games remaining is greater than number lost");
                } else {
                    System.out.println("number of games remaining is not greater than number lost");
                }

                // compute and print the team's record if they win or lose all remaining games
                if (totalGames < 25) {
                    int remainingWins = 25 - totalGames;
                    int remainingLosses = 25 - totalGames - remainingWins;
                    double winAllGamesAverage = (double) (wins + remainingWins) / 25;
                    double loseAllGamesAverage = (double) wins / (totalGames + remainingLosses);
                    System.out.println("record if team wins all remaining games: " + (wins + remainingWins) + "-" + losses + "\twinning average: " + String.format("%.4f", winAllGamesAverage));
                    System.out.println("record if team loses all remaining games: " + wins + "-" + (losses + remainingLosses) + "\twinning average: " + String.format("%.4f", loseAllGamesAverage));
                }
            }

            teamsProcessed++;
            System.out.println(); // skip a line before processing the next team
        }

        System.out.println("total number of teams processed: " + teamsProcessed);
    }
}
