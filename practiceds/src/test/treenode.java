/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author kiran
 */
 import java.util.Scanner;
import java.util.Stack;

 
class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data)
	{
		this.data=data;
		left=right=null;
	}
	TreeNode(int data,TreeNode left,TreeNode right)
	{
		this.data=data;
		this.left=left;
		this.right=right;		
	}
	
}

class BinaryTree<E>
{
		private TreeNode root;
		//private int size;
		public BinaryTree()
		{
 			root=null;
			//size=0;
		}
		
		//inserting values in a binary search tree
			

public void insert(int data)
		{
			if(root==null)
			{
				root=new TreeNode(data);
				System.out.println("root:"+root.data);
			}
			else
			{
				TreeNode current=root;	
				//TreeNode parent;
				while(true)
				{
					//parent=current;
					//System.out.println("current"+current.data);
					//System.out.println("data"+data);
					if(data<current.data)
					{
						if(current.left==null)
						{
							//System.out.println("pa"+parent.data);
							current.left=new TreeNode(data);
							System.out.println("Node inserted at left side");
							break;
						}
						else
						{
							current=current.left;
						}
 					}
					else
					{
						
						if(current.right==null)
						{
							//System.out.println("pa"+parent.data);
							current.right=new TreeNode(data);
							System.out.println("Node inserted at right side");
							break;
						}
						else
						{
							current=current.right;
						}
					}
						
				}//while
		    }//main else
		}//insert method close	
		
		//FULL NODECOUNT
		public int findfullnodecount()
		{
			return auxfindfullnodecount(root);
		}	
		
		private int auxfindfullnodecount(TreeNode root) 
		{
			if(root==null)
				return 0;
			if(root.left==null && root.right==null)
				return 0;
			int lc=auxfindfullnodecount(root.left);
			int rc=auxfindfullnodecount(root.right);
			int p=(root.left!=null&&root.right!=null)?1:0;
			return lc+rc+p;
 		}
		//END FULLNODE COUNT
		
		//PREORDER TRAVERSAL
		public void preorder()
		{
			auxpreorder(root);
		}		
		
		private void auxpreorder(TreeNode root) 
		{
			if(root==null)
				return;
			System.out.println(root.data);
			auxpreorder(root.left);
			auxpreorder(root.right);		
		}
		
		//INORDER TRAVERSAL
		public void inorder()
		{
			auxinorder(root);
		}		
		
		private void auxinorder(TreeNode root) 
		{
			if(root==null)
				return;
			auxinorder(root.left);
			System.out.println(root.data);
			auxinorder(root.right);		
		}
			
		//POSTORDER TRAVERSAL
		public void postorder()
		{
			auxpostorder(root);
		}		
		
		private void auxpostorder(TreeNode root) 
		{
			if(root==null)
				return;
			auxpostorder(root.left);
			auxpostorder(root.right);
			System.out.println(root.data);
		}		
		

		//tree height
		public int treeheight()
		{
			return auxtreeheight(root);			
		}
		private int auxtreeheight(TreeNode root) 
		{
			if(root==null)
				return 0;
			if(root.left==null && root.right==null)
				return 1;
			int lc=auxtreeheight(root.left);
			int rc=auxtreeheight(root.right);
			return Math.max(lc,rc)+1; //1-->rootnode adding with the maximum of lc/rc node count
		}
		//tree height close
		
		
		
		//Non recursive preorder TRAVERSAL
		
		public void preorderNR()
		{
			Stack<TreeNode> st=new Stack<TreeNode>(); 
			TreeNode current=root;
			while(true)
			{
				while(current!=null)
				{
					System.out.println(current.data);
					st.push(current);
					current=current.left;				
				}
					if(st.empty())
					{					
						break;
					}
					current=st.pop().right;
			}	
		}
		
		//Non recursive inorder TRAVERSAL
		
		public void inorderNR()
		{
			Stack<TreeNode> st=new Stack<TreeNode>(); 
			TreeNode current=root;
			while(true)
			{
				while(current!=null)
				{
					st.push(current);
					current=current.left;				
				}
					if(st.empty())
					{					
						break;
					}
					current=st.pop();
					System.out.println(current.data);
					current=current.right;
			}	
		}
		
