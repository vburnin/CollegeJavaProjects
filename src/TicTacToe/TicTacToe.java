/*
    Programming Assigment: TicTacToe
    Programmer: Vladimir Burnin
    Date: 5/12/2019
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe extends JFrame implements ActionListener{
    // Declare JFrame objects
    private JButton jbtnTicTacToe1, jbtnTicTacToe2, jbtnTicTacToe3, jbtnTicTacToe4, jbtnTicTacToe5, jbtnTicTacToe6, jbtnTicTacToe7, jbtnTicTacToe8, jbtnTicTacToe9, jbtnExit, jbtnReset;
    private JLabel lblPlayerX, lblPlayerO;
    private JTextField jtfPlayerO, jtfPlayerX;

    // Declare JPanels
    private JPanel jpnlCenter = new JPanel();
    private JPanel jpnlBottom = new JPanel();
    private JPanel jpnlTop = new JPanel();
    private JPanel jpnlMain = new JPanel();

    // Declare Variable to store turn status
    private boolean bIsPlayerX = true;

    public TicTacToe(String sTitle){
        //Setup JFrame
        super(sTitle);
        setSize(400,400);

        //Setup layouts for panels
        jpnlMain.setLayout(new BorderLayout());
        jpnlTop.setLayout(new GridLayout(1,4));
        jpnlCenter.setLayout(new GridLayout(3,3));
        jpnlBottom.setLayout(new GridLayout(1,2));

        // Create the labels
        lblPlayerX = new JLabel("Player X");
        lblPlayerO = new JLabel("Player O");

        // Create the player name fields
        jtfPlayerX = new JTextField();
        jtfPlayerO = new JTextField();

        // Set text color for labels and fields
        lblPlayerX.setForeground(Color.RED);
        lblPlayerO.setForeground(Color.GREEN);
        jtfPlayerX.setForeground(Color.RED);
        jtfPlayerO.setForeground(Color.GREEN);

        // Add labels and field to panel
        jpnlTop.add(lblPlayerX);
        jpnlTop.add(jtfPlayerX);
        jpnlTop.add(lblPlayerO);
        jpnlTop.add(jtfPlayerO);

        // Create Tic Tac Toe buttons
        jbtnTicTacToe1 = instantiateTTTButton();
        jbtnTicTacToe2 = instantiateTTTButton();
        jbtnTicTacToe3 = instantiateTTTButton();
        jbtnTicTacToe4 = instantiateTTTButton();
        jbtnTicTacToe5 = instantiateTTTButton();
        jbtnTicTacToe6 = instantiateTTTButton();
        jbtnTicTacToe7 = instantiateTTTButton();
        jbtnTicTacToe8 = instantiateTTTButton();
        jbtnTicTacToe9 = instantiateTTTButton();

        // Create UI buttons
        jbtnReset = instantiateUIButton("Reset");
        jbtnExit = instantiateUIButton("Exit");

        // Add all panels to main panel
        jpnlMain.add(jpnlBottom, BorderLayout.SOUTH);
        jpnlMain.add(jpnlCenter, BorderLayout.CENTER);
        jpnlMain.add(jpnlTop, BorderLayout.NORTH);

        // Setup container
        Container ca = getContentPane();
        ca.add(jpnlMain);
        setContentPane(ca);

        // Make visible and code exit behavior
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Instantiate the Tic Tac Toe button
    private JButton instantiateTTTButton(){
        JButton jbtnButton = new JButton();
        jbtnButton.addActionListener(this);
        jpnlCenter.add(jbtnButton);
        return jbtnButton;
    }

    // Instantiate the UI button
    private JButton instantiateUIButton(String sInCaption){
        JButton jbtnButton = new JButton(sInCaption);
        jbtnButton.addActionListener(this);
        jpnlBottom.add(jbtnButton);
        return jbtnButton;
    }

    // Method to clear Tic Tac Toe buttons
    private void clearTTTButton(JButton jbtnClear){
        jbtnClear.setText("");
        jbtnClear.setForeground(Color.BLACK);
    }

    public void actionPerformed(java.awt.event.ActionEvent e){
        // Set current button to jbtnSource
        JButton jbtnSource = (JButton) e.getSource();

        // If button caption is "Exit" , exit the program
        if(jbtnSource.getText()=="Exit"){
            System.exit(0);
        }

        // If button caption is "Reset" than clear all the buttons
        else if(jbtnSource.getText()=="Reset"){
            clearTTTButton(jbtnTicTacToe1);
            clearTTTButton(jbtnTicTacToe2);
            clearTTTButton(jbtnTicTacToe3);
            clearTTTButton(jbtnTicTacToe4);
            clearTTTButton(jbtnTicTacToe5);
            clearTTTButton(jbtnTicTacToe6);
            clearTTTButton(jbtnTicTacToe7);
            clearTTTButton(jbtnTicTacToe8);
            clearTTTButton(jbtnTicTacToe9);
        }

        // If button caption is blank than set the caption to the current player, switch the player and check for win
        else if(jbtnSource.getText()==""){
            if(bIsPlayerX){
                jbtnSource.setText("X");
                jbtnSource.setForeground(Color.RED);
            }
            else{
                jbtnSource.setText("O");
                jbtnSource.setForeground(Color.GREEN);
            }
            bIsPlayerX = !bIsPlayerX;
            CheckWin();
        }
        // If the button caption is something else then most likely they are a dirty cheater, kick them from the game
        else{
            JOptionPane.showMessageDialog(null,"AntiCheat Violation", "Tic Tac Toe Swing",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void CheckWin(){
        // Declare a int for each possible combo
        int iRow1, iRow2, iRow3, iColumn1, iColumn2, iColumn3, iDiag1, iDiag2;

        // Add up the scores for each combo
        iRow1 = CheckValue(jbtnTicTacToe1) + CheckValue(jbtnTicTacToe2) + CheckValue(jbtnTicTacToe3);
        iRow2 = CheckValue(jbtnTicTacToe4) + CheckValue(jbtnTicTacToe5) + CheckValue(jbtnTicTacToe6);
        iRow3 = CheckValue(jbtnTicTacToe7) + CheckValue(jbtnTicTacToe8) + CheckValue(jbtnTicTacToe9);
        iColumn1 = CheckValue(jbtnTicTacToe1) + CheckValue(jbtnTicTacToe4) + CheckValue(jbtnTicTacToe7);
        iColumn2 = CheckValue(jbtnTicTacToe2) + CheckValue(jbtnTicTacToe5) + CheckValue(jbtnTicTacToe8);
        iColumn3 = CheckValue(jbtnTicTacToe3) + CheckValue(jbtnTicTacToe6) + CheckValue(jbtnTicTacToe9);
        iDiag1 = CheckValue(jbtnTicTacToe1) + CheckValue(jbtnTicTacToe5) + CheckValue(jbtnTicTacToe9);
        iDiag2 = CheckValue(jbtnTicTacToe3) + CheckValue(jbtnTicTacToe5) + CheckValue(jbtnTicTacToe7);

        // If any of the combos add up to positive 3 that means player o has won, display win message
        if(iRow1==3 || iRow2==3 || iRow3==3 || iColumn1==3 || iColumn2==3 || iColumn3==3 || iDiag1==3 || iDiag2==3){
            JOptionPane.showMessageDialog(null, "Player O: " + jtfPlayerO.getText() + ", has won", "Tic Tac Toe Swing",JOptionPane.INFORMATION_MESSAGE);
        }

        // If any of the combos add up to negative 3 that means player x has won, display win message
        if(iRow1==-3 || iRow2==-3 || iRow3==-3 || iColumn1==-3 || iColumn2==-3 || iColumn3==-3 || iDiag1==-3 || iDiag2==-3){
            JOptionPane.showMessageDialog(null, "Player X: " + jtfPlayerX.getText() + ", has won", "Tic Tac Toe Swing",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // If a button belongs to player x set its value to -1, if it belongs to o set it to 1 and if its blank set it to 0
    public int CheckValue(JButton jbtnValue){
        int iValue;
        if(jbtnValue.getText()=="X"){
            iValue = -1;
        }
        else if(jbtnValue.getText()=="O"){
            iValue = 1;
        }
        else{
            iValue = 0;
        }
        return iValue;
    }

    // Main
    public static void main(String[] args){
        // Create GUI
        TicTacToe cGUI = new TicTacToe("Tic Tac Toe Swing");
    }
}
