import java.util.ArrayList;

public class Library {
    //Attributes
    protected ArrayList<LibraryItem> libraryItems;
    protected ArrayList<Author> authors;
    protected ArrayList<LibraryItem> borrowedBooks;
    
    public Library() {
        this.libraryItems = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    //Methods
    //borrowItem()
    public void borrowItem(LibraryItem borrowItem)
    {
        borrowedBooks.add(borrowItem);
        borrowItem.numCopies -= 1;
        System.out.println("Item borrowed!");
    }

    //returnItem()
    public void returnItem(LibraryItem returnItem) 
    {
        if (borrowedBooks.contains(returnItem))
        {
            borrowedBooks.remove(returnItem);
            returnItem.numCopies += 1;
            System.out.println("Book successfully returned!");
        }
        else {
            System.out.println("Item not found in borrowed books.");
        }
    }

    //addToLib()
    public void addToLib(LibraryItem newItem) 
    {
        libraryItems.add(newItem);
    }

    //displayBorrowed()
    public void displayBorrowed()
    {
        if (this.borrowedBooks.isEmpty())
        {
            System.err.println("No books borrowed currently." + "\n");
        }
        else {
        for (LibraryItem item : borrowedBooks) 
        {
            System.out.println(item.toString());
        }
    }
    }

    //displayLibItems()
    public void displayItems() 
    {
        for (LibraryItem item : libraryItems) 
        {
            System.out.println(item.toString());
        }
    }

    //deleteItem()
    public void deleteItem(LibraryItem itemToDelete)
    {
        //Check for item
        if (libraryItems.contains(itemToDelete)) {
            libraryItems.remove(itemToDelete);
            System.out.println("Item removed from library successfully.");}
        else {
            System.out.println("Item not found.");
        }
        }

    //searchItems() 
    //Search by name, etc, return a string of details about the item including copies available
    public ArrayList<LibraryItem> searchItems(String searchQuery)
    {
        //Add found items to array
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        //Lowercase to make search case-insensitive
       String lowercaseQuery = searchQuery.toLowerCase();

       for (LibraryItem item : libraryItems) {
        if (item.getTitle().toLowerCase().contains(lowercaseQuery) || 
            item.getAuthor().toLowerCase().contains(lowercaseQuery) ||
            item.getPublisher().toLowerCase().contains(lowercaseQuery) ||
            item.getISBN().contains(searchQuery) ||
            item.getID().contains(searchQuery)) 
            {
                searchResults.add(item); 
            }
        }

        if (searchResults.isEmpty())
        {
        System.out.println("No item found containing search query: " + searchQuery);
       }
       else {
        System.out.println("Search Results: " + "\n");
        for (int i =0; i < searchResults.size(); i++)
        {
            System.out.println("Index " + (i+1) + ". " + searchResults.get(i));
        }
       }
       return searchResults;
    }
}

