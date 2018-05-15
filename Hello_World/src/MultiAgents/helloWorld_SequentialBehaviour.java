/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author Gonçalo
 */

//Create a behaviour constituted by sub behaviours executed in a sequential way
public class helloWorld_SequentialBehaviour extends Agent{
    
    @Override
    protected void setup(){
        SequentialBehaviour sb = new SequentialBehaviour();
        sb.addSubBehaviour(new simpleBeh(this,"SB1"));
        sb.addSubBehaviour(new simpleBeh(this,"SB2"));
        sb.addSubBehaviour(new simpleBeh(this,"SB3"));
        this.addBehaviour(sb);
    }
    
    private class simpleBeh extends SimpleBehaviour{
        
        private boolean finished = false;
        int step = 0;
        String printOut;
        
        public simpleBeh(Agent a, String prtOut){
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
