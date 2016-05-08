package model;

import java.util.*;



public class AgentThread extends Thread{

    private AccountModel current_account;
    private AgentModel agent_model;
    private double amount;
    private double amount_transferred;
    public boolean running = true;
    private double operations_per_second = 0;
    private double operations_completed = 0;
    private int agent_id;
    private String choice;
    private String state;
    private static List<Integer> id_list = new ArrayList<Integer>();


    public AgentThread (int id, AccountModel acc, double n, double a, String choice, AgentModel agent_model) {
        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = 1;// (n * 1000);
        this.choice = choice;
        this.agent_model = agent_model;
    }

    public void run() {
        try {
            while (this.running) {
                if (choice.equals("Withdraw")) {
                    //if you try to withdraw more that you have
                    if ((current_account.getBalance() - amount) < 0) {
                        state = "Blocked"; System.out.println("blocked");

                    }
                    // otherwise, go ahead and do your thing.
                    else {
                        amount_transferred -= amount;
                        current_account.setBalance(current_account.getBalance()-amount);
                        System.out.println(current_account.getBalance());
                        state = "Running";System.out.println("running");
                    }
                }else {
                    amount_transferred += amount; //deposit.
                    current_account.setBalance(current_account.getBalance()+amount);
                    System.out.println(current_account.getBalance());
                }
                operations_completed++;
                ModelEvent update = new ModelEvent(current_account, operations_completed, amount_transferred, state);
                agent_model.notifyChanged(update);
                sleep((long) operations_per_second * 1000);
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

}
