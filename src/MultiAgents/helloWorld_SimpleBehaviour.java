package MultiAgents;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author gonca
 */
public class helloWorld_SimpleBehaviour extends SimpleBehaviour {
    //Comportamento ciclico que neste caso faz a ação 4 vezes
    int step = 0;

    public helloWorld_SimpleBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        System.out.println(step);
        if (step++ == 3) {
            finished = true;
        }
    }
    private boolean finished = false;

    //Método responsável por terminar o behaviour
    @Override
    public boolean done() {
        System.out.println("Terminar o Simple Behaviour");
        return finished;
    }
}
