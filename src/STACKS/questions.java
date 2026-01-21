package STACKS;

import java.util.Stack;

public class questions {

	public static void pushATBottom(Stack<Integer>s,int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		int top =s.pop();
		pushATBottom(s, data);
		s.push(top);
	}
//	public static void main(String args[]) {
//		Stack<Integer>  s = new Stack<>();
//		 s.push(10);
//		 s.push(20);
//		 s.push(30);
//		 s.push(40);
//		 
//		 pushATBottom(s, 4);
//		 
//		 while(!s.isEmpty()) {
//			 System.out.println(s.pop());
//			
//			 
//		 }
		 public static String reverseString(String str) {
			 Stack<Character> s = new Stack<>();
			 int idx = 0;
			 while(idx<str.length()) {
				 s.push(str.charAt(idx));
				 idx++;
				 
			 }
			 StringBuilder result = new StringBuilder("");
			 while(!s.isEmpty()) {
				 char curr =s.pop();
				 result.append(curr);
				 
			 }
			 return result.toString();
		 }
//		 
//		 public static void main(String args[]) {
//			 String str ="abc";
//			 String result = reverseString(str);
//			 System.out.println(result);
//		 }
		 
		public static void reveseStack(Stack<Integer>s) {
			if(s.isEmpty()) {
				return;
			}
			int top = s.pop();
			reveseStack(s);
			pushATBottom(s, top);
			}
		 
		 public static void printStack(Stack<Integer>s) {
			 while(!s.isEmpty()) {
				 System.out.println(s.pop());
			 }
		 }
			public static void main(String args[]) {
			Stack<Integer>  s = new Stack<>();
			 s.push(10);
			 s.push(20);
			 s.push(30);
			 s.push(40);
			 reveseStack(s);
			 printStack(s);
	}
}
