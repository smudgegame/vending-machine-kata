import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DispenserTest {
    @Test
    public void toProductDispenser() {
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        inDispenser.put("soda", 1);
        Dispenser dispenser = new Dispenser(inDispenser, coinCount);
        assertEquals(1, dispenser.amountOf("soda"));
    }

    @Test
    public void inCoinReturn() {
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(inDispenser, coinCount);
        assertEquals(0, dispenser.inCoinReturn(1));
    }

    @Test
    public void toCoinReturn() {
        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(inDispenser, coinCount);
        dispenser.toCoinReturn(1);
        assertEquals(1, dispenser.inCoinReturn(1));
    }
}
