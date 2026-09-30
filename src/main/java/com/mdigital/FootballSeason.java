package com.mdigital;

import java.util.Arrays;

public class FootballSeason {
    private static String[] generateRandomScoresForSeason() {
        // Declare a new Array of strings, and we know it will have 38 items (38 individual game scores)
        String[] gameScores = new String[38];

        for(int currentGame = 0; currentGame < 38; currentGame++){
            // Generate a random score from 1-4, for each team, each game
            int homeScore = (int) (Math.random() * 5);
            int awayScore = (int) (Math.random() * 5);

            // Convert the two scores for each game to a string
            String gameScoreAsString = homeScore + ":" + awayScore;
            // Then we store the game score in the global String[] array so we can return it later
            gameScores[currentGame] = gameScoreAsString;
        }

        return gameScores;
    }

    private static int calculateTeamSeasonPoints(String[] seasonScores, boolean homeTeam) {
        int seasonPoints = 0;

        for (String gameScore : seasonScores) {
            String[] parts = gameScore.split(":");

            int homeScore = Integer.parseInt(parts[0]);
            int awayScore = Integer.parseInt(parts[1]);

            if ((homeTeam ? homeScore : awayScore) > (homeTeam ? awayScore : homeScore)) {
                seasonPoints += 3;
            } else if (homeScore == awayScore) {
                seasonPoints += 1;
            }
        }

        return seasonPoints;
    }

   private static String getWinnerOfSeason(int homeScore, int awayScore){
        if(homeScore > awayScore){
            return "Home team wins";
        }
        else{
            return "Away team wins";        }

   }

    static void main() {
        // Generate 38 random game scores for a season
        String[] gameScores = generateRandomScoresForSeason();
        System.out.println("Game scores for season: " + Arrays.toString(gameScores));

        // Calculate Season points
        int homeTeamPoints = calculateTeamSeasonPoints(gameScores, true);
        System.out.println("Home Team points for season: " + homeTeamPoints);

        int awayTeamPoints = calculateTeamSeasonPoints(gameScores, false);
        System.out.println("Away Team points for season: " + awayTeamPoints);

        System.out.println(getWinnerOfSeason(homeTeamPoints , awayTeamPoints));
    }
}
