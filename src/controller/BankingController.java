package controller;

import model.AccountModel;

public class BankingController extends AbstractController {

    private AccountModel account;
    private String currency;

    public BankingController(AccountModel model, AccountModel acc, String curr) {
        this.account = acc;
        this.currency = curr;
        setModel(model);
        //setView(new BankingView(model, account, this, currency));
    }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public AccountModel getAccount() { return account; }
    public void setAccount(AccountModel account) { this.account = account; }
}
