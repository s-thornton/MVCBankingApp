package controller;

import model.AccountModel;
import model.AgentModel;
import view.AgentView;
import view.JFrameView;

import java.util.ArrayList;

public class AgentController extends AbstractController {

    private int numberOfAgents = 0;

    public AgentController(AccountModel acc, String option){
        setModel(new AgentModel('1', acc, 1, 1, option));
        setView(new AgentView((AgentModel)getModel(), this, acc));
        ((JFrameView)getView()).setVisible(true);
        ((AgentView)getView()).setTitle(option + " Agent: " + numberOfAgents +
                                        " for account" + acc.getAccount_id());
    }
    public void operation(String Option){

    }

}
