/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

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
 * @author Andre Dionisio Rocha
 */
public class DFInteraction {

    //find agent by service or name or both
    static public DFAgentDescription[] SearchInDF(Agent agentOwner, String serviceName, String serviceType) {
        DFAgentDescription[] agents = null;
        DFAgentDescription ad = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        if (serviceType != null) {
            sd.setType(serviceType);
        }
        if (serviceName != null) {
            sd.setName(serviceName);
        }
        ad.addServices(sd);
        try {
            agents = DFService.search(agentOwner, ad);
        } catch (FIPAException ex) {
            agents = null;
            System.out.println(Agent.class.getName() + ">" + ex.getMessage());
        }
        return agents;
    }

    //deregist agent
    static public boolean DeregisterFromDF(Agent agent) {
        return DFInteraction.DeregisterFromDF(agent);
    }

    //regist in df an agent with a service
    static public void RegisterInDF(Agent agentToBeRegistered, String serviceName, String serviceType) {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(agentToBeRegistered.getAID());

        ServiceDescription mySD = new ServiceDescription();
        mySD.setType(serviceType);
        mySD.setName(serviceName);
        dfd.addServices(mySD);

        try {
            DFService.register(agentToBeRegistered, dfd);
        } catch (FIPAException fe) {
            Logger.getLogger(DFInteraction.class.getName()).log(Level.SEVERE,null,fe);
        }
    }   
}
