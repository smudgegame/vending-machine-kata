public class VendingMachine {

    public static boolean isValid(String coin) {
        if (coin.equalsIgnoreCase("nickle")) return true;
        if (coin.equalsIgnoreCase("dime")) return true;
        return coin.equalsIgnoreCase("quarter");
    }

}
