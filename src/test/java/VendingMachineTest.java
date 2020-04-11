import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;

    @Test
    public void validCoin() {
        Coin coin = new Coin(DIME);
        VendingMachine vendingMachine = new VendingMachine(0);
        assertTrue(vendingMachine.isValid(coin));
    }

    @Test
    public void coinValue() {
        Coin coin = new Coin(DIME);
        VendingMachine vendingMachine = new VendingMachine(0);
        assertEquals(10, vendingMachine.getValue(coin));
    }

    @Test(expected = IllegalArgumentException.class)
    public void coinValueIfValid() {
        Coin coin = new Coin(PENNY);
        VendingMachine vendingMachine = new VendingMachine(0);
        vendingMachine.getValue(coin);
    }

    @Test
    public void insertCoinDisplay() {
        VendingMachine vendingMachine = new VendingMachine(0);
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void insertCoin() {
        Coin coin = new Coin(DIME);
        VendingMachine vendingMachine = new VendingMachine(0);
        vendingMachine.insertCoin(coin);
        assertEquals("$0.1", vendingMachine.display());
    }

}
