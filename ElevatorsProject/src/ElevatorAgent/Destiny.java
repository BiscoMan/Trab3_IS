/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gonca
 */
public class Destiny implements Serializable{

    ArrayList<Integer> CurrentDestinies = new ArrayList<>();
    int currentDestiny = 0;
    int nextDestiny = 0;
    
    public ArrayList<Integer> getCurrentDestinies() {
        return CurrentDestinies;
    }

    public int getCurrentDestiny() {
        return currentDestiny;
    }
    
    public int getNextDestiny() {
        return nextDestiny;
    }

    public void setCurrentDestinies(ArrayList<Integer> CurrentDestinies) {
        this.CurrentDestinies = CurrentDestinies;
        System.out.println("Ola");
    }

    public void setCurrentDestiny(int currentDestiny) {
        this.currentDestiny = currentDestiny;
    }
    
     public void setNextDestiny(int nextDestiny) {
        this.nextDestiny = nextDestiny;
    }

}
