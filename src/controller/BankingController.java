package controller;

import model.AccountModel;
import view.BankingView;
import view.JFrameView;

public class BankingController extends AbstractController {

    private AccountModel account;
    private double currency_rate;

    public BankingController(AccountModel model, AccountModel acc, double curr) {
        this.account = acc;
        this.currency_rate = curr;
        setModel(model);
        setView(new BankingView(model, this, account, currency_rate));
        ((JFrameView)getView()).setVisible(true);
        ((BankingView)getView()).current_account_balance.setText(String.format("%.2f",
                account.getBalance() * currency_rate));
        ((BankingView)getView()).current_account_name.setText(account.getName());
        ((BankingView)getView()).current_account_id.setText(account.getAccount_id());
    }

    public double getCurrency() { return currency_rate; }
    public void setCurrency(double currency_rate) { this.currency_rate = currency_rate; }
    public AccountModel getAccount() { return account; }
    public void setAccount(AccountModel account) { this.account = account; }

    public void operation(String o) {
        switch(o) {
            case "deposit":
                break;
            case "withdraw":
                break;
            default:
                break;
        }
    }
}
