import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //Attributes
    protected String name, authorDOB;
    protected ArrayList<LibraryItem> booksWritten;

    //Constructors
    public Author(String name, String authorDOB)
    {
        this.name = name;
        this.authorDOB = authorDOB;
        this.booksWritten = new ArrayList<>();
    }

    //Methods
    //getName()
    public String getName()
    {
        return this.name;
    }

    //addBookWritten()
    public void addBookWritten(LibraryItem book)
    {
        booksWritten.add(book);
    }

    //getBooksWritten()
    public ArrayList<LibraryItem> getBooksWritten()
    {
        return booksWritten;
    }

    //toString()
    public String toString()
    {
        String authorDetails = "Name: " + this.name + "\n" + "Date of Birth: " + this.authorDOB + "\n";
        return authorDetails;
    }

    //addAuthor()
    public static Author addAuthor(Scanner sc) 
    {
        System.out.println("Enter authors name: ");
        String name = sc.nextLine();
        System.out.println("Enter authors date of birth: ");
        String dob = sc.nextLine();

        return new Author(name, dob);
    }

    //editAuthor()
    public void editAuthor(Author existingAuthor, Scanner sc)
    {
        //Ask about each component.... If null (user does not enter data), maintain old data
        //Info message
        System.out.println("Edit author by entering new data where necessary. To skip editing, leave section blank." + "\n");

        //Name
        System.out.println("Current Name: " + this.name);
        System.out.println("Enter new name: ");
        String editName = sc.nextLine();

        //DOB
        System.out.println("Current Date of Birth: " + this.authorDOB);
        System.out.println("Enter new author date of birth: ");
        String editDOB = sc.nextLine();

        //If Statements
        if (!editName.isEmpty()) {
            this.name = editName;
        }
        if (!editDOB.isEmpty()) {
            this.authorDOB = editDOB;
        }
    }
}
