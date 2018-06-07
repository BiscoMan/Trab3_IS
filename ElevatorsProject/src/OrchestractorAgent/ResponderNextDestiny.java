/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

import Common.Serialize;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class ResponderNextDestiny extends AchieveREResponder {

    public ResponderNextDestiny(Agent a, MessageTemplate mt) {
        super(a, mt);
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        System.out.println(myAgent.getLocalName() + ": Processing REQUEST message");
        try {
            ((OrchestractorAgent) myAgent).destinies.setCurrentDestinies((ArrayList<Integer>) Serialize.fromString(request.getContent()));
            if (!((OrchestractorAgent) myAgent).destinies.CurrentDestinies.isEmpty()) {
                 ((OrchestractorAgent) myAgent).destinies.setCurrentDestiny(((OrchestractorAgent) myAgent).destinies.CurrentDestinies.get(((OrchestractorAgent) myAgent).destinies.CurrentDestinies.size() - 1));
                 ((OrchestractorAgent) myAgent).destinies.CurrentDestinies.remove(((OrchestractorAgent) myAgent).destinies.CurrentDestinies.size() - 1);
            }
            //System.out.println("Destinies List OA: " + destinies.getCurrentDestinies());
            //System.out.println("Destinies Number OA: " + destinies.getCurrentDestiny());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ResponderNextDestiny.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.AGREE);
        return msg;
    }

    @Override
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException {
        System.out.println(myAgent.getLocalName() + ": Preparing result of REQUEST");
        block(5000);
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        //System.out.println("Next destiny OA: " + nextDestiny(destinies));
        int myNumber = ((OrchestractorAgent) myAgent).destinies.getCurrentDestiny();
        int theNumber = 0;
        ArrayList<Integer> calls = ((OrchestractorAgent) myAgent).myOrchInt.calls();
        ArrayList<Integer> Destinies = ((OrchestractorAgent) myAgent).destinies.getCurrentDestinies();
        Destinies.addAll(calls);
        if (!((OrchestractorAgent) myAgent).destinies.CurrentDestinies.isEmpty()) {
            int distance = Math.abs(((OrchestractorAgent) myAgent).destinies.getCurrentDestinies().get(0) - myNumber);
            int idx = 0;
            for (int c = 1; c < Destinies.size(); c++) {
                int cdistance = Math.abs(Destinies.get(c) - myNumber);
                if (cdistance < distance) {
                    idx = c;
                    distance = cdistance;
                }
            }
            theNumber = Destinies.get(idx);
        }
        msg.setContent(Integer.toString(theNumber));
        return msg;
    }
}
