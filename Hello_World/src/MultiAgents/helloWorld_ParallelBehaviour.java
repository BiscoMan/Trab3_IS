/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SimpleBehaviour;
/**
 *
 * @author Gonçalo
 */
//Behaviours that runs in parallel. Ends when all or one sub behaviour ends
public class helloWorld_ParallelBehaviour extends Agent {
    
    @Override
    protected void setup(){
        ParallelBehaviour pb = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
        pb.addSubBehaviour(new simpleBeh(this, "SB1"));
        pb.addSubBehaviour(new simpleBeh(this, "SB2"));
        pb.addSubBehaviour(new simpleBeh(this, "SB3"));
        this.addBehaviour(pb);
    }
    
    private class simpleBeh extends SimpleBehaviour {
        
        private boolean finished = false;
        int step = 0;
        String printOut;
        
        public simpleBeh (Agent a, String prtOut){
            super(a);
            this.printOut = prtOut;
        }
        
        @Override
        public void action(){
            System.out.println("SimpleBehaviour: SubBehaviour: " + printOut + " - step: " + ++step);
            if(step == 3){
                finished = true;
            }
        }
        
        @Override
        public boolean done(){
            return finished;
        }
    }
    
}
