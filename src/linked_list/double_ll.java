package linked_list;

import linked_list.linked_list.node;

public class double_ll {
	public static class node {
		int data;
		node next;
		node prev;
		public node(int data) {
			this.data=data;
			this.next=null;
			this.prev=null;
		}
	}
	// head node & tail node
	public static node head;
	public static node tail;
	// for size of linked list 
	public static int size;




	public void addfirst(int data) {
		// yaha par maine nayi node create ke hai
		node newnode = new node(data); 
		size++;
		
		// if ll is empty then head = null
		if(head ==null) {
			head = tail = newnode;
			return;
		}
		// yaha par head ki value newnode man store kara de hai
		newnode.next = head; 
		// head yaha point kar raha hai new node ki head ki value abb new node main hai
		head.prev = newnode; 
		head =newnode;
	}
	        



	public void addlast(int data) {
		node newnode = new node(data);
		size++;
		if(head == null) {
			head = tail = newnode;
			return;
		}
		tail.next = newnode;
		newnode.prev = tail;
		tail = newnode;
	}





	public static int remove_first() {  
		if(size==0) {
			System.out.println(" doubly linked list is empty");
			return Integer.MIN_VALUE;
		}
		else if(size==1) {
			int val = head.data;
			head = tail = null;
			size=0;
			return val;
			
		}
	int val = head.data;
	head=head.next;
	head.prev=null;
	size--;
	return val;
	}




	public int remove_last() {
		if(size==0) {
			System.out.println("linked list is empty");
			return Integer.MIN_VALUE;
		}
		else if(size==1) {
			int val = head.data;
			head = tail = null;
			size=0;
			return val;
			
		}
		tail =tail.prev;
		tail.next=null;
		return 0;
	}
	 


	public void reverse() {
		node prev =null;
		node curr = head;
		node next;
		while(curr!=null) {
			next =curr.next;
			curr.next = prev;
			curr.prev = next;
		prev= curr;
		curr = next;
		}
		head = prev;
	}

	public void print() {
		if(head ==null) {
			System.out.println("Linked-list is empty");
			return;
			
		}
		node temp =head;
		while(temp != null) {
			System.out.print(temp.data+"<< >> ");
			temp=temp.next;

		}
		System.out.println("null");
	}

public static void main (String [] args) {
	double_ll dl = new double_ll();
	dl.addfirst(20);
	dl.addfirst(21);
	dl.addfirst(22);
	dl.addfirst(23);
	dl.addfirst(24);
	dl.addfirst(25);
	dl.print();
}


}
