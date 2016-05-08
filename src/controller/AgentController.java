package controller;

import model.AccountModel;
import model.AgentModel;
import model.AgentThread;
import view.AgentThreadView;
import view.AgentView;
import view.JFrameView;

public class AgentController extends AbstractController {
    private AccountModel current_account;
    private int num_agents = 0;
    private String operation;

    public AgentController(AccountModel acc, String option, boolean started){
        this.operation = option;
        this.current_account = acc;
        if (!started) {
            setModel(new AgentModel('1', acc, 1, 1));
            setView(new AgentView((AgentModel) getModel(), this, acc));
            ((JFrameView) getView()).setVisible(true);
            ((AgentView) getView()).setTitle(option + " Agent: " + num_agents +
                    " for account" + acc.getAccount_id());
        }
        else{
            setView(new AgentThreadView((AgentModel)getModel(), this, acc, ((AgentThread)getModel())));
            ((JFrameView) getView()).setVisible(true);
            ((AgentThreadView) getView()).setTitle(option + " Agent: " + num_agents +
                    " for account" + acc.getAccount_id());
        }
    }
    public void operation(String o){
        switch(o){
            case AgentView.start_string:
                ((JFrameView)getView()).dispose();
                new AgentController(current_account, operation, true);
                break;
            case AgentView.dismiss_string:
                ((JFrameView)getView()).dispose();
                break;
        }
    }

}
