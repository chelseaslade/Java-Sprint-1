import java.util.Scanner;

public class LibraryItem {
    //Attributes
    protected String id, title, author, ISBN, publisher;
    protected int numCopies;

    //Constructors
    public LibraryItem(String id, String title, String author, String ISBN, String publisher, int numCopies) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    //Methods
    //addNewItem()
    public LibraryItem addNewItem()
    {
       //Scanner for user input
       Scanner sc = new Scanner(System.in);

       //Title
       System.out.println("Enter item title: ");
       String title = sc.nextLine();
       //Author
       System.out.println("Enter items author: ");
       String author = sc.nextLine();
       //ID
       System.out.println("Enter item ID: ");
       String id = sc.nextLine();
       //Publisher
       System.out.println("Enter item publisher: ");
       String publisher = sc.nextLine();
       //ISBN
       System.out.println("Enter item ISBN: ");
       String ISBN = sc.nextLine();
       //numCopies
       System.out.println("Enter item title: ");
       int numCopies = sc.nextInt();
       
       //Determine periodical/book subclass
        System.out.println("Book or Periodical? Enter B for Book or P for periodical: ");
        String itemType = sc.nextLine();

        //If Book
        if (itemType.equalsIgnoreCase("B")) 
        {
            //Print Available
            System.out.println("Book available in print? (true/false): ");
            boolean isPrinted = sc.nextBoolean();
            //Electronic Available
            System.out.println("Book available in electronic form?: ");
            boolean isElectronic = sc.nextBoolean();
            //Audio Available
            System.out.println("Book available in audio form?: ");
            boolean isAudio = sc.nextBoolean();

            //Return book item
            return new Book(id, title, author, ISBN, publisher, numCopies, isPrinted, isElectronic, isAudio);
        }
        //If Periodical
        else if (itemType.equalsIgnoreCase("P"))
        {
            //Print Available
            System.out.println("Periodical available in print?: ");
            boolean isPrinted = sc.nextBoolean();
            //Electronic Available
            System.out.println("Periodical available in electronic form?: ");
            boolean isElectronic = sc.nextBoolean();

            //Return Periodical item
            return new Periodical(id, title, author, ISBN, publisher, numCopies, isPrinted, isElectronic);
        }
        //Incorrect input
        else
        {
            System.out.println("Incorrect input. Please select 'B' for book, or 'P' for periodical.");
            return null;
        }
    }

    //editItem()
    public void editItem(LibraryItem existingItem)
    {
    }

    //deleteItem()
    public void deleteItem(LibraryItem itemToDelete)
    {
    }

    //toString()
    public String toString() 
    {
        String bookDetails = "Title:" + this.title + "Author: " + this.author + "Publisher: " + this.publisher + "ID: " + this.id + "ISBN: " + this.ISBN;
        return bookDetails;
    }

}

//Subclasses
//Periodical
class Periodical extends LibraryItem {
    //Attributes
    protected boolean isPrinted, isElectronic;

    //Constructor
    public Periodical(String id, String title, String author, String ISBN, String publisher, int numCopies, boolean isPrinted, boolean isElectronic) 
    {
        super(id, title, author, ISBN, publisher, numCopies);
        this.isElectronic = isElectronic;
        this.isPrinted = isPrinted;
    }

    //Methods
    @Override
    public String toString()
    {
        String electronicAvailable = this.isElectronic ? "Yes" : "No";
        String printAvailable = this.isPrinted ? "Yes" : "No";

        String mainDetails = super.toString();
        String periodicalDetails = "Electronic Available: " + electronicAvailable + "Print Available: " + printAvailable;

        String periodicalString = mainDetails + periodicalDetails;
        return periodicalString;
    }
}

//Books
class Book extends LibraryItem {
    //Attributes
    protected boolean isPrinted, isElectronic, isAudio;

    //Constructor
    public Book(String id, String title, String author, String ISBN, String publisher, int numCopies, boolean isPrinted, boolean isElectronic, boolean isAudio) 
    {
        super(id, title, author, ISBN, publisher, numCopies);
        this.isElectronic = isElectronic;
        this.isPrinted = isPrinted;
        this.isAudio = isAudio;
    }

    //Methods
    @Override
    public String toString()
    {
        String electronicAvailable = this.isElectronic ? "Yes" : "No";
        String printAvailable = this.isPrinted ? "Yes" : "No";
        String audioAvailable = this.isAudio ? "Yes" : "No";

        String mainDetails = super.toString();
        String bookDetails = "Electronic Available: " + electronicAvailable + "Print Available: " + printAvailable + "Audio Available: " + audioAvailable;

        String bookString = mainDetails + bookDetails;
        return bookString;
    }
}
