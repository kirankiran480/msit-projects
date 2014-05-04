/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.priorityqueues;

import java.util.ArrayList;

/**
 *
 * @author kiran
 */

public class maxheap <T extends Comparable<T>> 
{
     
    private ArrayList <T> heap;
    
    public maxheap()
    {
        heap = new ArrayList<T>();
    }
    
    public boolean  add(T data)
    {
      
       heap.add(data);
        int current = heap.size()-1;
        //int current =0;
        while(current>0)
        {
        
       
        int res = heap.get(current).compareTo(heap.get((current-1)/2));
        if(res >0)
        {
            T tmp = heap.get(current);
            heap.set(current, heap.get((current-1)/2));
            heap.set((current-1)/2, tmp);
            current = current-1;
        }
        else if(res== 0)
        {
            return false;
                    
        }
        else
            break;
        }
        return true;
    }
    
    public T findmax()
    {
        return heap.get(0);
    }
}
