package discountstategy;

/**
 *
 * @author Alyson
 */
public class Start {

    /**
     * @param args the command line arguments
     */
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
