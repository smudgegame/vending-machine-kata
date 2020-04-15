public class VendingMachine {

    private Calculate calculate;
    private Dispenser dispenser;
    private Inventory inventory;

    public VendingMachine(Calculate calculate, Dispenser dispenser, Inventory inventory) {
        this.calculate = calculate;
        this.dispenser = dispenser;
        this.inventory = inventory;
    }

    public String display() {
        return calculate.display();
    }

    public void insertCoin(int weight) {
        if (!calculate.isValid(weight)) dispenser.toCoinReturn(weight);
        else calculate.addToSum(weight);
    }

    public void select(String product) {
        inventory.setProduct(product);
    }

    public void reset() {
        calculate.resetSum();
        inventory.resetSelection();
    }
}