package searchEngine.priorityQueue;

public interface PQueueADT{

	/*
	 * Inserts the element in the priority Queue
	 */
	public void enqueue(int value);
 
	/*
	 * Deletes the Priority(first element) element from the Queue.
	 */
	public int dequeue();
 
	/*
	 * Returns the number of elements of the Queue
	 */
	public int size();
 
	/*
	 * Returns true if Queue is empty and false otherwise. 
	 */
	public boolean is_empty();
 
	/*
	 * Returns the Priority(first element) element of the Queue 
	 */
	public int front();
}
