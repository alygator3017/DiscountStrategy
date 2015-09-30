/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstategy;

/**
 *
 * @author Alyson
 */
public class ArrayPractice {
    public static void main(String[] args) {
        //array with specific sizze
//        String[] names = new String[4];
        
        //array trick for arrays with variating sizes
        
        //create an array with 0 objects (empty array)
        String[] names = new String[0];
        
        //create a new temporary array thats sized 1 larger than the original 
        String[] temp = new String[names.length + 1];
        
        //copy everything from the original array into the new array
        for(int i = 0; i < names.length; i++){
            //looping over the original and assinging to new array
            temp[i] = names[i];
        }
        
        //add string to new array
        temp[temp.length - 1] = "Hello";
        
        //destroyed original array and substitute it with the new array
        names = temp;
        
        //null out new one so it erases it from memory
        temp = null;
        
        
    }
}
