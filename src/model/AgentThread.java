package model;

import java.util.*;
import model.Model;
import model.ModelEvent;
import sun.management.Agent;

public class AgentThread extends Thread{

    private AccountModel current_account;
    public AgentModel agent_model;
    private double amount;
    private double amount_transferred;
    private boolean running = true;
    private double operations_per_second = 0;
    private double operations_completed = 0;
    private int agent_id;
    private String choice;
    private String state = "Running";
    private static List<Integer> id_list = new ArrayList<Integer>();


    public AgentThread (int id, AccountModel acc, double n, double a, String choice, AgentModel agent_model) {
        this.agent_id = id;
        this.current_account = acc;
        this.amount = a;
        this.operations_per_second = 1;// (n * 1000);
        this.choice = choice;
        this.agent_model = agent_model;
        System.out.print("hit");
    }

    public void run() {
        try {
            while(this.running){
                System.out.print("were running");
                current_account.setBalance(current_account.getBalance() + amount);
                if (choice.equals("Withdraw")) amount_transferred += amount;
                else amount_transferred -= amount;
                operations_completed++;
                ModelEvent update = new ModelEvent(current_account, operations_completed, amount_transferred);
                agent_model.notifyChanged(update);
                sleep((long)operations_per_second*1000);
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
    public static void removeID(int id){
        for (Integer _id: id_list){

            System.out.print(_id);
            if (_id == id){
                id_list.remove(_id);
            }
        }
    }
    public static boolean checkID(int id){
        if (id_list.contains(id)) return false; // its in there.
        else return true; // its not. were good.
    }

}
