/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
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
// Example where a One shot behaviour searches and prints  the DF agents with the service "tutorial"
public class helloWorld_DFExample extends Agent{
    
    @Override
    protected void setup(){
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("tutorial");
        sd.setName(getLocalName());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException ex){
            Logger.getLogger(helloWorld_DFExample.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private class serachInDF extends OneShotBehaviour{
        
        @Override
        public void action(){
            DFAgentDescription dfd = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("tutorial");
            dfd.addServices(sd);
            DFAgentDescription[] result = null;
            try{
                result = DFService.search(myAgent, dfd);
            } catch(FIPAException ex){
                Logger.getLogger(helloWorld_DFExample.class.getName()).log(Level.SEVERE,null,ex);
            }
            System.out.println(result[0].getName());
        }
    }   
}
