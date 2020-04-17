import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;
    private static final int NICKEL = 3;
    private static final int QUARTER = 4;
    private static VendingMachine vendingMachine;

    private static CoinManager coinManager;
    private static Inventory inventory;
    private static Dispenser dispenser;


    @BeforeClass
    public static void setUp() {
        String product = "";

        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        coinManager = new CoinManager(coinHolding, coinReturn);

        dispenser = new Dispenser(product);

        Map<String, Integer> productStock = new HashMap<>();
        Map<String, Integer> productPrice = new HashMap<>();
        inventory = new Inventory(productStock, productPrice, product);

        Map<Integer, Integer> valueMap = new HashMap<>();
        Calculate calculate = new Calculate(0, valueMap, inventory, dispenser);
        vendingMachine = new VendingMachine(calculate, coinManager, dispenser, inventory);
    }

    @Test
    public void insertCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void insertCoin() {
        vendingMachine.reset();
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.1", vendingMachine.display());
    }

    @Test
    public void invalidCoinToReturn() {
        vendingMachine.insertCoin(PENNY);
        assertEquals(1, coinManager.inCoinReturn(PENNY));
    }


    @Test
    public void selectProduct() {
        vendingMachine.select("cola");
        assertEquals("cola", inventory.getProduct());
    }

    @Test
    public void notEnoughMoney() {
        vendingMachine.reset();
        vendingMachine.select("cola");
        assertEquals("PRICE", vendingMachine.display());
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void purchaseProduct() {
        vendingMachine.reset();
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.select("cola");
        assertEquals("THANK YOU", vendingMachine.display());
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void dispenseAfterPurchase() {
        vendingMachine.reset();
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.select("candy");
        assertEquals("candy", dispenser.inDispenser());
    }

    @Test
    public void makeChangeUponPurchase() {
        vendingMachine.reset();
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(NICKEL);
        vendingMachine.select("candy");
        assertEquals(1, coinManager.inCoinReturn(QUARTER));
        assertEquals(1, coinManager.inCoinReturn(DIME));
        assertEquals(1, coinManager.inCoinReturn(NICKEL));
    }

    @Test
    public void resetButton() {
        vendingMachine.reset();
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(DIME);
        vendingMachine.select("reset");
        assertEquals(4, coinManager.inCoinReturn(QUARTER));
        assertEquals(1, coinManager.inCoinReturn(DIME));
    }

}
