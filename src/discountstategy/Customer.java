
package discountstategy;

/**
 *
 * @author Alyson
 */
public class Customer {
    /**
     * what does a customer need
     * customerId
     * name
     * could add: 
     * address
     * email
     * phone
     * member rewards
     */
    
    //properties
    private String customerID;
    private String customerName;

    /**
     *
     * @param customerID
     * @param customerName
     */
    public Customer(String customerID, String customerName) {
        setCustomerID(customerID);
        setCustomerName(customerName);
    }

    public String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public final void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
   
}
