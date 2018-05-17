/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import ElevatorSimulation.HardwareImplementation;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import Common.DFInteraction;

/**
 *
 * @author André
 */
public class ElevatorAgent extends Agent {
    
    protected HardwareImplementation myElevInt = new HardwareImplementation();
    protected float speed;
    protected int upperBound;

    @Override
    protected void setup() {
        DFInteraction.RegisterInDF(this, "EA" , "ElevatorService");
        Object[] arguments = this.getArguments();
        myElevInt.initHardware(this, (float) arguments[0], (int) arguments[1]);
        
        this.addBehaviour(new UpdateDestinies(this,100));
        /*this.addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage receive = myAgent.receive();
                if (receive != null) {
                    myElevInt.goToPosition(Integer.parseInt(receive.getContent()));
                }
            }
        });*/
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
}
