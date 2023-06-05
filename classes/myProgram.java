package classes;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class myProgram {

    public static String formatDouble(double value) {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(value);
    }

    public static void main(String[] args) throws IOException {

        boolean added;

        // Universities

        ArrayList<University> universities = new ArrayList<>();
        File inputFile1 = new File("textFiles/Universities9.txt");
        Scanner fileScanner1 = new Scanner(inputFile1);

        while (fileScanner1.hasNext()) {

            String line = fileScanner1.nextLine();
            String[] fields = line.split(",");
            if (fields.length == 21) {

                University university = new University(
                        fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                        Double.parseDouble(fields[6]), Double.parseDouble(fields[7]), Double.parseDouble(fields[8]),
                        Double.parseDouble(fields[9]), Double.parseDouble(fields[10]), Double.parseDouble(fields[11]),
                        Double.parseDouble(fields[12]), Double.parseDouble(fields[13]), Double.parseDouble(fields[14]),
                        Double.parseDouble(fields[15]), Double.parseDouble(fields[16]), Double.parseDouble(fields[17]),
                        Double.parseDouble(fields[18]), Double.parseDouble(fields[19]), Double.parseDouble(fields[20]));

                // 'added' will help us check/update if the uni gets added
                added = false;

                // Runs an initial check to see if uni is in the list
                for (int i = 0; i < universities.size(); i++) {

                    if (universities.get(i).toString().equals(university.toString())) {
                        added = true;
                    }
                }

                // If the list is empty, add the uni w/o checking
                if (universities.size() == 0) {
                    universities.add(university);
                }

                // If size != 0 and the uni hasn't been added...
                else if (!added) {

                    // Iterate through the uni ArrayList
                    for (int i = 0; i < universities.size(); ++i) {

                        // Check if it's already been added
                        for (int j = 0; j < universities.size(); j++) {
                            if (universities.get(i).toString().equals(university.toString())) {
                                added = true;
                            }
                        }
                        if (added) {
                            break;
                        }

                        // Add it to its ordered position using compareTo() to help
                        else if (university.toString().compareTo(universities.get(i).toString()) < 1) {
                            universities.add(i, university);
                            added = true; // <- sets added to true when added
                        }

                        // If compareTo() didn't lead to a -1 and you hit the end of the list and
                        // compareTo() is saying 0 or +1, add to the end
                        else if (i == universities.size() - 1
                                && university.toString().compareTo(universities.get(i).toString()) >= 0) {
                            universities.add(university);
                            added = true;
                        }
                    }
                }
            }
        }
        fileScanner1.close();

        // Students
        ArrayList<Student> students = new ArrayList<>();
        File inputFile2 = new File("textFiles/StudentFile.txt");
        Scanner fileScanner2 = new Scanner(inputFile2);

        while (fileScanner2.hasNext()) {

            String line = fileScanner2.nextLine();
            String[] fields = line.split(",");
            if (fields.length == 17) {

                Student student = new Student(
                        fields[0], fields[1], fields[2],
                        Integer.parseInt(fields[3]),
                        fields[4], fields[5], fields[6], fields[7],
                        fields[8], fields[9], fields[10], fields[11],
                        Integer.parseInt(fields[12]),
                        fields[13], fields[14], fields[15], fields[16]);

                // 'added' will help us check/update if the uni gets added
                added = false;

                // Runs an initial check to see if uni is in the list
                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).toString().equals(student.toString())) {
                        added = true;
                    }
                }

                // If the list is empty, add the uni w/o checking
                if (students.size() == 0) {
                    students.add(student);
                }

                // If size != 0 and the uni hasn't been added...
                else if (!added) {

                    // Iterate through the uni ArrayList
                    for (int i = 0; i < students.size(); ++i) {

                        // Check if it's already been added
                        for (int j = 0; j < students.size(); j++) {
                            if (students.get(i).toString().equals(student.toString())) {
                                added = true;
                            }
                        }
                        if (added) {
                            break;
                        }

                        // Add it to its ordered position using compareTo() to help
                        else if (student.toString().compareTo(students.get(i).toString()) < 1) {
                            students.add(i, student);
                            added = true; // <- sets added to true when added
                        }

                        // If compareTo() didn't lead to a -1 and you hit the end of the list and
                        // compareTo() is saying 0 or +1, add to the end
                        else if (i == students.size() - 1
                                && student.toString().compareTo(students.get(i).toString()) >= 0) {
                            students.add(student);
                            added = true;
                        }
                    }
                }
            }
        }
        fileScanner2.close();

        PrintWriter writer = new PrintWriter(new File("textFiles/UniversityReport.txt"));
        for (int i = 0; i < universities.size(); i++) {

            // REPORT

            // First 4 lines
            writer.println("\n\t\t\t\t" + universities.get(i).getName().toUpperCase());
            writer.println("\t\t\t\t" + universities.get(i).getStreetAddress());
            writer.println("\t\t\t\t" + universities.get(i).getCity() + ", " + universities.get(i).getState() + ", "
                    + universities.get(i).getZip());
            writer.println("\t\t\t\t" + universities.get(i).getPhoneFormatted() + "\n");

            // Each student
            for (int j = 0; j < students.size(); j++) {
                if (universities.get(i).getName().equals(students.get(j).getStudentUniName())) {

                    // NAME and CREDITS
                    writer.printf("%-11s\t%-27s", "NAME", students.get(j).getName().toString());
                    writer.println("CREDITS  \t" + students.get(j).getCreditsEnrolled());

                    // ADDRESS
                    writer.printf("%-11s\t%-39s\n", "ADDRESS", students.get(j).getFullAddress().toString());

                    // PHONE
                    writer.printf("%-11s\t%s\n", "ADDRESS", students.get(j).getPhoneFormatted().toString());

                    // TUITION
                    double tuition;
                    if (students.get(j).getInstate() && students.get(j).getCreditsEnrolled() < 12) {
                        tuition = universities.get(i).getInStateTuition1to11();
                    } else if (students.get(j).getInstate() && students.get(j).getCreditsEnrolled() < 19) {
                        tuition = universities.get(i).getInStateTuition12to18();
                    } else if (students.get(j).getInstate() && students.get(j).getCreditsEnrolled() > 18) {
                        tuition = universities.get(i).getInStateTuition19plus();
                    } else if (!students.get(j).getInstate() && students.get(j).getCreditsEnrolled() < 12) {
                        tuition = universities.get(i).getOutStateTuition1to11();
                    } else if (!students.get(j).getInstate() && students.get(j).getCreditsEnrolled() < 19) {
                        tuition = universities.get(i).getOutStateTuition12to18();
                    } else {
                        tuition = universities.get(i).getOutStateTuition19plus();
                    }
                    writer.printf("%-11s\t%s%9s\n", "TUITION", "$ ", formatDouble(tuition));

                    // LATE FEE
                    double lateFee = 0.00;
                    if (students.get(j).getLateFeeAssessed()) {
                        lateFee = tuition * universities.get(i).getLateFee();
                    }
                    universities.get(i).addToTotalLateFee(lateFee);
                    writer.printf("%-11s\t%s%9s\n", "LATE FEE", "$ ", formatDouble(lateFee));

                    // INCIDENTAL
                    double incidental;
                    incidental = students.get(j).getCreditsEnrolled()
                            * universities.get(i).getIncidentalFeesPerCredit();
                    if (incidental > universities.get(i).getIncidentalFeesMax()) {
                        incidental = universities.get(i).getIncidentalFeesMax();
                    }
                    writer.printf("%-11s\t%s%9s\n", "INCIDENTAL", "$ ", formatDouble(incidental));

                    // HEALTH CARE
                    double healthcare;
                    if (students.get(j).getHasHealthcare() && students.get(j).getCreditsEnrolled() < 11) {
                        healthcare = students.get(j).getCreditsEnrolled() * universities.get(i).getHealthCare1to10();
                    } else if (students.get(j).getHasHealthcare() && students.get(j).getCreditsEnrolled() < 16) {
                        healthcare = students.get(j).getCreditsEnrolled() * universities.get(i).getHealthCare11to15();
                    } else if (students.get(j).getHasHealthcare() && students.get(j).getCreditsEnrolled() > 16) {
                        healthcare = students.get(j).getCreditsEnrolled() * universities.get(i).getHealthCare16plus();
                    } else {
                        healthcare = 0.00;
                    }
                    writer.printf("%-11s\t%s%9s\n", "HEALTH CARE", "$ ", formatDouble(healthcare));

                    // MEAL PLAN & TOTAL
                    double meal;
                    if (students.get(j).getFoodOption().equals("A")) {
                        meal = universities.get(i).getMealPlanA();
                        universities.get(i).addOneToMealPlanA();
                    } else if (students.get(j).getFoodOption().equals("B")) {
                        meal = universities.get(i).getMealPlanB();
                        universities.get(i).addOneToMealPlanB();
                    } else if (students.get(j).getFoodOption().equals("C")) {
                        meal = universities.get(i).getMealPlanC();
                        universities.get(i).addOneToMealPlanC();
                    } else {
                        meal = 0.00;
                    }
                    writer.printf("%-11s\t%s%9s", "MEAL PLAN", "$ ", formatDouble(meal));
                    writer.printf("\t\t%s\t\t%s\n\n", "   TOTAL ",
                            "$ " + formatDouble(tuition + lateFee + incidental + healthcare + meal));

                    // Update in/out of state, meal plans, tuition totals, late fee totals
                    if (students.get(j).getInstate()) {
                        universities.get(i).addInstate();
                    } else {
                        universities.get(i).addOutofstate();
                    }
                    universities.get(i).addToTotalTuition(tuition);
                }
            }
            writer.println("\t\t\t\t" + universities.get(i).getName().toUpperCase() + " TOTALS\n");
            writer.printf("%-18s\t%s\n", "NUMBER OF STUDENTS", universities.get(i).getNumTotalStudents());
            writer.printf("%-18s\t%s\n", "INSTATE", universities.get(i).getNumInstate());
            writer.printf("%-18s\t%s\n", "OUT OF STATE", universities.get(i).getNumOutofstate());

            writer.printf("%-9s\t\t%s\t%s%2s%9s\n", "MEAL PLAN", "3 Meals a day", universities.get(i).numOnMealPlanA,
                    "$", formatDouble(universities.get(i).getMealPlanA() * universities.get(i).numOnMealPlanA));
            writer.printf("%-9s\t\t%s\t%s%2s%9s\n", "", "2 Meals a day", universities.get(i).numOnMealPlanB, "$",
                    formatDouble(universities.get(i).getMealPlanB() * universities.get(i).numOnMealPlanB));
            writer.printf("%-9s\t\t%s\t%s%2s%9s\n", "", "1 Meals a day", universities.get(i).numOnMealPlanC, "$",
                    formatDouble(universities.get(i).getMealPlanC() * universities.get(i).numOnMealPlanC));

            writer.printf("\t\t\t%-14s\t%-4s%9s\n", "FOOD SUB TOTAL", "  $",
                    formatDouble((universities.get(i).getMealPlanA() * universities.get(i).numOnMealPlanA) +
                            (universities.get(i).getMealPlanB() * universities.get(i).numOnMealPlanB) +
                            (universities.get(i).getMealPlanC() * universities.get(i).numOnMealPlanC)));

            writer.printf("%-9s\t\t%-2s%9s\n", "TUITION", "$", formatDouble(universities.get(i).getTotalTuition()));
            writer.printf("%-9s\t\t%-2s%9s\n", "LATE FEE", "$",
                    formatDouble(universities.get(i).getTotalLateFee()));
        }

        PrintWriter universityWriter = new PrintWriter("textFiles/UniversityObjects.txt");
        for (int i = 0; i < universities.size(); i++) {
            universityWriter.println(universities.get(i).toString() + "\n");
        }
        universityWriter.close();

        PrintWriter studentWriter = new PrintWriter("textFiles/StudentObjects.txt");
        for (int i = 0; i < students.size(); i++) {
            studentWriter.println(students.get(i).toString() + "\n");
        }
        studentWriter.close();
    }
}