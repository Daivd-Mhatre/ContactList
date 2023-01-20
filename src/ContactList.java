import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

// Contact list class manges all of our people in an arraylist creating methods to do things
public class ContactList
{
    // TODO: Create your array contacts
    ArrayList<Person> contacts;
    // TODO: Write a Constructor
    // Creates our arraylist
    public ContactList(){
        contacts = new ArrayList<Person>();
    }
    // Prints the instructions for the game
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    // AddContact first determines weather to add a student of lifter then goes
    public void addContact() {
        // TODO: Complete the addContact method
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Lifter");
        // If it is a student it asks the normal information then the grade
        if (s.nextLine().equals("1")){
            System.out.println("Please fill out the following information.");
            System.out.println("First Name:");
            String firstName = s.nextLine();
            System.out.println("Last Name:");
            String lastName = s.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = s.nextLine();
            System.out.println("Grade:");
            int grade = s.nextInt();
            Student student = new Student(firstName, lastName, phoneNumber, grade);
            System.out.println(student.getLastName());
            contacts.add(student);
        }
        else{
            // Otherwise it is a lifter it asks the normal information then the bench
            System.out.println("Please fill out the following information.");
            System.out.println("First Name:");
            String firstName = s.nextLine();
            System.out.println("Last Name:");
            String lastName = s.nextLine();
            System.out.println("Phone Number:");
            String phoneNumber = s.nextLine();
            System.out.println("Bench:");
            int bench = s.nextInt();
            Lifter lifter = new Lifter(firstName, lastName, phoneNumber, bench);
            contacts.add(lifter);
        }

    }

    /**
     * Loops through and prints all contacts
     */
    // Loops through the contacts and then prints them
    public void printContacts() {
        // TODO: Complete the printContacts method
        for(Person j: contacts) {
            System.out.println(j);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    // Sorts the arraylist by calling the different function
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        if (sortBy == 0){
            sortFirstName();
        }
        if (sortBy == 1){
            sortLastName();
        }
        if (sortBy == 2){
            sortPhoneNumber();
        }
    }

    // This bubble sorts the list by first name
    public void sortFirstName(){
        for(int i = 0; i < contacts.size() - 1; i++) {
            if (contacts.get(i).getFirstName().compareTo(contacts.get(i + 1).getFirstName()) > 0){
                Person temp = contacts.get(i + 1);
                contacts.set(i + 1, contacts.get(i));
                contacts.set(i, temp);
            }
        }
    }
    // This bubble sorts the list by last name
    public void sortLastName(){
        for(int i = 0; i < contacts.size() - 1; i++) {
            if (contacts.get(i).getLastName().compareTo(contacts.get(i + 1).getLastName()) > 0){
                Person temp = contacts.get(i + 1);
                contacts.set(i + 1, contacts.get(i));
                contacts.set(i, temp);
            }
        }
    }
    // This bubble sorts the list by phone number
    public void sortPhoneNumber(){
        for(int i = 0; i < contacts.size() - 1; i++) {
            if (contacts.get(i).getPhoneNumber().compareTo(contacts.get(i + 1).getPhoneNumber()) > 0){
                Person temp = contacts.get(i + 1);
                contacts.set(i + 1, contacts.get(i));
                contacts.set(i, temp);
            }
        }
    }

    // SearchBy methods look through the arraylist to find the string if not return null this one does first name
    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName){
        sort(0);
        for(Person j: contacts){
            if (j.getFirstName().equals(firstName)) {
                return j;
            }
        }
        return null;
    }
    // SearchBy methods look through the arraylist to find the string if not return null this one does last name
    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName){
        sort(1);
        for(Person j: contacts){
            if(j.getLastName().equals(lastName)){
                return j;
            }
        }
        return null;
    }
    // SearchBy methods look through the arraylist to find the string if not return null this one does phone number
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber){
        sort(2);
        for(Person j: contacts){
            if(j.getPhoneNumber().equals(phoneNumber)){
                return j;
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    // Loops through the arraylist and prints them out
    public void listStudents() {
        // TODO: Complete the listStudents method
        for(Person j: contacts){
            if (j instanceof Student){
                System.out.println(j);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    // run prints the menu options then runs the method to get input and determine what was chosen
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
        inputGame();
    }


    // Creates an instace of the class and runs it
    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }

    // Each different option is done here with a scanner getting input
    public void inputGame(){
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        while (input != 0) {
            // This calls our addContact method
            if (input == 1) {
                addContact();
            }
            // the next 3 just sort the list by different things then print it
            if (input == 2) {
                sort(0);
                printContacts();
            }
            if (input == 3) {
                sort(1);
                printContacts();
            }
            if (input == 4) {
                sort(3);
                printContacts();
            }
            // List all of the students
            if (input == 5) {
                listStudents();
            }
            // the next 3 get the specified type they are looking for then calls the search method
            if (input == 6) {
                System.out.println("Enter a first name:");
                String temp = s.next();
                if (searchByFirstName(temp) == (null)){
                    System.out.println("Person is not in the list");
                }
                else{
                    System.out.println(searchByFirstName(temp));
                }
            }
            if (input == 7) {
                System.out.println("Enter a last name:");
                String temp = s.next();

                if (searchByLastName(temp) == (null)){
                    System.out.println("Person is not in the list");
                }
                else{
                    System.out.println(searchByLastName(temp));
                }
            }
            if (input == 8) {
                System.out.println("Enter a phone number:");
                String temp = s.next();
                if (searchByPhoneNumber(temp) == (null)){
                    System.out.println("Person is not in the list");
                }
                else{
                    System.out.println(searchByPhoneNumber(temp));
                }
            }
            // Lastly we reprint the options and get new input
            printMenuOptions();
            input = s.nextInt();
        }
        return;
    }

}
