package searchEngine.Dictionary;
class AVLNode<K,V>
{
	K key;
	V value;
	@SuppressWarnings("rawtypes")
	AVLNode left;
	@SuppressWarnings("rawtypes")
	AVLNode right;
	int height;
	AVLNode(K key,V value)
	{
	this.key=key;
	this.value=value;
	left=null;
	right=null;
	
	}
	@SuppressWarnings("rawtypes")
	AVLNode(K key,V value,AVLNode left,AVLNode right)
	{
		this.key=key;
		this.value=value;
		this.left=left;
		this.right=right;
		height=0;
	}	
}


class AVLTree<K extends Comparable<K>, V> 
{
    @SuppressWarnings("rawtypes")
	AVLNode root;
    
    AVLTree()
    {
    	root=null;
    }
    public void insert(K key,V value)
    {
    	root=insert(key,value,root);
    }
  @SuppressWarnings({ "unchecked", "rawtypes" })
public AVLNode insert(K key,V value,AVLNode s)
  { 
	 // AVLNode current=s;
	  @SuppressWarnings("unused")
	AVLNode newnode=null;
	  if(s==null)
		  return newnode=new AVLNode(key,value);
	 
	  if(((K)s.key).compareTo(key)>0)
	  {
	   s.left=insert(key,value,s.left);
	   if(height(s.left)-height(s.right)==2)
		   if(key.compareTo((K) s.left.key)<0)
			   s=rotateLeft(s);
		   else
			  s=doubleLeft(s);
	  }
	  else if(((K)s.key).compareTo(key)<0)
	  {
		  s.right=insert(key,value,s.right);
		  if(height(s.right)-height(s.left)==2)
			  if(key.compareTo((K)s.right.key)>0)
				  s=rotateRight(s);
			  else
				  s=doubleRight(s);
	  }
	  else
		  ;
	  s.height=Math.max(height(s.left), height(s.right))+1;
	  return s;
				  
 }
  public boolean isEmpty()
  {
	  return root==null;
  }
  @SuppressWarnings("rawtypes")
public int height(AVLNode s)
  {
	  if(s==null)
		  return -1;
	  else
		  return s.height;
		  
  }
  public void printTree()
  {
	  if(isEmpty())
		  System.out.println("empty tree");
	  else
		  printTree(root);
  }
  @SuppressWarnings("rawtypes")
public void printTree(AVLNode t)
  {
	  if(t!=null)
	  {
		  printTree(t.left);
		  System.out.println(t.key);
		  System.out.println(t.value);
		  printTree(t.right);
		  
	  }
	  
		  
  }
  @SuppressWarnings({ "unchecked", "rawtypes" })
public AVLNode<K,V> rotateLeft(AVLNode<K,V> node)
  {
	  AVLNode temp=node.left;
	  node.left=temp.right;
	  temp.right=node;
	  node.height=Math.max(height(node.left), height(node.right))+1;
	  temp.height=Math.max(height(temp.left), node.height)+1;
	  return temp;	  
  }
  @SuppressWarnings({ "unchecked", "rawtypes" })
public AVLNode<K,V> rotateRight(AVLNode<K,V> node1)
  {
	 AVLNode node2=node1.right;
	 node1.right=node2.left;
	 node2.left=node1;
	 node1.height=Math.max(height(node1.left), height(node2.right))+1;
	 node2.height=Math.max(height(node2.right), node1.height)+1;
	 return node2;
  }
  @SuppressWarnings("unchecked")
public AVLNode<K,V> doubleLeft(AVLNode<K,V> node3)
  {
	  node3.left=rotateRight(node3.left);
	  return rotateLeft(node3);
  }
  @SuppressWarnings("unchecked")
public AVLNode<K,V> doubleRight(AVLNode<K,V> node4) 
  {
	  node4.right=rotateLeft(node4.right);
	  return rotateRight(node4);
  }
    
};

public class AVLDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
	@SuppressWarnings("rawtypes")
	AVLTree tree=new AVLTree();
	public K[] getKeys() {
		// TODO Auto-generated method stub
		return null;
	}


	public V getValue(K str) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		tree.insert(key, value);
		
		
	}
	
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}
	public void display()
	{
		tree.printTree();
		
	}

}
