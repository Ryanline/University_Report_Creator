package classes;

public class University {

    // Address and contact info
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Tuitions
    private double inStateTuition1to11;
    private double inStateTuition12to18;
    private double inStateTuition19plus;

    private double outStateTuition1to11;
    private double outStateTuition12to18;
    private double outStateTuition19plus;

    // Meal plans
    private double mealPlanA;
    private double mealPlanB;
    private double mealPlanC;

    // Health care (per credit)
    private double healthCare1to10;
    private double healthCare11to15;
    private double healthCare16plus;

    // Late fee (% of tuition bill figured on credit)
    private double lateFee;
    public double totalLateFee;

    // Incidental fees (cost per credit and max price)
    private double incidentalFeesPerCredit;
    private double incidentalFeesMax;

    // My variables to help calculate number of students
    int numInstate;
    int numOutofstate;
    int numTotalStudents;
    int numOnMealPlanA;
    int numOnMealPlanB;
    int numOnMealPlanC;
    double totalTuition;

    // Constructor
    public University(
            String pName,
            String pStreetAddress,
            String pCity,
            String pState,
            String pZip,
            String pPhone,
            double pInStateTuition1to11,
            double pInStateTuition12to18,
            double pInStateTuition19plus,
            double pOutStateTuition1to11,
            double pOutStateTuition12to18,
            double pOutStateTuition19plus,
            double pMealPlanA,
            double pMealPlanB,
            double pMealPlanC,
            double pHealthCare1to10,
            double pHealthCare11to15,
            double pHealthCare16plus,
            double pLateFee,
            double pIncidentalFeesPerCredit,
            double pIncidentalFeesMax) {
        this.setName(pName);
        this.setStreetAddress(pStreetAddress);
        this.setCity(pCity);
        this.setState(pState);
        this.setZip(pZip);
        this.setPhone(pPhone);
        this.setInStateTuition1to11(pInStateTuition1to11);
        this.setInStateTuition12to18(pInStateTuition12to18);
        this.setInStateTuition19plus(pInStateTuition19plus);
        this.setOutStateTuition1to11(pOutStateTuition1to11);
        this.setOutStateTuition12to18(pOutStateTuition12to18);
        this.setOutStateTuition19plus(pOutStateTuition19plus);
        this.setMealPlanA(pMealPlanA);
        this.setMealPlanB(pMealPlanB);
        this.setMealPlanC(pMealPlanC);
        this.setHealthCare1to10(pHealthCare1to10);
        this.setHealthCare11to15(pHealthCare11to15);
        this.setHealthCare16plus(pHealthCare16plus);
        this.setLateFee(pLateFee);
        this.setIncidentalFeesPerCredit(pIncidentalFeesPerCredit);
        this.setIncidentalFeesMax(pIncidentalFeesMax);
        this.numInstate = 0;
        this.numOutofstate = 0;
        this.numOnMealPlanA = 0;
        this.numOnMealPlanB = 0;
        this.numOnMealPlanC = 0;
        this.totalTuition = 0;
        this.totalLateFee = 0;
    }

    // Getter and setter methods ...

    // Address and contact info + and setters
    public String getName() {
        return this.name;
    }

