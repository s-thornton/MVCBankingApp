package model;

import view.AgentView;
import view.JFrameView;

import javax.swing.*;

public class AgentModel extends AbstractModel {

    private int agent_id;
    private AccountModel current_account;
    private double amount;
    private double amount_transferred;
    private boolean running = false;
    private String operation;
    private double operations_per_second = 0;
    private int operations_completed = 0;


    public AgentModel (int id, AccountModel acc, double n, double a, String o) {

        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = n;
        this.operation = o;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }
}
