/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfreader;

/**
 *
 * @author gowtham
 */
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author gowtham
 */
public class dict 
{
    public void snipping() throws IOException
    {
        Runtime.getRuntime().exec( "SnippingTool.exe" );
        
        
    }
    public String Dictionary(String t) throws IOException {

 // construct the URL to the Wordnet dictionary directory
 String wnhome = System.getenv( "WNHOME" );
 System.out.println(wnhome);
 //String path = "C:\\Program Files\\WordNet\\2.1\\bin\\wn" + File.separator + "dict" ;
 String path="C:\\Program Files\\WordNet\\2.1\\dict";
 URL url = new URL( "file" , null , path);

 // construct the dictionary object and open it
 IDictionary dict = new Dictionary(url);
 dict.open();

 // look up first sense of the word " dog "
 IIndexWord idxWord = dict.getIndexWord( t , POS.NOUN);
 //System.out.println("asdf"+idxWord);
 if (idxWord==null)
 {
     idxWord=dict.getIndexWord( t , POS.ADJECTIVE);
 }
 if (idxWord==null)
 {
     idxWord=dict.getIndexWord( t , POS.ADVERB);
 }
 if (idxWord==null)
 {
     idxWord=dict.getIndexWord( t , POS.VERB);
 }
 if (idxWord==null)
 {
     return "Word Not Found In Dictionary";
 }
 IWordID wordID = idxWord.getWordIDs().get(0);
 System.out.println(wordID.getPOS());
 IWord word = dict.getWord(wordID);
 String res;
 res= "Word = " + word.getLemma() + "\n"+" Meaning = " + word.getSynset().getGloss();
 //System.out.println( " Lemma = " + word.getLemma());
 //System.out.println( " Gloss = " + word.getSynset().getGloss());
 return res;
    }
    /*public static void main(String [] args) throws IOException
    {
        snip s=new snip();
        s.testDictionary();
    }*/
}
