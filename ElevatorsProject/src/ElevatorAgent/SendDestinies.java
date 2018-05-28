/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

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
        if (nextPosition != null) {
            int nextPositionInt = Integer.parseInt(nextPosition);
            ((ElevatorAgent) myAgent).destinies.setNextDestiny(nextPositionInt);
            ((ElevatorAgent) myAgent).myElevInt.goToPosition(nextPositionInt);
        }
    }

    @Override
    protected void handleAgree(ACLMessage agree) {

    }
}
