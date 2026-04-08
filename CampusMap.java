import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        // Building
        myMap.addBuilding(new Building("Sabin-Reed Hall", "SR Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Hillyer Hall", "Art Museum Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("McConnell Hall", "McConnell Street Northampton, MA 01063", 5));
        // House
        House cutter = new House("Cutter House", "10 Prospect St Northampton, MA 01063", 4, true, true);
        House ziskind = new House("Ziskind House", "10 Prospect St", 4, true, true);
        House parsons = new House("Parsons House", "1 Parsons St", 5, true); 
        House lamount = new House("Lamount House", "10 Prospect St", 5, true);
        myMap.addBuilding(cutter);
        myMap.addBuilding(ziskind);
        myMap.addBuilding(parsons);
        myMap.addBuilding(lamount);
        // Library
        Library neilson = new Library("Neilson Library", "Neilson Drive", 5);
        myMap.addBuilding(neilson);
        //Cafe
        Cafe compass = new Cafe("Compass Cafe", "Neilson Drive", 4,100,100,100,100);
        Cafe cc = new Cafe("cc Cafe", "CC St", 1, 100,100,50,50);
        System.out.println(myMap);

        System.out.println("\n--- Testing Overloaded Methods---");
        System.out.println("\n Testing house Overloading:");
        cutter.moveIn("Julia","12345",2029);

        System.out.println("\n Testing Library Overloading:");
        neilson.checkOut("Java Programming");
        neilson.checkOut("Java Programming", "Julia");
        neilson.returnBook("Java Programming");
        neilson.returnBook("Java Programming","Evans");

        System.out.println("\n Testing Cafe Overloading:");
        compass.sellCoffee(12);
        compass.sellCoffee(16,2,1);
        cc.restock(25,25,25,25);
        cc.restock();


    }
    
}
