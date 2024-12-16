package Assignments;

public class As3_Player {
    private String name;
    private int id;
    private int goals;

    public As3_Player(String n, int i, int g) {
        name = n;
        id = i;
        goals = g;
    }

    public void printMe() {
        System.out.printf("%-15s %-15s %-15s\n", name, id, goals);
    }

    public int getGoals() {
        return goals;
    }

    public String getName() {
        return name;
    }

    public void updateStat(int g) {
        goals = g;
    }
}
