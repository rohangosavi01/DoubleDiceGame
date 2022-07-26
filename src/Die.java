import java.util.Random;

// Die Class – Class that simulates a six-sided die.
public class Die {

    // Declaring variables. 
    protected int dieValue;
    protected Random randInt; 

    // Constructor method.
    //Assigning default values.
    Die(){
        dieValue = 0; 
        randInt = new Random();      
    }

    // Simulating roll to generate a random value between 1 and 6.
    void roll(){
        dieValue = randInt.nextInt(6) + 1;
    }

    // returns Boolean true if both die have equal values, false otherwise.
    Boolean equals(Die dieValue2){
        if(dieValue == dieValue2.dieValue) return true;
        else return false;
    }

    // converting "int type" to "string type" using standard if-else statements. 
    public String toString(){
        if (dieValue == 1) return "one";
        else if (dieValue == 2) return "two";
        else if (dieValue == 3) return "three";
        else if (dieValue == 4) return "four";
        else if (dieValue == 5) return "five";
        else return "six";
    }  
}
