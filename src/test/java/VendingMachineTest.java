import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp() {
        vendingMachine = new VendingMachine(0);
    }

    @Test
    public void coinWeight() {
        assertEquals(0, vendingMachine.getCoin(0));
    }

    @Test
    public void coinValue() {
        assertEquals(10, vendingMachine.getCoin(1));
    }

    @Test
    public void noCoinDisplay() {
        assertEquals("INSERT COIN", vendingMachine.display(0));
    }

    @Test
    public void displayCoinValue() {
        VendingMachine vendingMachine = new VendingMachine(0);
        int sum = vendingMachine.getCoin(1);
        assertEquals("$0.10", vendingMachine.display(sum));
    }

    @Test
    public void pennyValue() {
        assertEquals(1, vendingMachine.getCoin(2));
    }

    @Test
    public void nickleValue() {
        assertEquals(5, vendingMachine.getCoin(3));
    }

}
