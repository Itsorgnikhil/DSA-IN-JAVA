package Tries;
import Tries.tries.Node;

public class prefix_problem {
	static class Node{
		Node children[] =new Node[26];
		boolean eow=false;
		int frq;
		
		public Node() {
			for(int i=0 ;i<children.length;i++) {
				children[i]=null;
			}
			frq = 1;
			
		}
	}
	
	public static Node root = new Node();// root node hamesa khali rehti hai isliye
	public static void insert(String word) {
		Node curr=root;
		for(int level=0;level<word.length();level++) {
			int idx=word.charAt(level)-'a';
			if(curr.children[idx] == null) {
				curr.children[idx] = new Node();
			}else {
			 curr.children[idx].frq++;
		}
		
			curr= curr.children[idx];
		}
		
		curr.eow=true;
		
	}

 
	public static void findprefix(Node root,String ans) {
		  if(root==null) {
			  return;
		  }
		  if(root.frq ==1) {
			  System.out.println(ans);
			  return;
		  }
		for(int i=0;i<root.children.length;i++) {
			if(root.children[i] !=null) {
				findprefix(root.children[i],ans+(char)(i+'a'));
			}
		}
		
	} 
	
	

public static void main (String arg[]) {
	String words[] = {"zebra","dog","duck","dove"};
	
	for(int i=0;i<words.length;i++ ) {
		insert(words[i]);
//		System.out.println(words[i]);
	}
		root.frq =-1;
		
		findprefix(root, "");
	

}}