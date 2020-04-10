import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    @Test
    public void isValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.isValid(1));
    }

}
