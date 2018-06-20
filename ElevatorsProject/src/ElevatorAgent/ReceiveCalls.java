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
public class ReceiveCalls extends AchieveREInitiator {

    public ReceiveCalls(Agent a, ACLMessage msg) {
        super(a, msg);
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        String calls;
        String position = Integer.toString((((ElevatorAgent) myAgent).myElevInt.getPosition()));
        calls = inform.getContent();
        if (!position.equals(calls) && calls != null) {
            int callsInt = Integer.parseInt(calls);
            ((ElevatorAgent) myAgent).destinies.setNextDestiny(callsInt);
            ((ElevatorAgent) myAgent).myElevInt.goToPosition(callsInt);
        }
    }

    @Override
    protected void handleAgree(ACLMessage agree) {

    }
}
