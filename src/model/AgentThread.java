package model;

import java.util.*;

public class AgentThread extends Thread{

    private AccountModel current_account;
    private double amount;
    private double amount_transferred;
    private boolean running = false;
    private double operations_per_second = 0;
    private double operations_completed = 0;
    private int agent_id;
    private String state = "Running";
    private static List<Integer> id_list = new ArrayList<Integer>();


    public AgentThread (int id, AccountModel acc, double n, double a) {

        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = (n * 1000);
    }

    public void run() {
        try {
            while(this.running){
                current_account.setBalance(current_account.getBalance() + amount);
                amount_transferred += amount;
                operations_completed++;
                ModelEvent current = new ModelEvent(current_account, amount_transferred, operations_completed);
                //TODO notifyChanged
                sleep(Double.doubleToLongBits(operations_per_second));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public double getAmount() {return amount;}

    public int getAgent_id() { return agent_id; }
    public double get_ops() {return operations_per_second;}
    public double get_ops_completed() {return operations_completed;}
    public double get_amount() {return amount;}
    public double get_amount_transferred() {return amount_transferred;}
    public String get_state() {return state;}

    public void set_amount_transferred(double amt) {this.amount_transferred = amt;}
    public void set_ops_completed(double ops) {this.operations_completed = ops;}
    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }
    public static void addId(int id){ id_list.add(id);}
    public static boolean checkID(int id){
        if (id_list.contains(id)) return false; // its in there.
        else return true; // its not. were good.
    }

}
