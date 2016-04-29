package model;

public class ModelEvent {
    private double user_balance;
    private AccountModel user;
    
    public ModelEvent(AccountModel acc) {
        this.user = acc;
        this.user_balance = acc.getBalance();
    }

    public double getUser_balance() { return user_balance; }
    public void setUser_balance(double balance) { this.user_balance = balance; }
    public AccountModel getAccount() { return user; }
    public void setAccount(AccountModel user) { this.user = user; }
}
