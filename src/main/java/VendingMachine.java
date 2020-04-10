import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private static final int DIME = 1;
    private int sum = 0;

    public VendingMachine(int sum) {
        this.sum = sum;
    }

    public boolean isValid(int weight) {
        return weight == DIME;
    }

    public int insertCoin(int coinWeight) {
        if (coinWeight == DIME) {
            sum += 10;
            return 10;
        }
        return 0;
    }

    public String display() {
        if (sum == 0)
            return "INSERT COIN";
        else return "$" + (double) sum / 100;
    }
}