import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME_WEIGHT = 1;

    @Test
    public void isValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.isValid(DIME_WEIGHT));
    }

    @Test
    public void insertCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(10,vendingMachine.insertCoin(DIME_WEIGHT));
    }

}
