import java.util.Scanner;

// Class that contains game looping and logic.
public class DoubleDice {

    // Method to decorate the display, you can comment-out different statements below for styling options.
    public static void printLine(){
        System.out.printf("\n--------------------------------------------------\n");
        //System.out.printf("\n**************************************************\n");
        //System.out.printf("\n----    ----    ----    ----    ----    ----    ----\n");
        //System.out.printf("\n---- ***** ---- ***** ---- ***** ----\n");
    }

    // Method to print initial game rules.
    public static void printMenu(){
        printLine();
        System.out.printf("Welcome to the Double Dice Game!\n\n");
        System.out.printf("Rules to keep in mind:\n");
        System.out.printf("1. You may bet upto the funds available to you.\n");
        System.out.printf("2. You may quit at any time by entering 'exit'.\n");
        System.out.printf("3. Game will get over if you run out of funds.\n\n");
        System.out.printf("Your available funds: $100.00");
        printLine();
    }
    
    // Program entry.
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // Declaring key variables used in the game - player funds (playerFunds) and betting amount (betAmount).
        // Using Double instead of Float to better format, calculate and display dollars and cents (as compared to float), for this game's general requirnments of using 2 decimal places.
        double playerFunds = 100; 
        double betAmount;

        // Printing intial game rules by calling printMenu() method.
        printMenu();
        
        // Initializing a while loop to keep the game running until a break; statement occurs.
        while(true){

            // printLine() method added for decoration after each if-else statement.
            // If player has no funds to bet, then the loop breaks at the break; statement.
            if (Math.abs(playerFunds-0) < 0.0001){ 
                System.out.printf("\nSorry, you have run out of money!\nBetter Luck next time.");
                printLine(); 
                break; 
            }
            
            // Using the scanner class to read user input and storing into the String input.
            System.out.printf("\nEnter an amount to bet (enter 'exit' to exit): $ ");
            String input = scnr.nextLine();
            
            // Checking if the input entered by the user is valid. Implementing the try-catch method to check if user input can be converted into a float point, if not, prompting the user to enter a valid float number.
            try{
                // Even if player inputs a value more than 2 decimal places, it will be automatically rounded to nearest 2 decimal places.
                betAmount = Math.round(Double.parseDouble(input)*100)/100.0;
            } 
            
            // if there is a NumberFormatException, then input could not be converted to a double type.
            catch (NumberFormatException e) {

                // Since our game quits when user inputs 'exit' irrespective of string case, we check if input matches the 'exit' and break the loop to stop the game.
                if (input.equalsIgnoreCase("exit")){
                    System.out.printf("Thank you for playing. You take home: $%.2f",playerFunds);
                    printLine();
                    break;
                }
                // Throws a warning that illegal characters have been entered.
                else{
                    System.out.printf("\nWARNING: illegal characters entered. Try again!");
                    printLine();
                    continue;
                }
            }
            
            // If betting amount is 0, generating a warning and restarting the loop.
            if (Math.abs(betAmount-0) < 0.0001) {
                System.out.printf("\nWARNING: cannot input 0, if you want to exit type 'exit'");
                printLine();
                continue;
            }

            // If betting amount is greater than funds available to the player, generating a warning and restarting the loop using the continue; statement.
            else if (betAmount > playerFunds){
                System.out.printf("WARNING: cannot bet more money than available funds. Try again!");
                printLine();
                continue;
            } 

            // If user inputs a negative number, displaying a warning to the player and restarting the loop using the continue; statement.
            else if (betAmount < 0.00){
                System.out.printf("WARNING: cannot input negative numbers. Try again!");
                printLine();
                continue;                
            }
            
            // If all above conditions are passed, simulating two dice roll using Die class.
            Die dieVal1 = new Die(); 
            dieVal1.roll();

            Die dieVal2 = new Die();  
            dieVal2.roll();

            // Printing results of rolled dice. 
            System.out.println("You rolled a "+dieVal1.toString()+" and "+dieVal2.toString());   
            
            // Using the equals method to check if both die have same face value
            if (dieVal1.equals(dieVal2)) {
                // If both die face value are same, updating player funds.
                playerFunds += betAmount;
                // Rounding to 2 decimal places after calculations ensures accuracy of dollars and cents everytime.
                playerFunds = Math.round(playerFunds*100)/100.0;
                System.out.printf("Congratulations! you won $%.2f",betAmount);
                System.out.printf("\nTotal available funds: $%.2f",playerFunds);
                printLine();
            }

            else {
                // If both die face value are not same, updating player funds.                
                playerFunds -= betAmount;
                // Rounding to 2 decimal places after calculations ensures accuracy of dollarsand cents everytime.
                playerFunds = Math.round(playerFunds*100)/100.0;
                System.out.printf("Sorry! you lose: $%.2f",betAmount);
                System.out.printf("\nTotal available funds: $%.2f",playerFunds);
                printLine();
            }
            
        }
    }
    
}
