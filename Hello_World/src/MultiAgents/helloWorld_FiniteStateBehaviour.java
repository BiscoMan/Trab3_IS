/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiAgents;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author Gonçalo
 */
//State machine
public class helloWorld_FiniteStateBehaviour extends Agent{
    
    @Override
    protected void setup(){
        FSMBehaviour fsmb = new FSMBehaviour();
        fsmb.registerFirstState(new simpleBeh(this, "A"),"St_A");
        fsmb.registerState(new simpleBeh(this,"B"), "St_B");
        fsmb.registerState(new simpleBeh(this,"C"),"St_C");
        fsmb.registerLastState(new simpleBeh(this,"D"), "St_D");
        fsmb.registerTransition("St_A", "St_B", 0);
        fsmb.registerTransition("St_B", "St_C", 1);
        fsmb.registerTransition("St_C","St_D",2);
        addBehaviour(fsmb);
    }
    
    private class simpleBeh extends SimpleBehaviour{
        
        private boolean finished = false;
        int step = 0;
        String currentState;
        
        public simpleBeh (Agent a, String crtSta){
            super(a);
            this.currentState = crtSta;
        }
        
        @Override
        public void action(){
            System.out.println("SimpleBehaviour: SubBehaviour: " + currentState + " - step: " + ++step);
            if(step == 3){
                finished = true;
            }
        }
        
        @Override
        public boolean done(){
            return finished;
        }
        
        @Override
        public int onEnd(){
            switch(currentState){
                case "A": return 0;
                case "B": return 1;
                case "C": return 2;
            } return -1;
        }
    }
}
