package model;

public class AgentThread extends Thread{

    private AccountModel current_account;
    private double amount;
    private double amount_transferred;
    private boolean running = false;
    private long operations_per_second = 0;
    private double operations_completed = 0;
    private int agent_id;


    public AgentThread (int id, AccountModel acc, double n, double a) {

        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = Double.doubleToLongBits(n * 1000);
    }

    public void run() {
        try {
            while(this.running){
                current_account.setBalance(current_account.getBalance() + amount);
                amount_transferred += amount;
                operations_completed++;
                ModelEvent current = new ModelEvent(current_account, amount_transferred, operations_completed);
                //TODO notifyChanged
                sleep(operations_per_second);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAgent_id() { return agent_id; }
    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }
    public double get_amount_transferred() {return amount_transferred;}
    public void set_amount_transferred(double amt) {this.amount_transferred = amt;}
    public double get_ops_completed() {return operations_completed;}
    public void set_ops_completed(double ops) {this.operations_completed = ops;}
}
