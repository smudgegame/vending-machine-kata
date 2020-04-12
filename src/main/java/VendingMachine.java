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

    public void insertCoin(Coin coin) {
        if (!weightTo.isValid(coin)) coinReturn.toReturn(coin);
        else sum += weightTo.value(coin);
    }

    public void reset() {
        sum = 0;
    }
}