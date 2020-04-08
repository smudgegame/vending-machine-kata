public class VendingMachine {

    private static final int DIME_WEIGHT = 1;

    public int getCoin(int weight) {
        int value = 0;
        if (weight == DIME_WEIGHT)
            value = 10;
        return value;
    }

    public String display(int sum) {
        String display = "INSERT COIN";
        return display;
    }

}
