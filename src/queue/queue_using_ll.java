package queue;

import queue.Queue_Array.queue;

public class queue_using_ll {

	
	public static class node{
		int data;
		node next;
		node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static class queue{
		static node head = null;
		static node tail =null;
	
	
	// is empty
	public static boolean isEmpty() {
		return head==null&&tail==null;
	}
	
	// add 0(1)
	public static void add(int data) {
		node newnode = new node(data);
		if(head==null) {
			head=tail=newnode;
			return;
		}
		tail.next = newnode;
		tail= newnode;
	}
	
	//remove
	public static int remove() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		}
		int front = head.data;
		if(tail==head) {
			tail=head=null;
		}else {
		head=head.next;
	}
		return front;
}
	// peek
	
	public static int peek()
	{if(isEmpty()) {
		System.out.println("queue is empty");
		return -1;
	}
	return head.data;
		
	}
	
}
	public static void main(String args[]) {
		queue q = new queue();
		q.add(1);
		q.add(2);
		q.add(3);

while(!q.isEmpty()) {
	System.out.println(q.peek());
     q.remove();
}
	}}