    public void setName(String pName) {
        this.name = pName;
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

    // Tuitions - getter and setters
    public double getInStateTuition1to11() {
        return this.inStateTuition1to11;
    }

    public void setInStateTuition1to11(double pInStateTuition1to11) {
        this.inStateTuition1to11 = pInStateTuition1to11;
    }

    public double getInStateTuition12to18() {
        return this.inStateTuition12to18;
    }

    public void setInStateTuition12to18(double pInStateTuition12to18) {
        this.inStateTuition12to18 = pInStateTuition12to18;
    }

    public double getInStateTuition19plus() {
        return this.inStateTuition19plus;
    }

    public void setInStateTuition19plus(double pInStateTuition19plus) {
        this.inStateTuition19plus = pInStateTuition19plus;
    }

    public double getOutStateTuition1to11() {
        return this.outStateTuition1to11;
    }

    public void setOutStateTuition1to11(double pOutStateTuition1to11) {
        this.outStateTuition1to11 = pOutStateTuition1to11;
    }

    public double getOutStateTuition12to18() {
        return this.outStateTuition12to18;
    }

    public void setOutStateTuition12to18(double pOutStateTuition12to18) {
        this.outStateTuition12to18 = pOutStateTuition12to18;
    }

    public double getOutStateTuition19plus() {
        return this.outStateTuition19plus;
    }

    public void setOutStateTuition19plus(double pOutStateTuition19plus) {
        this.outStateTuition19plus = pOutStateTuition19plus;
    }

    // Meal plans - getter and setters
    public double getMealPlanA() {
        return this.mealPlanA;
    }

    public void setMealPlanA(double pMealPlanA) {
        this.mealPlanA = pMealPlanA;
    }

    public double getMealPlanB() {
        return this.mealPlanB;
    }

    public void setMealPlanB(double pMealPlanB) {
        this.mealPlanB = pMealPlanB;
    }

    public double getMealPlanC() {
        return this.mealPlanC;
    }

    public void setMealPlanC(double pMealPlanC) {
        this.mealPlanC = pMealPlanC;
    }

    // Health care (per credit) - getter and setters
    public double getHealthCare1to10() {
        return this.healthCare1to10;
    }

    public void setHealthCare1to10(double pHealthCare1to10) {
        this.healthCare1to10 = pHealthCare1to10;
    }

    public double getHealthCare11to15() {
        return this.healthCare11to15;
    }

    public void setHealthCare11to15(double pHealthCare11to15) {
        this.healthCare11to15 = pHealthCare11to15;
    }

    public double getHealthCare16plus() {
        return this.healthCare16plus;
    }

    public void setHealthCare16plus(double pHealthCare16plus) {
        this.healthCare16plus = pHealthCare16plus;
    }

    // Late fee (% of tuition bill figured on credit) - getter and setters
    public double getLateFee() {
        return this.lateFee;
    }

    public void setLateFee(double pLateFee) {
        this.lateFee = pLateFee;
    }

    // Incidental fees (cost per credit and max price) - getter and setters
    public double getIncidentalFeesPerCredit() {
        return this.incidentalFeesPerCredit;
    }

    public void setIncidentalFeesPerCredit(double pIncidentalFeesPerCredit) {
        this.incidentalFeesPerCredit = pIncidentalFeesPerCredit;
    }

    public double getIncidentalFeesMax() {
        return this.incidentalFeesMax;
    }

    public void setIncidentalFeesMax(double pIncidentalFeesMax) {
        this.incidentalFeesMax = pIncidentalFeesMax;
    }

    // My own methods

    public int getNumInstate() {
        return this.numInstate;
    }

    public void addInstate() {
        this.numInstate++;
    }

    public int getNumOutofstate() {
        return this.numOutofstate;
    }

    public void addOutofstate() {
        this.numOutofstate++;
    }

    public int getNumTotalStudents() {
        return this.numInstate + this.numOutofstate;
    }

    public int getNumOnMealPlanA() {
        return this.numOnMealPlanA;
    }

    public void addOneToMealPlanA() {
        this.numOnMealPlanA++;
    }

    public int getNumOnMealPlanB() {
        return this.numOnMealPlanB;
    }

    public void addOneToMealPlanB() {
        this.numOnMealPlanB++;
    }

    public int getNumOnMealPlanC() {
        return this.numOnMealPlanC;
    }

    public void addOneToMealPlanC() {
        this.numOnMealPlanC++;
    }

    public void addToTotalTuition(double pTuition) {
        this.totalTuition = this.totalTuition + pTuition;
    }

    public double getTotalTuition() {
        return this.totalTuition;
    }

    public void addToTotalLateFee(double pLateFee) {
        this.totalLateFee = this.totalLateFee + pLateFee;
    }

    public double getTotalLateFee() {
        return this.totalLateFee;
    }

    // toString() and equals()

    @Override
    public String toString() {
        return "University: " + this.getName() + "\n" +
                "Street address: " + this.getStreetAddress() + "\n" +
                "City: " + this.getCity() + "\n" +
                "State: " + this.getState() + "\n" +
                "Zip: " + this.getZip() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "In-state tuition..." + "\n" +
                "1-11 credits: " + this.getInStateTuition1to11() + "\n" +
                "12-18 credits: " + this.getInStateTuition12to18() + "\n" +
                "19+ credits: " + this.getInStateTuition19plus() + "\n" +
                "Out-of-state tuition..." + "\n" +
                "1-11 credits: " + this.getOutStateTuition1to11() + "\n" +
                "12-18 credits: " + this.getOutStateTuition12to18() + "\n" +
                "19+ credits: " + this.getOutStateTuition19plus() + "\n" +
                "Meal plans..." + "\n" +
                "Meal plan A: " + this.getMealPlanA() + "\n" +
                "Meal plan B: " + this.getMealPlanB() + "\n" +
                "Meal plan C: " + this.getMealPlanC() + "\n" +
                "Healthcare..." + "\n" +
                "1-10 credits: " + this.healthCare1to10 + "\n" +
                "11-15 credits: " + this.healthCare11to15 + "\n" +
                "16+ credits: " + this.healthCare16plus + "\n" +
                "Late fee (% of tuition): " + this.getLateFee() + "\n" +
                "Incidental fees per credit: " + this.getIncidentalFeesPerCredit() + "\n" +
                "Maximum incidental fees: " + this.getIncidentalFeesMax();
    }

    public boolean equals(University pUniversity) {
        if (this.toString().equals(pUniversity.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
