/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorAgent;

import java.util.ArrayList;

/**
 *
 * @author gonca
 */
public class Destiny {

    ArrayList<Integer> CurrentDestinies = new ArrayList<>();
    int currentDestiny = 0;

    public Destiny() {
    }

    public ArrayList<Integer> getCurrentDestinies() {
        return CurrentDestinies;
    }

    public int getCurrentDestiny() {
        return currentDestiny;
    }

    public void setCurrentDestinies(ArrayList<Integer> CurrentDestinies) {
        this.CurrentDestinies = CurrentDestinies;
    }

    public void setCurrentDestiny(int currentDestiny) {
        this.currentDestiny = currentDestiny;
    }

}
