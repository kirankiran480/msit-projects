/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * 
 */ 

package searchEngine.parser;

import java.io.*;
import java.net.URL;

import searchEngine.element.PageElementInterface;
import searchEngine.element.PageFrame;
import searchEngine.element.PageHref;
import searchEngine.element.PageImg;
import searchEngine.element.PageNum;
import searchEngine.element.PageWord;
import searchEngine.parser.PageLexer;
import searchEngine.url.URLTextReader;


/**
 * A simple test program for Webreader assignment
 *
 * This class provides a main program for testing Part 1.  It opens a
 * web page and creates a PageLexer object for it.  It then retrieves
 * and prints out all of the PageElements returned by the PageLexer.
 *
 * To run this program from the command line, type the following:
 *
 *     % java WebReader <url>
 *
 * where <url> is the URL of a web page to read.
 *
 */
public class WebReader {

	@SuppressWarnings("rawtypes")
	public static void main (String[] args) {
		try {
			URL u;
			//FileOutputStream saveFile;

			if (args.length >= 1) {
			//if(true){
				
				u = new URL(args[0]);

				URLTextReader in = new URLTextReader(u);

				// Parse the page into its elements
				PageLexer elts = new PageLexer(in, u);

				// Print out the tokens
				int count = 0;
				while (elts.hasNext()) {
					count++;
					PageElementInterface elt = (PageElementInterface)elts.next();
					if (elt instanceof PageWord)
						System.out.println("word: "+elt);
					else if (elt instanceof PageHref)
						System.out.println("link: "+elt);
					else if (elt instanceof PageNum)
						System.out.println("num: "+elt);
					else if (elt instanceof PageImg)
						System.out.println("img: "+elt);
                    else if (elt instanceof PageFrame)
						System.out.println("frame: "+elt);
                   /*else if(elt instanceof PageAlt)
                    	System.out.println("alt:"+elt);*/
				}
				System.out.println();
				System.out.println(count + " total page elements retrieved.");
			} else {
				System.out.println("Usage: WebReader url");
				return;
			}
		} catch (IOException e) {
			System.out.println("Bad file or URL specification");
		}
	}

}