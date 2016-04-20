package controller;

import model.AccountModel;
import view.AccountView;
import view.JFrameView;

import java.util.ArrayList;

public class AccountController extends AbstractController {
    public ArrayList<AccountModel> accounts = new ArrayList<>();
    public String file_name;

    public AccountController(ArrayList<AccountModel> acc, String fn){
        accounts = acc;
        file_name = fn;
        setModel(new AccountModel("1", "Sean", 10));
        setView(new AccountView((AccountModel)getModel(), this, accounts));
        ((JFrameView)getView()).setVisible(true);
    }
}
