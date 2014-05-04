/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * Modified by Mahender on 12-10-2009
 */ 

package searchengine.indexer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

import searchengine.dictionary.AVLDictionary;
import searchengine.dictionary.BSTDictionary;
import searchengine.dictionary.DictionaryInterface;
import searchengine.dictionary.HashDictionary;
import searchengine.dictionary.ListDictionary;
import searchengine.dictionary.MyHashDictionary;
import searchengine.dictionary.ObjectIterator;
import searchengine.element.PageElementInterface;
import searchengine.element.PageWord;


/**
 * Web-indexing objects.  This class implements the Indexer interface
 * using a list-based index structure.

A Hash Map based implementation of Indexing 

 */
public class Indexer implements IndexerInterface
{
	/** The constructor for ListWebIndex.
	 */

	// Index Structure 
	DictionaryInterface index;
	int count;
	// This is for calculating the term frequency
	HashMap<?,?> wordFrequency;

	public Indexer(String mode)
	{
		// hash - Dictionary Structure based on a Hashtable or HashMap from the Java collections 
		// list - Dictionary Structure based on Linked List 
		// myhash - Dictionary Structure based on a Hashtable implemented by the students
		// bst - Dictionary Structure based on a Binary Search Tree implemented by the students
		// avl - Dictionary Structure based on AVL Tree implemented by the students

		if (mode.equals("hash")) 
			index = new HashDictionary();
		else if(mode.equals("list"))
			index = new ListDictionary();
		else if(mode.equals("myhash"))
			index = new MyHashDictionary();
		else if(mode.equals("bst"))
			index = new BSTDictionary();
		else if(mode.equals("avl"))
			index = new AVLDictionary();
	}

	/** Add the given web page to the index.
	 *
	 * @param url The web page to add to the index
	 * @param keywords The keywords that are in the web page
	 * @param links The hyperlinks that are in the web page
	 */
	public void addPage(URL url, ObjectIterator<?> keywords)	
	{
	    ////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		int freq=0;
		Vector v=new Vector();		
		v=keywords.returnVec();
		//System.out.println("hello");
		
		while(keywords.hasNext())
		{
			String s=url.toString();
		//	System.out.println("hello");			
			freq=0;
			String str=keywords.next().toString();
			for(int i=0;i<v.size();i++)
			{
				if(str.equals(v.get(i).toString()))
				{
					freq++;					
				}
			}				
			String ss = "";
			ss = s+"%"+str+">"+freq;
			
				//System.out.println(str+"->"+ss);			
			index.insert(ss,str);		
			//index.insert(ss,str);	
		}
		
       /* Vector<String> myv = new Vector();
       
        Vector<String> myv1 = new Vector();
    //    ObjectIterator<?> Out = new ObjectIterator(v);
        ////////////////////////////////////////////////////////////////////
        //  Write your Code here as part of Integrating and Running Mini Google assignment
        // 
        ///////////////////////////////////////////////////////////////////
        myv=(Vector<String>) v.returnVec();
        System.out.println(myv.firstElement());
        String temp,myu;
        int count;
      
        for(int i=0;i<myv.size();i++)
        {
            count=0;
            String str=myv.get(i);
            if(!myv1.contains(myv.get(i)))
            {
            	for(int j=0;j<myv.size();j++)
            	{
            		 
            		if(str.equals(myv.get(j)))
            		{
            			
            			count++;
            		}
            		
            	}
            	
            myv1.add(myv.get(i));
            temp=Integer.toString(count);
            myu=url.toString()+"|"+temp;
           
            System.out.println("key="+myv.get(i)+" value="+myu);
            index.insert(myv.get(i),myu );
            }
                       
        }*/
		
	}
	

	/** Produce a printable representation of the index.
	 *
	 * @return a String representation of the index structure
	 */
	public String toString()
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		return "You dont need to implement it\n";
		
		
	}

	/** Retrieve all of the web pages that contain the given keyword.
	 *
	 * @param keyword The keyword to search on
	 * @return An iterator of the web pages that match.
	 */
	public ObjectIterator<?> retrievePages(PageWord keyword)
	{                                                            
		
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		String[] keys = (String[]) index.getKeys();
		String str;
		Vector<String> vec=new Vector<String>();
		ObjectIterator<String> dat=new ObjectIterator<String>(vec); 
		str=(String)keyword.toString();
		for(int i=0;i<keys.length;i++)
			if(index.getValue(keys[i]).equals(str))		
				vec.add((String)keys[i]);		
		return dat;
		 
		 
		//return new ObjectIterator<PageElementInterface>(new Vector<PageElementInterface>(v));
	}

	/** Retrieve all of the web pages that contain any of the given keywords.
	 *	
	 * @param keywords The keywords to search on
	 * @return An iterator of the web pages that match.
	 * 
	 * Calculating the Intersection of the pages here itself
	 **/
	public ObjectIterator<?> retrievePages(ObjectIterator<?> keywords)
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		
		 String[] keys= (String[]) index.getKeys();
		ObjectIterator<?> i1 = null;
		Vector v1=new Vector();
		String s;
		String str;
		while (keywords.hasNext())
	   	{
			s=(String) keywords.next();
			for(int i=0;i<keys.length;i++)
			{
				if(index.getValue(keys[i]).equals(s))
				{
					v1.add(keys[i]);
				}
			}	
	   	}
		//for(int i=0;i<v1.size();i++)
			//System.out.println(v1.get(i));
		return new ObjectIterator<PageElementInterface>(new Vector<PageElementInterface>(v1));
	}

	/** Save the index to a file.
	 *
	 * @param stream The stream to write the index
	 */
	public void save(FileOutputStream stream) throws IOException
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		
		PrintStream ps=new PrintStream(stream);
		Comparable[] str=index.getKeys();
		System.out.println("Length is : "+str.length);
		for(int i=0;i<str.length;i++)
		{
			ps.println(index.getValue(str[i])+ ", " +str[i]);
			//System.out.println(index.getValue(str[i]));
			
		}
		ps.println();
		ps.close();
		/*PrintStream ps=new PrintStream(stream);
		Comparable[] str=index.getKeys();
		System.out.println("Length is : "+str.length);
		for(int i=0;i<str.length;i++)
		{
			if(str[i]!=null)
			{
			//ps.print(str[i]+ "$  ");
		
			HashDictionary ht=new HashDictionary();
			ht=(HashDictionary)index.getValue(str[i]);
			Comparable[] str1=ht.getKeys();
			for(int j=0;j<str1.length;j++)
			{
				ps.print(str[i]+ "$  ");
				ps.print(str1[j]+ " !   " +ht.getValue(str1[j])+ "   @   ");
			
			}
			ps.println();
		}
		}*/

		
	}

		
	/** Restore the index from a file.
	 *
	 * @param stream The stream to read the index
	 */
	public void restore(FileInputStream stream) throws IOException
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		 BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		 String str,key,value;	
         while((str=br.readLine())!= null)    
	     {
        	 key="";
        	 value="";        	 
        	 for(int i=0;i<str.length();i++)
        	 {
        		if(str.charAt(i)==',')
        		{
        			for(int j=i+1;j<str.length();j++)
        			{
        				value=value+str.charAt(j);
        			}
        			break;
        		}
        		else
        		{
        			key=key+str.charAt(i);
        		}
        	 }        	 
        	 index.insert(value,key);        	
	     }
	}
	

	/* Remove Page method not implemented right now
	 * @see searchengine.indexer#removePage(java.net.URL)
	 */
	public void removePage(URL url) {
	}
};
