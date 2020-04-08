import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisplayTest {

    @Test
    public void properDollarDisplay() {
        Display display = new Display();
        assertEquals("$1.23", display.showDisplay(123));
    }
}
