public class Display {

    public String showDisplay(int sum) {
        String display;
        if (sum == 0) display = "INSERT COIN";
        else display = "" + sum;
        return display;
    }

}
