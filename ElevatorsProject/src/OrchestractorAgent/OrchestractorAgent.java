/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

import Common.DFInteraction;
import OrchestractorSimulation.HardwareImplementation;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import static jade.lang.acl.MessageTemplate.MatchPerformative;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class OrchestractorAgent extends Agent {

    protected HardwareImplementation myOrchInt = new HardwareImplementation();
    protected Destiny destinies = new Destiny();
    protected ArrayList<String> calls;

    @Override
    protected void setup() {
        myOrchInt.initHardware(this);
        DFInteraction.RegisterInDF(this, this.getLocalName(), "Elevator");
        this.addBehaviour(new ResponderNextDestiny(this, MessageTemplate.and(MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("NextDestiny"))));
        this.addBehaviour(new ResponderNextDestinyCalls(this, MessageTemplate.and(MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ElevPosition"))));
    }

    @Override
    protected void takeDown() {

    }

}
