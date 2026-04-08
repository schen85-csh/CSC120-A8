/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    /**
     * Constructor of Cafe Class
     * @param name the name of Cafe
     * @param address the address of Cafe
     * @param nFloors the number of floors of the Cafe
     * @param coffee The initial number of ounces of coffee remaining in inventory
     * @param sugar The initial number of sugar packets remaining in inventory
     * @param cream The initial number of "splashes" of cream remaining in inventory
     * @param cups The initial number of cups remaining in inventory
     */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        // make the attributes from the super class available in this class
        super(name, address, nFloors);
        // set up the initail inventory
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * this method is used to sell coffee and decrease the corresponding inventroy
     * If there is no enough inventory, the method restock will be triggered and retock the inventory
     * @param size the number of ounces of coffee
     * @param nSugarPackets the number of packets of sugar
     * @param nCreams the number of "splashes" of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        // check the inventory based on the paramters
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
            // something is out of stock
            System.out.println("need restock!!!");
            System.out.println("Restocking...");
            // call restock method
            this.restock(size, nSugarPackets, nCreams, nCups);
        }else{// there's nothing out of stock
            // decrease the inventroy according to the parameters
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
       
    }
    
    /**
     * the private method can only used by sellCoffee in order to keep the cafe in control
     * @param nCoffeeOunces the number of ounces of coffee that is added
     * @param nSugarPackets the number of packets of sugar that is added
     * @param nCreams the number of "splashes" of cream that is added
     * @param nCups the number of cups that is added 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "Neilson Drive", 2, 20, 10, 10, 5);
        myCafe.sellCoffee(12, 2, 3);
        myCafe.sellCoffee(24, 5, 2);
    }
    
}
