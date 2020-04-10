public class VendingMachine {

    public boolean isValid(int weight) {
        return weight == 1;
    }

    public int insertCoin(int coinWeight) {
        if (coinWeight==1) return 10;
        return 0;
    }
}