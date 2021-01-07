/*
    Programming Assigment: Grade and Email
    Programmer: Vladimir Burnin
    Date: 3/22/2019
 */

import javax.swing.*;

public class GradeAndEmail {
    public static void main(String[] args){
        // Declare variables
        String sEmail, sGrade, sMessage="For User: ";
        Double dGrade;
        Boolean bInvalid = Boolean.FALSE;

        // Prompt user input
        sEmail = JOptionPane.showInputDialog("Enter a user email:");
        sGrade = JOptionPane.showInputDialog("Enter test grade:");
        dGrade = Double.parseDouble(sGrade);
        sMessage += sEmail + "\n";

        // Perform logic email
        if (sEmail.length()==0){
            sMessage += "Email is empty\n";
            bInvalid = Boolean.TRUE;
        }
        if (sEmail.length()>=30){
            sMessage += "Email must be less than 30 characters\n";
            bInvalid = Boolean.TRUE;
        }
        if (!sEmail.endsWith("@student.stcc.edu")){
            sMessage += "Email must end in: @student.stcc.edu\n";
            bInvalid = Boolean.TRUE;
        }
        if (sEmail.length()-sEmail.replace("@","").length()>1){
            sMessage += "Email can only contain one @\n";
            bInvalid = Boolean.TRUE;
        }
        if (sEmail.length() == 0 || !Character.isLetter(sEmail.charAt(0))){
            sMessage += "Email must start with latin letter\n";
            bInvalid = Boolean.TRUE;
        }
        if (sEmail.contains("#") || sEmail.contains("$") || sEmail.contains("%") || sEmail.contains("&") || sEmail.contains(",")){
            sMessage += "Email can not have: # $ % & ,\n";
            bInvalid = Boolean.TRUE;
        }
        if (bInvalid == Boolean.FALSE){
            sMessage += "Email is valid\n";
        }
        sMessage += "Test Score is: " + dGrade + "\n" + "Letter Grade is: ";

        // Perform logic grade
        if (dGrade > 96.9){
            sMessage += "A+";
        }
        else if (dGrade > 93.9){
            sMessage += "A";
        }
        else if (dGrade > 89.9){
            sMessage += "A-";
        }
        else if (dGrade > 86.9){
            sMessage += "B+";
        }
        else if (dGrade > 83.9){
            sMessage += "B";
        }
        else if (dGrade > 79.9){
            sMessage += "B-";
        }
        else if (dGrade > 76.9){
            sMessage += "C+";
        }
        else if (dGrade > 73.9){
            sMessage += "C";
        }
        else if (dGrade > 69.9){
            sMessage += "C-";
        }
        else if (dGrade > 66.9){
            sMessage += "D+";
        }
        else if (dGrade > 63.9){
            sMessage += "D";
        }
        else if (dGrade > 59.9){
            sMessage += "D-";
        }
        else {
            sMessage += "F";
        }

        // Output to user
        JOptionPane.showMessageDialog(null, sMessage, "Grade And Email",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
