package Assignments;

import Examples.Library;

import java.util.ArrayList;

public class As1_Main {
    public static void run() {
        ArrayList <As1_Crop> allCrops = new ArrayList<>();
        double totalRevenue = 0;

        allCrops.add(new As1_Crop("wheat", 55.6, "bu", 6.05));
        allCrops.add(new As1_Crop("oats", 90.9, "bu", 3.51));
        allCrops.add(new As1_Crop("barley", 75.9, "bu", 5.75));
        allCrops.add(new As1_Crop("canola", 31.8, "bu", 12.27));
        allCrops.add(new As1_Crop("flaxseed", 25.5, "bu", 17.25));

        allCrops.get(0).setAcres(250);
        allCrops.get(1).setAcres(180);
        allCrops.get(2).setAcres(300);
        allCrops.get(3).setAcres(150);
        allCrops.get(4).setAcres(120);

//        for (int i = 0; i < allCrops.size(); i++) {
//            System.out.println( allCrops.get(i) );
//        }

        while(true) {

            System.out.println("Press 1 farm summary\nPress 2 to search & harvest a crop\nPress 3 to get total revenue\nPress 4 to plant a crop\nPress 5 to exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                    allCrops.get(i).printMe();
                }
            }

            if (choice == 2) {
                System.out.println("What crop do you want to search for?");
                int i = searchByName(allCrops, Library.input.nextLine());
                if(i == -1) {
                    System.out.println("Error: Crop not found");
                } else {
                    allCrops.get(i).printMe();
                    System.out.println("Do you want to harvest the crop?");
                    if(Library.input.nextLine().equals("y")){
                        totalRevenue += allCrops.get(i).harvest();
                    }
                }
            }

            if (choice == 3) {
                System.out.println("Total revenue from all harvested crops: $" + totalRevenue);
            }

            if (choice == 4) {
                System.out.println("What crop do you want to plant?");
                String crop = Library.input.nextLine();
                System.out.println("How many acres do you want to plant?");
                int acres = Library.input.nextInt();
                Library.input.nextLine();

                if(searchByName(allCrops, crop) == -1) {
                    System.out.println("What is the yield");
                    double yield = Library.input.nextDouble();
                    Library.input.nextLine();

                    System.out.println("What units are you using?");
                    String units = Library.input.nextLine();

                    System.out.println("What is the price?");
                    double price = Library.input.nextDouble();
                    Library.input.nextLine();

                    allCrops.add(new As1_Crop(crop, yield, units, price));
                    allCrops.get(searchByName(allCrops, crop)).setAcres(acres);
                } else {
                    allCrops.get(searchByName(allCrops, crop)).addAcres(acres);
                }
            }

            if(choice == 5) {
                break;
            }
        }
    }

    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm   ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase(  list.get(i).getName()      )){
                return i;
            }
        }
        return -1;
    }
}
