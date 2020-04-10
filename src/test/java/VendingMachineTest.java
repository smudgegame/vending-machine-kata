import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;

    @Test
    public void isValidCoin() {
        VendingMachine vendingMachine = new VendingMachine(0);
        assertTrue(vendingMachine.isValid(DIME));
    }

    @Test
    public void insertCoin() {
        VendingMachine vendingMachine = new VendingMachine(0);
        assertEquals(10, vendingMachine.insertCoin(DIME));
    }

    @Test
    public void insertCoinDisplay() {
        VendingMachine vendingMachine = new VendingMachine(0);
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void oneCoinValueDisplayed() {
        VendingMachine vendingMachine = new VendingMachine(0);
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.1",vendingMachine.display());
        //TODO this should read $0.10
    }

    @Test
    public void twoCoinValueDisplayed() {
        VendingMachine vendingMachine = new VendingMachine(0);
        vendingMachine.insertCoin(DIME);
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.2",vendingMachine.display());
        //TODO this should read $0.20
    }

}
