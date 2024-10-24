import java.util.Scanner;

public class Author {
    //Attributes
    protected String name, authorDOB;
    protected String[] booksWritten;

    //Constructors
    public Author(String name, String authorDOB, String[] booksWritten)
    {
        this.name = name;
        this.authorDOB = authorDOB;
        this.booksWritten = booksWritten;
    }

    //Methods
    //addAuthor()
    public void addAuthor(Author newAuthor) 
    {
        newAuthor = new Author(name, authorDOB, booksWritten); 
    }

    //editAuthor()
    public void editAuthor(Author existingAuthor)
    {
        //Scanner for user input
        Scanner sc = new Scanner(System.in);

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

        //Close scanner
        sc.close();
    }

    //deleteAuthor()
    public void deleteAuthor() 
    {
    }

}
