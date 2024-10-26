import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    //Attributes
    protected ArrayList<LibraryItem> libraryItems;
    protected ArrayList<Author> authors;
    protected ArrayList<Patron> patrons;
    
    public Library() {
        this.libraryItems = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    //Methods
    //addToLib()
    public void addToLib(LibraryItem newItem) 
    {
        libraryItems.add(newItem);
    }

    //displayLibItems()
    public void displayItems(Scanner sc) 
    {
        System.out.println("List of all library items:");
        for (int i = 0; i < libraryItems.size(); i++) {
            System.out.println((i + 1) + ". " + libraryItems.get(i).toString());
        }

        // Prompt to add a new patron or return
        System.out.println("Choose one of the following options (1 or 2): ");
        System.out.println("1. Add a New Book");
        System.out.println("2. Add a New Periodical");
        System.out.println("3. Return to Main Menu" + "\n");
        
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                Book newBook = new Book(); 
                newBook.addNewItem(this, sc); 
                System.out.println("New Book added successfully!");
                break;
            case "2":
                Periodical newPeriodical = new Periodical(); 
                newPeriodical.addNewItem(this, sc); 
                System.out.println("New Periodical added successfully!");
                break;
            case "3": 
                break;
            default:
                System.out.println("Invalid selection, returning to main menu.");
                break;
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

    //addAuthorToLib
    public void addAuthorToLib(Author newAuthor)
    {
        authors.add(newAuthor);
    }

    //deleteAuthor
    public void deleteAuthor(Author deleteAuthor) 
    {
        authors.remove(deleteAuthor);
    }

    //displayAuthors()
    public void displayAuthors(Scanner sc)
    {
        System.out.println("List of all authors:");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ". " + authors.get(i).toString());
        }

        // Prompt to add a new patron or return
        System.out.println("Choose one of the following options (1, 2, or 3): ");
        System.out.println("1. Add a new Author");
        System.out.println("2. Delete an Author");
        System.out.println("3. Return to Main Menu" + "\n");
        
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                Author newAuthor = Author.addAuthor(sc);
                addAuthorToLib(newAuthor);
                System.out.println("New Author added successfully!");
                break;
            case "2":   
                System.out.println("Select which author to delete: (Select by index number. Ex: '1'");
                int indexToDelete = sc.nextInt();
                sc.nextLine();

                // Check if the index is valid
                if (indexToDelete > 0 && indexToDelete <= authors.size()) {
                    Author authorToDelete = authors.get(indexToDelete - 1); // Get the author based on the index
                    deleteAuthor(authorToDelete); // Call the method to delete
                    System.out.println("Author deleted successfully!");
                } else {
                    System.out.println("Invalid index, no author deleted.");
                }
                break;
            case "3": 
                break;
            default:
                System.out.println("Invalid selection, returning to main menu.");
                break;
        }
    }
    
    //addPatronToLib
    public void addPatronToLib(Patron newPatron)
    {
        patrons.add(newPatron);
    }

    //deletePatron
    public void deletePatron(Patron delePatron)
    {
        patrons.remove(delePatron);
    }

    public void displayPatrons(Scanner sc) {
        System.out.println("List of all patrons:");
        for (int i = 0; i < patrons.size(); i++) {
            System.out.println((i + 1) + ". " + patrons.get(i).toString());
        }

        // Prompt to add a new patron or return
        System.out.println("Choose one of the following options (1, 2, 3, or 4): ");
        System.out.println("1. View Books Borrowed");
        System.out.println("2. Add a new Patron");
        System.out.println("3. Delete A Patron");
        System.out.println("4. Return to Main Menu" + "\n");
        
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
            System.out.println("Select which patron to view borrowed books: (Select by index number. Ex: '1'");
            int indexToView = sc.nextInt();
            sc.nextLine();

            // Check if the index is valid
            if (indexToView > 0 && indexToView <= patrons.size()) {
                Patron patronToView = patrons.get(indexToView - 1); // Get the patron based on the index
                patronToView.displayBorrowedItems(sc);
            } else {
                System.out.println("Invalid index, no patron selected.");
            }
            break;

            case "2":
                Patron newPatron = Patron.addPatron(sc);
                addPatronToLib(newPatron);
                System.out.println("New Patron added successfully!");
                break;
            case "3": 
            System.out.println("Select which patron to delete: (Select by index number. Ex: '1'");
            int indexToDelete = sc.nextInt();
            sc.nextLine();

            // Check if the index is valid
            if (indexToDelete > 0 && indexToDelete <= patrons.size()) {
                Patron patronToDelete = patrons.get(indexToDelete - 1); // Get the patron based on the index
                deletePatron(patronToDelete); // Call the method to delete
                System.out.println("Patron deleted successfully!");
            } else {
                System.out.println("Invalid index, no patron deleted.");
            }
            break;

            case "4":
                break;

            default:
                System.out.println("Invalid selection, returning to main menu.");
                break;
        }
    }

    public void simplePatronDisplay(Scanner sc)
    {
        System.out.println("List of patrons:");
        for (int i = 0; i < patrons.size(); i++) {
            System.out.println((i + 1) + ". " + patrons.get(i).getName());
        }
    }
}



