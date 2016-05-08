package view;

import controller.BankingController;
import model.AccountModel;
import model.Model;
import model.ModelEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Bank interface class that passes operation input from user to the BankingController class
public class BankingView extends JFrameView {

    private double currency_rate;

    private static final String WITHDRAW = "Withdraw";
    private static final String DEPOSIT = "Deposit";
    private static final String CLOSE = "Close";


    public JTextField input_amount = new JTextField(15);
    public JTextField current_account_balance = new JTextField(15);
    public JTextField current_account_name = new JTextField(15);
    public JTextField current_account_id = new JTextField(15);


    public BankingView(Model model, BankingController controller, AccountModel acc, double rate) {
        super(model, controller);
        this.currency_rate = rate;

        JPanel button_panel = new JPanel();
        Jbutton_handler button_handler = new Jbutton_handler();

        JButton withdraw_button = new JButton(WITHDRAW);
        JButton deposit_button = new JButton(DEPOSIT);
        JButton close_button = new JButton(CLOSE);

        button_panel.add(withdraw_button);
        button_panel.add(deposit_button);
        button_panel.add(close_button);
        button_panel.setLayout(new GridLayout(3, 3, 40, 4));

        withdraw_button.addActionListener(button_handler);
        deposit_button.addActionListener(button_handler);
        close_button.addActionListener(button_handler);

        this.getContentPane().add(button_panel, BorderLayout.SOUTH);

        JPanel account_panel = new JPanel();
        account_panel.setLayout(new GridLayout(4, 4, 40, 4));
        account_panel.add(current_account_id);
        account_panel.add(current_account_name);
        account_panel.add(current_account_balance);
        account_panel.add(input_amount);

        input_amount.setText("0.00");
        current_account_balance.setEditable(false);
        current_account_name.setEditable(false);
        current_account_id.setEditable(false);

        this.getContentPane().add(account_panel, BorderLayout.EAST);

        JLabel id_label = new JLabel("Account ID: ");
        JLabel name_label = new JLabel("Name: ");
        JLabel balance_label = new JLabel("Current Balance: ");
        JLabel input_label = new JLabel("Enter amount in " + ((BankingController)getController()).getCurrency() + ": ");

        JPanel label_panel = new JPanel();
        label_panel.setLayout(new GridLayout(4, 4, 40, 4));
        label_panel.add(id_label);
        label_panel.add(name_label);
        label_panel.add(balance_label);
        label_panel.add(input_label);

        this.getContentPane().add(label_panel, BorderLayout.WEST);

        pack();
    }


    public void modelChanged(ModelEvent event) {
        current_account_balance.setText(String.format("%.2f", event.getUser_balance() * currency_rate));
    }

    private class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((BankingController)getController()).operation(e.getActionCommand());
        }
    }
}