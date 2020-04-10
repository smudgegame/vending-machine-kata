import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    @Test
    public void dimeIsValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(VendingMachine.isValid("Dime"));
    }

    @Test
    public void nickleIsValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(VendingMachine.isValid("Nickle"));
    }

    @Test
    public void quarterIsValidCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(VendingMachine.isValid("Quarter"));
    }

    @Test
    public void addDimeValue() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(10, vendingMachine.insertCoin("Dime"));
    }

    @Test
    public void addNickleValue() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(5, vendingMachine.insertCoin("Nickle"));
    }

    @Test
    public void addQuarterValue() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(25, vendingMachine.insertCoin("Quarter"));
    }

}
