package view;


import controller.BankingController;
import model.Model;
import model.ModelEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgentView extends JFrameView {
    public static final String AgentID = "";

    public AgentView(Model model, AgentController controller, AccountModel acc, double rate){

    }

    public void modelChanged(ModelEvent event) {

    }

    class Jbutton_handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ((BankingController)getController()).operation(e.getActionCommand());
        }
    }
}
