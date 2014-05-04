/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.linkedlists;

/**
 *
 * @author kiran
 */
public class node <t>{
    
    t data;
    node next;
    node()
    {
        data = null;
        next= null;
    }
    node(t data,node next)
    {
        this.data = data;
        this.next= next;
    }
}
