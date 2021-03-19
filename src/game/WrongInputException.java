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
public class WrongInputException extends RuntimeException{
    
    WrongInputException(){
        System.out.println("Please provide a single character only..!!");
    }
}
