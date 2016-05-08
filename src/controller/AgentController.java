package controller;

import model.AccountModel;
import model.AgentModel;
import model.AgentThread;
import view.AgentThreadView;
import view.AgentView;
import view.JFrameView;
import javax.swing.*;

public class AgentController extends AbstractController {
    private AccountModel current_account;
    private int num_agents = 0;
    private String operation;
    AgentThread ATModel;
    String option;



    public AgentController(AccountModel acc, String option){
        this.operation = option;
        this.current_account = acc;
        this.option = option;

        setModel(new AgentModel('1', acc, 1, 1));
        setView(new AgentView((AgentModel) getModel(), this, acc));
        ((JFrameView) getView()).setVisible(true);
        ((AgentView) getView()).setTitle(option + " Agent: " + num_agents +
                " for account" + acc.getAccount_id());

    }
    public void operation(String o){
        switch(o){
            case AgentView.start_string:
                int id_of_agent = Integer.parseInt(((AgentView)getView()).agent_id.getText());
                if (AgentThread.checkID(id_of_agent)){
                    AgentThread.addId(id_of_agent);
                }else{
                    JOptionPane.showMessageDialog(null, "Agent ID in use, Please choose another.");
                    ((AgentView)getView()).agent_id.setText("");
                    return;
                }
                double amount_of_transaction = Double.parseDouble(((AgentView)getView()).input_amount.getText());
                double ops = Double.parseDouble(((AgentView)getView()).ops.getText());
                ATModel = new AgentThread(id_of_agent, current_account, ops, amount_of_transaction);
                ((JFrameView)getView()).dispose();
                setView(new AgentThreadView((AgentModel)getModel(), this, current_account, ATModel));
                ((JFrameView) getView()).setVisible(true);
                ((AgentThreadView)getView()).setTitle(option + " Agent: " + ATModel.getAgent_id() +
                        " for account" + current_account.getAccount_id());
                break;
            case AgentView.dismiss_string: // this also disposes the agentThreadView for some reason also.. #oo-re-usability at its finest.
                ((JFrameView)getView()).dispose();
                break;
        }
    }

}
