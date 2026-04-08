/* This is a stub for the House class */

import java.util.ArrayList;
/**
 * House Class is a subclass of Building Class
 * it represents a building that students live, work, and sometimes eat.
 */
public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Full Constructor
   * House Counstroctor
   * @param name the name of the building
   * @param address the address of the building
   * @param nFloors the number of floors of the building
   * @param hasDiningRoom whether the house contains a dinning room
   * @param hasElevator shows whether the house contains elevators
   */
  public House(String name, String address, int floor, boolean hasDiningRoom, boolean hasElevator) {
    // use the attribute from the super class
    super(name, address,floor);
    // assigne value to the attribute that only belonngs to this class
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constrcutor without elevators
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom){
    this(name, address, nFloors, hasDiningRoom,false);

    System.out.println("You have built a house: 🏠");
  }


  /**
   * override showOptions
   */
    public void showOptions(){
      super.showOptions();
      System.out.println("+ moveIn(s) \n + moveOut(s) \n + isResident(s)");
    }

    /** @return whether the house contains a dining room */
    public boolean hasDiningRoom(){
      return this.hasDiningRoom;
    }

    /** @return the current number of residences */
    public int nResidents(){
      return this.residents.size();
    }

    /**
     * This method is for students to move in the house
     * @param s the student who moves into the house
     */
    public void moveIn(Student s){
      this.residents.add(s);
    }

    /**
     * This method is a overloading method for the method moveIn() above.
     * This method can be used when we only know the student's name, student id and class year,but the student object has not been created yet.
     * 
     */
    public void moveIn(String name, String id, int classYear){
      this.moveIn(new Student(name, id, classYear));
    }

    /**
     * This method is for students to move out the house
     * @param s the student who moves out from the house
     * @return the student who moves out from the house
     */
    public Student moveOut(Student s){
      this.residents.remove(s);
      return s;
    }

    /**
     * This method is used to check if a student is the residence of the house
     * @param s the student that we want to check
     * @return if the student s is the residence of the house, return true
     */
    public boolean isResident(Student s){
      return this.residents.contains(s);
    }
    
    /**
     * override goToFloor
     */
    public void goToFloor(int n){
      if (!hasElevator){
        if (this.activeFloor != -1){
          if (Math.abs(n- this.activeFloor)>1){
            throw new RuntimeException("This house has no elevator! You cannot jump from floor" + this.activeFloor + "to" + n + ".");
          }
        }
      }
      super.goToFloor(n);
    }

  public static void main(String[] args) {
    House myHouse = new House("Cutter House", "10 Prospect", 4, true);
    System.out.println("Name: " + myHouse.getName());
    System.out.println("Has dining room: " + myHouse.hasDiningRoom());
    System.out.println("Floors: " + myHouse.getFloors());
  }

}