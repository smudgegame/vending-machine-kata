public class VendingMachine {

    private static final int DIME_WEIGHT = 1;
    private static final int PENNY_WEIGHT = 2;
    private static final int NICKLE_WEIGHT = 3;
    private int sum;

    public VendingMachine(int sum) {
        this.sum = sum;
    }

    public int getCoin(int weight) {
        int value = 0;
        if (weight == DIME_WEIGHT)
            value = 10;
        if (weight == PENNY_WEIGHT)
            value = 1;
        if (weight == NICKLE_WEIGHT)
            value = 5;
        sum += value;
        return value;
    }

    public String display(int sum) {
        String display;
        if (sum == 0) display = "INSERT COIN";
        else display = "$0." + this.sum;
        return display;
    }

}
