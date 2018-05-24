/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import Common.DFInteraction;
import Common.Serialize;
import ElevatorSimulation.InsideFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonca
 */
public class UpdateDestinies extends TickerBehaviour {

    Destiny destiny = new Destiny();
    

    public UpdateDestinies(Agent a, long period) {
        super(a, period);
        destiny.CurrentDestinies = ((ElevatorAgent) myAgent).myElevInt.destinies();
    }

    @Override
    protected void onTick() {

        ArrayList<Integer> newDestinies = ((ElevatorAgent) myAgent).myElevInt.destinies();
        if (!destiny.CurrentDestinies.equals(newDestinies)) {
            destiny.CurrentDestinies = new ArrayList<>(newDestinies);
        }
        
        //Criar tickerbehaviour em que de tempo a tempo confirma se o arriveposition retorna true e isso significa
        //que o elevador chegou à nova posição muda o valor do currentposition com o valor que estava no currentposition
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        DFAgentDescription[] dfd = DFInteraction.SearchInDF(myAgent, null, "Elevator");
        AID name = dfd[0].getName();
        msg.addReceiver(name);
        try {
            msg.setContent(Serialize.toString(destiny));
        } catch (IOException ex) {
            Logger.getLogger(UpdateDestinies.class.getName()).log(Level.SEVERE, null, ex);
        }

        myAgent.addBehaviour(new SendDestinies(myAgent, msg));
    }
}
