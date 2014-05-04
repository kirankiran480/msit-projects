package searchEngine.Dictionary;

class ListNode <K,V> {
    K key;
    V value;
    ListNode<K,V> next;

    public ListNode(){}
    public ListNode(final V value, final K key) {
        this.value = value;
        this.key = key;
    }
}

public class ListDictionary <K extends Comparable<K>,V> implements DictionaryInterface <K,V>
{

	ListNode<K, V> head;
	int size;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListDictionary(){
		size = 0;
		head = new ListNode(null,null);
	}
	@SuppressWarnings("unchecked")
	@Override
	public K[] getKeys() {
		// TODO Auto-generated method stub
		int i=0;
		ListNode<K,V> h1 = head.next;
		K keys[] = (K[])new String[size];
		while(h1.next != null){
			keys[i++] = h1.key;
			h1=h1.next;
		}
		keys[i]=h1.key;
		return keys;
	}

	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		ListNode<K,V> h1 = head;
		while(h1 != null){
			if(h1.key == str)
				return (V)h1.value;
			h1 = h1.next;
		}
		return null;
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		int flag=0;
		ListNode<K,V> current = new ListNode<K,V>(value,key);
		ListNode<K,V> h1 = head;
		while(h1.next != null)
		{
			h1=h1.next;
			if((h1.key).equals(key))
			{
				h1.value = value;
				flag=1;
			}

		}
		if(flag==0)
		{
			size++;
			h1.next = current;
		}
		
	}
	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		ListNode<K,V> h2=head;
		ListNode<K,V> h1=head;
		while(h1.next!=null)
		{
			h2=h1;
			h1=h1.next;			
			if(h1.key.equals(key))
			{
				size--;
				break;
			}
		}
		h2.next=h2.next.next;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
