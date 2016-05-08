package model;

import java.util.ArrayList;

public class AgentModel extends AbstractModel {

    private int agent_id;
    private AccountModel current_account;
    private double amount;
    private double operations_per_second;
    private ArrayList<AgentThread> agents = new ArrayList<>();

    public AgentModel (int id, AccountModel acc, double n, double a, String choice) {
        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = n;
    }
    public AgentThread make_new_agent(int id, AccountModel acc, double n, double a, String choice){
        AgentThread agent;
        agent = new AgentThread(id, acc, n, a, choice, this); //agentmodel
        agent.start();
        return agent;
    }

    public int getAgent_id() { return agent_id; }
    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }
    public double get_amount() {return amount;}
    public void set_amout(double amt){ this.amount = amt;}
    public double get_ops() {return operations_per_second;}
    public void set_ops(double ops) {this.operations_per_second = ops;}
    public AccountModel getCurrent_account() { return current_account; }
    public void setCurrent_account(AccountModel current_account) { this.current_account = current_account; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}