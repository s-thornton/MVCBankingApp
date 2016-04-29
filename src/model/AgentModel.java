package model;

import view.AgentView;
import view.JFrameView;

import javax.swing.*;

public class AgentModel extends AbstractModel {

    private int agent_id;
    private AccountModel current_account;
    private double amount;
    private boolean running = false;
    private String operation;
    private double operations_per_second = 0;
    private int operations_completed = 0;


    public AgentModel (int id, AccountModel acc, double n, double a, String o) {

        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = n;
        this.operation = o;
    }

    public void run() {

        switch(this.operation) {
//            case "Deposit":
//                try{
//                    amount = Double.parseDouble(((AgentView)getView()).input_amount.getText());
//                    if(((AccountModel)getModel()).deposit(current_account, amount, currency_rate)) {
//                        new_balance = account.getBalance() * currency_rate;
//                        ((AgentView)getView()).input_amount.setText("0.00");
//                        ((AgentView)getView()).current_account_balance.setText(String.format("%.2f", new_balance));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null,
//                            "Failed to deposit funds, amount must be comprised of numeric characters");
//                }
//                break;
//            case "Withdraw":
//                try {
//                    amount = Double.parseDouble(((AgentView)getView()).input_amount.getText());
//                    if(((AccountModel)getModel()).withdraw(account, amount, currency_rate)) {
//                        new_balance = account.getBalance() * currency_rate;
//                        ((AgentView)getView()).input_amount.setText("0.00");
//                        ((AgentView)getView()).current_account_balance.setText(String.format("%.2f", new_balance));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null,
//                            "Failed to withdraw funds, amount must be comprised of numeric characters");
//                }
//                break;
//            case "Close":
//                ((JFrameView)getView()).dispose();
//                break;
            default:
                break;
        }
    }

}
