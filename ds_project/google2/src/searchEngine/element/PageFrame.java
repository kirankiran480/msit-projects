/**  
 * 
 * Copyright: Copyright (c) 2004 Carnegie Mellon University
 * 
 * This program is part of an implementation for the PARKR project which is 
 * about developing a search engine using efficient Datastructures.
 * 
 * 
 */

package searchEngine.element;

import java.net.*;

import searchEngine.url.URLFixer;

/** A hyperlink in a web page.
*
*/
public class PageFrame implements PageElementInterface {

    public PageFrame (String h) throws MalformedURLException {
	href = new URL(h);
    }

    public PageFrame (URL context, String h) throws MalformedURLException {
	href = URLFixer.fix(context, h);
    }

    public String toString () {
		if(href == null )
			return null;
	return href.toString();
    }

    private URL href;
}
