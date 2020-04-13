public class VendingMachine {

    private int sum;
    private CoinReturn coinReturn;
    private WeightTo weightTo;

    public VendingMachine(int sum, CoinReturn coinReturn, WeightTo weightTo) {
        this.sum = sum;
        this.coinReturn = coinReturn;
        this.weightTo = weightTo;
    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(int weight) {
        if (!weightTo.isValid(weight)) coinReturn.toReturn(weight);
        else sum += weightTo.value(weight);
    }

    public void reset() {
        sum = 0;
    }
}