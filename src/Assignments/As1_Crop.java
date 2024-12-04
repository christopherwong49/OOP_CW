package Assignments;

public class As1_Crop {
    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;

    public As1_Crop(String n, double y, String u, double p) {
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;
    }

    public String toString() {
        return name + ", " + yield  + ", " + units   + ", " + price + ", " + acres;
    }

    public void printMe(){
        System.out.println( name + ", " + yield + " " + units + "/acre" + ", " + "$" + price + "/" + units + ", " + acres + " acres");
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }

    public void addAcres(int acres) {this.acres += acres;}

    public String getName() {
        return name;
    }

    public double harvest() {
        double total = yield*price*acres;
        System.out.println("Harvest Value: $" + total);
        acres = 0;
        return total;
    }


}
