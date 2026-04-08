
import java.util.Hashtable;

/* This is a stub for the Library class */
/**
 * Library Class is a subclass of Building Class
 * The class is used to manage the book collection in the library. 
 */
public class Library extends Building implements LibraryRequirements {

    private Hashtable<String, Boolean> collection;
    /**
     * COnstructor for Library Class
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors of the library
     */
    public Library(String name, String address, int nFloors){
      //pick attributes from super class and make them available in this class
      super(name, address, nFloors);
      //creat the Hashtavle attribute
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  

    /**
     * override showOption to make the methods that only included in library can be shown when useing this method.
     */
    @Override
    public void showOptions(){
      super.showOptions();
      System.out.println("+ addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + checkOut(title, name) \n + returnBook(title) \n + returnBook(title, name) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
    }

    /**
     * Most libraries have elevators, so we do not need to override this method.
     * @param n tells the floor that we want to go.
     */
    @Override
    public void goToFloor(int n){
      super.goToFloor(n);
    }

    /**
     * This mathod adds books into library's collection
     * @param title the title of the book that we want to add into library's collection.
     */
    
    public void addTitle(String title){
      if (this.collection.containsKey(title)) {
        throw new RuntimeException(title + " is already in the collection.");
    } else {
        this.collection.put(title, true);
    }
    }

    /**
     * This method removes books from the library collection
     * @param title the title of the book that we want to remove
     * @return the title of the book that we need to remove
     */
    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }
    
    /**
     * this method is used for books check out
     * @param title the title of books that we checked out
     */
    public void checkOut(String title){
      this.collection.replace(title, false);
    }
    
    /**
     * this method overload the method checkOut(). 
     * This overloaded version allows people to record their name when they borrow the books.
     * @param title tells the title of books that people checked out
     * @param borrowerName tells the people who borrow the book.
     */
    public void checkOut(String title, String borrowerName){
      this.checkOut(title);
    }

    
    /**
     * this method is used to change the status of a book after it is returned
     * @param title the title of the book that is returned
     */
    public void returnBook(String title){
      this.collection.replace(title, true);
    }

    /**
     * this method overload the returnBook() method.
     * This method allows the borrower to record their name.
     * @param title tells the title of the borrowed books.
     * @param name tells the borrower's name.
     */
    public void returnBook(String title, String name){
      this.returnBook(title);
    }
    /**
     * This method is used to check if the books exist in the library collection
     * @param title the title of the book
     * @return if the book is in the collection, return true; Otherwise, return false
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    /**
     * this method checks that if the book is available
     * @param title the title of the book
     * @return if the book can be found in the collection, return true; Otherwise, return false
     */
    public boolean isAvailable(String title){
      return this.collection.getOrDefault(title, false);
    }


    /**
     * this mathod prints all the collections and the books' status
     */
    public void printCollection(){
      System.out.println("--- Current Collection ---");
      for (String title : this.collection.keySet()) {
        boolean available = this.collection.get(title);
        String status;
        if (available) {
            status = "Available";
        } else {
            status = "Checked Out";
        }
        System.out.println("\"" + title + "\"" + " is " + status + "!");
    }
    }

    public static void main(String[] args) {
      Library myLibrary = new Library("Neilson Library", "Neilson Drive", 5);
      myLibrary.addTitle("How to become a successful computer scientist?");
      myLibrary.addTitle("How to live more than 100 years");
      
      myLibrary.printCollection();
    }
  }