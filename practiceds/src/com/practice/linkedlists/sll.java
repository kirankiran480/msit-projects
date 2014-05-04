/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.linkedlists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kiran
 */


public class sll<t> {
    
    public node head;
    public node tail;
    public int size;
    public sll()
    {
        head = new node();
        tail = new node();
        size= 0;
    }
    public t addfirst(t data)
    {
        node tmp = new node(data,head.next);
        
            head.next = tmp;
            tail = tmp.next;
          //tmp.next = tail;
         // tail.next = null;
    return data;
    }
     
    public void addlasteff(t data)
    {
       node tmp = new node(data,null);
       
      tail.next = tmp;
      tail = tmp;
      
       tail.next= null;
    }
    public void display()
    {
        node tmp;
        tmp = head.next;
        while(tmp!=null)
        {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        
    }
    
    public node nrecreverse()
    {
        
       node prev = null;
       node tmp = null;
       node current = head.next;
       while(current!=null)
       {
          tmp = current.next;
         
         current.next= prev;
          prev = current;
           current = tmp;
       }
       head.next = prev;
       return  head.next;
    }
    public void mainreverse()
    {
        Reverse(head.next);
        display();
    }
    public node Reverse(node list)
{
    //if (list == null) return null; // first question

    if (list.next == null) 
    {
        head.next = list;
        return list;} // second question

    // third question - in Lisp this is easy, but we don't have cons
    // so we grab the second element (which will be the last after we reverse it)

   node secondElem = list.next;
//System.out.println("kiran");
    // bug fix - need to unlink list from the rest or you will get a cycle
   // list.next = null;

    // then we reverse everything from the second element on
    node reverseRest;
        reverseRest = Reverse(secondElem);

   node tmp = secondElem;
   tmp.next= list;
   list.next= null;
    return reverseRest;
}
    public boolean find(t data)
    {
        node tmp = head.next;
        int flag = 0;
        while(tmp!= null)
        {
            if(tmp.data == data)
            {
                flag = 1;
                break;
        }
            
         tmp = tmp.next;
         
        }
        if(flag == 1)
         {
             return true;
         
             
        }
  return false;
    }
    
    public void remove(t data)
    {
        if(data == head.next.data)
        {
            head.next = head.next.next;
        }
        else
        {
        node tmp = head.next;
        while(tmp.next!=null)
        {
            
            if(tmp.next.data == data)
            {
               node newtmp = tmp.next.next;
               tmp.next = newtmp;
               break;
            }
            else
                tmp = tmp.next;
        }}
    }
    public void addlast(t data)
    {
        node tmp = head.next;
        node newnode = new node(data,tmp.next);
        while(true)
        {
           if(tmp.next == null)
           {
               tmp.next = newnode;
               newnode.next = null;
               break;
           }
           else
           tmp = tmp.next;
        }
    }
    public static void main(String [] args) throws IOException
    {
        sll s1 = new sll();
        while(true)
        {
        java.io.BufferedReader br  = new java.io.BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.ADDFIRST \t  2. display \t 3.find \t 4. addlast  \t 5. addlasttail \t 6. remove element \t 7.quit");
        System.out.println("enter a choice");
        int choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
            case 1:
                System.out.println("enter a value to add");
                int val = Integer.parseInt(br.readLine());
                s1.addfirst(val);
                break;
                
            case 2:
                s1.display();
                break;
                
            case 3:
                 System.out.println("enter a value to find");
                int val1 = Integer.parseInt(br.readLine());
                System.out.println(s1.find(val1));
                break;
                
            case 4: 
                System.out.println("enter a value to add");
                int val2 = Integer.parseInt(br.readLine());
                s1.addlast(val2);
                break;

            case 5:
                System.out.println("enter a value to add");
                int val3 = Integer.parseInt(br.readLine());
                s1.addlasteff(val3);
                break;
            case 6:
                System.out.println("enter a value to remove");
                int val4 = Integer.parseInt(br.readLine());
                s1.remove(val4);
                break;
                
            case 7:
                 s1.nrecreverse();
                break;
                
            case 8:
                 s1.mainreverse();
                break;
            case 9:
                System.exit(0);
                break;
                
                        }
        }
    }
    
    
}
