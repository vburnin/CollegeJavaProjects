/*
    Programming Assigment: GUI Circle Calculator
    Programmer: Vladimir Burnin
    Date: 3/22/2019
 */
import javax.swing.*;

public class GUICircleCalc {
    public static void main(String[] args){
        // Declare variables
        String sResult, sDiameter;
        Double dDiameter, dRadius, dCircumference, dArea;

        // Prompt user input
        sDiameter = JOptionPane.showInputDialog("Enter the diameter of the circle:");
        dDiameter = Double.parseDouble(sDiameter);

        // Perform calculations
        dRadius = dDiameter/2;
        dCircumference = dDiameter * Math.PI;
        dArea = dRadius*dRadius;

        // Output to users
        sResult = "The entered diameter is: " + Math.round(dDiameter) + "\nThe radius is: " + Math.round(dRadius) + "\nThe circumference of the circle is: " + Math.round(dCircumference) + "\nThe area of the circle is: " + Math.round(dArea);
        JOptionPane.showMessageDialog(null, sResult, "GUI Circle Calculator",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
