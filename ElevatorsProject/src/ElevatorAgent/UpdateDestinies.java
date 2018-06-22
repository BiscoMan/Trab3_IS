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
public class UpdateDestinies extends TickerBehaviour {

    public UpdateDestinies(Agent a, long period) {
        super(a, period);
        //destiny.setCurrentDestinies(((ElevatorAgent) myAgent).myElevInt.destinies());
    }

    @Override
    protected void onTick() {

        ArrayList<Integer> newDestinies = ((ElevatorAgent) myAgent).myElevInt.destinies();
        if(newDestinies.isEmpty()){
            ((ElevatorAgent) myAgent).destinies.removeCurrentDestiny();
        }
        /*System.out.println("New Destinies Elevator: " + newDestinies);
        System.out.println("Current Destinies Elevator: " + ((ElevatorAgent) myAgent).destinies.CurrentDestinies);*/
        if (!((ElevatorAgent) myAgent).destinies.CurrentDestinies.equals(newDestinies)) {
            ((ElevatorAgent) myAgent).destinies.setCurrentDestinies(newDestinies);
            ((ElevatorAgent) myAgent).destinies.CurrentDestinies.add(((ElevatorAgent) myAgent).destinies.currentDestiny);
            /*System.out.println("Current Destinies Elevator: " + ((ElevatorAgent) myAgent).destinies.CurrentDestinies);
            System.out.println("Current Destiny Elevator: " + ((ElevatorAgent) myAgent).destinies.currentDestiny);*/
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            DFAgentDescription[] dfd = DFInteraction.SearchInDF(myAgent, "Orchestractor", "Elevator");
            AID name = dfd[0].getName();
            msg.addReceiver(name);
            msg.setOntology("NextDestiny");
            try {
                msg.setContent(Serialize.toString(((ElevatorAgent) myAgent).destinies.CurrentDestinies));
            } catch (IOException ex) {
                Logger.getLogger(UpdateDestinies.class.getName()).log(Level.SEVERE, null, ex);
            }
            myAgent.addBehaviour(new ReceiveDestinies(myAgent, msg));
            ((ElevatorAgent) myAgent).destinies.CurrentDestinies.remove(((ElevatorAgent) myAgent).destinies.CurrentDestinies.size() - 1);
        } else {
            //System.out.println("Não está a entrar no if.");
        }
    }
}
