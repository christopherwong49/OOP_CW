package Assignments;

import java.util.ArrayList;

public class As3_Team {
    private String name;
    private String city;
    private String division;
    private int wins;
    private int otLosses;
    private int gamesPlayed;
    private ArrayList <As3_Player> players = new ArrayList<>();


    public As3_Team(String n, String c, String d, int g, int w, int o) {
        name = n;
        city = c;
        division = d;
        wins = w;
        otLosses = o;
        gamesPlayed = g;
    }

    public void addPlayer(String n, int i, int g) {
        players.add(new As3_Player(n, i, g));
    }

   public void printMe() {
       System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", name, city, division, wins, otLosses, gamesPlayed);
   }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDivision() {
        return division;
    }

    public int getWins() {
        return wins;
    }

    public int getOtLosses() {
        return otLosses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setOtLosses(int otLosses) {
        this.otLosses = otLosses;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void printMyPlayers() {
        System.out.printf("%-15s %-15s %-15s\n", "Name", "Number", "Goals");
        for (int i = 0; i < players.size(); i++) {
            players.get(i).printMe();
        }
    }

    public int goals() {
        int goals = 0;
        for (int i = 0; i < players.size(); i++) {
            goals += players.get(i).getGoals();
        }
        return goals;
    }

    public void updatePlayerStats(String p, int g) {
        for (int i = 0; i < players.size(); i++) {
            if(p.equals(players.get(i).getName())) {
                players.get(i).updateStat(g);
            }
        }
    }
}
