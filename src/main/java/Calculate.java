import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculate {

    private int sum;

    private static final int DIME_VALUE = 10;
    private static final int NICKEL_VALUE = 5;
    private static final int QUARTER_VALUE = 25;
    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;
    private Map<Integer, Integer> valueMap;

    private Inventory inventory;
    private Dispenser dispenser;

    public Calculate(int sum, Map<Integer, Integer> valueMap, Inventory inventory, Dispenser dispenser) {
        this.sum = sum;
        this.valueMap = valueMap;
        valueMap.put(QUARTER_WEIGHT, QUARTER_VALUE);
        valueMap.put(DIME_WEIGHT, DIME_VALUE);
        valueMap.put(NICKEL_WEIGHT, NICKEL_VALUE);
        this.inventory = inventory;
        this.dispenser = dispenser;
    }

    void setSum(int sum) {
        this.sum = sum;
    }

    void addToSum(int weight) {
        sum += value(weight);
    }

    public boolean isValid(int weight) {
        return valueMap.containsKey(weight);
    }

    public int value(int weight) {
        if (!isValid(weight)) throw new IllegalArgumentException();
        return valueMap.get(weight);
    }

    String display() {
        String display;
        if (inventory.getProduct().equals("")) {
            if (sum == 0) display = "INSERT COIN";
            else display = "$" + (double) sum / 100;
        } else {
            if (inventory.inStock()) {
                if (sum >= inventory.getPrice()) {
                    display = "THANK YOU";
                    inventory.resetSelection();
                    sum = 0;
                } else {
                    display = "PRICE";
                    inventory.resetSelection();
                }
            } else {
                display = "SOLD OUT";
                inventory.resetSelection();
            }
        }
        return display;
    }


    void dispense() {
        if (sum >= inventory.getPrice()) {
            dispenser.dispense(inventory.getProduct());
        }
    }

    public int credit(int price) {
        return sum - price;
    }

    public List<Integer> change() {
        List<Integer> change = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        weights.add(4);
        weights.add(1);
        weights.add(3);
        int credit = credit(inventory.getPrice());
        for (int weight : weights)
            while (credit >= value(weight)) {
                credit = credit - value(weight);
                change.add(weight);
            }
        return change;
    }
}
