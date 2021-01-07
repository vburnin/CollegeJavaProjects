/*
    Programming Assigment: PI Approximator
    Programmer: Vladimir Burnin
    Date: 4/20/2019
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Craps extends JFrame {

    //Declare Jframe Objects
    private JTextArea jtaOutput;
    private JButton jbPlay, jbClear, jbExit;
    private JScrollPane jspOutput;
    private PlayButtonHandler pbHandler;
    private ExitButtonHandler ebHandler;
    private ClearButtonHandler cbHandler;

    public Craps(){
        //Setup Jframe
        setTitle("Craps");
        setSize(320,180);

        //Setup Scrollable Text Area
        jtaOutput = new JTextArea(10,1);
        jtaOutput.setEditable(false);
        jspOutput = new JScrollPane(jtaOutput);

        //Setup Buttons
        jbPlay = new JButton("Play Craps!");
        pbHandler = new PlayButtonHandler();
        jbPlay.addActionListener(pbHandler);

        jbClear = new JButton("Clear");
        cbHandler = new ClearButtonHandler();
        jbClear.addActionListener(cbHandler);

        jbExit = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        jbExit.addActionListener(ebHandler);

        //Setup Panes
        Container jpnlMain = getContentPane();
        JPanel jpnlCenter = new JPanel();
        JPanel jpnlSouth = new JPanel();

        //Setup Pane grid
        jpnlCenter.setLayout(new GridLayout(1,1));
        jpnlSouth.setLayout(new GridLayout(1,3));

        //Add objects to pane
        jpnlCenter.add(jspOutput);
        jpnlSouth.add(jbPlay);
        jpnlSouth.add(jbClear);
        jpnlSouth.add(jbExit);

        //Add panes to main pane
        jpnlMain.add(jpnlCenter, BorderLayout.CENTER);
        jpnlMain.add(jpnlSouth, BorderLayout.SOUTH);

        //Set visible and code exit behavior
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Play Button Handler
    private class PlayButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // Declare Variables
            int iRollTwo, iRollOne, iSum, iPoint;
            String sOutput;
            boolean Continue=true;

            //Roll Dice
            iRollOne = RollDice();
            iRollTwo = RollDice();

            //Find Sum
            iSum = iRollOne + iRollTwo;

            //Calculate Output and Pass to writeMessage
            sOutput = "You rolled " + iRollOne + " + " + iRollTwo + " = " + iSum + "\n";
            writeMessage(sOutput);

            //Calculate win
            if(iSum==2 || iSum==3 || iSum==12){
                sOutput = "You lost because you got a crap out :(\n";
                writeMessage(sOutput);
            }
            else if(iSum==7 || iSum==11){
                sOutput = "You win because you got a natural :)\n";
                writeMessage(sOutput);
            }
            else{
                sOutput = "Point is: " + iSum + "\n";
                writeMessage(sOutput);
                iPoint = iSum;
                while(Continue){
                    iRollOne = RollDice();
                    iRollTwo = RollDice();
                    iSum = iRollOne + iRollTwo;
                    sOutput = "You rolled " + iRollOne + " + " + iRollTwo + " = " + iSum + "\n";
                    writeMessage(sOutput);
                    if (iSum == 7) {
                        Continue=false;
                        sOutput = "You lost because your roll matches 7 :(\n";
                        writeMessage(sOutput);
                    }
                    else if (iSum == iPoint) {
                        Continue=false;
                        sOutput = "You win because your roll matches point :)\n";
                        writeMessage(sOutput);
                    }
                    else{
                        Continue=true;
                    }
                }
            }

        }

        //Roll Dice Method
        public int RollDice(){
            int iDiceValue = 1 + (int) (Math.random() * 6);
            return iDiceValue;
        }

        //Write Message Method
        public void writeMessage(String sOutput){
            jtaOutput.append(sOutput);
        }

    }

    //Clear button handler
    private class ClearButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            jtaOutput.setText("");
        }
    }

    //Exit button handler
    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    //Main
    public static void main(String args[]){
        // Create Gui
        Craps cGUI = new Craps();

    }
}
