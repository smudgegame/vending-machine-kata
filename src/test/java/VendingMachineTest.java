import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void coinWeight() {
        assertEquals(0, vendingMachine.getCoin(0));
    }

    @Test
    public void coinValue() {
        assertEquals(10, vendingMachine.getCoin(1));
    }

}
