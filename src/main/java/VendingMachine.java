import java.util.Map;

public class VendingMachine {

    private static final int DIME_VALUE = 10;
    private static final int PENNY_VALUE = 1;
    private static final int NICKLE_VALUE = 5;
    private static final int QUARTER_VALUE = 25;
    private int sum;

    public VendingMachine(int sum) {
        this.sum = sum;
    }

    public String insertCoin(int weight) {
        if (isCoinValid(weight)) {
            sum += weightToValue(weight);
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
        return weight == 1 || weight == 3 || weight == 4;
    }

    private int weightToValue(int weight) {
        if (weight == 1) return DIME_VALUE;
        if (weight == 2) return PENNY_VALUE;
        if (weight == 3) return NICKLE_VALUE;
        if (weight == 4) return QUARTER_VALUE;
        return 0;
    }

    public void reset() {
        sum = 0;
    }

}
