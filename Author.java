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
    }

    //deleteAuthor()
    public void deleteAuthor() 
    {
    }

}
