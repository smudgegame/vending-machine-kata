import java.util.Map;

public class VendingMachine {

    private Map<Integer, Integer> coinHash;
    private int sum;

    public VendingMachine(int sum, Map<Integer, Integer> coinHash) {
        this.sum = sum;
        this.coinHash = coinHash;
    }

    public String addCoin(int weight) {
        Display display = new Display();
        if(weight==2)
            return display.showDisplay(sum);
        int value = coinHash.getOrDefault(weight, 0);
        sum += value;
        return display.showDisplay(sum);
    }

    public void reset() {
        sum = 0;
    }

}
