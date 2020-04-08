public class Display {

    public String showDisplay(int sum) {
        String display = "";
        int ones = sum % 10;
        int tens = (sum % 100 - ones) / 10;
        int dollars = (sum % 1000 - tens - ones) / 100;

        if (sum == 0) display = "INSERT COIN";
        else display = "$" + dollars + "." + tens + ones;
        return display;
    }

}
