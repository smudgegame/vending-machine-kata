import java.util.Map;

public class VendingMachine {

    private Map<Integer, Integer> coinHash;
    private int sum;

    public VendingMachine(int sum, Map<Integer, Integer> coinHash) {
        this.sum = sum;
        this.coinHash = coinHash;
    }

    public String addCoin(int weight) {
        if (isCoinValid(weight)) {
            sum += coinHash.getOrDefault(weight, 0);
        }
        return showDisplay(sum);
    }

    private String showDisplay(int sum) {
        String display;
        if (sum == 0) display = "INSERT COIN";
        else display = "$" + (double) sum / 100;
        return display;
    }

    private boolean isCoinValid(int weight) {
        if (weight == 1 || weight == 3 || weight == 4) {
            return true;
        } else return false;
    }

    public void reset() {
        sum = 0;
    }

}
