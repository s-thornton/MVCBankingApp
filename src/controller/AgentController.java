package controller;

import model.AccountModel;
import model.AgentModel;
import view.AgentViewRunning;
import view.AgentViewStart;
import view.JFrameView;

public class AgentController extends AbstractController {
    private AccountModel current_account;
    private int numberOfAgents = 0;
    private String operation;

    public AgentController(AccountModel acc, String option, boolean started){
        this.operation = option;
        this.current_account = acc;
        setModel(new AgentModel('1', acc, 1, 1, option));
        if (!started) {
            setView(new AgentViewStart((AgentModel) getModel(), this, acc));
            ((JFrameView) getView()).setVisible(true);
            ((AgentViewStart) getView()).setTitle(option + " Agent: " + numberOfAgents +
                    " for account" + acc.getAccount_id());
        }
        else{
            setView(new AgentViewRunning((AgentModel) getModel(), this, acc));
            ((JFrameView) getView()).setVisible(true);
            ((AgentViewRunning) getView()).setTitle(option + " Agent: " + numberOfAgents +
                    " for account" + acc.getAccount_id());
        }
    }
    public void operation(String o){
        switch(o){
            case AgentViewStart.start_string:
                ((JFrameView)getView()).dispose();
                new AgentController(current_account, operation, true);
                break;
            case AgentViewStart.dismiss_string:
                ((JFrameView)getView()).dispose();
                break;
        }
    }

}
