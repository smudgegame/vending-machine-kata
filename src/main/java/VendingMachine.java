public class VendingMachine {

    private int sum;
    private CoinReturn coinReturn;
    private WeightTo weightTo;
    private Inventory inventory;


    public VendingMachine(int sum, CoinReturn coinReturn, WeightTo weightTo, Inventory inventory) {
        this.sum = sum;
        this.coinReturn = coinReturn;
        this.weightTo = weightTo;
        this.inventory = inventory;
    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(int weight) {
        if (!weightTo.isValid(weight)) coinReturn.toReturn(weight);
        else sum += weightTo.value(weight);
    }

    public void select(String product) {
        inventory.setProduct(product);
    }

    public void reset() {
        sum = 0;
    }
}