public class Patron {
    //Attributes
    protected String name, address, phoneNum;
    protected String[] itemsBorrowed;

    //Constructors
    public Patron(String name, String address, String phoneNum, String[] itemsBorrowed)
    {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.itemsBorrowed = itemsBorrowed;
    }

    //Methods
    //addPatron()
    //editPatron()
    //deletePatron()
}

//Subclasses
//Employee
class Employee extends Patron {
    //Attributes
    
    //Constructor
    public Employee(String name, String address, String phoneNum, String[] itemsBorrowed)
    {
        super(name, address, phoneNum, itemsBorrowed);
    }
}

//Student
class Student extends Patron {
    //Attributes

    //Constructor
    public Student(String name, String address, String phoneNum, String[] itemsBorrowed)
    {
        super(name, address, phoneNum, itemsBorrowed);
    }
}