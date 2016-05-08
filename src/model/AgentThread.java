package model;

import java.util.*;



public class AgentThread extends Thread{

    private AccountModel current_account;
    private AgentModel agent_model;
    private double amount;
    private double amount_transferred;
    boolean running = true;
    private double operations_per_second = 0;
    private double operations_completed = 0;
    private int agent_id;
    private String choice;
    private String state = "Running";
    private static List<Integer> id_list = new ArrayList<>();


    public AgentThread (int id, AccountModel acc, double n, double a, String choice, AgentModel agent_model) {
        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = n;
        this.choice = choice;
        this.agent_model = agent_model;
    }

    public void run() {
        try {
            while (this.running) {
                if (choice.equals("Withdraw")) {
                    //if you try to withdraw more that you have do nothing and change the state to blocked.
                    if ((current_account.getBalance() - amount) < 0) {
                        state = "Blocked";

                    }
                    // otherwise, go ahead and do your thing.
                    else {
                        amount_transferred -= amount;
                        current_account.setBalance(current_account.getBalance()-amount);
                        state = "Running";
                        operations_completed++;
                    }
                }else {
                    amount_transferred += amount; //deposit.
                    current_account.setBalance(current_account.getBalance()+amount);
                    operations_completed++;
                }
                ModelEvent update = new ModelEvent(current_account);
                agent_model.notifyChanged(update);
                sleep((long)((1/operations_per_second)*1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public int getAgent_id() { return agent_id; }
    public double get_ops() {return operations_per_second;}
    public double get_ops_completed() {return operations_completed;}
    public double get_amount() {return amount;}
    public double get_amount_transferred() {return amount_transferred;}
    public String get_state() {return state;}
    public static void addId(int id){ id_list.add(id);}
    public static boolean checkID(int id){
        return !id_list.contains(id);
    }
    public static void removeID(Integer id){
        if (id_list.contains(id)){
            id_list.remove(id); // doesn't remove at index id. actually removes the object id since it is of
                                // type Integer instead of int. new trick learned from stack overflow:)
        }
    }


}
