package searchengine.spider;

import java.net.*;
import java.util.Vector;

import searchengine.dictionary.ObjectIterator;
import searchengine.dictionary.PQueue;
import searchengine.element.PageElementInterface;
import searchengine.element.PageHref;
import searchengine.element.PageWord;
import searchengine.indexer.Indexer;
import searchengine.parser.PageLexer;
import searchengine.url.URLTextReader;

/** Web-crawling objects.  Instances of this class will crawl a given
 *  web site in Priority-first order.
 */
public class PriorityBasedSpider implements SpiderInterface 
{

	/** Create a new web spider.
	@param u The URL of the web site to crawl.
	@param i The initial web index object to extend.
	 */

	private Indexer i = null;
	private URL u; 

	public PriorityBasedSpider (URL u, Indexer i) 
	{
		this.u = u;
		this.i = i;

	}

	/** Crawl the web, up to a certain number of web pages.
	@param limit The maximum number of pages to crawl.
	 */
	@SuppressWarnings("unchecked")
	public Indexer crawl (int limit) 
	{
	
		////////////////////////////////////////////////////////////////////
	    //  Write your Code here as part of Priority Based Spider assignment
	    //  
	    ///////////////////////////////////////////////////////////////////
		PQueue q=new PQueue();
    	
		try
    	{
    		URLTextReader in = new URLTextReader(u);
    		// Parse the page into its elements
    		PageLexer elts = new PageLexer(in, u);		
    		int count1=0;
    		// Print out the tokens
    		int count = 0;
    		Vector v=new Vector();
    		while (elts.hasNext()) 
    		{
    			count++;
    			PageElementInterface elt = (PageElementInterface)elts.next();			 
    			if (elt instanceof PageHref)
    			if(count1<limit)
    			{
    				if(q.isempty())
    				{
    					q.enqueue(elt.toString(),count);
					}
    				else
    				{
    					if(q.search(elt.toString(),count))
    					{
    						q.enqueue(elt.toString(),count);
    					}
    				}
    				count1++;
    				System.out.println("link: "+elt);
    				
    			}
    		}
    		System.out.println("links retrieved: "+count1);
    		q.display();
    		while(limit !=0)
    		{
    			Object elt=q.dequeue();
    			URL u1=new URL(elt.toString());
    			URLTextReader in1= new URLTextReader(u1);
    			// Parse the page into its elements
    			PageLexer elt1 = new PageLexer(in1, u1);
    			while (elt1.hasNext()) 
    			{
    				PageElementInterface elts2= (PageElementInterface)elt1.next();
    				if (elts2 instanceof PageWord)
    				{
    					v.add(elts2);
    				}
    				System.out.println("words:"+elts2);
    			}    			
				ObjectIterator OI=new ObjectIterator(v);
				i.addPage(u1,OI);
				for(int j=0;j<v.size();j++);
				{
					System.out.println("hello"+v.get(count));
				}
				limit--;
    		}
    		
    	}
    	catch (Exception e)
    	{
    		System.out.println("Bad file or URL specification");
    	}
     return i;
	}

	/** Crawl the web, up to the default number of web pages.
	 */
	public Indexer  crawl() 
	{
		// This redirection may effect performance, but its OK !!
		System.out.println("Crawling: "+u.toString());
		return  crawl(crawlLimitDefault);
	}

	/** The maximum number of pages to crawl. */
	public int crawlLimitDefault = 10;

}