/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

/**
 *
 * @author gonca
 */
    
// Used when an agent wants to communicate point-by-point

public class helloWorld_InitiatorProtocolAgent extends Agent {
    
    @Override
    protected void setup() {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("responder", false));
        this.addBehaviour(new initiator(this, msg));
    }

    private class initiator extends AchieveREInitiator {

        public initiator(Agent a, ACLMessage msg) {
            super(a, msg);
        }

        @Override
        protected void handleAgree(ACLMessage agree) {
            System.out.println(myAgent.getLocalName() + ": AGREE message received");
        }

        @Override
        protected void handleInform(ACLMessage inform) {
            System.out.println(myAgent.getLocalName() + ": INFORM message received");
        }
    }
}
