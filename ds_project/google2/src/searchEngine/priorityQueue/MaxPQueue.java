package searchEngine.priorityQueue;

public class MaxPQueue implements PQueueADT {
	int MAX;
	int first = 1;
	int lastIndex = first;
	int[] pQueue;
	
	public MaxPQueue(int size){
		MAX = size;
        pQueue = new int[ MAX ];
        //java.util.Arrays.fill( pQueue, (Integer) null );
	}
	
	public int dequeue() {
		// TODO Auto-generated method stub
		int rootElement = pQueue[first];
        int elementIndex = --lastIndex;
        int element = pQueue[ elementIndex ];
 
        pQueue[first] = element;
        pQueue[elementIndex] = (Integer)null;
        elementIndex = first;
 
        for( int minChildIndex; ( ( minChildIndex = minChild( elementIndex ) ) != (Integer)null ) 
            && ( pQueue[elementIndex] < pQueue[minChildIndex] ); ) {
 
            swap( elementIndex, minChildIndex );
            elementIndex = minChildIndex;			
        }
 
        return rootElement;
	}
	
	public void swap( int a, int b ) {
        int temp = pQueue[a];
        pQueue[a] = pQueue[b];
        pQueue[b] = temp;
    }
	
	public void enqueue(int value) {
		if( value < 0 || lastIndex == MAX ) {
            return;
        }
 
        int elementIndex = lastIndex++;
        pQueue[elementIndex] = value;
 
        while(pQueue[ elementIndex ] > pQueue[ parent( elementIndex ) ] ) {
            swap( elementIndex, parent( elementIndex ) );
            elementIndex = parent( elementIndex );
        }
	}
	
	public int parent(int index){
		return index/2;
	}
	public int left(int index){
		return 2*index;
	}
	public int right(int index){
		return 2*index+1;
	}

	@Override
	public int front() {
		// TODO Auto-generated method stub
		return pQueue[first];
	}

	@Override
	public boolean is_empty() {
		// TODO Auto-generated method stub
		return (lastIndex == first);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return pQueue.length;
	}
	
	public int minChild( int index ) {
		 
        int leftChildIndex = left( index );
        int rightChildIndex = right( index );
 
        if( leftChildIndex <= MAX && rightChildIndex <= MAX ) return (Integer)null;
        else if( rightChildIndex <= MAX ) return leftChildIndex;
 
        if( pQueue[leftChildIndex] == (Integer)null && pQueue[ rightChildIndex ] == (Integer)null ) return (Integer) null;
        else if( pQueue[rightChildIndex] == (Integer)null ) return leftChildIndex;
 
        return pQueue[ leftChildIndex ] >= pQueue[ rightChildIndex ] ? leftChildIndex : rightChildIndex;	
    }
	
	public void display(){
		System.out.println("The elements in the list are");
		for(int i=1;i<lastIndex;i++)
			System.out.println(pQueue[i]);
	}
}
