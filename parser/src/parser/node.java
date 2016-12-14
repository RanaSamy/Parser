package parser;
import java.util.*;
public class node {
	private ArrayList<node> children;
	private String data;
	private String shape;
	private node sibling;

	node()
	{
	    children= new ArrayList<node>();
	}

	node(String data, String shape)
	{
	    children= new ArrayList<node>();
	    this.data= data;
	    this.shape= shape;
	}

	 
	public void addChild(node child)
	{
	    this.children.add(child);   
	}
	public void addSibling(node sibling)
	{
	    this.sibling=sibling;   
	}
	public void print()
	{
	  System.out.println(this.children);
	}


}
