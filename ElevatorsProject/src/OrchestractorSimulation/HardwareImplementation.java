/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorSimulation;

import OrchestractorAgent.OrchestractorAgent;
import java.util.ArrayList;

/**
 * @author André
 */
public class HardwareImplementation{
    
    OutsideFrame myFrame = new OutsideFrame();

    public ArrayList<Integer> calls() {
        return myFrame.calls;
    }
    
    public void removeCall(int floor){
        myFrame.removeCall(floor);
    }
    
    public boolean initHardware(OrchestractorAgent agent) {
        myFrame.setTitle(agent.getLocalName());
        myFrame.setVisible(true);
        return true;
    }
    
}

            