/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author gonca
 */
//Runs periodically and has a time window between executions
public class helloWorld_TickerBehaviour extends TickerBehaviour {
    
    public helloWorld_TickerBehaviour(Agent a, long period){
        super(a,period);
    }
    
    @Override
    protected void onTick(){
        System.out.println("TickerBehaviour: Disparou o behaviour");
    }
    
}
