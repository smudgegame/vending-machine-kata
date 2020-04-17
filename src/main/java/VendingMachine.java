public class VendingMachine {

    private Calculate calculate;
    private Dispenser dispenser;
    private Inventory inventory;
    private CoinManager coinManager;

    public VendingMachine(Calculate calculate, CoinManager coinManager, Dispenser dispenser, Inventory inventory) {
        this.calculate = calculate;
        this.coinManager = coinManager;
        this.dispenser = dispenser;
        this.inventory = inventory;
    }

    public String display() {
        return calculate.display();
    }

    public void insertCoin(int weight) {
        if (!calculate.isValid(weight)) coinManager.toCoinReturn(weight);
        else calculate.addToSum(weight);
    }

    public void select(String product) {
        inventory.setProduct(product);
        for (int weight : calculate.change()) {
            coinManager.toCoinReturn(weight);
        }
        calculate.dispense();
    }

    public void reset() {
        dispenser.collect();
        coinManager.reset();
        calculate.reset();
    }
}