		//TREE Diameter
		public int treediameter()
		{
			Counter d=new Counter();
			auxtreediameter(root,d);
			return d.getvalue();
			
		}

		private int auxtreediameter(TreeNode root,Counter d) 
		{
			if(root==null)
				return 0;
			if(root.left==null &&root.right==null)
				return 1;
			int lh=auxtreediameter(root.left, d);
			int rh=auxtreediameter(root.right, d);
			int k=lh+rh;
			if(k>d.getvalue())
			{
				d.setvalue(lh+rh);
			}
			return Math.max(lh, rh)+1;
		}
		

		class Counter
		{
			int val=0;
			public void setvalue(int d)
			{
				val=d;
			}
			int getvalue()
			{
				return val;
			}
		}
		

		//Building a tree by taking INORDER and PREORDER of that tree as input
	

		public TreeNode buildTree(int[] in,int[] pre)
		{

			return auxbuildTree(in,pre,0,in.length-1);
		}

 		private TreeNode auxbuildTree(int[] in, int [] pre, int l, int r) 
		{
			if(l>r)
				return null;
			TreeNode tmp=new TreeNode(pre[l],null,null);
			int ser=search(in,l,r,pre[l]);
			tmp.left=auxbuildTree(in, pre, ser-1, l++);
			tmp.right=auxbuildTree(in, pre, ser+1, l++);
			return tmp;
		}

		//searching for the desired index and returning it
		private int search(int[] in, int l, int r, int i) 
		{
			for(int j=0;j<in.length-1;j++)
			{
				if(in[j]==in[i])
				{
					return j;
				}
			}
			return 0;
		}
		

		//Removing an element in a binary tree
				
		public void remove(int data) 
		{
				Status status =new Status();
				auxremove(root, data, status);
				System.out.println(data+" removed successfully");
				
		}

		private TreeNode auxremove(TreeNode root, int data, Status status) 
		{
			 if(root==null)
			 {
				 status.setstatus(true);
				 return null;
			 }
		    if(data<root.data)
			 {
		    	System.out.println("in left");
				 root.left=auxremove(root.left, data, status);
				 
			 }
		    else if(data>root.data)
		    {
		    	System.out.println("in right");
		    	root.right=auxremove(root.right, data, status);
		    }
		    
		    if(root.left!=null && root.right!=null)
		    {
		    	root=findsmallestRST(root.right);
		    	root.right=auxremove(root.right,root.data,status);
		    }		 
			 
		    if (root.left==null && root.right==null)
		    {
		    	System.out.println("In final else statement");
		    	return root.left!=null?root.left:root.right;//case 1 & case 2
		    }
		    //System.out.println("root"+root.data);
			return root;
		    
		    
		}		
		
        // finding the smallest element in the tree
		private TreeNode findsmallestRST(TreeNode right)
		{
			//System.out.println("in smallest rst");
			while(right.left!=null)
			{
				right=right.left;
			}
			System.out.println("small ele::"+right.data);
			
			return right;
		}


		class Status
		{
			boolean val;
			Status()
			{
				val=false;
			}
			public void setstatus(boolean b)
			{
				val=b;
			}
			/*boolean getstatus()
			{
				return val;
			}*/
			
		}


		public void findLCA(int d1, int d2) 
		{
			TreeNode cur=root;
			if(d1<cur.data&&d2<cur.data)
			{
				if(cur.left.data==d1||cur.right.data==d2)
				{
 					System.out.println("LCA"+cur.data);
				}
			}
			if((d1<cur.data&&d2>cur.data)||(d1>cur.data&&d2<cur.data))
			{
				System.out.println("LCA"+cur.data);
			}
			
			if(d1>cur.data&&d2>cur.data)
			{
				if(cur.left.data==d1||cur.right.data==d2)
				{
 					System.out.println("LCA"+cur.data);
				}
			}
			
		}

