/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import Common.DFInteraction;
import Common.Serialize;
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
public class ElevatorPosition extends TickerBehaviour {

    public ElevatorPosition(Agent a, long period) {
        super(a, period);
        //destiny.setCurrentDestinies(((ElevatorAgent) myAgent).myElevInt.destinies());
    }

    @Override
    protected void onTick() {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        DFAgentDescription[] dfd = DFInteraction.SearchInDF(myAgent, "Orchestractor", "Elevator");
        AID name = dfd[0].getName();
        msg.addReceiver(name);
        msg.setOntology("ElevPosition");
        try {
            msg.setContent(Serialize.toString(((ElevatorAgent) myAgent).myElevInt.getPosition()));
        } catch (IOException ex) {
            Logger.getLogger(UpdateDestinies.class.getName()).log(Level.SEVERE, null, ex);
        }
        myAgent.addBehaviour(new ReceiveCalls(myAgent, msg));
    }
}
