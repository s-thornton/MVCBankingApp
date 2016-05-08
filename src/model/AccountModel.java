package model;

import javax.swing.*;
//Account model that has basic account information and withdraw and deposit operations
public class AccountModel extends AbstractModel {

    private String account_id;
    private String name;
    private double balance = 0;

    public AccountModel(String id, String n, double b, int index) {

        this.account_id = id;
        this.name = n;
        this.balance = b;
    }

    public String getAccount_id() { return account_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBalance() { return balance; }
    void setBalance(double balance) { this.balance = balance; }


    public boolean validate(double amount, double currency_rate, boolean withdraw) {

        if(amount < 1) {
            JOptionPane.showMessageDialog(null, "Invalid input, amount must be greater than or equal to 1");
            return false;
        }

        if(withdraw && this.getBalance() < (amount * (1/currency_rate))) {
            JOptionPane.showMessageDialog(null, "Failed to withdraw funds, amount requested exceeds available balance");
            return false;
        }
        return true;
    }

    public void transact(double amount, double currency_rate) {

        this.setBalance(this.getBalance() + (amount * (1/currency_rate)));
        ModelEvent current = new ModelEvent(this);
        notifyChanged(current);
    }
}
