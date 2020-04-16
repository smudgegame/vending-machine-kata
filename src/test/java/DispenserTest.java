import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DispenserTest {

    @Test
    public void productInDispenser() {
        String product = "";
        Dispenser dispenser = new Dispenser(product);
        assertEquals("", dispenser.inDispenser());
    }

    @Test
    public void dispense() {
        String product = "";
        Dispenser dispenser = new Dispenser(product);
        dispenser.dispense("cola");
        assertEquals("cola", dispenser.inDispenser());
    }

}
