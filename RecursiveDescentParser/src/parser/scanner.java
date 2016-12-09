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
public class scanner { 
    
    private String str;
//    String Reservedwords[]={"if","then","else","repeat","until","read","write"};
    scanner(String S){
    str = S;
    }

//    char[] tochar(){
//        char[] charArray = str.toCharArray();
//        return charArray;
//    }
//    char[] strc = str.toCharArray();
     
    
    boolean isNumber(String str)
{

    for (int i = 0; i < str.toCharArray().length; i++)
	{
		if (!Character.isDigit(str.toCharArray()[i]))
		{
			return false;
		}
	}
    return true;
}
boolean  isWord(String x)
{
	for (int i = 0; i< x.toCharArray().length; i++)
	{
		if (!Character.isLetter(x.toCharArray()[i]))
		{
			return false;
		}
	}
	return true;
}

void get_token (){
    
	int i = 0;
	int state; //state1:start state2:incomment state3:innum state4:inid state5:inassign state6:done
	state = 1;
//        Vector<Character> token = new Vector<>();
        String token = "";
	String type;

	while ((state == 1 || state == 2 || state == 3 || state == 4 || state == 5 || state == 6) && (i < str.toCharArray().length))
	{
		switch (state)
		{
		case 1:
			if (str.toCharArray()[i] == ' ')
			{
				i++;
				state = 1;
			}
			else if (str.toCharArray()[i] == '{')
			{
				i++;
				state = 2;
			}
			else if (Character.isDigit(str.toCharArray()[i]))
			{

				token += (char) str.toCharArray()[i];
				i++;
				state = 3;
			}
			else if (Character.isLetter(str.toCharArray()[i]))
			{
				token += (char) str.toCharArray()[i];
				i++;
				state = 4;
			}
			else if (str.toCharArray()[i] == ':')
			{
				token += (char) str.toCharArray()[i];
				i++;
				state = 5;
			}
			else
			{
				token += (char) str.toCharArray()[i];
				i++;
				state = 6;
			}
			break;
		case 2:
			if (str.toCharArray()[i] == '}')
			{
				state = 1;
				i++;
			}
			else
			{

				state = 2;
				i++;
			}
			break;
		case 3:
			if (Character.isDigit(str.toCharArray()[i]))
			{

				token += (char) str.toCharArray()[i];
				i++;
				state = 3;
			}
			else
			{
				state = 6;
				//i++;
			}
			break;
		case 4:
			if (Character.isLetter(str.toCharArray()[i]))
			{
				token += (char)str.toCharArray()[i];
				i++;
				state = 4;

			}
			else
			{
				state = 6;
				//i++;
			}
			break;
		case 5:
			if (str.toCharArray()[i] == '=')
			{
				token += (char) str.toCharArray()[i];
				i++;
				state = 6;
			}
			else
			{
				i++;
				state = 6;
			}
			break;
		case 6:

			if (token.equals("if"))
			{
				type = "IF";
                                System.out.println(token+"  "+type);
			}
			else if (token.equals("then"))
			{
				type = "THEN";
				System.out.println(token+"  "+type);

			}
			else if (token.equals("else"))
			{
				type = "ELSE";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("end"))
			{
				type = "END";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("repeat"))
			{
				type = "REPEAT";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("until"))
			{
				type = "UNTIL";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("read"))

			{
				type = "READ";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("write"))
			{
				type = "WRITE";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("+"))
			{
				type = "PLUS";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("-"))
			{
				type = "MINUS";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("*"))
			{
				type = "MULTIPLY";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("/"))
			{
				type = "DIVIDE";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("="))
			{
				type = "EQUALS";
				System.out.println(token+"  "+type);
			}
			else if (token.equals(">"))
			{
				type = "GREATER THAN";
				System.out.println(token+"  "+type);
			}
                        else if (token.equals("<"))
			{
				type = "SMALLER THAN";
				System.out.println(token+"  "+type);
			}
                        else if (token.equals(">="))
			{
				type = "GREATER THAN OR EQUAL";
				System.out.println(token+"  "+type);
			}
                        else if (token.equals("<="))
			{
				type = "SMALLER THAN OR EQUAL";
				System.out.println(token+"  "+type);
			}
			else if (token.equals("("))
			{
				type = "LEFT BRACKETS";
				System.out.println(token+"  "+type);
			}
			else if (token.equals(")"))
			{

				type = "RIGHT BRACKETS";
				System.out.println(token+"  "+type);
			}
			else if (token.equals(":="))
			{
				type = "ASSIGN";
				System.out.println(token+"  "+type);
			}
			else if (token.equals(";"))
			{
				type = "SEMI COLON";
				System.out.println(token+"  "+type);
			}
			else if (isWord(token))
			{
				type = "IDENTIFIER";
				System.out.println(token+"  "+type);

			}
			else if (isNumber(token))
			{
				type = "NUMBER";
				System.out.println(token+"  "+type);
			}
			token = "";
			state = 1;
			//i++;
			break;
		}
        }




}
    
    
    
    
    
//    boolean isdigit(char d){return (d>='0' && d<='9');}
//    boolean isletter(char l){return ((l>='a'&& l<='z')||(l>='A'&& l<='Z'));}
//    boolean ispace(char s){return ((s ==' '));}
//    boolean issymbol (char c){return (c=='+'||c=='-'||c=='*'||c=='/'||c=='>'||c=='<'||c=='('||c==')'||c==';');}
}
