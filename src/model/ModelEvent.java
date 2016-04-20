package model;

import java.awt.event.ActionEvent;

public class ModelEvent {
    private double user_balance;
    private AccountModel user;
    
    public ModelEvent(Object obj, int id, String message, double a, AccountModel acc) {
        //super(obj, id, message);
        this.user = acc;
        this.user_balance = a;
    }

    public double getAmount() { return user_balance; }
    public void setAmount(double balance) { this.user_balance = balance; }
    public AccountModel getAccount() { return user; }
    public void setAccount(AccountModel user) { this.user = user; }
}
