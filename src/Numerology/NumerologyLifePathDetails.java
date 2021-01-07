public class NumerologyLifePathDetails extends Numerology {

    // Declare Variables
    private String sDescription;

    // Constructor
    public NumerologyLifePathDetails(String sName, String sBirthdate) {
        // super reference
        super(sName, sBirthdate);
    }

    // Method to find Life Path Description using if statement
    public String getLifePathDescription(){
        if(getLifePath()==1){
            sDescription="The Independent: Wants to work/think for themselves";
        }
        else if(getLifePath()==2){
            sDescription="The Mediator: Avoids conflict and wants love and harmony";
        }
        else if(getLifePath()==3){
            sDescription="The Performer: Likes music, art and to perform or get attention";
        }
        else if(getLifePath()==4){
            sDescription="The Teacher/Truth Seeker: Is meant to be a teacher or mentor and is truthful";
        }
        else if(getLifePath()==5){
            sDescription="The Adventurer: Likes to travel and meet others, often a extrovert";
        }
        else if(getLifePath()==6){
            sDescription="The Inner Child: Is meant to be a parent and/or one that is young at heart";
        }
        else if(getLifePath()==7){
            sDescription="The Naturalist: Enjoy nature and water and alternative life paths, open to spirituality";
        }
        else if(getLifePath()==8){
            sDescription="The Executive: Gravitates to money and power";
        }
        else if(getLifePath()==9){
            sDescription="The Humanitarian: Helps others and/or experiences pain and learns the hard way";
        }
        else{
            sDescription="Error: description not found";
        }

        // Return the description
        return sDescription;
    }
}
