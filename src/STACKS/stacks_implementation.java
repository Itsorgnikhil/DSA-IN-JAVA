package STACKS;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;




/// stack implementation by arraylist
public class stacks_implementation {
	static ArrayList<Integer> list = new ArrayList<>();
	// is empty
	public static boolean isempty() {
		return list.size()==0;
		
}
	// push 
	public static void push(int data) {
		list.add(data);
		
	}
	//pop
	public static int pop() {
		if(isempty()) {
			return -1;
		}
		int top = list.get(list.size()-1);
		list.remove(list.size()-1);
		return top;
	}
	// peek
	public static int peek() {
		if(isempty()) {
			return -1;
		}
		return list.get(list.size()-1);
	}
 public static void main(String args[]) {
	 
	 stacks_implementation s = new stacks_implementation();
	 
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
