/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.sorting;

/**
 *
 * @author kiran
 */
public class bubblesort {
   
      
   
    public void bsort(int []a)
    {
        int j,flag=0,c;
        for( j=0;j<=a.length;j++)
        {
       
     for(int i=0;i<a.length-1; i++)
     {
         if(a[i]<a[i+1])
         {
             
        c= a[i];
        a[i]=a[i+1];
        a[i+1]=c;
                   
         }
       
     }
      
        }

        
    }
        
    public static void main(String [] args)
    {
      bubblesort sort = new bubblesort();
        int a[] ={2,1,4,3,5};
        sort.bsort(a);
       for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
    }
}
