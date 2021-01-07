/*
    Programming Assigment: PI Approximator
    Programmer: Vladimir Burnin
    Date: 4/20/2019
 */

import javax.swing.*;

public class PIApproximator {
    public static void main(String [] args){
        // Define variables, doubles needed to support more than 2 billion iterations
        String sMax;
        Double dPi = 1.0, dCount = 1.0, dMax;
        Boolean bEven = Boolean.FALSE;

        // Prompt user for input
        sMax = JOptionPane.showInputDialog("Enter maximum number to approximate too");

        // Perform calculations, since a even always follows a odd and vice versa it's faster to keep track of that then too perform calculation
        dMax = Double.parseDouble(sMax);
        while (dCount<=dMax){
            if (bEven==Boolean.TRUE){
                dPi += 1/(dCount*2+1);
            }
            else {
                dPi -= 1/(dCount*2+1);
            }
            bEven = !bEven;
            dCount++;
        }
        dPi *= 4;

        // Output result to user
        JOptionPane.showMessageDialog(null, "The approximate value of Pi calculated " + sMax + " times is: " + dPi, "Pi Approximator",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
