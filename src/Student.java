/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

// Student is a type of person just like lifter
public class Student extends Person{
    // TODO: Modify and complete this class
    // Initializing instance variables
    private int grade;
    // Constructor calling person constructor and initializing grade
    public Student(String fname, String lname, String pNumber, int Grade){
        super(fname, lname, pNumber);
        grade = Grade;
    }

    // Getter method for grade
    public int getGrade() {
        return grade;
    }

    // Overrides toString from person
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
