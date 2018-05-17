/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import Common.DFInteraction;

/**
 *
 * @author gonca
 */
public class AchieveInitiator extends Agent{
    DFAgentDescription[] dfd;
    
    @Override
    protected void setup(){
        AID name;
        ACLMessage msg = new ACLMessage (ACLMessage.REQUEST);
        dfd = DFInteraction.SearchInDF(this, "OA", "Elevator");
        
        //Fazer um waker behaviour para ver se há alguém
        if(dfd.length != 0){
            name = dfd[0].getName();
            msg.addReceiver(name);
        }
    }
    
}
