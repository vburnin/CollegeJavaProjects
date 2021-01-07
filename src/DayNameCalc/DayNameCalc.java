/*
    Programming Assigment: Day Name Calculator
    Programmer: Vladimir Burnin
    Date: 3/22/2019
 */
import javax.swing.*;

public class DayNameCalc {
    public static void main(String[] args){
        // Declare variables
        String sDate, sTest, sDay = "Error";
        Integer iDay, iMonth, iCenturyYear, iYear, iCentury, iCenturyCode = 0, iMonthCode = 0, iDayCode;
        Boolean bLeapYear = Boolean.FALSE;

        // Prompt user for input
        sDate = JOptionPane.showInputDialog("Enter the date in mm/dd/yyyy format:");

        // Extract dates information
        iMonth = Integer.parseInt(sDate.substring(0, sDate.indexOf('/')));
        iDay = Integer.parseInt(sDate.substring(sDate.indexOf('/')+1,sDate.lastIndexOf('/')));
        iCenturyYear = Integer.parseInt(sDate.substring(sDate.lastIndexOf('/')+1));
        iYear = Integer.parseInt(sDate.substring(sDate.length()-2));
        iCentury = Integer.parseInt(sDate.substring(sDate.lastIndexOf('/')+1, sDate.length()-2))+1;

        // Check for leap year
        if (iYear%4 == 0){
            bLeapYear = Boolean.TRUE;
            if (iYear%100 == 0){
                bLeapYear = Boolean.FALSE;
                if (iYear%400 == 0){
                    bLeapYear = Boolean.TRUE;
                }
            }
        }

        // Find century code
        if (iCentury%4 == 0){
            iCenturyCode = 0;
        }
        else if (iCentury%4 == 1){
            iCenturyCode = 6;
        }
        else if (iCentury%4 == 2){
            iCenturyCode = 4;
        }
        else if (iCentury%4 == 3){
            iCenturyCode = 2;
        }
        else {
            JOptionPane.showMessageDialog(null, "Error: Invalid Year", "Day Name Calculator",JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        }

        // Find month code
        if (iMonth == 1){
            if (bLeapYear==Boolean.FALSE){
                iMonthCode = 0;
            }
            else {
                iMonthCode = 6;
            }
        }
        else if (iMonth == 2){
            if (bLeapYear==Boolean.FALSE){
                iMonthCode = 3;
            }
            else {
                iMonthCode = 2;
            }
        }
        else if (iMonth == 3){
            iMonthCode = 3;
        }
        else if (iMonth == 4){
            iMonthCode = 6;
        }
        else if (iMonth == 5){
            iMonthCode = 1;
        }
        else if (iMonth == 6){
            iMonthCode = 4;
        }
        else if (iMonth == 7){
            iMonthCode = 6;
        }
        else if (iMonth == 8){
            iMonthCode = 2;
        }
        else if (iMonth == 9){
            iMonthCode = 5;
        }
        else if (iMonth == 10){
            iMonthCode = 0;
        }
        else if (iMonth == 11){
            iMonthCode = 3;
        }
        else if (iMonth == 12){
            iMonthCode = 5;
        }
        else {
            JOptionPane.showMessageDialog(null, "Error: Invalid Month", "Day Name Calculator",JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        }

        // Calculation
        iDayCode = (iCenturyCode+iYear+iYear/4+iMonthCode+iDay)%7;

        // Find day of the week
        switch (iDayCode) {
            case 1:
                sDay = "The Day of the week is Monday";
                break;
            case 2:
                sDay = "The Day of the week is Tuesday";
                break;
            case 3:
                sDay = "The Day of the week is Wednesday";
                break;
            case 4:
                sDay = "The Day of the week is Thursday";
                break;
            case 5:
                sDay = "The Day of the week is Friday";
                break;
            case 6:
                sDay = "The Day of the week is Saturday";
                break;
            case 0:
                sDay = "The Day of the week is Sunday";
                break;
        }

        // Output result to user
        JOptionPane.showMessageDialog(null, sDay, "Grade And Email",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);







    }
}
