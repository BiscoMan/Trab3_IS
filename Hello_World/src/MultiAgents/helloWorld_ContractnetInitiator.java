/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
import java.util.Vector;

/**
 *
 * @author Gonçalo
 */

// Used to initialize a previous negotiation before the execution
public class helloWorld_ContractnetInitiator extends Agent {
    
    @Override
    protected void setup(){
        ACLMessage msg = new ACLMessage (ACLMessage.CFP);
        msg.addReceiver(new AID("responder",false));
        this.addBehaviour(new initiator(this,msg));
    }
    
    private class initiator extends ContractNetInitiator{
    
        public initiator(Agent a, ACLMessage msg){
            super(a,msg);
        }
        
        @Override
        protected void handleInform(ACLMessage inform){
            System.out.println(myAgent.getLocalName() + ": INFORM message received");
        }
        
        @Override
        protected void handleAllResponses(Vector responses, Vector acceptances){
            System.out.println(myAgent.getLocalName() + ": All PROPOSALS received");
            ACLMessage auxMsg = (ACLMessage) responses.get(0);
            ACLMessage reply = auxMsg.createReply();
            reply.setPerformative (ACLMessage.ACCEPT_PROPOSAL);
            acceptances.add(reply);
        }
    }
}
