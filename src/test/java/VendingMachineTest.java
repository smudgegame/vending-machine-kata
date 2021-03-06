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

    private static Calculate calculate;
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
        calculate = new Calculate(0, false, valueMap, inventory, dispenser);
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
        inventory.stock("cola", 1);
        vendingMachine.select("cola");
        assertEquals("PRICE", vendingMachine.display());
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void purchaseProduct() {
        vendingMachine.reset();
        inventory.stock("cola", 1);
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

    @Test
    public void soldOut() {
        vendingMachine.reset();
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.select("chips");
        assertEquals("SOLD OUT", vendingMachine.display());
    }

    @Test
    public void masterTest() {
        vendingMachine.reset();
        inventory.stock("chips", 2);
        inventory.stock("cola", 2);
        inventory.stock("candy", 1);
        calculate.exactChange(true);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(NICKEL);
        vendingMachine.select("chips");
        assertEquals("THANK YOU", vendingMachine.display());
        assertEquals(0, coinManager.inCoinReturn(3));
        assertEquals("EXACT CHANGE ONLY", vendingMachine.display());
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.select("chips");
        assertEquals("THANK YOU", vendingMachine.display());
        vendingMachine.select("Chips");
        assertEquals("PRICE", vendingMachine.display());
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.select("Chips");
        assertEquals("SOLD OUT", vendingMachine.display());
        assertEquals("$0.5", vendingMachine.display());
        vendingMachine.select("reset");
        assertEquals(2, coinManager.inCoinReturn(QUARTER));
    }

}
