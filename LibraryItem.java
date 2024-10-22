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
    public void addNewItem(LibraryItem newItem)
    {
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
    public void addNewItem(LibraryItem newItem)
    {
    super.addNewItem(newItem);
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
    public void addNewItem(LibraryItem newItem)
    {
    super.addNewItem(newItem);
    }
}
