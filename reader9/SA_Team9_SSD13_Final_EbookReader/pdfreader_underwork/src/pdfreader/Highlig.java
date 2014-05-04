/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfreader;

import gui.gui;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.Highlight;

/**
 *
 * @author gowtham
 */
public class Highlig implements java.io.Serializable
{
    public static void writeAccount(int [] a,String fn) throws Exception
	{
            
            Vector<int[]> v=new Vector<>();
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn+"high.txt"));
			v=(Vector<int[]>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
                    File f= new File(fn+"high.txt");
                    //System.out.println(e);
                }
			
		v.add(a);
		try
		{
			ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream(fn+"high.txt"));
			obj1.writeObject(v);
			obj1.close();
		}
		catch(IOException e)
		{
                    System.out.println(e);
                }
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn+"high.txt"));
			v=(Vector<int[]>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
                    System.out.println(e);
                }
		
	}
        public Vector<int[]> look(String e)throws Exception
        {
          int[] account;
            Vector<int[]> v=new Vector<>();
            ObjectInputStream oi = null;
		int[]p; // initialize it after reading from file
		// write code to open the files, read
		// openning Object intput stream
		try {
			oi = new ObjectInputStream(new FileInputStream(e+"high.txt"));
			v=(Vector<int[]>) oi.readObject();
                        ListIterator iter = v.listIterator();
                       // gui g= new gui();
                        while (iter.hasNext())
			{
				account = (int[])iter.next();
                                System.out.println("acc"+account[0]);
                                System.out.println("acc"+account[1]);
                         //       g.rehigh(account[0], account[1]);
			}
			oi.close();
		} catch (Exception ee) 
                { System.out.println(ee);
		}
		return v;
            
        }
        public static void writehash(Highlighter h, int st,String fn) throws Exception
	{
            Map<Integer, Highlighter.Highlight> highlights = new HashMap<Integer, Highlighter.Highlight>();
            
          
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn+"hash.txt"));
			highlights=(Map<Integer, Highlighter.Highlight>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
                    File f= new File(fn+"hash.txt");
                    //System.out.println(e);
                }
		Highlighter.Highlight[] highlightIndex = h.getHighlights();
                highlights.put(st, highlightIndex[highlightIndex.length - 1]);
		try
		{
			ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream(fn+"hash.txt"));
			obj1.writeObject(highlights);
			obj1.close();
		}
		catch(IOException e)
		{
                    System.out.println(e);
                }
		try
		{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn+"hash.txt"));
			highlights=(Map<Integer, Highlighter.Highlight>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
                    System.out.println(e);
                }
		
	}
        public Map<Integer, Highlight> gethash(String e)throws Exception
        {
            Map<Integer, Highlighter.Highlight> highlights = new HashMap<Integer, Highlighter.Highlight>();
            ObjectInputStream oi = null;
		int[]p; // initialize it after reading from file
		// write code to open the files, readhighlights
		// openning Object intput stream
		try {
			oi = new ObjectInputStream(new FileInputStream(e+"hash.txt"));
			highlights=(Map<Integer, Highlighter.Highlight>) oi.readObject();
			oi.close();
		} catch (Exception ee) 
                { System.out.println(ee);
		}
		return highlights;
            
        }

    public static void main(String [] args)
    {
        ArrayList<int[]> action = new ArrayList<>();
        action.add(new int[2]);
        int[] i =new int[2];
        for ( int k=1;k<10;k++)
        {
            i[0]=k;
            i[1]=k+1;
            action.add(i);
        }
        System.out.print(action.listIterator());
        
    }
}