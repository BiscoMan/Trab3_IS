/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import ElevatorAgent.Destiny;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Andre Rocha
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
      =* @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(6);
        Destiny testDestiny = new Destiny();
        testDestiny.setCurrentDestiny(89);
        testDestiny.setCurrentDestinies(test);
        String test2 = Serialize.toString(testDestiny);
        Destiny fromString = (Destiny) Serialize.fromString(test2);
        System.err.println(fromString);
    }
}
