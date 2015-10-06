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
public class ConsoleOutput implements OutputStrategy {

    public ConsoleOutput() {
    }
    
    @Override
    public final void outputData(String output){
        if(output == null || output.isEmpty()) {
            throw new IllegalArgumentException();
        }
        System.out.println(output);
    }
}
