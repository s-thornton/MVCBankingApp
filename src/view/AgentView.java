package view;


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

public class AgentView extends JFrameView {
    AccountModel current_account;
    double currency_rate;
    public JTextField input_amount = new JTextField(20);
    public JTextField ops_per_second = new JTextField(20);
    public JTextField state = new JTextField(15);
    public JTextField amount_transferred = new JTextField(15);
    public JTextField ops_completed = new JTextField(15);

    public static final String stop = "Stop Agent";
    public static final String dismiss = "Dismiss";

    public AgentView(Model model, AgentController controller, AccountModel acc){
        super(model, controller);
        this.current_account = acc;

        JPanel panel = new JPanel();
        Jbutton_handler button_hander = new Jbutton_handler();

        panel.add(input_amount);
        panel.add(ops_per_second);
        panel.add(state);
        panel.add(amount_transferred);
        panel.add(ops_completed);

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
        panel.add(stop_button);
        panel.add(dismiss_button);

        panel.setLayout(new GridLayout(5,1));
        this.getContentPane().add(panel, BorderLayout.CENTER);


    }

    public void modelChanged(ModelEvent event) {

    }

    class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((BankingController)getController()).operation(e.getActionCommand());
        }
    }
}
