import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DispenserTest {
    @Test
    public void productInDispenser() {
        String product = "";
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(product, coinCount);
        assertEquals("", dispenser.inDispenser());
    }

    @Test
    public void dispense() {
        String product = "";
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(product, coinCount);
        dispenser.dispense("cola");
        assertEquals("cola", dispenser.inDispenser());
    }

    @Test
    public void inCoinReturn() {
        String product = "";
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(product, coinCount);
        assertEquals(0, dispenser.inCoinReturn(1));
    }

    @Test
    public void toCoinReturn() {
        String product = "";
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(product, coinCount);
        dispenser.toCoinReturn(1);
        assertEquals(1, dispenser.inCoinReturn(1));
    }
}
