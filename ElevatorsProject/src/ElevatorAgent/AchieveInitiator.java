/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import Common.DFInteraction;

/**
 *
 * @author gonca
 */
public class AchieveInitiator extends Agent {

    DFAgentDescription[] dfd;
    AID name;
    ACLMessage msg;

    @Override
    protected void setup() {
        msg = new ACLMessage(ACLMessage.REQUEST);
        dfd = DFInteraction.SearchInDF(this, "OA", "Elevator");
        this.addBehaviour(new myBehaviour(this, 1000));
        this.addBehaviour(new initiator(this, msg));
    }

    class myBehaviour extends WakerBehaviour {

        public myBehaviour(Agent a, long timeout) {
            super(a, timeout);
        }

        protected void onMake() {
            if (dfd.length != 0) {
                name = dfd[0].getName();
                msg.addReceiver(name);
                msg.setContent("ola");//perguntar como ir buscar o content
            }
        }
    }

    class initiator extends AchieveREInitiator {

        public initiator(Agent a, ACLMessage msg) {
            super(a, msg);
            send(msg);
        }

        @Override
        protected void handleAgree(ACLMessage agree) {
            
        }

        @Override
        protected void handleInform(ACLMessage inform) {

        }
    }
}
