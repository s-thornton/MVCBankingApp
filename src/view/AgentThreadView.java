package view;


import controller.AccountController;
import controller.AgentController;
import controller.BankingController;
import controller.Controller;
import model.AccountModel;
import model.AgentModel;
import model.Model;
import model.ModelEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgentThreadView extends JFrameView {
    AccountModel current_account;
    double currency_rate;
    public JTextField input_amount = new JTextField(20);
    public JTextField ops_per_second = new JTextField(20);
    public JTextField state = new JTextField(15);
    public JTextField amount_transferred = new JTextField(15);
    public JTextField ops_completed = new JTextField(15);

    public static final String stop = "Stop Agent";
    public static final String dismiss = "Dismiss";
    public static final String input_amount_string = "Amount in $:";
    public static final String ops_per_second_string = "Operations per Second:";
    public static final String state_string = "State:";
    public static final String amount_transferred_string = "Amount in $ Transferred:";
    public static final String ops_completed_string = "Operations Completed";


    public AgentThreadView(AgentModel model, AgentController controller, AccountModel acc){

        super(model, controller);

        this.current_account = acc;

        JPanel panel = new JPanel();
        Jbutton_handler button_hander = new Jbutton_handler();

        input_amount.setText(Double.toString (current_account.getBalance()));
        ops_per_second.setText("0");
        state.setText("Running");
        amount_transferred.setText("0");
        ops_completed.setText("0");

        input_amount.setEditable(false);
        ops_per_second.setEditable(false);
        state.setEditable(false);
        amount_transferred.setEditable(false);
        ops_completed.setEditable(false);

        JButton stop_button = new JButton(stop);
        JButton dismiss_button = new JButton(dismiss);

        // labels :)
        JLabel input_amount_label = new JLabel(input_amount_string);
        JLabel ops_per_second_label = new JLabel(ops_per_second_string);
        JLabel state_label = new JLabel(state_string);
        JLabel amount_transferred_label = new JLabel(amount_transferred_string);
        JLabel ops_completed_label = new JLabel(ops_completed_string);

        panel.add(input_amount_label);
        panel.add(input_amount);
        panel.add(ops_per_second_label);
        panel.add(ops_per_second);
        panel.add(state_label);
        panel.add(state);
        panel.add(amount_transferred_label);
        panel.add(amount_transferred);
        panel.add(ops_completed_label);
        panel.add(ops_completed);

        // another panel for buttons for style :)
        JPanel button_panel = new JPanel();

        stop_button.addActionListener(button_hander);
        dismiss_button.addActionListener(button_hander);

        button_panel.add(stop_button);
        button_panel.add(dismiss_button);

        panel.setLayout(new GridLayout(5,2));
        button_panel.setLayout(new GridLayout(2,1));
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(button_panel, BorderLayout.SOUTH);
        pack();

    }

    public void modelChanged(ModelEvent event) {

    }

    class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((AgentController)getController()).operation(e.getActionCommand());
        }
    }
}
