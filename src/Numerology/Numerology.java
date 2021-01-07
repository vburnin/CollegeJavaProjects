import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Numerology {
    // Declare Variables
    private int iAttidue;
    private int iBirthDay;
    private int iLifePath;
    private int iPersonality;
    private int iPowerName;
    private int iSoul;
    private long lLetterNumber;

    private String sValidName;
    private String sValidBirthdate;

    // Constructor
    public Numerology(String sName, String sBirthdate){
        // Validate date
        if(!sBirthdate.matches("[0-9/]+")){
            InvalidInput("Only put numbers and slashes in date");
        }

        if(sBirthdate.substring(sBirthdate.indexOf("/", sBirthdate.indexOf("/")+1)+1).length()!=4){
            InvalidInput("Please enter year in yyyy format");
        }


        DateFormat dfDateFormat = new SimpleDateFormat("mm/dd/yyyy");
        dfDateFormat.setLenient(false);

        try{
            dfDateFormat.parse(sBirthdate);

        }
        catch(Exception e){
            InvalidInput("Please enter a valid Gregorian date in mm/dd/yyyy format");
        }

        // Validate name
        if(sName.length() - sName.replaceAll(" ","").length()!=1){
            InvalidInput("Please enter name in FirstName LastName format");
        }

        if(!sName.matches("[a-z A-Z]+")){
            InvalidInput("Please only enter letters in Name, if your name has irregular letters please use the closest equivalent (for example use 'o' instead of 'ö')");
        }

        sValidName=sName;
        sValidBirthdate=sBirthdate;
    }

    // Method for showing error
    private void InvalidInput(String sError){
        JOptionPane.showMessageDialog(null, sError, "Numerology",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    // Method for reducing numbers
    private int Reduce(long lReduction){
        // Declare Variables
        int iReducation;
        long lSum = 0;

        // Loop until the result is 1 digit
        while(String.valueOf(lReduction).length()>1){
            //
            while(lReduction>0){
                // Add modulus of variable divided by 10 to sum
                lSum += lReduction%10;
                // Divide by 10
                lReduction /= 10;
            }
            // Set variable to sum
            lReduction=lSum;
            // Reset sum
            lSum=0;
        }

        // Convert variable to int and return it
        iReducation = (int) lReduction;
        return iReducation;
    }

    // Method to convert numbers to letters
    private long toNumber(String sLetters){
        // Declare variables
        int iIndex=0;
        String sLetterNumber="";

        // Convert letters to lowercase
        sLetters=sLetters.toLowerCase();

        // For each letter find matching number and add it to sLetters
        while(iIndex<sLetters.length()){
            if(sLetters.substring(iIndex,iIndex+1).matches("[ajs]+")){
                sLetterNumber = sLetterNumber.concat("1");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[bkt]+")){
                sLetterNumber = sLetterNumber.concat("2");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[clu]+")){
                sLetterNumber = sLetterNumber.concat("3");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[dmv]+")){
                sLetterNumber = sLetterNumber.concat("4");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[enw]+")){
                sLetterNumber = sLetterNumber.concat("5");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[fox]+")){
                sLetterNumber = sLetterNumber.concat("6");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[gpy]+")){
                sLetterNumber = sLetterNumber.concat("7");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[hqz]+")){
                sLetterNumber = sLetterNumber.concat("8");
            }
            else if(sLetters.substring(iIndex,iIndex+1).matches("[ir]+")){
                sLetterNumber = sLetterNumber.concat("9");
            }
            else{
                sLetterNumber = sLetterNumber.concat("0");
            }
            iIndex++;
        }

        // Convert sLetterNumber to long and return it
        lLetterNumber = Long.parseLong(sLetterNumber);
        return lLetterNumber;
    }

    // Method to find Attitude
    public int getAttitude(){
        iAttidue = Reduce(Long.parseLong(sValidBirthdate.substring(0,2)+sValidBirthdate.substring(3,5)));
        return iAttidue;
    }

    // Method to find Birth Day
    public int getBirthDay(){
        iBirthDay = Reduce(Long.parseLong(sValidBirthdate.substring(3,5)));
        return iBirthDay;
    }

    // Method to find Life Patch
    public int getLifePath(){
        iLifePath = Reduce(Long.parseLong(sValidBirthdate.replaceAll("/","")));
        return iLifePath;
    }

    // Method to find personality
    public int getPersonality(){
       iPersonality = Reduce(toNumber(sValidName.replaceAll("[aeiouAEIOU]+","")));
       return iPersonality;
    }

    // Method to find Soul
    public int getSoul(){
        // Declare variables
        int iSoulIndex=0;
        String sVowels="";

        // For each letter add it to sVowels if its a vowel
        while(iSoulIndex<sValidName.length()){
            if(sValidName.substring(iSoulIndex,iSoulIndex+1).matches("[aeiouAEIOU]+")){
                sVowels = sVowels.concat(sValidName.substring(iSoulIndex,iSoulIndex+1));
            }
            iSoulIndex++;
        }

        // Convert to Numbers, Reduce and return
        iSoul = Reduce(toNumber(sVowels));
        return iSoul;
    }

    // Method to find power nane
    public int getPowerName(){
        iPowerName = Reduce(getSoul()+getPersonality());
        return iPowerName;
    }

    public String getName(){
        return sValidName;
    }

    public String getBirthdate(){
        return sValidBirthdate;
    }
}