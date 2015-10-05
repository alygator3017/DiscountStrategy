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
       CashRegister cr = new CashRegister();
       
       cr.startSale("115", new FakeDatabase(), new ConsoleOutput());
       cr.addNewItem("2001", 1);
       cr.addNewItem("2002", 2);
       cr.addNewItem("2003", 1);
       cr.addNewItem("2004", 1);
       cr.endSale();
    }
    
}
