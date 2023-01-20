// Lifter is a tyoe of person just like student
public class Lifter extends Person{
    // Initializing instance variables
    private int Bench;
    // Constructor calling person constructor and initializing bench
    public Lifter(String fname, String lname, String pNumber, int bench){
        super(fname, lname, pNumber);
        Bench = bench;
    }

    // Getter method for bench
    public int getBench() {
        return Bench;
    }

    // Overrides toString from person
    @Override
    public String toString() {
        return super.toString() + " Bench: " + Bench;
    }
}

