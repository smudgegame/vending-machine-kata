public class Dispenser {

    private String product;

    public Dispenser(String product) {
        this.product = product;
    }

    public String inDispenser() {
        return product;
    }

    public void dispense(String product) {
        this.product = product;
    }

    void collect() {
        product = "";
    }
}
