/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gonçalo
 */
// Service of yellow pages where Agents can identify themselfs and put services
public class helloWorld_DF extends Agent{
    
    @Override
    protected void setup(){
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("tutorial");
        sd.setName(getLocalName());
        dfd.addServices(sd);
        try{
            DFService.register(this, dfd);
        } catch (FIPAException ex){
            Logger.getLogger(helloWorld_DF.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
