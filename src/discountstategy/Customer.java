
package discountstategy;

/**
 *
 * @author Alyson
 */
public class Customer implements CustomerInformationStrategy {
    
    
    
    private String customerID;
    private String customerName;

    public Customer(){
        
    }
    /**
     *
     * @param customerID
     * @param customerName
     */
    public Customer(String customerID, String customerName) {
        if(customerID == null || customerID.isEmpty() || customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        setCustomerID(customerID);
        setCustomerName(customerName);
    }

    @Override
    public final String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) {
        if(customerID == null || customerID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.customerID = customerID;
    }

    @Override
    public final String getCustomerName() {
        return customerName;
    }

    public final void setCustomerName(String customerName) {
        if(customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.customerName = customerName;
    }
   
}
