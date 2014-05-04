package searchEngine.priorityQueue;

import java.util.Scanner;

public class PQueueTest {
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		int size,choice,val;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the priority queue");
		size = scan.nextInt();
		MaxPQueue obj = new MaxPQueue(size);
		while(true){
			System.out.println("Choose from the below menu");
			System.out.println("1.Enqueue\n2.Dequeue\n3.Display\n4.First element\n5.Size\n6.IsEmpty\n7.Exit");
			choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter a value");
				val = scan.nextInt();
				obj.enqueue(val);
				break;
			case 2:
				System.out.println(obj.dequeue()+"Dequeued");
				break;
			case 3:
				obj.display();
				break;
			case 4:
				System.out.println("First :"+obj.front());
				break;
			case 5:
				System.out.println("Size of the priority queue: "+obj.size());
				break;
			case 6:
				if(obj.is_empty())
					System.out.println("Queue is empty");
				else
					System.out.println("Queue is not empty");
				break;
			case 7:
				System.exit(1);
				break;
			default:
				System.out.println("Wrong choice");
			}
		}
	}
}
