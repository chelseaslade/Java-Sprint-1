public class LibManagementDemo {

    public static void main(String[] args)
    {
        //Tests
        //Initialize Library (Array)
        Library library = new Library();

        //Initialize newItem
        LibraryItem itemManager = new LibraryItem(null, null, null, null, null, 0);

        //Add new item
        itemManager.addNewItem(library);

        //Display items in library
        library.displayItems();
    }
}
