package classes;

public class Person {

    private int age;
    private String gender;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phone;
    protected Name name;

    // Getter and setter methods for all field variables (just getter for Name)
    public int getAge() {
        return this.age;
    }

    public void setAge(int pAge) {
        this.age = pAge;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String pGender) {
        this.gender = pGender;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String pStreetAddress) {
        this.streetAddress = pStreetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String pCity) {
        this.city = pCity;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String pState) {
        this.state = pState;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String pZip) {
        this.zip = pZip;
    }

    public String getFullAddress() {
        return this.getStreetAddress() + ", " + this.getCity() + ", " + this.getState() + " " + this.getZip();
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneFormatted() {
        if (this.getPhone().length() == 10) {
            return "(" + this.getPhone().substring(0, 3) + ") " + this.getPhone().substring(3, 6) + "-"
                    + this.getPhone().substring(6, 10);
        } else {
            return this.getPhone().substring(0, 1) + "(" + this.getPhone().substring(1, 4) + ") "
                    + this.getPhone().substring(4, 7) + "-" + this.getPhone().substring(7, 11);
        }
    }

    public void setPhone(String pPhone) {
        this.phone = pPhone;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name.toString() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Gender: " + this.getGender() + "\n" +
                "Street address: " + this.getStreetAddress() + "\n" +
                "City: " + this.getCity() + "\n" +
                "State: " + this.getState() + "\n" +
                "Zip code: " + this.getZip() + "\n" +
                "Phone number: " + this.getPhone() + "\n";
    }

    public int compareTo(Person pPerson) {
        return this.toString().compareTo(pPerson.toString());
    }

    public boolean equals(Person pPerson) {
        return this.toString().equals(pPerson.toString());
    }
}
