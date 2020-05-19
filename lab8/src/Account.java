class Account {
    private int balance;

    public Account(int sum) {
        balance = sum;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw (int amount) {
        balance = balance - amount;
    }

    public void deposit (int amount) {
        balance = balance + amount;
    }
}
