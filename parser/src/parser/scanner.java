package parser;
import java.util.*;
public class scanner {
	 
    private String str;
    scanner(String S){
    str = S;
    }
     
    
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

Vector get_token (){
    
	int i = 0;
	int state; //state1:start state2:incomment state3:innum state4:inid state5:inassign state6:done
	state = 1;
        String token = "";
	String type = "";
        Vector<String> vctr= new Vector<String>();

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
//                                System.out.println(token+"  "+type);
			}
			else if (token.equals("then"))
			{
				type = "THEN";
//				System.out.println(token+"  "+type);

			}
			else if (token.equals("else"))
			{
				type = "ELSE";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("end"))
			{
				type = "END";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("repeat"))
			{
				type = "REPEAT";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("until"))
			{
				type = "UNTIL";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("read"))

			{
				type = "READ";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("write"))
			{
				type = "WRITE";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("+"))
			{
				type = "+";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("-"))
			{
				type = "-";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("*"))
			{
				type = "*";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("/"))
			{
				type = "/";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals("="))
			{
				type = "=";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals(">"))
			{
				type = ">";
//				System.out.println(token+"  "+type);
			}
                        else if (token.equals("<"))
			{
				type = "<";
//				System.out.println(token+"  "+type);
			}
//                      
			else if (token.equals("("))
			{
				type = "(";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals(")"))
			{

				type = ")";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals(":="))
			{
				type = ":=";
//				System.out.println(token+"  "+type);
			}
			else if (token.equals(";"))
			{
				type = ";";
//				System.out.println(token+"  "+type);
			}
			else if (isWord(token))
			{
				type = "IDENTIFIER";
//				System.out.println(token+"  "+type);

			}
			else if (isNumber(token))
			{
				type = "NUMBER";
//				System.out.println(token+"  "+type);
			}
                        vctr.add(type);
			token = "";
                        type = "";
			state = 1;
			break;
		}
                
        }

return vctr;


}
    
    
    

}
