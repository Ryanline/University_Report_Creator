package classes;

public class Student extends Person {

    private String studentID;
    private String studentUniName;
    private int creditsEnrolled;
    private boolean instate;
    private boolean lateFeeAssessed;
    private String foodOption;
    private boolean hasHealthCare;

    // Constructor
    public Student(
            String pFirstName,
            String pMiddleName,
            String pLastName,
            int pAge,
            String pGender,
            String pStreetAddress,
            String pCity,
            String pState,
            String pZip,
            String pPhone,
            String pUniversity,
            String pStudentID,
            int pCreditsEnrolled,
            String pInState,
            String pLateFeeAssessed,
            String pFoodOption,
            String pHasHealthCare) {
        this.name = new Name(pFirstName, pMiddleName, pLastName);
        this.setAge(pAge);
        this.setGender(pGender);
        this.setStreetAddress(pStreetAddress);
        this.setCity(pCity);
        this.setState(pState);
        this.setZip(pZip);
        this.setPhone(pPhone);
        this.setStudentUniName(pUniversity);
        this.setStudentID(pStudentID);
        this.setCreditsEnrolled(pCreditsEnrolled);
        if (pInState.equals("Y")) {
            this.setInstate(true);
        } else {
            this.setInstate(false);
        }
        if (pLateFeeAssessed.equals("Y")) {
            this.setLateFeeAssessed(true);
        } else {
            this.setLateFeeAssessed(false);
        }
        this.setFoodOption(pFoodOption);
        if (pHasHealthCare.equals("Y")) {
            this.setHasHealthcare(true);
        } else {
            this.setHasHealthcare(false);
        }
    }

    // Getter and setter methods
    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String pStudentID) {
        this.studentID = pStudentID;
    }

    public String getStudentUniName() {
        return this.studentUniName;
    }

    public void setStudentUniName(String pUniName) {
        this.studentUniName = pUniName;
    }

    public int getCreditsEnrolled() {
        return this.creditsEnrolled;
    }

    public void setCreditsEnrolled(int pCreditsEnrolled) {
        this.creditsEnrolled = pCreditsEnrolled;
    }

    public boolean getInstate() {
        return this.instate;
    }

    public void setInstate(boolean pInstate) {
        this.instate = pInstate;
    }

    public boolean getLateFeeAssessed() {
        return this.lateFeeAssessed;
    }

    public void setLateFeeAssessed(boolean pLateFeeAssessed) {
        this.lateFeeAssessed = pLateFeeAssessed;
    }

    public String getFoodOption() {
        return this.foodOption;
    }

    public void setFoodOption(String pFoodOption) {
        this.foodOption = pFoodOption;
    }

    public boolean getHasHealthcare() {
        return this.hasHealthCare;
    }

    public void setHasHealthcare(boolean pHasHealthCare) {
        this.hasHealthCare = pHasHealthCare;
    }

    @Override
    public String toString() {
        return super.toString() +
                "University: " + this.getStudentUniName() + "\n" +
                "Student ID: #" + this.getStudentID() + "\n" +
                "Credits Enrolled: " + this.getCreditsEnrolled() + "\n" +
                "In-state: " + this.getInstate() + "\n" +
                "Late fee assessed: " + this.getLateFeeAssessed() + "\n" +
                "Food option: " + this.getFoodOption() + "\n" +
                "Has health care: " + this.getHasHealthcare() + "\n";
    }

    public int compareTo(Student pStudent) {
        if (super.compareTo(pStudent) != 0) {
            return super.compareTo(pStudent);
        } else {
            return this.getStudentID().compareTo(pStudent.getStudentID());
        }
    }

    public String getNameAndID() {
        return this.name.toString() + this.getStudentID();
    }

    public boolean equals(Student pStudent) {
        if (this.getNameAndID().equals(pStudent.getNameAndID())) {
            return true;
        } else {
            return false;
        }
    }
}