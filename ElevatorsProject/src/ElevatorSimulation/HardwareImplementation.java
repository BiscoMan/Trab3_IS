/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorSimulation;

import ElevatorAgent.ElevatorAgent;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.util.ArrayList;

/**
 * @author André
 */
public class HardwareImplementation {

    InsideFrame myFrame;

    public boolean arrivePosition(int position) {
        if (myFrame.currentPosition == position && myFrame.stoped) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> destinies() {
        return myFrame.myDestinies;
    }

    public boolean goToPosition(int position) {
        return myFrame.goToNewPosition(position);
    }

    public int getPosition() {
        return myFrame.currentPosition;
    }

    public boolean initHardware(ElevatorAgent agent, float speed, int upperBound) {
        myFrame = new InsideFrame(upperBound);
        myFrame.setTitle(agent.getLocalName());
        myFrame.setVisible(true);
        agent.addBehaviour(new SimulateElevator(agent, (long) (1000 / speed), myFrame));
        return true;
    }

    private static class SimulateElevator extends TickerBehaviour {

        InsideFrame myFrame;

        public SimulateElevator(Agent a, long period, InsideFrame myFrame) {
            super(a, period);
            this.myFrame = myFrame;
        }

        @Override
        protected void onTick() {
            myFrame.updateState();
        }
    }
}
