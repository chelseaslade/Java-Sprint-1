import java.util.Scanner;

public class LibManagementDemo {
    public static void main(String[] args)
    {
        //Initialize Library (Array)
        Library library = new Library();
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        Book bookOne = new Book("001", "1984", "George Orwell", "9780451524935", "Signet", 10, true, true, true);
        library.addToLib(bookOne);

        while (loop == true)
        {
            System.out.println("Select an option: " + "\n");
            System.out.println("1. View All Books in Library" + "\n");
            System.out.println("2. Add to Library" + "\n");
            System.out.println("3. Search Library" + "\n");
            System.out.println("4. Exit" + "\n");

            String menuOption = sc.nextLine();

            switch (menuOption)
            {
                //Display items
                case "1":
                library.displayItems();
                break;

                //Add new item
                case "2":
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
                case "3":
                System.out.println("Enter your search criteria: ");
                String searchCriteria = sc.nextLine();

                System.out.println(library.searchItems(searchCriteria));
                break;

                case "4":
                loop = false;
                break;
                
            }
        }
    }

}
