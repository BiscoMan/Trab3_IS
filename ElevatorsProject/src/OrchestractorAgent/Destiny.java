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
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author gonca
 */
public class Destiny implements Serializable {

    Map<String, ArrayList<Integer>> hmap = new HashMap<>();
    Map<String, Integer> hmap_position = new HashMap<>();

    public void setHashMapNames(String LocalName, ArrayList<Integer> Destinies) {
        this.hmap.put(LocalName, Destinies);
    }

    public void setHashMapPosition(String LocalName, int calls) {
        this.hmap_position.put(LocalName, calls);
    }

    public ArrayList getHashMapPostion() {
        ArrayList<Integer> position = new ArrayList<>();

        if (!hmap_position.isEmpty()) {
            for (Entry<String, Integer> i : hmap_position.entrySet()) {
                position.add(i.getValue());
            }
        }

        return position;
    }
}
