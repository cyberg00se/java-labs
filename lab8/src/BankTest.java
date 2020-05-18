import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class BankTest {

    @Test
    void transfer() throws InterruptedException {
        //arrange
        Bank bank = new Bank();
        for(int i = 0; i < 100; i++) {
            int sum = 100 + (int)(Math.random() * 901); // from 100 to 1000
            bank.addAccount(sum);
        }
        int expectedSum = bank.countTotalSum();

        //act
        Thread[] threads = new Thread[5000];
        for(int i = 1; i < threads.length; i++) {
            int accountFromNumber = 0 + (int)(Math.random() * 100); // from 0 to 99
            int accountToNumber = 0 + (int)(Math.random() * 100); // from 0 to 99
            int transactionSum = 1 + (int)(Math.random() * 200); // from 1 to 200
            Account from = bank.getAccount(accountFromNumber);
            Account to = bank.getAccount(accountToNumber);

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.transfer(from, to, transactionSum);
                }
            });
            threads[i].start();
        }
        for(int i = 1; i < threads.length; i++) {
            threads[i].join();
        }
        int actualSum = bank.countTotalSum();

        //assert
        assertEquals(expectedSum, actualSum);
    }
}