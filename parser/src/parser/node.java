/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
	
	public boolean isLeaf() 
    {
    if(this.children.size() == 0) 
        return true;
    else 
        return false;
    }
    public node getSibling()
    {
        node x=this.sibling;
        return x;
    }
    public String getData()
    {
        String x=this.data;
        return x;
    }
    public boolean haveSibling()
    {
        if(this.sibling!=null)
            return true;
        else
            return false;
    }
    public ArrayList getChildren()
    {
        ArrayList x =this.children;
        return x;
    }
    public void Traverse(node x)
    {
         node next=new node();
         node nextSibling= new node();
         next=x;
         
        if(next.isLeaf() && !next.haveSibling() )
        {
            System.out.println(next.getData());
        }
        else 
        {
            System.out.println(next.getData());
            if(next.haveSibling()&& next.children.isEmpty())
            {
                nextSibling=next.getSibling();
               
                Traverse(nextSibling);
            }
            else
            {
                for(int i=0; i<next.children.size(); i++)
                {
                node child=next.children.get(i);
                
                Traverse(child);
                if(child.haveSibling())
                {
                    nextSibling=child.getSibling();
                    Traverse(nextSibling);
                    if(nextSibling.haveSibling())
                    {
                        nextSibling=nextSibling.getSibling();
                        Traverse(nextSibling);
                    }
                }
                }
            }
    }
}
}