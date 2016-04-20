package model;

import java.awt.event.ActionEvent;

public class ModelEvent {
    private double amount;
    private AccountModel account;
    public ModelEvent(Object obj, int id, String message, double a, AccountModel acc) {
        //super(obj, id, message);
        this.account = acc;
        amount = a;
    }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public AccountModel getAccount() { return account; }
    public void setAccount(AccountModel account) { this.account = account; }
}
