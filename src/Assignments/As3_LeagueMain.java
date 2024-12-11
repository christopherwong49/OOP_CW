package Assignments;

import Examples.Library;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {
    public static void run() {
        ArrayList<As3_Team> team = new ArrayList<>();

        loadFile("data/teams.csv", team);


        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getNickname());
        }

        while(true) {

            System.out.println("Press 1 to print all\nPress 2 to for country\nPress 3 for jazzy grooves\nPress 4 to exit.");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println("Let's rock!");

            }
            if (choice == 2) {
                System.out.println("Yeehaw!");
            }
            if (choice == 3) {
                System.out.println("Cool dadio!");
            }
            if (choice == 4) {
                break;
            }
            System.out.println();

        }//while
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


}

