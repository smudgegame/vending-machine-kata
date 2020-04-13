import java.util.Map;

public class Dispenser {

    private final Map<String, Integer> inDispenser;

    public Dispenser(Map<String, Integer> inDispenser) {
        this.inDispenser = inDispenser;
    }

    public int amountOf(String product) {
        return inDispenser.getOrDefault(product,0);
    }
}
