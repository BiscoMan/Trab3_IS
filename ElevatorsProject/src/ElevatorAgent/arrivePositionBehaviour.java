/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author gonca
 */
public class arrivePositionBehaviour extends TickerBehaviour {

    public arrivePositionBehaviour(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        if (((ElevatorAgent) myAgent).myElevInt.arrivePosition(((ElevatorAgent) myAgent).destinies.getNextDestiny())) {
            ((ElevatorAgent) myAgent).destinies.setCurrentDestiny(((ElevatorAgent) myAgent).destinies.getNextDestiny());
        }
    }
}
