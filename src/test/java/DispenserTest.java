import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DispenserTest {
    @Test
    public void toDispenser() {
        Map<String,Integer> inDispenser = new HashMap<>();
        inDispenser.put("soda", 1);
        Dispenser dispenser = new Dispenser(inDispenser);
        assertEquals(1,dispenser.amountOf("soda"));
    }
}
