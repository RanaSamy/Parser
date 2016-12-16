
package parser;
import java.util.*;
public class Parser {
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
  node program()
{
    node tempo= new node();
   tempo=stmt_seq();
  
   return tempo;
}
  node stmt_seq()
  {
      node tempo= new node();
      
      tempo=stmt();
      node newtempo = tempo;
      while(token.equals(";"))
      {
          match(";");
          node next = stmt();
          newtempo.addSibling(next);
          newtempo = next;
          
      }
      return tempo;
  }
    node stmt()
  {
      node tempo= new node();
      if(token.equals("IF"))
      {
          tempo=if_stmt();
      }
     else if(token.equals("REPEAT"))
      {
          tempo=repeat_stmt();
      }
     else if (token.equals("IDENTIFIER"))
      {
          tempo=assign_stmt();
      }
     else if (token.equals("READ"))
      {
          tempo=read_stmt();
      }
     else if (token.equals("WRITE"))
      {
          tempo=write_stmt();
      }
      return tempo;
  }
    node if_stmt()
  {
      match("IF");
      node tempo= new node("IF","square");
      tempo.addChild(expression());
      match("THEN");
      tempo.addChild(stmt_seq());
      if(token.equals("ELSE"))
      {
          match("ELSE");
          tempo.addChild(stmt_seq());
      }
      match("END");
      System.out.println("IF found");
      return tempo;
  }
  
  node repeat_stmt()
  {
      match("REPEAT");
      node tempo= new node("REPEAT", "square");
      tempo.addChild(stmt_seq());
      match("UNTIL");
      tempo.addChild(expression());
      System.out.println("repeat found");
      return tempo;
  }
  
  node assign_stmt()
  {
      match("IDENTIFIER");
      match(":=");
      node tempo= new node("ASSIGN", "square");
      tempo.addChild(expression());
      System.out.println("assign found");
      return tempo; 
  }
  
  node read_stmt()
  {
      match("READ");
      node tempo= new node("READ "+token,"square");
      match("IDENTIFIER");
      
      System.out.println("read found");
      return tempo;
  }
  
  node write_stmt()
  {
      match("WRITE");
      node tempo= new node("WRITE", "square");
      tempo.addChild(expression());
      System.out.println("write found");
      return tempo;
  }
 
  node expression()
  {
      node tempo= simple_exp();
      if(token.equals("<")|| token.equals("="))
      {
    	  
          node newtempo=compop();
          newtempo.addChild(tempo);
          newtempo.addChild(simple_exp());
          tempo = newtempo;
      }
      return tempo;
  }
  node compop()
  {
      if(token.equals("<")||token.equals("="))
      {
          node tempo= new node(token, "circle");
          match(token);
          return tempo;
      }
      //else System.out.println("Error in comop");
    return null;
  }
     
  node simple_exp()
  {
      node tempo= term();
     while (token.equals("+")|| token.equals("-"))
     {
    	 node newtempo=addop();
         newtempo.addChild(tempo);
         newtempo.addChild(term());
         tempo = newtempo;
     }
     return tempo;
  }
  node addop()
  {
      
      if(token.equals("+")||token.equals("-"))
      {
    	  node tempo= new node(token, "circle");
          match(token);
          return tempo;
          
      }
      return null;
      //else System.out.println("Error in addop");
  }
  
  
  node term()
  {
      node tempo = factor();
      while(token.equals("*")||token.equals("/"))
      {
    	  node newtempo=mulop();
          newtempo.addChild(tempo);
          newtempo.addChild(factor());
          tempo = newtempo;          
      }
      return tempo;
  }
  
  
  node mulop()
  {
      if(token.equals("*")||token.equals("/"))
      {
    	  node tempo= new node(token, "circle");
          match(token);
          return tempo;
      }
      //else System.out.println("Error in mulop");
      return null;
  }
  
  node factor(){
     node tempo = new node(); 
  if(token.equals("("))
  {
      
      match("(");
      tempo=expression();
      match(")");
  }
  
  else if (token.equals("NUMBER"))
  {
      match("NUMBER");
      tempo=new node("NUMBER","circle");
      
  }
  else if (token.equals("IDENTIFIER"))
  {
      match("IDENTIFIER");
      tempo=new node("IDENTIFIER","circle");
  }
  //else System.out.println("Error in factor");
  return tempo;
  }
  



  
    public static void main(scanner F) {
        
          // TODO code application logic here
          
// Vector <String> temp= new Vector<String>();
//        scanner F = new scanner("{ Sample program in TINY language – computes factorial} read x;   {input an integer } if  0 < x   then     {  don’t compute if x <= 0 } fact:=1; repeat fact:= fact*x; x:= x - 1 until x  =  0; write  fact;   {  output  factorial of x } end   ");
//        //scanner F = new scanner(" fact  := 1; read x;  repeat fact  := fact *  x;x  := x  -  1;until  x  =  0;write  fact   {  output  factorial of x } ");
//        F.get_token();
//       temp= F.get_token();
//         
//  for(String s: temp){System.out.println(s); }
////      
         Parser P = new Parser(F);
            P.init();
          node tree =  P.program();
          System.out.println("finish");
          tree.Traverse(tree); 
            
            

         
   }
}


