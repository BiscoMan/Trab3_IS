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
 * @author Gonçalo
 */
public class ResponderNextDestinyCalls extends AchieveREResponder {

    public ResponderNextDestinyCalls(Agent a, MessageTemplate mt) {
        super(a, mt);
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        try {
            ((OrchestractorAgent) myAgent).destinies.setHashMapPosition(request.getSender().getLocalName(), (int) Serialize.fromString(request.getContent()));
            //System.out.println("Destinies List OA: " + destinies.getCurrentDestinies());
            //System.out.println("Destinies Number OA: " + destinies.getCurrentDestiny());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ResponderNextDestiny.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.AGREE);
        return msg;
    }

    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage responde) throws FailureException {
        ArrayList<Integer> calls = ((OrchestractorAgent) myAgent).myOrchInt.calls();
        int currentPosition = 0;
        block(5000);
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        //System.out.println("Next destiny OA: " + nextDestiny(destinies));
        if (!((OrchestractorAgent) myAgent).destinies.hmap_position.isEmpty()) {
            currentPosition = ((OrchestractorAgent) myAgent).destinies.hmap_position.get(request.getSender().getLocalName());
        }
        int myNumber = currentPosition;
        int theNumber = 0;
        if (!calls.isEmpty()) {
            int distance = Math.abs(calls.get(0) - myNumber);
            int idx = 0;
            for (int c = 1; c < calls.size(); c++) {
                int cdistance = Math.abs(calls.get(c) - myNumber);
                if (cdistance < distance) {
                    idx = c;
                    distance = cdistance;
                }
            }
            theNumber = calls.get(idx);
        }
        msg.setContent(Integer.toString(theNumber));
        ((OrchestractorAgent) myAgent).myOrchInt.removeCall(myNumber);
        return msg;
    }
}
