/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrchestractorAgent;

/**
 *
 * @author gonca
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author gonca
 */
public class Destiny implements Serializable{
    
    HashMap<String, ArrayList> hmap = new HashMap<>();
    
    public void setHashMapNames(String LocalName, ArrayList<Integer> Destinies){
        this.hmap.put(LocalName, Destinies);
    }

}

