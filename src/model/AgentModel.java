package model;

public class AgentModel extends Thread {

    public AccountModel current_account;
    public double amount;
    public boolean running = false;
    public double operations;


    public AgentModel (AccountModel acc, double o, double a) {
        this.current_account = acc;
        this.amount = a;
        this.operations = o;
    }

}
