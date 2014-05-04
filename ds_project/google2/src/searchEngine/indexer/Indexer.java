/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * Modified by Mahender on 12-10-2009
 */ 

package searchEngine.indexer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import searchEngine.Dictionary.AVLDictionary;
import searchEngine.Dictionary.BSTDictionary;
import searchEngine.Dictionary.DictionaryInterface;
import searchEngine.Dictionary.HashDictionary;
import searchEngine.Dictionary.ListDictionary;
import searchEngine.Dictionary.MyHashDictionary;
import searchEngine.Dictionary.ObjectIterator;
import searchEngine.element.PageWord;


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
	DictionaryInterface<String,HashMap<URL,Integer>> index;

	// This is for calculating the term frequency
	HashMap<URL,Integer> wordFrequency;

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		while(keywords.hasNext())
        {
            String key = (String)keywords.next();
            
            if(index.getValue(key)!=null)
            {
                 if(wordFrequency.containsKey(url))
                 {
                     wordFrequency.put(url, new Integer(((Integer) wordFrequency.get(url)).intValue()+1));
                     
                 }
                 else {
                     wordFrequency.put(url, new Integer(1));
                 }
            }
            else
            {
                wordFrequency = new HashMap<URL, Integer>();
                wordFrequency.put(url, new Integer(1));
                
            }
            index.insert(key, wordFrequency);
        }
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
	public ObjectIterator<?> retrievePages(PageWord keywords)
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		 Vector<java.util.Map.Entry<URL,Integer>> v = new Vector<java.util.Map.Entry<URL,Integer>>();
	        wordFrequency = index.getValue(keywords.toString());
			if(wordFrequency == null) return null;
			Set<java.util.Map.Entry<URL,Integer>> urlSet = wordFrequency.entrySet();
			v.addAll(urlSet);
			return new ObjectIterator<java.util.Map.Entry<URL,Integer>>(v);

	}
	/** Save the index to a file.
	 *
	 * @param stream The stream to write the index
	 */
	@SuppressWarnings({ "rawtypes" })
	public void save(FileOutputStream stream) throws IOException
	{
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Integrating and Running Mini Google assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		 String s[] = index.getKeys();
	        PrintStream ps = new PrintStream(stream);
	        Set<Map.Entry<URL,Integer>> set;
	        int i=0;
	        while(i<s.length)
	        {
	            ps.print(s[i]);
	            wordFrequency = index.getValue(s[i]);
	            set = wordFrequency.entrySet();
	            Iterator<Entry<URL,Integer>> it=set.iterator();
	            while(it.hasNext())
	            {
	                ps.print(" ");
	                Entry ob = it.next();
	                ps.print(ob.getKey());
	                ps.print(" ");
	                ps.print(ob.getValue());
	            }
	            ps.print("\n");
	            i++;
	        }
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
		String key = null;
        String strLine = null;
        DataInputStream in = new DataInputStream(stream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((strLine = br.readLine()) != null)
        {
            try{
                String words[] = strLine.split(" ");
                if(words.length != 0)
                {
                        key = words[0];
                        wordFrequency = new HashMap<URL,Integer>(); 
                        int i = 1;
                        while(i < words.length -1 )
                        {
                                try{
                                wordFrequency.put(new URL(words[i]), new Integer(words[i+1]));
                                }catch(Exception e)
                                {}
                                i = i + 2;
                        }
                        index.insert(key, wordFrequency);
                }
            }
            catch(Exception e){}
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }    

	/* Remove Page method not implemented right now
	 * @see searchengine.indexer#removePage(java.net.URL)
	 */
	public void removePage(URL url) {
		 throw new UnsupportedOperationException("Not supported yet.");
	}
	@SuppressWarnings("unchecked")
	@Override
	public ObjectIterator<?> retrievePages(ObjectIterator<?> keywords) {
		// TODO Auto-generated method stub
		 Vector<java.util.Map.Entry<URL,Integer>> v = new Vector<java.util.Map.Entry<URL,Integer>>();
			while(keywords.hasNext())
			{
				wordFrequency = (HashMap<URL, Integer>) index.getValue(keywords.next().toString());	
				if(wordFrequency != null)
				{
					Set<?> urlSet = wordFrequency.entrySet();
					v.addAll((Collection<? extends Entry<URL, Integer>>) urlSet);
				}
			}
			return new ObjectIterator<java.util.Map.Entry<URL,Integer>>(v);
	}

};
