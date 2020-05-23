package lab3;

class BalanceCard extends BasicCard {
    private int balance;

    public void setBalance(int input){
        this.balance = input;
    }
    public int getBalance()
    {
        return this.balance;
    }

    public BalanceCard(int id, int balance) {super(id); this.balance = balance;}

    protected boolean PassCard(){
        if (this.balance > 0) {
            this.balance -= 5;
            return true;
        }
        else
            return false;
    }
}
