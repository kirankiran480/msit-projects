/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.linkedlists;

/**
 *
 * @author kiran
 */
public class len_maxrepseq {
    
    public sll s;
    public node head;
    
    public void buildlinkedlist(char [] seq)
    {
          s = new sll();
        head= s.head;
        for(int i=0;i<seq.length;i++)
        {
            s.addfirst(seq[i]);
        }
        s.display();
    }
    public int findmaxseq()
    {
        int currcount=1;
         int oldcount=1;
         node tmp;
      
       tmp = s.head.next;
       node current;
       while(tmp.next!=null)
       {
           if(tmp.data == tmp.next.data)
           {
               currcount++;
           }
           else
               if(currcount>oldcount)
           {
           oldcount = currcount;
           currcount=1;
           }
               
               
             tmp = tmp.next;  
       }
       System.out.println("currcount"+currcount);
       System.out.println("oldcount"+oldcount);
      if(currcount>oldcount)
          return currcount;
      else
          return oldcount;
    }
     public static void main(String [] args)
     {
         
         len_maxrepseq lm = new len_maxrepseq();
         char [] rbseq = {'R','B','R','R','R','R','R','R','B','B','B','B','B','R'};
         lm.buildlinkedlist(rbseq);
         System.out.println("max_seq"+lm.findmaxseq());
     }
}
