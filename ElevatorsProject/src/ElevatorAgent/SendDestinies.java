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
import Common.Serialize;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonca
 */
public class SendDestinies extends AchieveREInitiator {

//    class myBehaviour extends WakerBehaviour {
//
//        public myBehaviour(Agent a, long timeout) {
//            super(a, timeout);
//        }
//
//        @Override
//        protected void onWake() {
//            DFAgentDescription[] dfd = DFInteraction.SearchInDF(myAgent, "OA", "Elevator");
//            if (dfd.length != 0) {
//                name = dfd[0].getName();
//                msg.addReceiver(name);
//                msg.setContent("ola");//perguntar como ir buscar o content
//            }
//        }
//    }
    public SendDestinies(Agent a, ACLMessage msg) {
        super(a, msg);
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        String nextPosition;
        nextPosition = inform.getContent();
        ((ElevatorAgent) myAgent).myElevInt.goToPosition(Integer.parseInt(nextPosition));
    }

    @Override
    protected void handleAgree(ACLMessage agree) {

    }
}
