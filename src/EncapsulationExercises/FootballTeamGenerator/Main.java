package EncapsulationExercises.FootballTeamGenerator;
//package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String command = reader.readLine();
        while (!command.equals("END")) {
            String[] token = command.split(";");

            switch (token[0]) {
                case "Team" -> {
                    String name = token[1];
                    Team team = new Team(name);
                    teams.putIfAbsent(name, team);
                }
                case "Add" -> {
                    String team = token[1];
                    String playerName = token[2];
                    int endurance = Integer.parseInt(token[3]);
                    int sprint = Integer.parseInt(token[4]);
                    int dribble = Integer.parseInt(token[5]);
                    int passing = Integer.parseInt(token[6]);
                    int shooting = Integer.parseInt(token[7]);

                    if (!teams.containsKey(team)) {
                        System.out.println("Team " + team + " does not exist.");
                    } else {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(team).addPlayer(player);
                    }
                }
                case "Remove" -> {
                    String team = token[1];
                    String playerName = token[2];
                    if (!teams.containsKey(team)) {
                        System.out.println("Team " + team + " does not exist.");
                    } else {
                        teams.get(team).removePlayer(playerName);
                    }
                }
                case "Rating" -> {
                    String team = token[1];

                    if (!teams.containsKey(team)) {
                        System.out.println("Team " + team + " does not exist.");
                    } else {
                        System.out.println(team + " - " + String.format("%.0f", teams.get(team).getRating()));
                    }
                }
            }
            command = reader.readLine();
        }
    }
}
