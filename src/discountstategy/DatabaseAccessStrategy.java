
package discountstategy;

/**
 *
 * @author Alyson
 */
public interface DatabaseAccessStrategy {

    
    public abstract CustomerInformationStrategy findCustomer(String customerID);

    
    public abstract Item findItem(String itemID);
    
}
