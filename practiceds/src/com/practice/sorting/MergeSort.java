package com.practice.sorting;


public class MergeSort {

	/**
	 * @param args
	 */
	public int[] merge(int[] a)
	
	{
		if(a.length<=1)
			return a;
		int mid=a.length/2;
		int[] left=new int[mid];
		int[] right;
		if(a.length%2==0)
			right=new int[mid];
		else
			right=new int[mid+1];
		int[] res=new int[a.length];
		for(int i=0;i<mid;i++)
		{
			left[i]=a[i];
		}
		int r=0;
		for(int j=mid;j<a.length;j++)
		{
			if(r<right.length)
				{
				right[r]=a[j];
				r++;
				}
		}
		left=merge(left);
		right=merge(right);
		res=merge_sort(left,right);
		return a;
		
		
	}
	private int[] merge_sort(int[] left, int[] right) {
		// TODO Auto-generated method stub
		int reslen=left.length+right.length;
		int[] res=new int[reslen];
		int iL=0,iR=0,ires=0;
		while(iL<left.length || iR<right.length)
		{
			if((iL<left.length) && (iR<right.length))
			{
				if(left[iL]<=right[iR])
				{
					res[ires]=left[iL];
					iL++;
					ires++;
				}
				else
				{
					res[ires]=right[iR];
					iR++;
					ires++;
				}
			}
			else if(iL<left.length)
			{
				res[ires]=left[iL];
				ires++;
				iL++;
			}
			else if(iR<right.length)
			{
				res[ires]=right[iR];
				iR++;
				ires++;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
