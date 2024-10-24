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

    //Empty constructor
    public LibraryItem()
    {
        this.id = null;
        this.title = null;
        this.author = null;
        this.ISBN = null;
        this.publisher = null;
        this.numCopies = 0;
    }

    //Methods
    //addNewItem()
    public void addNewItem(Library library, Scanner sc)
    {
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

       //Use leftover newline
       sc.nextLine();

       LibraryItem newItem = new LibraryItem(id, title, author, ISBN, publisher, numCopies);
       library.addToLib(newItem);
    }

    //editItem()
    public void editItem(LibraryItem existingItem, Scanner sc)
    {
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

    }

    //toString()
    public String toString() 
    {
        String bookDetails = "Title:" + this.title + "\n" + "Author: " + this.author + "\n" + "Publisher: " + this.publisher + "\n" + "ID: " + this.id + "\n" + "ISBN: " + this.ISBN + "\n" + "Number of copies available: " + numCopies + "\n";
        return bookDetails;
    }

    //getTitle()
    public String getTitle()
    {
        return this.title;
    }

    //getAuthor()
    public String getAuthor()
    {
        return this.author;
    }

    //getPublisher()
    public String getPublisher()
    {
        return this.publisher;
    }

    //getISBN()
    public String getISBN()
    {
        return this.ISBN;
    }

    //getID()
    public String getID()
    {
        return this.id;
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

    public Periodical()
    {
        this.id = null;
        this.title = null;
        this.author = null;
        this.ISBN = null;
        this.publisher = null;
        this.numCopies = 0;
        this.isElectronic = false;
        this.isPrinted = false;
    }

    //Methods
    @Override
    public String toString()
    {
        String electronicAvailable = this.isElectronic ? "Yes" : "No";
        String printAvailable = this.isPrinted ? "Yes" : "No";

        String mainDetails = super.toString();
        String periodicalDetails = "Electronic Available: " + electronicAvailable + "\n" + "Print Available: " + printAvailable + "\n";

        String periodicalString = mainDetails + periodicalDetails;
        return periodicalString;
    }
    @Override
    public void editItem(LibraryItem existingItem, Scanner sc)
    {
        super.editItem(existingItem, sc);

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
    }
    @Override
    public void addNewItem(Library library, Scanner sc)
    {
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

       //Use leftover newline
       sc.nextLine();
        
        System.out.println("Periodical available in print? (true/false): ");
        boolean isPrinted = sc.nextBoolean();
        sc.nextLine();
        //Electronic Available2
        System.out.println("Periodical available in electronic form?: ");
        boolean isElectronic = sc.nextBoolean();
        sc.nextLine();

        //Return periodical item
        Periodical newItem = new Periodical(id, title, author, ISBN, publisher, numCopies, isPrinted, isElectronic);
        library.addToLib(newItem);
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

    public Book()
    {
        this.id = null;
        this.title = null;
        this.author = null;
        this.ISBN = null;
        this.publisher = null;
        this.numCopies = 0;
        this.isElectronic = false;
        this.isPrinted = false;
        this.isAudio = false;
    }

    //Methods
    @Override
    public String toString()
    {
        String electronicAvailable = this.isElectronic ? "Yes" : "No";
        String printAvailable = this.isPrinted ? "Yes" : "No";
        String audioAvailable = this.isAudio ? "Yes" : "No";

        String mainDetails = super.toString();
        String bookDetails = "Electronic Available: " + electronicAvailable + "Print Available: " + printAvailable + "Audio Available: " + audioAvailable + "\n";

        String bookString = mainDetails + bookDetails;
        return bookString;
    }
    @Override
    public void editItem(LibraryItem existingItem, Scanner sc)
    {
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
    }
    @Override
    public void addNewItem(Library library, Scanner sc)
    {
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

       //Use leftover newline
       sc.nextLine();
        
        System.out.println("Book available in print? (true/false): ");
        boolean isPrinted = sc.nextBoolean();
        sc.nextLine();
        //Electronic Available2
        System.out.println("Book available in electronic form?: ");
        boolean isElectronic = sc.nextBoolean();
        sc.nextLine();
        //Audio Available
        System.out.println("Book available in audio form?: ");
        boolean isAudio = sc.nextBoolean();
        sc.nextLine();

        //Return book item
        Book newItem = new Book(id, title, author, ISBN, publisher, numCopies, isPrinted, isElectronic, isAudio);
        library.addToLib(newItem);
    }
}

