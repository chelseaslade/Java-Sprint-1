import java.util.ArrayList;

public class Library {
    //Attributes
    protected ArrayList<LibraryItem> libraryItems;
    
    public Library() {
        this.libraryItems = new ArrayList<>();
    }

    //Methods
    //borrowItem()
    public void borrowItem()
    {
    }

    //returnItem()
    public void returnItem() 
    {
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
    public String searchItems(String searchQuery)
    {
        //Lowercase to make search case-insensitive
       String lowercaseQuery = searchQuery.toLowerCase();

       for (LibraryItem item : libraryItems) {
        if (item.getTitle().contains(lowercaseQuery) || 
            item.getAuthor().contains(lowercaseQuery) ||
            item.getPublisher().contains(lowercaseQuery) ||
            item.getISBN().contains(searchQuery) ||
            item.getID().contains(searchQuery)) 
            {
                return item.toString();
            }
        }
        String notFound = ("No item found containing search query: " + searchQuery);
        System.out.println(notFound);
        return notFound;
       }
    }

