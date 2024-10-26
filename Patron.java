import java.util.ArrayList;
import java.util.Scanner;

public class Patron {
    //Attributes
    protected String name, address, phoneNum;
    protected ArrayList<LibraryItem> itemsBorrowed;

    //Constructors
    public Patron(String name, String address, String phoneNum)
    {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.itemsBorrowed = new ArrayList<>();
    }

    //Methods

    //getName()
    public String getName()
    {
        return this.name;
    }

    //getAddress
    public String getAddress()
    {
        return this.address;
    }

    //getPhoneNum
    public String getPhoneNum()
    {
        return this.phoneNum;
    }



    //toString() 
    public String toString()
    {
        String patronDetails = "Name: " + this.name + "\n" + "Address: " + this.address + "\n" + "Phone Number: " + this.phoneNum + "\n";
        return patronDetails;
    }

    //addPatron()
    public static Patron addPatron(Scanner sc)
    {
        System.out.println("Enter patron name: " + "\n");
        String name = sc.nextLine();
        System.out.println("Enter patron address: " + "\n");
        String address = sc.nextLine();
        System.out.println("Enter patron phone number: " + "\n");
        String phoneNum = sc.nextLine();

        return new Patron(name, address, phoneNum);
    }

    //editPatron()
    public void editPatron(Patron existingPatron, Scanner sc)
    {
        //Ask about each component.... If null (user does not enter data), maintain old data
        //Info message
        System.out.println("Edit patron by entering new data where necessary. To skip editing, leave section blank." + "\n");

        //Name
        System.out.println("Current Name: " + this.name);
        System.out.println("Enter new name: ");
        String editName = sc.nextLine();

        //Address
        System.out.println("Current Address: " + this.address);
        System.out.println("Enter new patron address: ");
        String editAddress = sc.nextLine();

        //PhoneNum
        System.out.println("Current phone number: " + this.phoneNum);
        System.out.println("Enter new patron phone number: ");
        String editPhoneNum = sc.nextLine();

        //If Statements
        if (!editName.isEmpty()) {
            this.name = editName;
        }
        if (!editAddress.isEmpty()) {
            this.address = editAddress;
        }
        if (!editPhoneNum.isEmpty()) {
            this.phoneNum = editPhoneNum;
        }
    }

    //borrowItem()
    public void borrowItem(LibraryItem item)
    {
        if (item.numCopies > 0) {
        itemsBorrowed.add(item);
        item.numCopies -= 1;
        System.out.println("Item borrowed by " + this.name);}
        
        else
         {
            System.out.println("No copies available to borrow.");
        }
    }

    //returnItem()
    public void returnItem(LibraryItem item)
    {
        if (itemsBorrowed.contains(item))
        {
            itemsBorrowed.remove(item);
            item.numCopies += 1;
            System.out.println("Book successfully returned by " + this.name);
        }
        else {
            System.out.println("Item not found in borrowed books.");
        }
    }

    //displayBorrowed()
    public void displayBorrowedItems(Scanner sc) {
        if (itemsBorrowed.isEmpty()) {
            System.out.println("No items are currently borrowed by " + name + ".");
            return;
        }

        System.out.println("Borrowed items by " + name + ":");
        for (int i = 0; i < itemsBorrowed.size(); i++) {
            System.out.println((i + 1) + ". " + itemsBorrowed.get(i).getTitle());
        }

        System.out.println("\nEnter the number of the item you want to return, or type '0' to exit:");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        if (choice > 0 && choice <= itemsBorrowed.size()) {
            LibraryItem itemToReturn = itemsBorrowed.get(choice - 1);
            returnItem(itemToReturn);
        } else if (choice == 0) {
            System.out.println("Returning to main menu.");
        } else {
            System.out.println("Invalid selection. Returning to main menu.");
        }
    }
}

//Subclasses
//Employee
class Employee extends Patron {
    //Attributes
    
    //Constructor
    public Employee(String name, String address, String phoneNum)
    {
        super(name, address, phoneNum);
    }

    //Methods
    @Override
     public void borrowItem(LibraryItem item) 
     {
        super.borrowItem(item);
     }
     @Override
     public void displayBorrowedItems(Scanner sc) 
     {
        super.displayBorrowedItems(sc);
     }
}

//Student
class Student extends Patron {
    //Attributes

    //Constructor
    public Student(String name, String address, String phoneNum)
    {
        super(name, address, phoneNum);
    }
}