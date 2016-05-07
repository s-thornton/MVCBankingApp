package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AgentModel extends AbstractModel {

    private static final AtomicInteger seed = new AtomicInteger();
    private int agent_id = seed.incrementAndGet();
    private AccountModel current_account;
    private double amount;
    private double operations_per_second;
    private ArrayList<AgentThread> agents = new ArrayList<>();

    public AgentModel (AccountModel acc, double n, double a) {
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = n;
    }

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

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}