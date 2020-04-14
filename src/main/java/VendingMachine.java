public class VendingMachine {

    private int sum;
    private Dispenser dispenser;
    private WeightTo weightTo;
    private Inventory inventory;


    public VendingMachine(int sum, Dispenser dispenser, WeightTo weightTo, Inventory inventory) {
        this.sum = sum;
        this.dispenser = dispenser;
        this.weightTo = weightTo;
        this.inventory = inventory;
    }

    public String display() {
        if (sum == 0) {
            if (inventory.getPrice() > sum) return "PRICE";
            return "INSERT COIN";
        }
        return "$" + (double) sum / 100;
    }

    public void insertCoin(int weight) {
        if (!weightTo.isValid(weight)) dispenser.toCoinReturn(weight);
        else sum += weightTo.value(weight);
    }

    public void select(String product) {
        inventory.setProduct(product);
    }

    public void reset() {
        sum = 0;
        inventory.resetSelection();
    }
}