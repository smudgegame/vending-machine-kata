public class VendingMachine {

    private int sum;
    private String display;
    private Dispenser dispenser;
    private WeightTo weightTo;
    private Inventory inventory;


    public VendingMachine(int sum, String display, Dispenser dispenser, WeightTo weightTo, Inventory inventory) {
        this.sum = sum;
        this.display = display;
        this.dispenser = dispenser;
        this.weightTo = weightTo;
        this.inventory = inventory;
    }

    public String display() {
        if (inventory.getProduct().equals("")) {
            if (sum == 0) display = "INSERT COIN";
            else display = "$" + (double) sum / 100;
        } else {
            if (sum >= inventory.getPrice()) {
                display = "THANK YOU";
                reset();
            } else {
                display = "PRICE";
                inventory.resetSelection();
            }
        }
        return display;
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