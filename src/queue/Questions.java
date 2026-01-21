package queue;

import java.security.PublicKey;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Questions {
// in this question i made queue from two stacks
	public static class queue{
		static Stack<Integer> s1 = new Stack<>();
		static Stack<Integer> s2 = new Stack<>();
		
		public static boolean isEmpty() {
			return s1.isEmpty();

		}
		//add o(n)
public static void add(int data) {
	while(!s1.isEmpty()) {
		s2.push(s1.pop());
		
	}
	s1.push(data);
	while(!s2.isEmpty()) {
		s1.push(s2.pop());
	}
}
		
		//remove
public static int remove() {
	if(isEmpty()) {
		System.out.println("queue is empty");
		return -1;
	}
	return s1.pop();
	
}
		//peek
public static int peek() {
	if(isEmpty()) {
		System.out.println("queue is empty");
		return -1;
	}
	return s1.peek();
}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 // in this question i have been made stack by using two queues
public static class stack{
	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	
	
	public static boolean isEmpty() {
		return q1.isEmpty()&&q2.isEmpty();
	}
	
	public static void add(int data) {
		if(!q1.isEmpty()) {
			q1.add(data);
		}else {
			q2.add(data);
		}
	}
	public static int pop() {
		if(isEmpty()) {
			System.out.println("quque is khale");
			return -1;
		}
		int top =-1;
		
		//case 1
		if(!q1.isEmpty()) {
			while(!q1.isEmpty()) {
				top = q1.remove();
				if(!q1.isEmpty()) {
					break;
				}
				q2.add(top);
			}
		}
		else {
			if(!q2.isEmpty()) {
				while(!q2.isEmpty()) {
					top = q2.remove();
					if(!q2.isEmpty()) {
						break;
					}
					q1.add(top);
				}
		}
			
	}
		return top;}
		
		public static int peek() {
			if(isEmpty()) {
				System.out.println("quque is khale");
				return -1;
			}
			int top =-1;
			
			//case 1
			if(!q1.isEmpty()) {
				while(!q1.isEmpty()) {
					top = q1.remove();
					
					q2.add(top);
				}
			}
			else {
				if(!q2.isEmpty()) {
					while(!q2.isEmpty()) {
						top = q2.remove();
						
						q1.add(top);
					}
		 }
			}
			return top;
	     }
       }
	
	

public static void printnonreapating(String atr) {
	
	int freq[] =new int [26];// 'a'-'z'
	Queue<Character> q = new LinkedList<>();
	for(int i=0;i<atr.length();i++) {
		char ch = atr.charAt(i);
		q.add(ch);
		freq[ch-'a'] ++;
		while(!q.isEmpty()&&freq[q.peek()-'a']>1) {
			q.remove();
		}
		if(q.isEmpty()) {
			System.out.print(-1+" ");
		}else {
			System.out.print(q.peek()+" ");
		}
	}
	System.out.println();
}


















public static void interleave(Queue<Integer> q) {
	Queue<Integer> firsthalf = new LinkedList<>();
	 int size = q.size();
	 for(int i=0;i<size/2;i++) {
		 firsthalf.add(q.remove());
	 }
	
	 while(!firsthalf.isEmpty()) {
		 q.add(firsthalf.remove());
		 q.add(q.remove());
	 }
}









public static void reverse(Queue<Integer> q) {
	Stack<Integer> s = new Stack<>();
	while(q.isEmpty()) {
		s.push(q.remove());
	}
	while(s.isEmpty()) {
		q.add(s.pop());
	}

	
}


/// here we using deque to implement stack
public static class stack1{
	
	static Deque<Integer> d = new LinkedList<>();
	public static void push(int data) {
		d.addLast(data);
	}
	public static void pop() {
		d.removeLast();
	}
	public static void peek() {
		d.getLast();
	}
}



/// here we using deque to implement queue
public static class queue1{
	
	static Deque<Integer> d = new LinkedList<>();
	public static void push(int data) {
		d.addLast(data);
	}
	public static void pop() {
		d.removeFirst();
	}
	public static void peek() {
		d.getFirst();
	}
}







	public static void main(String args[]) {
		
		String atr ="aabccxb";
	printnonreapating(atr);
		queue q = new queue();
//		q.add(1);
//		q.add(2);
//		q.add(3);
//
//while(!q.isEmpty()) {
//	System.out.println(q.peek());
//     q.remove();
//}
//	}
}}
