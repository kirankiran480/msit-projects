/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine.element;

/**
 *
 * @author user
 */
public class PageAlt implements PageElementInterface {

	public PageAlt (String w) {
		word = w;
	}

	public String toString () {
		return word;
	}

	private String word;
}
