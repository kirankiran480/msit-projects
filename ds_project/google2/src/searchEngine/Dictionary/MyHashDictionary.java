package searchEngine.Dictionary;

class Node <K extends Comparable<K>, V>{
	K key;
	V value;
	@SuppressWarnings("rawtypes")
	Node next;
	public Node(){}
	public Node(K key,V value){
		this.key = key;
		this.value = value;
		next = null;
	}
}
public class MyHashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{

	private Node<K, V>[] obj;
	private int count;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyHashDictionary(){
		size = 10370;
		obj = new Node[size];
		for(int i=0;i<size;i++)
			obj[i] = new Node<K,V>(null,null);
		count = 0;
	}
	public static int calculateHash(String str) {
		int code = 0;
		if(str.length()>4) {
		for (int i=0; i<4; i++)
			code = (code<<2)+ str.charAt(i);
		}
		else
			for (int i=0; i<str.length(); i++)
				code = (code<<2)+ str.charAt(i);
		return code;
	} 
	
	@SuppressWarnings("unchecked")
	public K[] getKeys() {
		K arr[] = (K[]) new String[count];
		int j=0;
		for (int i=0; i<this.size; i++)
		{
			if(obj[i].key != null)
					arr[j++]=obj[i].key;
		}
		return arr;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		int temp = calculateHash((String)str);
		Node link = obj[temp];
		while(link != null){
			System.out.println(link.value);
			link = link.next;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		int temp = calculateHash((String)key);
		Node<K,V> val = new Node<K,V>(key,value);
		if(obj[temp].key == null){
			count++;
			obj[temp]=val;
			obj[temp].next = new Node<K,V>(null,null);
			}
		else{
			Node link = obj[temp];
			while(link.key != null)
				link = link.next;
			link = val;
			link.next = new Node<K,V>(null,null);
		}
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		if (this.getValue(key)!=null)
			count--;
		obj[calculateHash((String) key)].value = null;
		obj[calculateHash((String) key)].key = null;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
