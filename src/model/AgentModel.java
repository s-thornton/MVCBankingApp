package model;


public class AgentModel extends AbstractModel {

    public AgentThread make_new_agent(int id, AccountModel acc, double n, double a, String choice){
        AgentThread agent;
        agent = new AgentThread(id, acc, n, a, choice, this);
        agent.start();
        return agent;
    }

    public void stop_thread(AgentThread thread){ thread.running = false;}
}