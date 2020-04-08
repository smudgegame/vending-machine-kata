import java.util.Map;

public class VendingMachine {

    private Map<Integer, Integer> coinHash;
    private int sum;

    public VendingMachine(int sum, Map<Integer, Integer> coinHash) {
        this.sum = sum;
        this.coinHash = coinHash;
    }

    public int getCoin(int weight) {
        int value = coinHash.getOrDefault(weight, 0);
        sum += value;
        return value;
    }

    public String display(int sum) {
        String display;
        if (sum == 0) display = "INSERT COIN";
        else display = "$0." + this.sum;
        return display;
    }

    public void reset() {
        sum = 0;
    }

}
