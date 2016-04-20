package view;

import controller.AccountController;
import model.AccountModel;
import model.ModelEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class AccountView extends JFrameView {

    public static final String BANK_USD = "Bank in USD";
    public static final String BANK_EURO = "Bank in Euro";
    public static final String BANK_YUAN = "Bank in Yuan";
    public static final String SAVE = "Save";
    public static final String EXIT = "Exit";
    public ArrayList<AccountModel> accounts = new ArrayList<>();
    public String file_name;

    public AccountView (AccountModel model, AccountController controller, ArrayList<AccountModel> account_list) {

        super(model, controller);

        accounts = account_list;
        String[] accounts_array = new String[accounts.size()];
        int i = 0;
        for(AccountModel a : accounts) {
            accounts_array[i] = a.getName() + " " + a.getAccount_id();
            i++;
        }
        JComboBox accounts_dropdown = new JComboBox<>(accounts_array);
        accounts_dropdown.setSelectedIndex(0);
        controller.user = accounts.get(0);

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
        panel.setLayout(new GridLayout(5, 1, 40, 20));

        this.getContentPane().add(accounts_dropdown, BorderLayout.NORTH);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        Jbutton_handler button_handler = new Jbutton_handler();
        JComboBox_handler box_handler = new JComboBox_handler();
        bank_usd_button.addActionListener(button_handler);
        bank_euro_button.addActionListener(button_handler);
        bank_yuan_button.addActionListener(button_handler);
        save_button.addActionListener(button_handler);
        exit_button.addActionListener(button_handler);
        accounts_dropdown.addActionListener(box_handler);


        pack();
    }

    public void modelChanged(ModelEvent event) { String msg = event.getAmount() + ""; }

    class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((AccountController)getController()).operation(e.getActionCommand(), file_name);
        }
    }

    class JComboBox_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            int account_index = (int)cb.getSelectedIndex();
            ((AccountController)getController()).set_user(account_index);
        }
    }
    public static void main(String[] args) {

        try {
            String file_name = args[0];
            String line;
            ArrayList<AccountModel> accounts = new ArrayList<>();
            FileInputStream fin = new FileInputStream(file_name);
            DataInputStream input = new DataInputStream(fin);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String account_info[] = line.split(",");
                String name = account_info[0];
                String account_id = account_info[1];
                double balance = Double.parseDouble(account_info[2]);

                AccountModel account = new AccountModel(account_id, name, balance);
                accounts.add(account);
                System.out.print("Account Information: " + account.getAccount_id() + " " + account.getName() + " " +
                        account.getBalance() + "\n");
            }
            reader.close();
            new AccountController(accounts, file_name);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.print("Input file input.txt not found, please place 'input.txt' in directory MVCBankingApp");
            System.exit(1);
        }
    }
}
