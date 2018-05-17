package Console;


import ElevatorAgent.ElevatorAgent;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author André
 */
public class ConsoleAgent extends Agent implements frameToAgentCom {
    
    ConsoleFrame myFrame;

    @Override
    protected void setup() {
        myFrame = new ConsoleFrame(this);
        myFrame.setVisible(true);
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean launchNewAgent(String name, float speed, int upperBound) {
        try {
            ElevatorAgent newElevator = new ElevatorAgent();
            newElevator.setArguments(new Object[]{speed,upperBound});
            AgentController agent = this.getContainerController().acceptNewAgent(name, newElevator);
            agent.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
