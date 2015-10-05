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
public class Tester {
    
    public static void main(String[] args) {
       ReceiptInformation receipt = new ReceiptInformation("110", new FakeDatabase(), new ConsoleOutput());
       
       receipt.addNewLineItem("2001", 1);
       receipt.addNewLineItem("2002", 3);
       receipt.addNewLineItem("2004", 1);
       
       receipt.outputReceipt();
    }
    
}
