import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(int startSum) {
        accounts.add(new Account(startSum));
    }
    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public int countTotalSum() {
        int sum = 0;
        for(Account account: accounts) {
            sum += account.getBalance();
        }
        return sum;
    }

    public void transfer(Account from, Account to, int amount) {
        if(from == to)
            return;
        Account firstForLock;
        Account secondForLock;
        if(from.hashCode() < to.hashCode()) {
            firstForLock = from;
            secondForLock = to;
        }
        else {
            firstForLock = to;
            secondForLock = from;
        }
        synchronized(firstForLock){
            synchronized(secondForLock){
                if(from.getBalance() - amount >= 0) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
}
