package Assignments;

import Examples.Library;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {
    public static void run() {
        ArrayList<As3_Team> teams = new ArrayList<>();

        loadFile("data/teams.csv", teams);

        teams.get(0).addPlayer("Dach",77,2);
        teams.get(0).addPlayer("Caufield",13,17);

        teams.get(1).addPlayer("Tkachuk",7,14);
        teams.get(1).addPlayer("Stuzle", 18, 10);

        teams.get(2).addPlayer("Marchand",63,12);
        teams.get(2).addPlayer("Zacha",18,7);

        teams.get(3).addPlayer("Draisaitl",29,20);
        teams.get(3).addPlayer("McDavid",97,14);
        teams.get(3).addPlayer("Bouchard",2,6);
        teams.get(3).addPlayer("Nugent-Hopkins",93,4);
        teams.get(3).addPlayer("Hyman",18,5);

        teams.get(4).addPlayer("Tavares",91,12);
        teams.get(4).addPlayer("Matthews",34,9);

        teams.get(5).addPlayer("Kucherov",86,14);
        teams.get(5).addPlayer("Guentzal",59,16);

        teams.get(6).addPlayer("Huberdeau",10,11);
        teams.get(6).addPlayer("Lomberg",70,0);

        teams.get(7).addPlayer("Connor",18,16);
        teams.get(7).addPlayer("Scheifele",55,16);

        teams.get(8).addPlayer("Pettersson",40,8);
        teams.get(8).addPlayer("Miller",9,6);

        teams.get(9).addPlayer("Lewis",61,3);
        teams.get(9).addPlayer("Turcotte",15,2);


        while(true) {

            System.out.println("Press 1 to print list of teams\nPress 2 to for average\nPress 3 for division\nPress 4 to sort by wins\nPress 5 to enter game info");
            System.out.println("Press 6 to print players\nPress 7 for total goals\nPress 8 to update players stats\nPress 9 to save and exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < teams.size(); i++) {
                    teams.get(i).printMe();
                }
            }
            if (choice == 2) {
                double a1, a2, a3;
                a1 = a2 = a3 = 0;
                for (int i = 0; i < teams.size(); i++) {
                    a1 += teams.get(i).getWins();
                    a2 += teams.get(i).getOtLosses();
                    a3 += teams.get(i).getGamesPlayed();
                }
                System.out.println("Average Wins: " + a1/teams.size() + "\nAverage Overtime Losses: " + a2/ teams.size() + "\nAverage Games Played: " + a3/ teams.size());
            }
            if (choice == 3) {
                System.out.println("Input Division");
                String division = Library.input.nextLine();
                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < teams.size(); i++) {
                    if(teams.get(i).getDivision().equals(division)) {
                        teams.get(i).printMe();
                    }
                }
            }

            if(choice == 4){
                for(int i=0; i< teams.size()-1; i++){
                    int lowestIndex = i;
                    for(int j=i+1; j< teams.size(); j++){
                        if(teams.get(j).getWins() < teams.get(lowestIndex).getWins()){
                            lowestIndex = j;
                        }
                    }
                    As3_Team temp = teams.get(i);
                    teams.set(i, teams.get(lowestIndex));
                    teams.set(lowestIndex, temp);
                }

                System.out.printf("%-15s %-15s %-15s %-10s %-10s %-10s\n", "Team", "City", "Division", "W", "OTL", "Games");
                for (int i = 0; i < teams.size(); i++) {
                    teams.get(i).printMe();
                }
            }

            if(choice == 5) {
                System.out.println("Input winning team");
                String w = Library.input.nextLine();

                System.out.println("Input losing team");
                String l = Library.input.nextLine();

                System.out.println("Did the game go to overtime");
                boolean ot = Library.input.nextBoolean();

                for (int i = 0; i < teams.size(); i++) {
                    if(w.equals(teams.get(i).getName())){
                        teams.get(i).setWins( teams.get(i).getWins() + 1);
                        teams.get(i).setGamesPlayed( teams.get(i).getGamesPlayed() + 1);
                    }

                    if(l.equals(teams.get(i).getName())) {
                        teams.get(i).setGamesPlayed( teams.get(i).getGamesPlayed() + 1);

                        if(ot) {
                            teams.get(i).setOtLosses( teams.get(i).getOtLosses() + 1);
                        }
                    }
                }
            }

            if(choice == 6) {
                System.out.println("Input team");
                String team = Library.input.nextLine();

                for (int i = 0; i < teams.size(); i++) {
                    if(team.equals(teams.get(i).getName())) {
                        teams.get(i).printMyPlayers();
                    }
                }
            }


            if(choice == 7) {
                System.out.printf("%-15s %-15s\n", "Team", "Goals");
                for (int i = 0; i < teams.size(); i++) {
                    System.out.printf("%-15s %-15s\n", teams.get(i).getName(), teams.get(i).goals());
                }
            }

            if(choice == 8) {
                System.out.println("Input team");
                String team = Library.input.nextLine();

                System.out.println("Input player");
                String player = Library.input.nextLine();

                System.out.println("Input goals");
                int goals = Library.input.nextInt();
                Library.input.nextLine();

                for (int i = 0; i < teams.size(); i++) {
                    if(team.equals(teams.get(i).getName())) {
                        teams.get(i).updatePlayerStats(player, goals);
                    }
                }
            }

            if (choice == 9) {
                saveFile("data/teams.csv", teams);
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
                toSave +="," + tempList.get(i).getGamesPlayed();
                toSave +="," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getOtLosses();

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

