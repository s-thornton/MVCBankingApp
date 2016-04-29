package model;

public class ModelEvent {
    private double user_balance;
    private AccountModel user;
    
    public ModelEvent(Object obj, int id, String message, double a, AccountModel acc) {
        this.user = acc;
        this.user_balance = a;
    }

    public double getUser_balance() { return user_balance; }
    public void setUser_balance(double balance) { this.user_balance = balance; }
    public AccountModel getAccount() { return user; }
    public void setAccount(AccountModel user) { this.user = user; }
}
