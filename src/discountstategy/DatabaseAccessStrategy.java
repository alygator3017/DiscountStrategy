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
public interface DatabaseAccessStrategy {

    //find customer using customer array
    public abstract CustomerInformationStrategy findCustomer(String customerID);

    //find product using product array
    public abstract Item findItem(String itemID);
    
}
