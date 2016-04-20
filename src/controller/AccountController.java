package controller;

import model.AccountModel;
import view.AccountView;
import view.JFrameView;

import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountController extends AbstractController {
    public ArrayList<AccountModel> accounts = new ArrayList<>();
    public AccountModel current_account;
    public String file_name;

    public AccountController(ArrayList<AccountModel> acc, String fn){
        accounts = acc;
        file_name = fn;
        setModel(new AccountModel("1", "Sean", 10, 0));
        setView(new AccountView((AccountModel)getModel(), this, accounts));
        ((JFrameView)getView()).setVisible(true);
    }

    public void operation(String o, String fn){
        switch (o) {
            case AccountView.BANK_USD:
                new BankingController((AccountModel)getModel(), current_account, "USD", 1.0);
                break;
            case AccountView.BANK_EURO:
                new BankingController((AccountModel)getModel(), current_account, "EURO", 0.88);
                break;
            case AccountView.BANK_YUAN:
                new BankingController((AccountModel)getModel(), current_account, "YUAN", 6.47);
                break;
            case AccountView.SAVE:
                save(fn);
                break;
            case AccountView.EXIT:
                save(fn);
                System.exit(0);
                break;
            default:
                save(fn);
                System.exit(1);
        }
    }

    public void save(String fn) {
        try {
            PrintWriter writer = new PrintWriter(fn);
            writer.println("name, id, balance");
            for(AccountModel a : accounts)
                writer.println(a.getName() + ", " + a.getAccount_id() + ", " + a.getBalance());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to save, exiting");
            System.exit(1);
        }
    }

    public void set_current_account(int account_id) {
        current_account = accounts.get(account_id);
    }

}
