package Assignments;

import Examples.Library;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {
    public static void run() {
        ArrayList<As3_Team> team = new ArrayList<>();

        loadFile("data/teams.csv", team);
        team.get(3).addPlayer("Draisaitl", 20);
        team.get(3).addPlayer("McDavid", 14);
        team.get(3).addPlayer("Bouchard", 6);
        team.get(3).addPlayer("Nugent-Hopkins", 4);
        team.get(3).addPlayer("Hyman", 5);


        while(true) {

            System.out.println("Press 1 to print list of teams\nPress 2 to for average\nPress 3 for division\nPress 4 to sort by wins\nPress 5 to enter game info\nPress 6 to save and exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < team.size(); i++) {
                    team.get(i).printMe();
                }
            }
            if (choice == 2) {
                double a1, a2, a3;
                a1 = a2 = a3 = 0;
                for (int i = 0; i < team.size(); i++) {
                    a1 += team.get(i).getWins();
                    a2 += team.get(i).getOtLosses();
                    a3 += team.get(i).getGamesPlayed();
                }
                System.out.println("Average Wins: " + a1/team.size() + "\nAverage Overtime Losses: " + a2/ team.size() + "\nAverage Games Played: " + a3/ team.size());
            }
            if (choice == 3) {
                System.out.println("Input Division");
                String division = Library.input.nextLine();
                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < team.size(); i++) {
                    if(team.get(i).getDivision().equals(division)) {
                        team.get(i).printMe();
                    }
                }
            }

            if(choice == 4){
                for(int i=0; i< team.size()-1; i++){
                    int lowestIndex = i;
                    for(int j=i+1; j< team.size(); j++){
                        if(team.get(j).getWins() < team.get(lowestIndex).getWins()){
                            lowestIndex = j;
                        }
                    }
                    As3_Team temp = team.get(i);
                    team.set(i, team.get(lowestIndex));
                    team.set(lowestIndex, temp);
                }

                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < team.size(); i++) {
                    team.get(i).printMe();
                }
            }

            if(choice == 5) {
                System.out.println("Input winning team");
                String w = Library.input.nextLine();

                System.out.println("Input losing team");
                String l = Library.input.nextLine();

                System.out.println("Did the game go to overtime");
                boolean ot = Library.input.nextBoolean();

                for (int i = 0; i < team.size(); i++) {
                    if(w.equals(team.get(i).getName())){
                        team.get(i).setWins( team.get(i).getWins() + 1);
                        team.get(i).setGamesPlayed( team.get(i).getGamesPlayed() + 1);
                    }

                    if(l.equals(team.get(i).getName())) {
                        team.get(i).setGamesPlayed( team.get(i).getGamesPlayed() + 1);

                        if(ot) {
                            team.get(i).setOtLosses( team.get(i).getOtLosses() + 1);
                        }
                    }
                }
            }

            if (choice == 6) {
                saveFile("data/teams.csv", team);
                break;
            }
            System.out.println();

        }
    }

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String[] tempArray = dataToRead.split(",");
                list.add( new As3_Team(tempArray[0],tempArray[1], tempArray[2],Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getOtLosses();
                toSave +="," + tempList.get(i).getGamesPlayed();

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void selectionSorIntArr(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            //swap the data
            int temp = arr[i];
            arr[i] = arr[lowestIndex];
            arr[lowestIndex] = temp;

        }
    }
}

