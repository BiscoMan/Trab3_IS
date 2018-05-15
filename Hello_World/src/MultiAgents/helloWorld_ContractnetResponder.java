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
import jade.proto.ContractNetResponder;
/**
 *
 * @author Gonçalo
 */
public class helloWorld_ContractnetResponder extends Agent {
    
    @Override
    protected void setup(){
        this.addBehaviour(new responder(this, MessageTemplate.MatchPerformative(ACLMessage.CFP)));
    }
    
    private class responder extends ContractNetResponder{
        
        public responder(Agent a, MessageTemplate mt){
            super(a,mt);
        }
        
        @Override
        protected ACLMessage handleCfp(ACLMessage cfp) throws RefuseException, FailureException, NotUnderstoodException{
            System.out.println(myAgent.getLocalName() + ": Processing CFP message");
            ACLMessage msg = cfp.createReply();
            msg.setPerformative(ACLMessage.PROPOSE);
            msg.setContent("My Proposal value");
            return msg;
        }
        
        @Override
        protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException{
            System.out.println(myAgent.getLocalName()+ ": Preparing result of CFP");
            block(5000);
            ACLMessage msg = cfp.createReply();
            msg.setPerformative(ACLMessage.INFORM);
            return msg;
        }
    }
}
