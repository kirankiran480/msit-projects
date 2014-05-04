package com.practice.trees;

public class hanoi {

	/**
	 * @param args
	 */
	public static void hanoi(int n,char src,char aux,char target)
	{
		if(n==0)
		{
			return;
		}
		if(n==1)
		{
			System.out.println(src+"->"+target);
		}
		if(n>0)
		{
			hanoi(n-1,src,target,aux);
			System.out.println(src+"->"+target);
			hanoi(n-1,aux,src,target);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		
		hanoi(4,'A','B','C');
		
	}

}
