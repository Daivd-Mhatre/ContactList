/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

// Person class is what makes up the contacts
public class Person {
    // TODO: Complete the Person class
    // Instances variables for a person
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor initializes are variables
    public Person(String fname, String lname, String pNumber){
        firstName = fname;
        lastName = lname;
        phoneNumber = pNumber;
    }

    // Getter methods for our variables
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Overrides toString from object
    @Override
    public String toString() {
        return firstName + " " + lastName + " -  #" + phoneNumber;
    }
}
