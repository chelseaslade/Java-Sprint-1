import java.util.Scanner;
import java.util.ArrayList;

public class LibManagementDemo {
    public static void main(String[] args)
    {
        //Initialize Library (Array)
        Library library = new Library();
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        Book bookOne = new Book("001", "1984", "George Orwell", "9780451524935", "Signet", 10, true, true, true);
        library.addToLib(bookOne);

        Book bookTwo = new Book("002", "Animal Farm", "George Orwell", "9780141036137", "Penguin UK", 10, true, true, true);
        library.addToLib(bookTwo);

        Book bookThree = new Book("003", "Pride and Predjudice", "Jane Austen", "9780141439518", "Penguin UK", 10, true, true, true);
        library.addToLib(bookThree);


        while (loop == true)
        {
            System.out.println("Select an option: " + "\n");
            System.out.println("1. View Borrowed Books" + "\n");
            System.out.println("2. View All Books in Library" + "\n");
            System.out.println("3. Add Item to Library" + "\n");
            System.out.println("4. Search Library" + "\n");
            System.out.println("5. Exit" + "\n");

            String menuOption = sc.nextLine();
            System.out.println("\n");

            switch (menuOption)
            {
                //Borrowed Books
                case "1":
                library.displayBorrowed(sc);
                break;

                //Display items
                case "2":
                library.displayItems();
                break;

                //Add new item
                case "3":
                System.out.println("Would you like to add a book or a periodical? (Enter B for book, P for periodical)" + "\n");
                String addOption = sc.nextLine();

                if (addOption.equalsIgnoreCase("B"))
                {
                    new Book().addNewItem(library, sc);
                }
                else if (addOption.equalsIgnoreCase("P"))
                {
                    new Periodical().addNewItem(library, sc);
                }
                break;

                //Search item --> Delete or edit item
                case "4":
                System.out.println("Enter your search criteria: ");
                String searchCriteria = sc.nextLine();

                ArrayList<LibraryItem> searchResults = new ArrayList<>();
                searchResults = library.searchItems(searchCriteria);

                if (searchResults.isEmpty()) //No items found
                {
                    System.out.println("No matching items found.");
                }
                else if (searchResults.size() == 1) { //One item found
                    LibraryItem selectedItem = searchResults.get(0);
                
                    //Options with selectedItem
                    System.out.println("Options (Enter 1, 2 3, or 4): " + "\n");
                    System.out.println("1. Borrow item" + "\n");
                    System.out.println("1. Edit item" + "\n");
                    System.out.println("2. Delete item" + "\n");
                    System.out.println("3. Back to Main Menu" + "\n");

                    String searchOption = sc.nextLine();

                    switch (searchOption)
                    {
                        //Borrow
                        case "1":
                        library.borrowItem(selectedItem);
                        break;
                        //Edit
                        case "2":
                        selectedItem.editItem(selectedItem, sc);
                        break;
                        //Delete
                        case "3":
                        library.deleteItem(selectedItem);
                        System.out.println("Item deleted!");
                        //Main Menu
                        case "4":
                        break;
                        //Error, return to main menu
                        default:
                        System.out.println("Invalid selection");
                        break;
                    }
            }
            else { //Multiple Items found
                System.out.println("Select an item from the list using the index number (ex. '1') to edit or delete. Type 'exit' to return to main menu. " + "\n");
                String itemSelection = sc.nextLine();

                if (itemSelection.equalsIgnoreCase("exit"))
                {
                    continue; //Exit to main menu
                }

                try {
                    int selectedIndex = Integer.parseInt(itemSelection) - 1;

                    if (selectedIndex >= 0 && selectedIndex < searchResults.size())
                    {
                        LibraryItem selectedItem = searchResults.get(selectedIndex);

                        //Edit/Delete options
                        System.out.println("Options (Enter 1, 2 3, or 4): " + "\n");
                        System.out.println("1. Borrow item" + "\n");
                        System.out.println("2. Edit item" + "\n");
                        System.out.println("3. Delete item" + "\n");
                        System.out.println("4. Back to Main Menu" + "\n");

                        String searchOption = sc.nextLine();

                        switch (searchOption) 
                        {
                            case "1": //Borrow
                            library.borrowItem(selectedItem);
                            break;

                            case "2": //Edit
                            selectedItem.editItem(selectedItem, sc);
                            break;

                            case "3": //Delete 
                            library.deleteItem(selectedItem);
                            System.out.println("Item deleted!");
                            break;

                            case "4": //Main menu
                            break;
                        }
                    }
                    else {
                        System.out.println("Invalid selection. Please try again." + "\n");
                    }}
                     catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
            }
            break;

                //Exit
                case "5":
                loop = false;
                break;
                
            }
        }
    }
}
