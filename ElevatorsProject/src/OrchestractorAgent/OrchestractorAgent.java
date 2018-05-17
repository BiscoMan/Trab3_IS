/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

import OrchestractorSimulation.HardwareImplementation;
import jade.core.Agent;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class OrchestractorAgent extends Agent{
    
    protected HardwareImplementation myOrchInt = new HardwareImplementation();
    protected ArrayList<String> calls;

    @Override
    protected void setup() {
        myOrchInt.initHardware(this);
    }

    @Override
    protected void takeDown() {
        
    }
    
}
