package controller;

import model.AccountModel;
import model.AgentModel;
import model.Model;
import view.AccountView;
import view.AgentView;
import view.JFrameView;

import java.util.ArrayList;

public class AgentController extends AbstractController {
    public AccountModel current_account;
    public Double current_rate;

    public AgentController(AgentModel model, AccountModel acc){

        setModel(model);
        setView(new AgentView(model, this, acc));
        ((JFrameView)getView()).setVisible(true);
    }

}
