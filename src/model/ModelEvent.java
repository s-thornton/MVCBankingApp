package model;

public class ModelEvent {
    private double user_balance;
    private AccountModel user;
    private double amount_transferred;
    private int operations_completed;

    
    public ModelEvent(AccountModel acc, double a, int c) {
        this.user = acc;
        this.user_balance = acc.getBalance();
        this.amount_transferred = a;
        this.operations_completed = c;
    }

    public double getUser_balance() { return user_balance; }
    public void setUser_balance(double balance) { this.user_balance = balance; }
    public AccountModel getAccount() { return user; }
    public void setAccount(AccountModel user) { this.user = user; }
    public double getAmount_transferred() { return amount_transferred; }
    public void setAmount_transferred(double amount_transferred) { this.amount_transferred = amount_transferred; }
    public int getOperations_completed() { return operations_completed; }
    public void setOperations_completed(int operations_completed) { this.operations_completed = operations_completed; }
}
