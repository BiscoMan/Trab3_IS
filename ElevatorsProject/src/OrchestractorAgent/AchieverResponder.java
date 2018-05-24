/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

import Common.Serialize;
import OrchestractorSimulation.HardwareImplementation;
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
public class AchieverResponder extends AchieveREResponder {

    
    protected HardwareImplementation myOrchInt = new HardwareImplementation();
    
    protected class destinies{
        ArrayList<Integer> destinies;
        int currentPosition;
    }
    destinies destinies = new destinies();
     
    public AchieverResponder(Agent a, MessageTemplate mt) {
        super(a, mt);
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        System.out.println(myAgent.getLocalName() + ": Processing REQUEST message");
        try {
            destinies = (destinies)Serialize.fromString(request.getContent());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AchieverResponder.class.getName()).log(Level.SEVERE, null, ex);
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
        msg.setContent(Integer.toString(nextDestiny(destinies)));
        return msg;
    }
    
    public int nextDestiny(destinies destinies) {
        int myNumber = destinies.currentPosition;
        ArrayList<Integer> calls = myOrchInt.calls();
        ArrayList<Integer> Destinies = destinies.destinies;
        Destinies.addAll(calls);
        int distance = Math.abs(destinies.destinies.get(0) - myNumber);
        int idx = 0;
        for (int c = 1; c < Destinies.size(); c++) {
            int cdistance = Math.abs(Destinies.get(c) - myNumber);
            if (cdistance < distance) {
                idx = c;
                distance = cdistance;
            }
        }
        int theNumber = Destinies.get(idx);

        return theNumber;
    }
}