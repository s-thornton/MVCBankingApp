package model;

public class AgentModel extends AbstractModel {

    private int agent_id;
    private AccountModel current_account;

    public AgentModel (int id, AccountModel acc, double n, double a, String o) {
        this.agent_id = id;
        this.current_account = acc;
    }

    public int getAgent_id() { return agent_id; }
    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }
    public AccountModel getCurrent_account() { return current_account; }
    public void setCurrent_account(AccountModel current_account) { this.current_account = current_account; }
}
