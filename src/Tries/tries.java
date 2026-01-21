package Tries;

import java.awt.geom.AffineTransform;
import java.security.PublicKey;

public class tries{

	static class Node{
		Node children[] =new Node[26];
		boolean eow=false;
		
		public Node() {
			for(int i=0 ;i<26;i++) {
				children[i]=null;
			}
		}
	}
	
	public static Node root = new Node();// root node hamesa khali rehti hai isliye
	public static void insert(String word) {
		Node curr=root;
		for(int level=0;level<word.length();level++) {
			int idx=word.charAt(level)-'a';
			if(curr.children[idx] == null) {
				curr.children[idx] = new Node();
			}
			curr= curr.children[idx];
		}
		curr.eow=true;
		
	}
	
	public static boolean search(String key) {
		Node curr=root;
		for(int level=0;level<key.length();level++) {
			int idx=key.charAt(level)-'a';
			if(curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		return curr.eow == true;
		
	}
	
	public static boolean wordbreak(String key) {
		if(key.length() ==0 ) {
			return true;
		}
		for(int i=1;i<=key.length();i++) {
			// substring(beg indx,lastindx)
			 if(search(key.substring(0, i)) && 
					 wordbreak(key.substring(i))) {
				 return true;
				 
			 } 
		}
		return false;
	}
	
	public static boolean Startswith(String key) {
		Node curr=root;
		for(int level=0;level<key.length();level++) {
			int idx=key.charAt(level)-'a';
			if(curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		return  true;
		
	}
	
	
	public static int countnodes(Node root) {
		if(root==null) {
			return 0;
		}
		
		int count =0;
		for(int i=0;i<26;i++) {
			if(root.children[i] !=null) {
		 		count +=countnodes(root.children[i]); 
			}
		}
		return count+1;
	}
	
	
	public static String ans="";
	public static void longestword(Node root,StringBuilder temp) {
		if(root==null) {
			return;
		}
		
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null && root.children[i].eow==true) {
				char ch = (char)(i+'a');
				temp.append(ch);
				if(temp.length() > ans.length()) {
					ans = temp.toString();
					
				}
				longestword(root.children[i], temp);
				temp.deleteCharAt(temp.length()-1);// backtracing
			}
		}
	}
	public static void main (String arg[]) {
//		String words[] = {"apple","app","mango","man","woman","ice"};
//		
//		for(int i=0;i<words.length;i++ ) {
//			insert(words[i]);
////			System.out.println(words[i]);
//		}
//		String keyString="ilikesamsung";
//		System.out.println(wordbreak(keyString));
//		String key="app";
//		System.out.println(Startswith(key));
//		
//		String str = "ababa";
//		/// suffix -> insert in tria
//		for(int i=0;i<str.length();i++) {
//			String suffix = str.substring(i);
//			insert(suffix);
//		}
//		System.out.println(countnodes(root));
//		
//	}

		String words[] = {"a","banana","app","appl","ap","apple"}; 
		
		
		for(int i=0;i<words.length;i++) {
			insert(words[i]);
			
		}
		
		longestword(root, new StringBuilder(""));
		System.out.println(ans);
	}
	
}