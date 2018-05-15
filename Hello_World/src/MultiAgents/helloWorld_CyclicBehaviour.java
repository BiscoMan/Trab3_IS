/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author gonca
 */
public class helloWorld_CyclicBehaviour extends CyclicBehaviour {
    //Runs an iteration cyclically
    public helloWorld_CyclicBehaviour(Agent a) {
    
    }

    @Override
    public void action() {
        System.out.println("CyclicBehaviour: Disparou o behaviour");
    }

}
