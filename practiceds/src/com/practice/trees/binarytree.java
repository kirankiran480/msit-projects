package com.practice.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class binarytree {

	/**
	 * @param args
	 */
	private   btreenode root;
	
	private int size;
	public static int tree[];
	public int maxsize;
	public binarytree()
	{    
	    
		root =null;
		size=0;
	}
	
	public  void buildtree(int a)
	{
		int [] arr = tree;
		
			
		 btreenode temp = new btreenode(a);
	  if(root == null)
	  {
		 root = temp;
		 
	  }
	  else
	  {
	btreenode  current = root;
	  while(current!=null)
	  {
		  
	  if(a > current.data)
	  {
		  if(current.right!=null)
		  {
			  current = current.right;
		  }
		  else
		  {
		  current.right = temp;
		  break;
		  
		  }
	  }
	  else if(a< current.data) 
	  {
		 // System.out.println("less");
		  if(current.left != null)
		  {
			  current = current.left;
		  }
		  else
		  {
		  root.left = temp;
		  break;
		  }
	  }
	 else 
	  {
		  break;
	  } 
	  }
		}
		}
	  
	
	
	private void preordernr(btreenode current)
	{
		Stack <btreenode> s = new Stack<btreenode>();
		//btreenode current = root;
	   while(true)
	   {
		   while (current!=null)
		   {
			  System.out.println(current.data);
			  s.push(current);
			  current = current.left;
		   }
		   if(s.isEmpty())
			   break;
			  
	       current = s.pop().right;
	   }
	   
	}
	private void preorderrec()
	{
		auxpreorder(root);
	}
	
   private void auxpreorder(btreenode root)
   {
	   if(root==null)
		   return;
	   System.out.println(root.data);
	   auxpreorder(root.left);
	   auxpreorder(root.right);
   }
   
   public int treeheight()
   {
	   return auxtreeheight(root);
   }
   
   private int auxtreeheight(btreenode root)
   {
	   if(root == null)
	   {
		   return 0;
	   }
	   if(root.left == null && root.right == null)
	   {
		   return 1;
	   }
	   int lh=auxtreeheight(root.left);
	   int rh = auxtreeheight(root.right);
	   
	   return Math.max(lh, rh)+1;
   }
   
   public btreenode randomtree(int[] a)
   {
	   return auxRandomTree(a,0,a.length-1);
   }
   
   private btreenode auxRandomTree(int[] a, int l, int r)
   {
	   if(l>r)
		   return null;
	   int tmp = getrandom(l,r);
	   System.out.println("random"+tmp);
	   btreenode root = new btreenode(a[tmp]);
	   
	   root.left = auxRandomTree(a,l,tmp-1);
	   
	   root.right = auxRandomTree(a,tmp+1,r);
	   return root;
   }
   
  
   public int getrandom(int lb , int rb)
   {
	   java.util.Random rand =  new java.util.Random();
	  return lb+(rand.nextInt(rb-lb+1));
   }
   
   public void levelorder(btreenode root)
   {
	   Queue<btreenode> q = new LinkedList<btreenode>();
	   q.add(root);
	   while(!q.isEmpty())
	   {
		   btreenode tmp = q.poll();
		   System.out.println(tmp.data);
		   if(tmp.left!=null)
		   {
			   q.add(tmp.left);
		   }
		   if(tmp.right!=null)
		   {
			   q.add(tmp.right);
		   }
	   }
	   
   }
   
   public int treediameter(btreenode root1)
   {
	   counter d = new counter();
	   
	   return auxtreediameter(root1,d);
   }
   private int auxtreediameter(btreenode root,counter d)
   {
	   if(root == null)
		   return 0;
	   if(root.left== null && root.right == null)
		   return 1;
	   
	   int lh = auxtreediameter(root.left,d);
	   int rh = auxtreediameter(root.right,d);
	   
	   if(lh+rh> d.getvalue())
	   {
		   d.setvalue(lh+rh);
	   }
	   return Math.max(lh, rh)+1;
   }
   public  btreenode serialbuildtree(int [] in , int [] preorder)
   {
	 return auxbuildtree(in,preorder,0,in.length-1);
   }
  
   private  btreenode auxbuildtree(int [] in , int [] preorder, int l , int r)
   {
       if(l>r)
           return null;
	  btreenode tmp = new btreenode(preorder[l],null,null);
	  int p = search(in,l,r,preorder[l]);
	  tmp.left = auxbuildtree(in,preorder,p-1,l++);
	  tmp.right = auxbuildtree(in,preorder,p+1,l++);
	  return tmp;
   }
   private  int search(int [] in , int l ,int r,int pre)
   {
	   int j=0;
	   for(j = 0 ; j< in.length;j++)
	   {
		   if(in[j]== pre)
		   {
			   break;
		   }
	   }
	   return j;
   }
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		 int [] arr = {1,7,5,2,19};
		 binarytree t = new binarytree();
		
		 while(true)
		 { 
			 System.out.println("1.insert\t 2. preorderrec \t 3. preordernr \t 4. height  \t 5. random binary tree  \t 6. serialing bt ");
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int ch = Integer.parseInt(br.readLine());
        
			 if(ch==1)
			 {
			  
				   System.out.println("enter element");
				   int ele=0;
				   BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					
					ele = Integer.parseInt(br2.readLine());
				
				   t.buildtree(ele);
			 }	 
				  
				   
			  if(ch==2)
			  {
				   t.preorderrec();
				   
			  }   
			  if(ch==3)
			  {
				  // t.preordernr();
				  
			  }   
			if(ch==4)
			{
				   System.out.println("tree height"+t.treeheight());


			}
			if(ch==5)
			{
				int [] arr1 = null;
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("enter the size of array");
			  int arrlength = Integer.parseInt(br2.readLine());
			  arr1 = new int[arrlength];
			  System.out.println("enter the elements");
              for(int k=0;k<arrlength;k++)
              {
            	  arr1[k]= Integer.parseInt(br2.readLine());
              }
              
             btreenode newroot= t.randomtree(arr1);
				//t.preordernr(newroot);
              t.levelorder(newroot);
				System.out.println(t.treediameter(newroot));
			}
			
			if(ch == 6)
			{
				int [] inorder = {1,2,3};
				int [] preorder = {2,1,3};
				System.out.println(t.serialbuildtree(inorder,preorder).data); 
			}
		
		 }
		
		
         
	}

}

