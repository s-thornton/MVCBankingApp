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
    int agentID;



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

                // see if the user input values. if not.. we throw error messages.
                if (((AgentView)getView()).agent_id.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid agent ID");
                    return;
                }
                if (((AgentView)getView()).input_amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount to " + option);
                    return;
                }
                if (((AgentView)getView()).ops.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount of operations per second");
                    return;
                }

                // get the agent id and see if its in use.
                int id_of_agent = Integer.parseInt(((AgentView)getView()).agent_id.getText());
                if (!AgentThread.checkID(id_of_agent)){
                    JOptionPane.showMessageDialog(null, "Agent ID in use, \n Please choose another.");
                    ((AgentView)getView()).agent_id.setText("");
                    return;
                }

                // get values for operations per second & transaction amount & append the agent id to the list.
                double amount_of_transaction = Double.parseDouble(((AgentView)getView()).input_amount.getText());
                double ops = Double.parseDouble(((AgentView)getView()).ops.getText());
                agentID = id_of_agent;
                AgentThread.addId(id_of_agent);

                // create and set the new view.. & kill the old one.
                ATModel = new AgentThread(id_of_agent, current_account, ops, amount_of_transaction);
                ((JFrameView)getView()).dispose();
                setView(new AgentThreadView((AgentModel)getModel(), this, current_account, ATModel));
                ((JFrameView) getView()).setVisible(true);
                ((AgentThreadView)getView()).setTitle(option + " Agent: " + ATModel.getAgent_id() +
                        " for account" + current_account.getAccount_id());
                break;

            case AgentView.dismiss_string: // this also disposes the agentThreadView for some reason also.. #oo-re-usability at its finest.
                ((JFrameView)getView()).dispose();
                try {
                    AgentThread.removeID(agentID); // when the view closes, we delete the agentid from the list.\
                }catch (Exception e){
                    System.out.print("cant delete agent id. " + e);
                }
                break;
        }
    }

}