		public TreeNode randomtree(int[] p)
		{
			return auxrandomTree(p,0,p.length-1);
		}

		TreeNode auxrandomTree(int[] p, int l, int r)
		{
			random ran=new random();
			if(l>r)
				return null;
			int tmp=ran.getrandom(l,r);
			System.out.println("tmp value:: "+tmp);
			TreeNode root=new TreeNode(p[tmp],null,null);
			root.left=auxrandomTree(p, l, tmp-1);
			root.right=auxrandomTree(p, tmp+1, r);
			return root;	
		}
		
		class random
		{
			public int getrandom(int l,int r)
			{
				int rno= (int) (l + (Math.random() * (r - l)));
				return rno;
				
			}
		}
		
		
		//Non recursive postorder TRAVERSAL
		
		/*public void postorderNR()
		{
			Stack<TreeNode> st=new Stack<TreeNode>(); 
			TreeNode current=root;
			while(true)
			{
				while(current!=null)
				{
					st.push(current);
					current=current.left;
				}
				if(st.empty()) 
					break;
				current=st.pop();
				if(current>0)
				{
					st.push(current*-1);
					current=current.right;
				}
				else
				{
					current*=-1;
					System.out.println(current.data);
					current=null;
				}
				
			}
		}*/
		
}




class TestonBinaryTree
{
	public static void main(String[] args)
	{
		@SuppressWarnings("rawtypes")
		BinaryTree bt=new BinaryTree();
 		int x,y,z;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.insert");
			System.out.println("2.height");
			System.out.println("3.fullnodecount");
			System.out.println("4.PREORDER traversal");
			System.out.println("5.INORDER Traversal");
			System.out.println("6.POSTORDER Traversal");
			System.out.println("7.Treediameter");
			System.out.println("8. BUILD TREE");
			System.out.println("9. DELETE A NODE");
			System.out.println("10.Least common node in the tree");
			System.out.println("11.Create random Binary Tree");
			System.out.println("20.Exit");			
			System.out.println("enter ur choice");
			x=sc.nextInt();
			switch(x)
			{
			case 1:
					
					System.out.println("enter element to insert");
					z=sc.nextInt();
					bt.insert(z);					
				  break;
			
			case 2:
				   System.out.println("height of Tree"+bt.treeheight());
				   break;
			case 3:
				   System.out.println("fullNodes:"+bt.findfullnodecount());
				   break;
			
			case 4:
				    bt.preorder();
				    break;
			
			case 5:
				   bt.inorder();
				   break;
				   
			case 6:
				   bt.postorder();
				   break;
				   
				   
			case 7:
				   System.out.println("Diameter"+ bt.treediameter());
				   break;
				
			case 8:
					//EX1: inorder-->{1, 3, 4, 5,7,8,10}, preorder-->{5,3,1,4,8,7,10}
					//EX2: inorder-->{1,2,4,5,6,8,9,10,12,14,16,20,22,25,28}, preorder-->{10,5,2,1,4,8,6,9,20,14,12,16,25,22,28}
				   int []pre={10,5,2,1,4,8,6,9,20,14,12,16,25,22,28};
				   int []in={1,2,4,5,6,8,9,10,12,14,16,20,22,25,28};
				   //System.out.println("enter inorder array");				   
				   System.out.println("RootNode:"+ bt.buildTree(in,pre).data);
				   break;
				   
			case 9:
					System.out.println("enter an element to delete from tree");
					y=sc.nextInt();
					bt.remove(y);
					break;
					//System.out.println("removed element is::"+bt.remove(y).data);
					
			
			case 10:
					System.out.println("enter two nodes to find least common ancestor");
					int a=sc.nextInt();
					int b=sc.nextInt();
					bt.findLCA(a,b);
					break;
					
			 
			case 11:
					int p[]={6,4,8,12,10,2};
					System.out.println("RootNODE:: "+bt.randomtree(p).data);
					break;
					
					
			case 20:
				System.exit(0);
				
				
				   		
			}//switch
				
		}
	}
}











