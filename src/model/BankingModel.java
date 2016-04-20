package model;

import java.util.ArrayList;

public class BankingModel extends AbstractModel {

    public BankingModel() { }

    public boolean deposit(AccountModel acc, double amount, String currency) {
        ModelEvent current;
        switch(currency) {
            case "USD":
                acc.setBalance(acc.getBalance() + amount);
                current = new ModelEvent(this, 1, "deposit", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            case "EURO":
                acc.setBalance(acc.getBalance() + (amount * (1/0.88)));
                current = new ModelEvent(this, 1, "deposit", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            case "YUAN":
                acc.setBalance(acc.getBalance() + (amount * (1/6.47)));
                current = new ModelEvent(this, 1, "deposit", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            default:
                return false;
        }
    }

    public boolean withdraw(AccountModel acc, double amount, String currency) {
        ModelEvent current;
        switch(currency) {
            case "USD":
                if(acc.getBalance() < amount)
                    break;
                acc.setBalance(acc.getBalance() - amount);
                current = new ModelEvent(this, 2, "withdraw", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            case "EURO":
                if(acc.getBalance() < (amount * (1/0.88)))
                    break;
                acc.setBalance(acc.getBalance() - (amount * (1/0.88)));
                current = new ModelEvent(this, 2, "withdraw", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            case "YUAN":
                if(acc.getBalance() < (amount * (1/6.47)))
                    break;
                acc.setBalance(acc.getBalance() - (amount * (1/6.47)));
                current = new ModelEvent(this, 2, "withdraw", acc.getBalance(), acc);
                notifyChanged(current);
                return true;
            default:
                return false;
        }
        return false;
    }
}