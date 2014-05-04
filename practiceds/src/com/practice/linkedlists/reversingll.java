package com.practice.linkedlists;


class ListNode
{
	private Object data;
	public ListNode next;
	public ListNode(Object data,ListNode next)
	{
		this.data=data;
		this.next=next;
	}
	public ListNode() 
	{
		this.data=null;
		this.next=null;
	}
	public void setData(Object data)
	{
		this.data=data;
	}
	public Object getData()
	{
		return this.data;
	}
	
}
class LinkedList {

	/**
	 * @param args
	 */
	private ListNode head;
	private int size;
	public LinkedList()
	{
		head=new ListNode();
		size=0;
	}
	public boolean addFirst(Object data)
	{
		head.next=new ListNode(data,head.next);
		return true;
	}
	
	public void addLast(Object data)
	{
		  if(head == null) addFirst(data);
		   else
		   {
		      ListNode tmp = head;
		      while(tmp.next != null) tmp = tmp.next;

		      tmp.next = new ListNode(data, null);
		   }
	}
	public int listCount(ListNode head)
	{
		ListNode current=head.next;
		int count=0;
		while(current!=null)
		{
			++count;
			current=current.next;
			
			
		}
		return count;	
	}
	public int getCount()
	{
		return listCount(head);
	}
	public boolean find(Object data)
	{
		ListNode current;
		for(current=head.next;current!=null;current=current.next)
		{
			if(current.getData().equals(data))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		ll.addFirst(new Integer(10));
		ll.addFirst(new Integer(20));
		//ll.addLast(new Integer(30));
		System.out.println(ll.getCount());
		System.out.println(ll.find(new Integer(40)));
	}

}
