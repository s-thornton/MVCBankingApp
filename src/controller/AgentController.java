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

    public AgentController(AccountModel acc_mod){
//        this.current_account = (AccountModel) acc_mod;
        setModel((AgentModel)getModel());
        setView(new AgentView((AgentModel)getModel(), this, acc_mod));
        ((JFrameView)getView()).setVisible(true);
    }

}
