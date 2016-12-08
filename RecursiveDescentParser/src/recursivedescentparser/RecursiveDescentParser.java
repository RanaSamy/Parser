/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedescentparser;

import java.io.DataInputStream;

/**
 *
 * @author M
 */
public class RecursiveDescentParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Parser parser = new Parser(new Scanner(  
    new DataInputStream(System.in)));  
    parser.run( );  
    System.out.println("done");  
    }
    
}
