/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.sorting;

/**
 *
 * @author kiran
 */
public class QuickSort {
    
  
    public void quickSort(int [] a, int start, int end)
    {
        if(start<end)
        {
            int pindex = partition(a,start,end);
            quickSort(a,start,pindex-1);
            quickSort(a, pindex+1, end);
        } 
       //  System.out.println(java.util.Arrays.toString(a));
    }
   public int partition(int []a,int start,int end)
    {
        int pivot = a[end];
        int pindex = start;
       // System.out.println("pindex"+pindex);
        for(int i=start;i<end;i++)
        {
            if (a[i]<=pivot)
            {
            /*   int c= a[i];
               a[i]=a[pindex];
               a[pindex]= c;*/
              swap(a,i,pindex);
                pindex=pindex+1;
            }
        }
     /*   int c1= a[pindex];
        a[pindex]=a[end];
        a[end]=c1; */
      swap(a,pindex,end);
        return pindex;
    }
  public int[] swap(int []arr,int aindex,int bindex)
  {
        //System.out.println(a+"\t"+b);
      int c;
      c=arr[aindex];
      arr[aindex]=arr[bindex];
      arr[bindex]=c; 
      
     //System.out.println(a+"\t"+b);
     return arr;
  }
  
  public static void main(String []args)
  {
      
      QuickSort q= new QuickSort();
      int []a= {7,2,1,6,8,5,3,0};
      q.quickSort(a,0,a.length-1);
      
       for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
  }
}
