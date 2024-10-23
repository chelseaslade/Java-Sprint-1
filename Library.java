import java.util.ArrayList;

public class Library {
    //Attributes
    protected ArrayList<LibraryItem> libraryItems;
    
    public Library() {
        this.items = new ArrayList<>();
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

    //searchItems() ??
    //Search by name, etc, return a string of details about the item including copies available
    public LibraryItem searchItems(String searchQuery)
    {
       for (LibraryItem item : libraryItems) {
        if (item.getTitle().equalsIgnoreCase(searchQuery) || 
            item.getAuthor().equalsIgnoreCase(searchQuery) ||
            item.getPublisher().equalsIgnoreCase(searchQuery) ||
            item.getISBN().equals(searchQuery) ||
            item.getID().equals(searchQuery)) 
            {
                return item;
            }
        }
        System.out.println("No item found matching search query.");
        return null;
       }
    }

