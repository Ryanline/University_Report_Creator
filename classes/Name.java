package classes;

public class Name {

    // Contains First Name, Middle Name, and Last Name
    private final String firstName;
    private final String middleName;
    private final String lastName;

    // Constructor
    public Name(String pFirstName, String pMiddleName, String pLastName) {
        this.firstName = pFirstName;
        this.middleName = pMiddleName;
        this.lastName = pLastName;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    // Returns "firstName middleName lastName" with spaces inbetween
    @Override
    public String toString() {
        return "" + this.firstName + " " + this.middleName + " " + this.lastName + "";
    }

    public boolean equals(Name pName) {
        if (this.toString().equals(pName.toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * These next two methods work together
     * 
     * (1) comparisonOrder() tees the names up in last-first-middle order
     * 
     * (2) compareTo(Name pName) uses String compareTo() method to lexographically
     * compare the two class' names in that order
     */
    public String comparisonOrder() {
        return this.getLastName() + this.getFirstName() + this.getMiddleName();
    }

    public int compareTo(Name pName) {
        return this.comparisonOrder().compareTo(pName.comparisonOrder());
    }
}
