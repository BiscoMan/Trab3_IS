package MultiAgents;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author gonca
 */
//Runs after x time
public class helloWorld_WakerBehaviour extends WakerBehaviour {

    public helloWorld_WakerBehaviour(Agent a, long timeout) {
        super(a, timeout);
        System.out.println("Start - " + System.currentTimeMillis());
    }

    @Override
    protected void onWake() {
        System.out.println("End - " + System.currentTimeMillis());
    }
}
