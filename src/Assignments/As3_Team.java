package Assignments;

public class As3_Team {
    private String nickname;
    private String city;
    private String division;
    private int wins;
    private int otLosses;
    private int gamesPlayed;

    public As3_Team(String n, String c, String d, int w, int o, int g) {
        nickname = n;
        city = c;
        division = d;
        wins = w;
        otLosses = o;
        gamesPlayed = g;
    }

    public String getNickname() {
        return nickname;
    }
}
