/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import Common.DFInteraction;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.util.ArrayList;

/**
 *
 * @author gonca
 */
public class UpdateDestinies extends TickerBehaviour {

    ArrayList<Integer> CurrentDestinies = new ArrayList<Integer>(); 

    public UpdateDestinies(Agent a, long period) {
        super(a, period);
        CurrentDestinies = ((ElevatorAgent) myAgent).myElevInt.destinies();
    }

    @Override
    protected void onTick() {

        ArrayList<Integer> newDestinies = ((ElevatorAgent) myAgent).myElevInt.destinies();
        if (!CurrentDestinies.equals(newDestinies)) {
            CurrentDestinies = new ArrayList<>(newDestinies);
        }
    }
}
