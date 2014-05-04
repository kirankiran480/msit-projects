package searchengine.dictionary;

import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;



public class HashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{

	Hashtable<K, V> hashTable = new Hashtable<K, V>();
	public K a[];
	@SuppressWarnings("unchecked")
	@Override
	public K[] getKeys() 
	{
		a=(K[]) new String[hashTable.size()];
		Iterator iterator =(Iterator) hashTable.keySet().iterator();
		int i =0;
		while((iterator).hasNext())
		{
			a[i]= (K) iterator.next();
			i++;
		
		}
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public V getValue(K str)
	{
		// TODO Auto-generated method stub
		return hashTable.get(str);
	}

	@Override
	public void insert(K key, V value)
	{
		// TODO Auto-generated method stub
		 hashTable.put(key, value);
		
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		hashTable.remove(key);	
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	public boolean isempty()
	{
		return hashTable.isEmpty();
	}
	public boolean search(K word)
	{
		return hashTable.containsKey(word);
	}


}
