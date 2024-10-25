import java.util.ArrayList;
import java.util.Scanner;

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
    public void displayBorrowed(Scanner sc)
    {
        if (this.borrowedBooks.isEmpty())
        {
            System.err.println("No books borrowed currently." + "\n");
        }
        else {
        System.out.println("Borrowed Books: " + "\n");
        for (int i = 0; i < borrowedBooks.size(); i++) 
        {
            System.out.println((i+1) + ". " + borrowedBooks.get(i).toString());
        }
    }

        System.out.println("Menu: (Enter 1 or 2) " + "\n" + "1. Return Book" + "\n" + "2. Main Menu" + "\n");
        String returnSelection = sc.nextLine();

        switch (returnSelection)
        {
            //Return Book
            case "1":
            int selectedIndex = Integer.parseInt(returnSelection) - 1;

            if (selectedIndex >= 0 && selectedIndex < borrowedBooks.size())
            {
                LibraryItem selectedItem = borrowedBooks.get(selectedIndex);
                returnItem(selectedItem);
            }
            else {
                System.out.println("Invalid selection." + "\n");
            }
            break;

            //Return to Main Menu
            case "2":
            break;
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

    //displayAuthors()
    public void displayAuthors()
    {
        for (Author author : authors) 
        {
            System.out.println(author.toString());
        }
    }

}

