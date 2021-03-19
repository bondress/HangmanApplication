/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author pc
 */
public class Hangman {

    String word[]={"japan", "qatar", "syria", "mongolia", "bahrain", "india",
    "somalia", "nigeria", "scandinavia", "nicaragua", "congo", "kenya", 
    "uruguay", "niger", "france", "germany", "switzerland", "spain", "brazil"};
    /**
     * @param args the command line arguments
     */
       public void playGame(){
           int len, i, count = 0, rnd, flag = 0;
           String choice, temp;
           
           Random rd = new Random();
           Scanner input = new Scanner(System.in);
           rnd = rd.nextInt(19); /*generates a random number between 0 and 18
           and assigns the same to the variable rnd
           It was initially 6 but I changed it to 19
           After increasing the number of words in the array
           */
           len = word[rnd].length();
           char[] newString = new char[len];
           
           StringBuffer wrgString = new StringBuffer();
           
           //prints blanks or dashes equivalent to the lenght of the word
           for(int j = 0; j < len; j++){
               System.out.print("_ ");
           }
           
           System.out.println();
           
                do{
                    flag = 0;
                    
                    System.out.print("\n\nEnter your guess: ");
                    
                    //Implement user defined exception
                    try{
                        String ch = input.nextLine().toLowerCase();
                        if(ch.length()!=1){
                        throw new WrongInputException();
                        }              
                    
                    count++;
                    
                    for(i = 0; i < len; i++){
                        if(word[rnd].charAt(i) == ch.charAt(0)){
                            newString[i] = word[rnd].charAt(i);
                            flag = 1;
                        }
                    }
                    
                    if(flag == 0){
                        flag = 1;
                        wrgString.append(ch + ",");
                        System.out.println("\nMisses: " + wrgString);
                    }
                    
                    System.out.println(newString);
                    temp = new String(newString);
                    
                    if(word[rnd].equals(temp)){
                        System.out.println("---------- Congrats :) You won "
                                + "---------");
                        System.out.println("Do you want to play again? (Y/N)");
                        choice = input.nextLine();
                        
                        if(choice.equalsIgnoreCase("y")){
                            playGame();
                        }
                        else{
                            showMenu();
                        }
                    }
                }
                catch(WrongInputException e){
                        //System.out.println(e);
                        flag = 1;
                        }
                }
                
                while(flag!=0);
       }
       
       public void instructGame(){
           System.out.println("Instruct Game method is invoked");
       }
       
       public void exitGame(){
           System.out.println("Exit Game method is invoked. Exiting...");
           System.exit(0);
       }
       //Method to display Game Menu
       public void showMenu(){
        
        //Declaring option to accept user input
        int option;
        
        //Creating scanner object to accept user input
        Scanner input = new Scanner(System.in);
        
        //Print out Menu options
        /*
        System.out.println will print the statement and moves
        the cursor to a new line while the System.out.print will
        print the statement and keep the cursor on the same line.
        */
        System.out.println("----------Menu----------");
        System.out.println("1. Play");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.print("\nPleaase choose an option: ");
        
        //try-catch block
        option = 0;
        
        //Accept user input
        try{
            option = input.nextInt();
        }
        catch(RuntimeException e){
            System.out.println("Please provide a valid numeric input!");
            showMenu();
        }
        
        //switch case (to call required methods based on user option
        switch(option){
            case 1: playGame();
                    break;
            case 2: instructGame();
                    break;
            case 3: exitGame();
                    break;
            default: 
                try{
                    throw new MenuInputException();
                }
                catch(Exception e){
                    showMenu();
                }
                break;
        }
    }
       
    public static void main(String[] args) {
        //Creating an object of the Hangman Class
        Hangman hg = new Hangman();
        
        //Calling showMethod()
        hg.showMenu();
    }
}