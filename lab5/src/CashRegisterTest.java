import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashRegisterTest {
    static private CashRegister cashRegister;
    static private Item testItem1;
    static private Item testItem2;
    static private Item testItem3;

    @BeforeAll
    static void initItems() {
        testItem1 = new Item("testName", 6.43);
        testItem2 = new Item("itemName", 5.5);
        testItem3 = new Item("newName", 10);
    }

    @BeforeEach
    void initCashRegister() {
        cashRegister = new CashRegister();
    }

    @Test
    void addItem() {
        //arrange
        int expected = 3;

        //act
        for(int i = 0; i < 2; i++) {
            cashRegister.addItem(testItem1);
        }
        for(int i = 0; i < 3; i++) {
            cashRegister.addItem(testItem2);
        }
        cashRegister.addItem(testItem3);
        int actual = cashRegister.getItemsLength();

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateTotalSum() {
        //arrange
        for(int i = 0; i < 2; i++) {
            cashRegister.addItem(testItem1);
        }
        for(int i = 0; i < 3; i++) {
            cashRegister.addItem(testItem2);
        }
        cashRegister.addItem(testItem3);
        double expected = 39.36;

        //act
        cashRegister.calculateTotalSum();
        double actual = cashRegister.getTotalSum();

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createCheck() {
        //arrange
        for(int i = 0; i < 2; i++) {
            cashRegister.addItem(testItem1);
        }
        for(int i = 0; i < 3; i++) {
            cashRegister.addItem(testItem2);
        }
        cashRegister.addItem(testItem3);
        String expected = "itemName 5.50 x3" + System.lineSeparator()
                + "newName 10.00 x1" + System.lineSeparator()
                + "testName 6.43 x2" + System.lineSeparator()
                + "Total sum: 39.36";

        //act
        cashRegister.calculateTotalSum();
        String actual = cashRegister.createCheck();

        //assert
        Assertions.assertEquals(expected, actual);
    }
}