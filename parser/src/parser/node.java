package parser;
import java.io.PrintWriter;
import java.util.*;
public class node {
	
	private ArrayList<node> children;
	private String data;
	private String shape;
	private node sibling;
       
private	int index;
private       int childindex;
public        int rank;
        Vector<String> vec=new Vector<String>(0);
        
        

	node()
	{
	    children= new ArrayList<node>();
	}

	node(String data, String shape,int index)
	{
	    children= new ArrayList<node>();
	    this.data= data;
	    this.shape= shape;
	    this.index=index;
	}

	 
	public void addChild(node child)
	{
	    this.children.add(child);   
	}
	public void addSibling(node sibling)
	{
	    this.sibling=sibling;   
	}
	public String getshape()
	{
		return shape;
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
        public void setChild()
        {
            this.childindex++;
        }
        public void setRank()
        {
            this.rank++;
        }
        int getindex()
        {
        	return index;
        }
        
        	
        
 



}