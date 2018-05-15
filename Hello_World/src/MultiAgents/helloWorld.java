package MultiAgents;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jade.core.Agent;

/**
 *
 * @author gonca
 */
public class helloWorld extends Agent {

    @Override
    protected void setup() {
        this.addBehaviour(new helloWorld_SimpleBehaviour(this));
        this.addBehaviour(new helloWorld_OneShotBehaviour(this));
        this.addBehaviour(new helloWorld_WakerBehaviour(this, 1000));
        this.addBehaviour(new helloWorld_CyclicBehaviour(this));
        this.addBehaviour(new helloWorld_TickerBehaviour(this,2000));
    }
}
