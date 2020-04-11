import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    @Test
    public void insertCoin() {
        Coin coin = new Coin(1);
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.isValid(coin));
    }

}
