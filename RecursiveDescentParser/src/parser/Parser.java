/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;
import java.util.*;
/**
 *
 * @author Doaa
 */
public class Parser {   /**
     * @param args the command line arguments
     */ 
    private scanner s;
    public Parser(scanner scanner) {  
      s = scanner;
    } 
    
    
    Vector <String> temp= new Vector<String>();
    Vector initv(){
        temp = s.get_token();
        return temp;
    }
    
    
    

    
    
  int i=0;
 
  String token;
  
 String init(){
     initv();
 token= temp.get(i);
 return token;
 }
 
 void error(){System.out.println("Error");}
         
         
 void match(String s)
 {
     if(s.equals(token))
     {
        if(i!=(temp.size()-1)){i++;}
        token = temp.get(i);
     }
     else 
       System.out.println("Error in match");
 }
  void program()
{
   stmt_seq(); 
}
  void stmt_seq()
  {
      stmt();
      while(token.equals(";"))
      {
          match(";");
          stmt();
      }
  }
    void stmt()
  {
      if(token.equals("IF"))
      {
          if_stmt();
      }
     else if(token.equals("REPEAT"))
      {
          repeat_stmt();
      }
     else if (token.equals("IDENTIFIER"))
      {
          assign_stmt();
      }
     else if (token.equals("READ"))
      {
          read_stmt();
      }
     else if (token.equals("WRITE"))
      {
          write_stmt();
      }
      
  }
    void if_stmt()
  {
      match("IF");
      expression();
      match("THEN");
      stmt_seq();
      if(token.equals("ELSE"))
      {
          stmt_seq();
      }
      match("END");
      System.out.println("IF found");
  }
  
  void repeat_stmt()
  {
      match("REPEAT");
      stmt_seq();
      match("UNTIL");
      expression();
      System.out.println("repeat found");
      
  }
  
  void assign_stmt()
  {
      match("IDENTIFIER");
      match(":=");
      expression();
      System.out.println("assign found");
  }
  
  void read_stmt()
  {
      match("READ");
      match("IDENTIFIER");
      System.out.println("read found");
  }
  
  void write_stmt()
  {
      match("WRITE");
      expression();
      System.out.println("write found");
  }
 
   void expression()
  {
      simple_exp();
      if(token.equals("<")|| token.equals("="))
      {
          compop();
          simple_exp();
      }
  }
     void compop()
  {
      if(token.equals("<")||token.equals("="))
      {
          match(token);
      }
      //else System.out.println("Error in comop");
  }
     
  void simple_exp()
  {
     term();
     while (token.equals("+")|| token.equals("-"))
     {
         addop();
         term();
     }
  }
  void addop()
  {
      if(token.equals("+")||token.equals("-"))
      {
          match(token);
      }
      //else System.out.println("Error in addop");
  }
  
  
   void term()
  {
      factor();
      while(token.equals("*")||token.equals("/"))
      {
          mulop();
          term();
      }
      
  }
  
  
  void mulop()
  {
      if(token.equals("*")||token.equals("/"))
      {
          match(token);
      }
      //else System.out.println("Error in mulop");
  }
  
void factor(){
  if(token.equals("("))
  {
      match("(");
      expression();
      match(")");
  }
  
  else if (token.equals("NUMBER"))
  {
      match("NUMBER");
  }
  else if (token.equals("IDENTIFIER"))
  {
      match("IDENTIFIER");
  }
  //else System.out.println("Error in factor");
  }
  



  
    public static void main(String[] args) {
        
          // TODO code application logic here
          
 Vector <String> temp= new Vector<String>();
        scanner F = new scanner("{ Sample program in TINY language – computes factorial} read x;   {input an integer } if  0 < x   then     {  don’t compute if x <= 0 } fact:=1; repeat fact:= fact*x; x:= x-1; until x  =  0; write  fact;   {  output  factorial of x } end   ");
        //scanner F = new scanner(" fact  := 1; read x;  repeat fact  := fact *  x;x  := x  -  1;until  x  =  0;write  fact   {  output  factorial of x } ");
        F.get_token();
       temp= F.get_token();
         
  for(String s: temp){System.out.println(s); }
//      
         Parser P = new Parser(F);
            P.init();
            P.program();

         
   }
    
}
