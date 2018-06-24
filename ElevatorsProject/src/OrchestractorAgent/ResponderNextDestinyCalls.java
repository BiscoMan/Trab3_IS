/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

import Common.DFInteraction;
import Common.Serialize;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map.Entry;

/**
 *
 * @author Gonçalo
 */
public class ResponderNextDestinyCalls extends AchieveREResponder {

    public ResponderNextDestinyCalls(Agent a, MessageTemplate mt) {
        super(a, mt);
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        try {
            ((OrchestractorAgent) myAgent).destinies.setHashMapPosition(request.getSender().getLocalName(), (int) Serialize.fromString(request.getContent()));
            //System.out.println("Destinies List OA: " + destinies.getCurrentDestinies());
            //System.out.println("Destinies Number OA: " + destinies.getCurrentDestiny());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ResponderNextDestiny.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.AGREE);
        return msg;
    }

    @Override
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage responde) throws FailureException {
        ArrayList<Integer> calls = ((OrchestractorAgent) myAgent).myOrchInt.calls();
        int myNumber = 0;
        int distance = 0;
        int j = 0;
        int lower_distance = 0;
        AID name = null;
        String elev_name;
        block(5000);
        ACLMessage msg = request.createReply();
        msg.setPerformative(ACLMessage.INFORM);
        //System.out.println("Next destiny OA: " + nextDestiny(destinies));
        if (!((OrchestractorAgent) myAgent).destinies.hmap_position.isEmpty()) {
            for (Entry<String, Integer> i : ((OrchestractorAgent) myAgent).destinies.hmap_position.entrySet()) {
                myNumber = i.getValue();
                elev_name = i.getKey();
                if (!calls.isEmpty()) {
                    if (j == 0) {
                        lower_distance = Math.abs(calls.get(0) - myNumber);
                        j++;
                    }
                    distance = Math.abs(calls.get(0) - myNumber);
                }
                if (distance < lower_distance) {
                    elev_name = i.getKey();
                    System.out.println("elev name: " + elev_name);
                    DFAgentDescription[] dfd = DFInteraction.SearchInDF(myAgent, elev_name, "ElevatorService");
                    name = dfd[0].getName();
                    msg.addReceiver(name);
                }
            }
            if (!calls.isEmpty()) {
                msg.setContent(Integer.toString(calls.get(0)));
                ((OrchestractorAgent) myAgent).myOrchInt.removeCall(myNumber);
            }
        }
        return msg;
    }
}
