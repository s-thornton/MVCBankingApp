package view;

import controller.AgentController;
import model.AccountModel;
import model.AgentModel;
import model.ModelEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgentView extends JFrameView{


    private static final String id_string = "Agent ID:";
    private static final String amount_string = "Amount in $:";
    private static final String ops_string = "Operations Per Second:";

    public static final String start_string = "Start Agent";
    public static final String dismiss_string = "Dismiss";

    public JTextField agent_id = new JTextField(15);
    public JTextField input_amount = new JTextField(15);
    public JTextField ops = new JTextField(15);

    public AgentView(AgentModel model, AgentController controller, AccountModel acc){
        super (model, controller);

        JPanel panel = new JPanel();
        Jbutton_handler button_hander = new Jbutton_handler();

        JLabel agent_id_label = new JLabel(id_string);
        JLabel amount_label = new JLabel(amount_string);
        JLabel ops_label = new JLabel(ops_string);

        agent_id.setText("");
        input_amount.setText("");
        ops.setText("");

        JButton start_button = new JButton(start_string);
        JButton dismiss_button = new JButton(dismiss_string);

        start_button.addActionListener(button_hander);
        dismiss_button.addActionListener(button_hander);

        panel.add(agent_id_label);
        panel.add(agent_id);
        panel.add(amount_label);
        panel.add(input_amount);
        panel.add(ops_label);
        panel.add(ops);
        panel.add(start_button);
        panel.add(dismiss_button);

        panel.setLayout(new GridLayout(4,2));
        this.getContentPane().add(panel, BorderLayout.CENTER);

        pack();
    }
    public void modelChanged(ModelEvent event) {

    }

    private class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((AgentController)getController()).operation(e.getActionCommand());
        }
    }
}
