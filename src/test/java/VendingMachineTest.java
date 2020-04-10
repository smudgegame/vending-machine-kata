import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test
    public void dimeIsValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(true, VendingMachine.isValid("Dime"));
    }
}
