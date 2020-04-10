public class VendingMachine {

    public static boolean isValid(String coin) {
        if (coin.equalsIgnoreCase("nickle")) return true;
        if (coin.equalsIgnoreCase("dime")) return true;
        return coin.equalsIgnoreCase("quarter");
    }

    public int insertCoin(String coin) {
        if (isValid(coin)) {
            if (coin.equalsIgnoreCase("dime"))
                return 10;
            if (coin.equalsIgnoreCase("nickle"))
                return 5;
            if (coin.equalsIgnoreCase("quarter"))
                return 25;
        }
        return 0;
    }

    public String display() {
        return "INSERT COIN";
    }
}
