package view;

import controller.AccountController;
import controller.BankingController;
import model.AccountModel;
import model.Model;
import model.ModelEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingView extends JFrameView {

    AccountModel current_account;
    double currency_rate;

    public static final String WITHDRAW = "Withdraw";
    public static final String DEPOSIT = "Deposit";
    public static final String CLOSE = "Close";

    public JTextField input_amount = new JTextField();
    public JTextField current_account_balance = new JTextField();
    public JTextField current_account_name = new JTextField();
    public JTextField current_account_id = new JTextField();

    public BankingView(Model model, BankingController controller, AccountModel acc, double rate) {
        super(model, controller);
        this.current_account = acc;
        this.currency_rate = rate;

        JPanel button_panel = new JPanel();
        Jbutton_handler button_handler = new Jbutton_handler();

        JButton withdraw_button = new JButton(WITHDRAW);
        JButton deposit_button = new JButton(DEPOSIT);
        JButton close_button = new JButton(CLOSE);

        button_panel.add(withdraw_button);
        button_panel.add(deposit_button);
        button_panel.add(close_button);
        button_panel.setLayout(new GridLayout(1, 1));

        withdraw_button.addActionListener(button_handler);
        deposit_button.addActionListener(button_handler);
        close_button.addActionListener(button_handler);

        this.getContentPane().add(button_panel, BorderLayout.CENTER);

        JPanel account_panel = new JPanel();
        account_panel.setLayout(new GridLayout(4, 1));

        account_panel.add(current_account_id);
        account_panel.add(current_account_name);
        account_panel.add(current_account_balance);
        account_panel.add(input_amount);

        input_amount.setText("0.00");
        current_account_balance.setEditable(false);
        current_account_name.setEditable(false);
        current_account_id.setEditable(false);

        this.getContentPane().add(account_panel, BorderLayout.NORTH);

        pack();
    }


    public void modelChanged(ModelEvent event) {
        String display_amount;

    }

    class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((BankingController)getController()).operation(e.getActionCommand());
        }
    }
}