/*
    Programming Assigment: Lottery Odds
    Programmer: Vladimir Burnin
    Date: 3/29/2019
 */
import javax.swing.*;
import java.text.DecimalFormat;

public class LotteryOdds {
    public static void main(String[] args) {
        // Define variables
        Double dTotal = 1.0, dMax, dNumbers;
        String sMax, sNumbers;
        DecimalFormat dfNumber = new DecimalFormat("#,###");

        // Prompt user for input
        sMax = JOptionPane.showInputDialog("Enter maximum number:");
        sNumbers = JOptionPane.showInputDialog("Enter the amount of numbers:");

        // Perform calculations
        dMax= Double.parseDouble(sMax);
        dNumbers = Double.parseDouble(sNumbers);

        while(dNumbers>0){
            dTotal *= dMax/dNumbers;
            dNumbers--;
            dMax--;
        }

        // Output to user
        JOptionPane.showMessageDialog(null, "Chances of winning are 1 out of " + dfNumber.format(dTotal), "Lottery Odds",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
