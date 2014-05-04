package searchEngine.Dictionary;

class BSTNode <K extends Comparable<K>, V>{
	K key;
	V value;
	@SuppressWarnings("rawtypes")
	BSTNode leftChild;
	@SuppressWarnings("rawtypes")
	BSTNode rightChild;
	public K returnKey(){
		return this.key;
	}
	public void display(){
		System.out.println("Key:"+this.key+"Value:"+this.value);
	}
}

public class BSTDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{

	@SuppressWarnings("rawtypes")
	BSTNode root;
	int count;
	int i;
	K[] keys;
	
	public BSTDictionary(){
		root = null;
		count = 0;
		i=0;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public K[] getKeys() {
		// TODO Auto-generated method stub
		keys = (K[]) new String[count];
		return inorder(root);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public V getValue(K str) {
	// TODO Auto-generated method stub
		BSTNode current = root;
		while(current != null){
			if(str.compareTo((K) current.key) <= 0){
				if(current.key.equals(str))
					return (V) current.value;
				current = current.leftChild;
			}
			else{
				if(current.key.equals(str))
					return (V) current.value;
				current = current.rightChild;
			}
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		BSTNode newNode = new BSTNode();
		newNode.key = key;
		newNode.value = value;
		
		if(root == null){
			root = newNode;
			count++;
		}
		else{
			BSTNode current = root;
			BSTNode parent;
			while(true){
				parent = current;
				if(key.compareTo((K) current.key) < 0){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						count++;
						return;
					}
				}
				else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						count++;
						return;
					}
				}
			}
		}
		
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public K[] inorder(BSTNode local){
		try{
		if(local != null){
			inorder(local.leftChild);
			keys[i++] = (K) local.key;
			inorder(local.rightChild);
		}
		}catch(Exception e){e.printStackTrace();}
		return keys;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
