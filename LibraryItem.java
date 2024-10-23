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
       System.out.println("Enter number of copies available: ");
       int numCopies = sc.nextInt();

       //Next line
       sc.nextLine();
       
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

            //Close scanner
            sc.close();

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

            //Close scanner
            sc.close();

            //Return Periodical item
            return new Periodical(id, title, author, ISBN, publisher, numCopies, isPrinted, isElectronic);
            
        }
        //Incorrect input
        else
        {
            System.out.println("Incorrect input. Please select 'B' for book, or 'P' for periodical.");
            //Close scanner
            sc.close();
            //Empty return
            return null;
        }
    }

    //editItem()
    public void editItem(LibraryItem existingItem)
    {
        //Scanner for user input
        Scanner sc = new Scanner(System.in);

        //Ask about each component.... If null (user does not enter data), maintain old data
        //Info message
        System.out.println("Edit item by entering new data where necessary. To skip editing, leave section blank." + "\n");

        //Check each item
        //Title
        System.out.println("Current Title: " + this.title);
        System.out.println("Enter new title: ");
        String editTitle = sc.nextLine();

        //Author
        System.out.println("Current Author: " + this.author);
        System.out.println("Enter new author: ");
        String editAuthor = sc.nextLine();

        //Publisher
        System.out.println("Current Publisher: " + this.publisher);
        System.out.println("Enter new publisher: ");
        String editPublisher = sc.nextLine();

        //ID
        System.out.println("Current ID: " + this.id);
        System.out.println("Enter new ID ");
        String editID = sc.nextLine();

        //ISBN
        System.out.println("Current ISBN: " + this.ISBN);
        System.out.println("Enter new ISBN: ");
        String editISBN = sc.nextLine();

        //NumCopies
        System.out.println("Current Number of Copies: " + this.numCopies);
        System.out.println("Enter new number of copies: ");
        String editNumCopies = sc.nextLine();
        
        //If statements
        //Check if user input was empty
        if (!editTitle.isEmpty()) 
        {
            this.title = editTitle;
        }

        if (!editAuthor.isEmpty()) 
        {
            this.author = editAuthor;
        }

        if (!editPublisher.isEmpty()) 
        {
            this.publisher = editPublisher;
        }

        if (!editID.isEmpty()) 
        {
            this.id = editID;
        }

        if (!editISBN.isEmpty()) 
        {
            this.ISBN = editISBN;
        }

        if (!editNumCopies.isEmpty()) 
        {
            this.numCopies = Integer.parseInt(editNumCopies);
        }

        //Close scanner
        sc.close();

    }

    //toString()
    public String toString() 
    {
        String bookDetails = "Title:" + this.title + "\n" + "Author: " + this.author + "\n" + "Publisher: " + this.publisher + "\n" + "ID: " + this.id + "\n" + "ISBN: " + this.ISBN + "\n" + "Number of copies available: " + numCopies;
        System.out.println(bookDetails);
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
        String periodicalDetails = "Electronic Available: " + electronicAvailable + "\n" + "Print Available: " + printAvailable;

        String periodicalString = mainDetails + periodicalDetails;
        System.out.println(periodicalString);
        return periodicalString;
    }
    @Override
    public void editItem(LibraryItem existingItem)
    {
        super.editItem(existingItem);

        //Open scanner
        Scanner sc = new Scanner(System.in);

        //Edit periodical attributes
        System.out.println("Currently - Periodical available in print: " + this.isPrinted);
        System.out.println("Enter new print availability (true/false)");
        String editPrinted = sc.nextLine();
        if (!editPrinted.isEmpty()) {
            this.isPrinted = Boolean.parseBoolean(editPrinted);
        }

        System.out.println("Currently - Periodical available in electronic form: " + this.isElectronic);
        System.out.println("Enter new electronic availability (true/false)");
        String editElectronic = sc.nextLine();
        if (!editElectronic.isEmpty()) {
            this.isElectronic = Boolean.parseBoolean(editElectronic);
        }

        //Close Scanner
        sc.close();
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
        System.out.println(bookString);
        return bookString;
    }
    @Override
    public void editItem(LibraryItem existingItem)
    {
        super.editItem(existingItem);

        //Open scanner
        Scanner sc = new Scanner(System.in);

        //Edit periodical attributes
        //Print
        System.out.println("Currently - Book available in print: " + this.isPrinted);
        System.out.println("Enter new print availability (true/false)");
        String editPrinted = sc.nextLine();
        if (!editPrinted.isEmpty()) {
            this.isPrinted = Boolean.parseBoolean(editPrinted);
        }

        //Electronic
        System.out.println("Currently - Book available in electronic form: " + this.isElectronic);
        System.out.println("Enter new electronic availability (true/false)");
        String editElectronic = sc.nextLine();
        if (!editElectronic.isEmpty()) {
            this.isElectronic = Boolean.parseBoolean(editElectronic);
        }

        //Audio
        System.out.println("Currently - Book available in audio form: " + this.isAudio);
        System.out.println("Enter new audio availability (true/false)");
        String editAudio = sc.nextLine();
        if (!editAudio.isEmpty()) {
            this.isAudio = Boolean.parseBoolean(editAudio);
        }

        //Close Scanner
        sc.close();
    }
}
