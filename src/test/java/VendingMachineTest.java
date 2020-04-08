import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test
    public void coinWeight() {
        VendingMachine vendingMachine = new VendingMachine();

        assertEquals(1, vendingMachine.getCoin(1));
    }

}
