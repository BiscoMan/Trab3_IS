/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

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
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> test = new ArrayList<>();
        test.add("Andre");
        test.add("Antonio");
        String test2 = Serialize.toString(test);
        ArrayList<String> fromString = (ArrayList<String>) Serialize.fromString(test2);
        System.err.println(fromString);
    }
}
