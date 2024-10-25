package EncapsulationExercises.FootballTeamGenerator;
//package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        int index = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)) index = i;
        }
        if (index >= 0) this.players.remove(index);
        else {
            System.out.println("Player "+name+" is not in "+this.getName()+" team.");
        }
    }

    public double getRating() {
        if (this.players.isEmpty()) return 0;
        else return players.stream().map(Player::overallSkillLevel).reduce((a, b) -> a + b).get();
    }

}
