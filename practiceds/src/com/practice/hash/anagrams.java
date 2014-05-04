package com.practice.hash;
import java.util.*;
public class anagrams {
	
	public static boolean  checkana(String s1, String s2)
	{
		HashMap s = new HashMap();
		int count =0;
		for(int i =0;i<s1.length();i++ )
		{
			if(!s.containsKey(s1.charAt(i)))
			{
			s.put(s1.charAt(i), count=count+1);
			count =0;
			}
			else
			{
				int count2 = (int) s.get(s1.charAt(i));
				count2= count2+1;
				s.put(s1.charAt(i), count2);
			}
		}
		int count2=0;
		for(int j=0;j<s2.length();j++)
		{
			if(s.containsKey(s2.charAt(j)))
			{
			    count2 = (int) s.get(s2.charAt(j));
				count2= count2-1;
				s.put(s2.charAt(j), count2);
			}
			if(count2==0)
			{
				s.remove(s2.charAt(j));
			}
		}
		System.out.println(s);
		return s.isEmpty();
		
	}
	
	public static void main(String [] args)
	{
		
		if(checkana("abc","bac"))
		{
			System.out.println("anagrams");
			
		}
		else
		{
			System.out.println("not  anagrams");
		}
		
	}

}
