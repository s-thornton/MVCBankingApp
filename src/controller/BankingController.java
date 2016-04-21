package controller;

import model.AccountModel;
import view.BankingView;
import view.JFrameView;

import javax.swing.*;
//Receives input from BankingView and access AccountModel to perform actions deposit and withraw
public class BankingController extends AbstractController {

    private AccountModel account;
    private String currency;
    private double currency_rate;

    public BankingController(AccountModel model, AccountModel acc, String curr, double rate) {
        this.account = acc;
        this.currency = curr;
        this.currency_rate = rate;

        setModel(model);
        setView(new BankingView(model, this, account, currency_rate));
        ((BankingView)getView()).current_account_balance.setText(String.format("%.2f",
                account.getBalance() * currency_rate));
        ((BankingView)getView()).current_account_name.setText(account.getName());
        ((BankingView)getView()).current_account_id.setText(account.getAccount_id());
        ((BankingView)getView()).setTitle(account.getName() + " " + account.getAccount_id() +
                "; Operations in " + currency);
        ((JFrameView)getView()).setVisible(true);
    }

    public double getCurrency_rate() { return currency_rate; }
    public void setCurrency_rate(double currency_rate) { this.currency_rate = currency_rate; }
    public AccountModel getAccount() { return account; }
    public void setAccount(AccountModel account) { this.account = account; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public void operation(String o) {
        double amount;
        double new_balance;
        switch(o) {
            case "Deposit":
                try{
                    amount = Double.parseDouble(((BankingView)getView()).input_amount.getText());
                    if(((AccountModel)getModel()).deposit(account, amount, currency_rate)) {
                        new_balance = account.getBalance() * currency_rate;
                        ((BankingView)getView()).input_amount.setText("0.00");
                        ((BankingView)getView()).current_account_balance.setText(String.format("%.2f", new_balance));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Failed to deposit funds, amount must be comprised of numeric characters");
                }
                break;
            case "Withdraw":
                try {
                    amount = Double.parseDouble(((BankingView)getView()).input_amount.getText());
                    if(((AccountModel)getModel()).withdraw(account, amount, currency_rate)) {
                        new_balance = account.getBalance() * currency_rate;
                        ((BankingView)getView()).input_amount.setText("0.00");
                        ((BankingView)getView()).current_account_balance.setText(String.format("%.2f", new_balance));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Failed to withdraw funds, amount must be comprised of numeric characters");
                }
                break;
            case "Close":
                ((JFrameView)getView()).dispose();
                break;
            default:
                break;
        }
    }
}
