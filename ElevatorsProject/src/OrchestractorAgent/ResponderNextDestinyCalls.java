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
    
    public ResponderNextDestinyCalls(Agent a, MessageTemplate mt){
        super(a,mt);
    }
    
    @Override
    protected ACLMessage handleRequest (ACLMessage request) throws NotUnderstoodException, RefuseException{
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.AGREE);
        return msg;
    }
    
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage responde) throws FailureException{
        ArrayList<Integer> calls = ((OrchestractorAgent) myAgent).myOrchInt.calls();
        int nextDestiny = 0;
        block(5000);
        ACLMessage msg = request.createReply();
        nextDestiny = calls.get(0);
        msg.setContent((Integer.toString(nextDestiny)));
        return msg;
    }
}