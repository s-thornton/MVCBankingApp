package model;

import java.util.ArrayList;

public class AgentModel extends AbstractModel {

    private int agent_id;
    private AccountModel current_account;
    private double operations_per_second;
    private ArrayList<AgentThread> agents = new ArrayList<>();

    public AgentModel (int id, AccountModel acc, double n, double a) {
        this.agent_id = id;
        this.current_account = acc;
        this.operations_per_second = n;
    }

    public int getAgent_id() { return agent_id; }
    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }
    public AccountModel getCurrent_account() { return current_account; }
    public void setCurrent_account(AccountModel current_account) { this.current_account = current_account; }

    public AgentThread start_agent(double amount) {

        for(AgentThread a : agents)
            if(a.getAgent_id() == agent_id)
                return null;

        AgentThread new_agent_thread = new AgentThread(agent_id, current_account, operations_per_second, amount);
        agents.add(new_agent_thread);
        new_agent_thread.start();

        return new_agent_thread;
    }
}
