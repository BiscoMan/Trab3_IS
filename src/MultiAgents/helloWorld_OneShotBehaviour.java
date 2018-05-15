package MultiAgents;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
/**
 *
 * @author gonca
 */
public class helloWorld_OneShotBehaviour extends OneShotBehaviour{
    //Comportamento que´só corre uma vez
    public helloWorld_OneShotBehaviour(Agent a){
        
    }
    public void action(){ 
        System.out.println("OneShotbehaviour: Disparou o behaviour");
    }
}
