package STACKS;

public class stacks_by_ll {

	public static class node {
		int data;
		node next;
		public node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public static node head = null;
	
	public static boolean isempty() {
		return head ==null;
	}
	//push
	public static void push(int data) {
		node newnode = new node(data);
		
		if(isempty()) {
			head=newnode;
			return;
		}
		newnode.next =head;
		head = newnode;
	}
	//pop
	public static int pop() {
		if(isempty()) {
			
			return -1;
		}
int top = head.data;
head = head.next;
return top;
	}
	
	//peek
	public static int peek() {
if(isempty()) {
			
			return -1;
		}
return head.data;
	}
	public static void main(String args[]) {
		 
		 stacks_by_ll s = new stacks_by_ll();
		 
		 s.push(10);
		 s.push(20);
		 s.push(30);
		 s.push(40);
		 while(!s.isempty()) {
			 System.out.println(s.peek());
			 s.pop();
			 
		 }
		 
		 
	 }
}
