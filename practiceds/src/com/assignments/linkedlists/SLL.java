/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignments.linkedlists;

import java.util.Hashtable;

/**
 *

 */

class ListNode
{
    Object data;
    ListNode next;

    public ListNode() 
    {
        data=null;
        next=null;
    }

    public ListNode(Object data, ListNode next) 
    {
        this.data = data;
        this.next = next;
    }
}
public class SLL 
{
    
    private ListNode head;
    private int size;
    
    public SLL()
    {
        head=new ListNode();
        size=0;
    }
    public boolean find(Object data)
    {
        ListNode current;
        for(current=head.next;current!=null;current=current.next)
        {
            if(current.data.equals(data))
                return true;
        }
        return false;
    }
    public boolean addFirst(Object data)
    {
        head.next=new ListNode(data, head.next);
        return true;
    }
    
    public void display()
    {
        ListNode temp=head.next;
        while(temp!=null)
        {
            System.out.println("value: "+temp.data);
            temp=temp.next;
        }
    }
    
    public static void main(String[] args) 
    {
        
        Hashtable ht=new Hashtable();
        SLL sl=new SLL();
        sl.addFirst((new Integer(10)));
        sl.addFirst((new Integer(20)));
        sl.addFirst((new Integer(30)));
        System.out.println(sl.find(new Integer(20)));
       sl.display();
    }
    
}
