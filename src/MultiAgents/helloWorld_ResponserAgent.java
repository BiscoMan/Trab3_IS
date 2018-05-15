/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;

/**
 *
 * @author gonca
 */
public class helloWorld_ResponserAgent extends Agent {
    @Override
    protected void setup(){
        this.addBehaviour(new responder(this,MessageTemplate.MatchPerformative(ACLMessage.REQUEST)));
    }
    
    private class responder extends AchieveREResponder{
        public responder(Agent a, MessageTemplate mt){
            super(a,mt);
        }
        
        @Override
        protected ACLMessage handleRequest (ACLMessage request) throws NotUnderstoodException, RefuseException{
            System.out.println(myAgent.getLocalName() + " processing REQUEST message");
            ACLMessage msg = request.createReply();
            msg.setPerformative(ACLMessage.AGREE);
            return msg;
        }
        
        @Override
        protected ACLMessage prepareResultNotification(ACLMessage request,ACLMessage response) throws FailureException{
            System.out.println(myAgent.getLocalName() + ": Preparing result of REQUEST");
            block(5000);
            ACLMessage msg = request.createReply();
            msg.setPerformative(ACLMessage.INFORM);
            return msg;
        }
    }   
}
