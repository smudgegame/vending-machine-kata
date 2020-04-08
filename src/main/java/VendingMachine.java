public class VendingMachine {

    private static final int DIME_WEIGHT = 1;
    private int sum;

    public VendingMachine(int sum) {
        this.sum = sum;
    }

    public int getCoin(int weight) {
        int value = 0;
        if (weight == DIME_WEIGHT)
            value = 10;
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
