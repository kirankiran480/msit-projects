package searchengine.dictionary;

class ListNode<K extends Comparable<K>, V>{
	K key;
	V value;
	ListNode<K, V> next;
}

public class ListDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{

	ListNode first,temp,temp1,temp2;
	public int size;
	public K[] a;
	public ListDictionary()
	{
		first=null;
		size=0;
	}
	@Override
	public K[] getKeys() 
	{
		int m=0;
	    a= (K[])new String[size];
		temp = new ListNode();
		ListNode temp1 = first;
		int i=0;
		/*while(temp1!=null)
		{
			a[i]=(K) temp1.key;
				i++;
			temp1 = temp1.next;
		}*/
		for(i=0;i<size;i++)
		{
			a[i]=(K) temp1.key;
			//a[i]=(K) temp1.value;
		temp1 = temp1.next;
			
		}
		
		/*if(temp1 == null)
		{
			System.out.println("Your entered element is not found in the list");
		}*/
		// TODO Auto-generated method stub
		return a;
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public V getValue(K str)
	{
		V val=null;
		temp = new ListNode();
		temp1 = first;
		/*while(temp1!=null)
		{
			//System.out.println("key:"+temp1.key);
			if(str.equals(temp1.key))
			{
				val=(V)temp1.value;
				//temp.next = temp1;
				//temp1.next = temp;
				break;
			}*/
		for(int i=0;i<size;i++)
		{
			if(str.equals(temp1.key))
			{
				//val=(V)temp1.value;
				val=(V)temp1.value;
				//temp.next = temp1;
				//temp1.next = temp;
				//break;
			}
			temp = temp1;
			temp1 = temp1.next;
		}
			
		
		// TODO Auto-generated method stub
		return val;
	}

	@Override
	public void insert(K key, V value)
	{
		temp = new ListNode();
		int flag=0;
		if(first == null)
		{
			first = temp;
			first.value=value;
			first.key=key;
			/*temp.value=value;
			temp.key=key;
			temp.next=null;*/
			size++;
			
		}
		else if(first.next==null&&key.equals(first.key))
		{
			
			first.value=value;
			/*String s = (String) first.value;
			//temp1.value=value;
			first.value = s+","+value;*/
			
		}
		else
		{
			temp1 = first;
			while(temp1.next!=null)
			{
				if(temp1.key.equals(key))
				{
					flag=1;
					break;
				}
				temp1 = temp1.next;
			}
			if(flag==1)
			{
				/*String s = (String) temp1.value;
				//temp1.value=value;
				temp1.value = s+","+value;*/
				temp1.value=value;
			}
			else if(key.equals(temp1.key))
			{
				//String s = (String) temp1.value;
				temp1.value=value;
				//temp1.value = s+","+value;
	
			}
		/*	if(flag==1)
			{
				//temp1.value=value;
				String s = (String) temp1.value;
				//temp1.value=value;
				temp1.value = s+","+value;
			}*/
			else
			{
			temp1.next = temp;
			temp.value=value;
			temp.key=key;
			//temp.next=first;
			temp1 = temp;
			//first=temp;
			
			
			size++;
			}
		}
	}
		
		// TODO Auto-generated method stub
		
	

	@Override
	public void remove(K key) 
	{
		// TODO Auto-generated method stub
		temp1 = first;
		temp = first;
	    //temp2=null;
		if(size==0)
		{
			System.out.println("Deletion is not possible");
		}
		/*if(first.key==key)
		{
			temp=first.next;
			first=temp;
			size--;
			
		}*/
		/*	while(temp1!=null)			
			{
				System.out.println(key+"    "+temp.key);
				if(key.equals(temp.key))
				{
					System.out.println("hello");
					temp.next = temp1.next;
					System.out.println(temp.key+" has been deleted");
					size--;
					break;
				}
				temp = temp1;
				temp1 = temp1.next;
					
					//temp = temp1;
				
			}*/
		for(int i=0;i<size;i++)
		{
			//System.out.println(key+"    "+temp.key);
			if(key.equals(temp1.key))
			{
				//System.out.println("hello");
				temp.next = temp1.next;
				System.out.println(temp1.key+" has been deleted");
				size--;
				break;
			}
			temp = temp1;
			temp1 = temp1.next;
			
		}
			if(temp1 == null)
				System.out.println("Key is not found");
		}
		
	
	public void display()
	{
		ListNode temp;	
		temp = first;
		while(temp!=null)
		{
			System.out.println(temp.key+"->"+temp.value);
			temp = temp.next;
			
		}
		System.out.println();
	}
	public boolean isempty()
	{
		if(first==null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public  boolean search(K key1)
	{
		ListNode temp;	
		temp = first;
		while(temp!=null)
		{
			if(key1.equals(temp.key))
				return true;
			 temp=temp.next;
		}
		return false;
	}

}


