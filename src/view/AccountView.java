package view;

import controller.AccountController;
import model.AccountModel;
import model.ModelEvent;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class AccountView extends JFrameView {
    public static final String BANK_USD = "Bank in USD";
    public static final String BANK_EURO = "Bank in Euro";
    public static final String BANK_YUAN = "Bank in Yuan";
    public static final String SAVE = "Save";
    public static final String EXIT = "Exit";
    public ArrayList<AccountModel> account_list = new ArrayList<>();

    public AccountView (AccountModel model, AccountController controller, ArrayList<AccountModel> accounts) {
        super(model, controller);
        account_list = accounts;

        JButton bank_usd_button = new JButton(BANK_USD);
        JButton bank_euro_button = new JButton(BANK_EURO);
        JButton bank_yuan_button = new JButton(BANK_YUAN);
        JButton save_button = new JButton(SAVE);
        JButton exit_button = new JButton(EXIT);
        JPanel panel = new JPanel();

        panel.add(bank_usd_button);
        panel.add(bank_euro_button);
        panel.add(bank_yuan_button);
        panel.add(save_button);
        panel.add(exit_button);

        panel.setLayout(new GridLayout(10, 4, 6, 6));
        this.getContentPane().add(panel, BorderLayout.CENTER);

        pack();
    }

    public void modelChanged(ModelEvent event) { String msg = event.getAmount() + ""; }

    public static void main(String[] args) {
        ArrayList<AccountModel> accounts = new ArrayList<>();
        String file;
        if(args.length > 0)
            file = args[0];
        else
            return;
        new AccountController(accounts, file);
    }
}
