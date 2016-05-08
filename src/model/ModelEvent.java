package model;

public class ModelEvent{
    private double user_balance;

    public ModelEvent(AccountModel acc) {
        this.user_balance = acc.getBalance();
    }
    public double getUser_balance() { return user_balance; }
}
