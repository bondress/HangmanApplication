/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author pc
 */
public class MenuInputException extends RuntimeException {
    
    MenuInputException(){
        System.out.println("Please provide a valid input (1-3)");
    }
}
