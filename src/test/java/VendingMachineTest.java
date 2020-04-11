import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    @Test
    public void validCoin() {
        Coin coin = new Coin(1);
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.isValid(coin));
    }

    @Test
    public void coinValue() {
        Coin coin = new Coin(1);
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(10, vendingMachine.getValue(coin));
    }

}
