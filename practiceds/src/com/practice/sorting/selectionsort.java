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
public class selectionsort {
    public void selectionsort(int []a)
    {
        
     int j;
        for(int i = 0; i< a.length-1;i++)
        {
            int imin=i;
            for(j = i+1; j<a.length;j++)
            {
                if(a[j]<a[imin])
                    imin=j;
             }
            int c = a[imin];
            a[imin]=a[i];
            a[i]= c;
        }
        for(int k =0;k<a.length;k++)
        System.out.println(a[k]);
    }

    
    public static void main(String [] args)
    {
  selectionsort sort = new selectionsort();
        int a[] ={1,4,4,2,5};
        sort.selectionsort(a);
    }
}
