/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * Modified by Mahender on 12-10-2009
 */
package searchengine.spider;

import java.util.*;
import java.io.IOException;
import java.net.*;

import searchengine.Interface.CrawlerDriverInterface;
import searchengine.dictionary.ObjectIterator;
import searchengine.element.*;
import searchengine.indexer.Indexer;
import searchengine.parser.PageLexer;
import searchengine.url.URLTextReader;


/** Web-crawling objects.  Instances of this class will crawl a given
 *  web site in breadth-first order.
 */
public class BreadthFirstSpider implements SpiderInterface {

	/** Create a new web spider.
	@param u The URL of the web site to crawl.
	@param i The initial web index object to extend.
	 */
	
	CrawlerDriverInterface cc=new CrawlerDriverInterface();
	private Indexer i = null;
	private URL u; 
	public String aa[];
	public Vector vec12=new Vector();
	public BreadthFirstSpider()
	{
		
	}
	public BreadthFirstSpider (URL u, Indexer i) {
		this.u = u;
		this.i = i;

	}

	/** Crawl the web, up to a certain number of web pages.
	@param limit The maximum number of pages to crawl.
	 */
	public Indexer crawl (int limit)
	{
	
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Breadth First Spider assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		int count=0,a=1;
		URLTextReader in = new URLTextReader(u);
		Queue<Object> qe2=new LinkedList<Object>();
		Queue<Object> qe3=new LinkedList<Object>();
		try
		{
		Queue<Object> qe1=new LinkedList<Object>();
		
		PageLexer<PageElementInterface> elts = new PageLexer<PageElementInterface>(in, u);
		PageLexer<PageElementInterface> elts1;
		
		
		while (elts.hasNext()) 
		{			
			PageElementInterface elt = (PageElementInterface)elts.next();			
			 if (elt instanceof PageHref)
			 {				 
				 qe1.add(elt);         //if reference move to queue
				 qe2.add(elt);
				 qe3.add(elt);
				 count++;              //inc count,1 count will be 3. 
				 if(count==crawlLimitDefault)    //if max limit
				 {
					  break;
				 }
			 }			
		}//while	

		while(a==1)
		{
			String p=qe1.remove().toString();    //pop the link
			URL u1=new URL(p);
			URLTextReader in1 = new URLTextReader(u1);
		    elts1=new PageLexer<PageElementInterface>(in1,u1); //passing pop link to page lexer
		     while (elts1.hasNext())                           
				{			
					PageElementInterface elt1 = (PageElementInterface)elts1.next();			
					 if (elt1 instanceof PageHref)
					 {											 
						 qe1.add(elt1);                     //adding elements in that link to queue
						 qe2.add(elt1);
						 qe3.add(elt1);
						 count++;
						 if(count==crawlLimitDefault && a==1)
						 {			 
							 a=0;
						       break;
						 }
					 }			
				}//while
		   
		}
		int s=0;
	    aa=new String[limit];
		for(int i=0;i<crawlLimitDefault;i++)
		{
			//System.out.println(i+")"+qe2.remove());
			//cc.res[s]=i+")"+qe2.remove();
			aa[i]=i+")"+qe2.remove();
			
			//s++;
		}
		for(int i=0;i<crawlLimitDefault;i++)
		{
			System.out.println(aa[i]);
			vec12.add(aa[i]);
			//System.out.println("jjjjj"+cc.res[i]);
			//cc.res[s]=aa[i];
			//aa[i]=i+")"+qe2.remove();
			//s++;
		}
	
	}//try
	catch(Exception e)
	{
		//System.out.println(e);
	}
	 System.out.println("count="+count);
	 int number=0;
	 try
	 {
		while(limit !=0)
		{
			

			Object elt=qe3.remove();
			//System.out.println(elt.toString());
			URL u1=new URL(elt.toString());
			URLTextReader in1= new URLTextReader(u1);

		// Parse the page into its elements
		PageLexer elt1 = new PageLexer(in1, u1);
		Vector v=new Vector();
		while (elt1.hasNext()) 
		{
			PageElementInterface elts2= (PageElementInterface)elt1.next();
			if (elts2 instanceof PageWord)
			{
				v.add(elts2);
			}
			
		}
				ObjectIterator OI=new ObjectIterator(v);
				i.addPage(u1,OI);
			
		//for(int j=0;j<v.size();j++)
	//		System.out.println(u1+"------>"+v.get(j));
		limit--;
		}
	 }
	 catch(Exception e)
	 {}
	 	//disp();
		return i;
	}

	/** Crawl the web, up to the default number of web pages.
	 */
	public Indexer  crawl() {
		// This redirection may effect performance, but its OK !!
		System.out.println("Crawling: "+u.toString());
		return  crawl(crawlLimitDefault);
	}

	/** The maximum number of pages to crawl. */
	public int crawlLimitDefault = 10;
	public Vector disp()
	{
		
		return vec12;
	}
	
	}


