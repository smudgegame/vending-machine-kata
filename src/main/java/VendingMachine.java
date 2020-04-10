public class VendingMachine {

    public static boolean isValid(String coin) {
        if (coin.equalsIgnoreCase("nickle")) return true;
        if (coin.equalsIgnoreCase("dime")) return true;
        return coin.equalsIgnoreCase("quarter");
    }

    public int insertCoin(String coin) {
        if (isValid(coin)) return 10;
        return 0;
    }
}
