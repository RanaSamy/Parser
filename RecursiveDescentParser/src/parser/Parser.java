/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Doaa
 */
public class Parser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        scanner F = new scanner("{ Sample program in TINY language – computes factorial\n" +
"    }\n" +
"     read x;   {input an integer }\n" +
"     if  0 < x   then     {  don’t compute if x <= 0 }\n" +
"        fact  := 1;\n" +
"        repeat \n" +
"           fact  := fact *  x;\n" +
"            x  := x  -  1\n" +
"        until  x  =  0;\n" +
"        write  fact   {  output  factorial of x }\n" +
"     end  ");
        F.get_token();
        
    }
    
}
