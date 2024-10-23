import java.util.ArrayList;

public class Library {
    //Attributes
    protected ArrayList<LibraryItem> items;
    
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
        if (items.contains(itemToDelete)) {
            items.remove(itemToDelete);
            System.out.println("Item removed from library successfully.");}
        else {
            System.out.println("Item not found.");
        }
        }

    //searchItems() ??
    //Search by name, etc, return a string of details about the item including copies available
    public String searchItems()
    {
        String bookDetails = "";
        return bookDetails;
    }
}
