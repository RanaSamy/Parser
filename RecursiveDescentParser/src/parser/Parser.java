/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Vector;
import static parser.Parser.stmtTypes.*;



/**
 *
 * @author Doaa,Rana,Dalia
 */
public class Parser {
  private scanner scanner;
  public Parser(scanner scanner) {  
    this.scanner = scanner;  
} 
  /* This program illustrates recursive descent parsing using a 
   pure procedural approach. 
 
   The grammar: 
 
   statement = { expression  ";" } "."   
   expression = term { ( "+" | "-" ) term } 
   term      = factor { ( "*" | "/" ) factor } 
   factor    = number | "(" expression ")" 
     
*/  
 
 
  
  int j=0;
  String token= getstring(j);
  public enum stmtTypes {IF, REPEAT, ASSIGN, READ, WRITE, ERROR};
  public String getstring(int i)
  {              
   Vector<String> vec=scanner.get_token();
      if(i>= 0 || i< vec.size())
      {
           token=vec.get(i);  
      }
      return token;
  }

stmtTypes getStmtType(String s)
{
    s=token;
	if ("IF".equals(s)) return IF;
	if ("IDENTIFIER".equals(s)) return ASSIGN;
	if ("READ".equals(s)) return READ;
	if ("WRITE".equals(s)) return WRITE;
	if ("REPEAT".equals(s)) return REPEAT;
	else return ERROR;
}
void match(String s) 
{
     Vector<String> vec=scanner.get_token();
	if (token.equals(s)) 
	{ 
          /*  for(int i =0; i < vec.size();i++)
            {
                token=vec.get(i);
                System.out.println(token);
            }*/
		//System.out.println("doesn't match");
	}
        else{
            
            System.out.println("doesn't match");
        }
        
	
}
  void stmt_seq()
{
	stmt();
	while (";".equals(token)) 
	{
		match(";");
		stmt();
	}
}
  void stmt() 
{
	switch (getStmtType(token))
	{
	case IF:
		if_stmt(); break;
	case REPEAT:
		repeat_stmt(); break;
	case ASSIGN:
		assign_stmt(); break;
	case READ: 
		read_stmt(); break;
	case WRITE:
		write_stmt(); break;
	case ERROR:
		System.out.println("Statement not found");  break;
	default:
		break;
	}
}
  void if_stmt() 
{
	match("IF");
	exp();
	match("THEN");
	stmt_seq();
	if ("ELSE".equals(token)) stmt_seq();
	match("END");
	System.out.println( "- if statement found");
}
  void repeat_stmt() 
{
	match("REPEAT");
	stmt_seq();
	match("UNTIL");
	exp();
	System.out.println("- repeat found");
}
  void assign_stmt() 
{
	match("IDENTIFIER");
	match(":=");
	exp();
	System.out.println("- assignment found");
}
void read_stmt() 
{
	match("READ");
	match("IDENTIFIER");
	System.out.println("- read found");
}
void write_stmt() 
{
	match("WRITE");
	exp();
	System.out.println("- write found" );
}
void exp() 
{
	simple_exp();
	if ("<".equals(token) || "=".equals(token)) 
	{
		comparison_op();
		simple_exp();
	}
}
void comparison_op() 
{
	if ("<".equals(token)) match("<");
	if ("=".equals(token)) match("=");
}
void simple_exp() 
{
	term();
	while ("+".equals(token) || "-".equals(token)) {
		addop();
		term();
	}
}
void addop() 
{
	if ("+".equals(token)) match("+");
	if ("-".equals(token)) match("-");
}
void term() 
{
	factor();
	while ("*".equals(token) || "/".equals(token)) 
	{
		mulop();
		factor();
	}
}
void mulop() 
{
	if ("*".equals(token)) match("*");
	if ("/".equals(token)) match("/");
}
void factor() 
{
	if ("(".equals(token)) 
	{ 
		match("(");
		exp();
		match(")");
	}
	else if ("NUMBER".equals(token)) 
	{
		match("NUMBER");
	}
	else if ("IDENTIFIER".equals(token)) 
	{
		match("IDENTIFIER");
	}
}

void program()
{
	stmt_seq();
	System.out.println("-- Program found" );
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        scanner F = new scanner("read x;" +
         "if  0 <= x then x := 1 ");
        F.get_token();
        System.out.println("..........parser output .........");
        Parser p = new Parser(F);
        p.program();
        
    }
    
}
