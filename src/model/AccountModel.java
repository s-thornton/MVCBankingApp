package model;

public class AccountModel extends AbstractModel {

    private String account_id;
    private String name;
    private double balance = 0;

    public AccountModel(String id, String n, double b) {
        this.account_id = id;
        this.name = n;
        this.balance = b;
    }

    public String getAccount_id() { return account_id; }
    public void setAccount_id(String account_id) { this.account_id = account_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }

}
