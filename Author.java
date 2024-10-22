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
    public void editAuthor()
    {
    }

    //deleteAuthor()
    public void deleteAuthor() 
    {
    }

}
