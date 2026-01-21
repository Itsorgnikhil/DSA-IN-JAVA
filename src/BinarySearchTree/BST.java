package BinarySearchTree;
import java.awt.Window;
import java.util.*;

import org.w3c.dom.NamedNodeMap;

public class BST {
	static class node{
		int data;
		node left;
		node right;
		
		node(int data){
		this.data =data;
		
		}
		
	}
	
	public static node insert(node root ,int val) {
		if(root==null) {
			root= new node(val);
			return root;
		}
	if(root.data>val) {
		root.left = insert(root.left,val);
	}
	else {
		root.right=insert(root.right, val);
	}
	return root;
	}

	
	public static void inorder(node root) {
		if(root==null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	
	public static boolean search(node root,int key) {
		if(root==null) {
			return false;
		}
		if(root.data==key) {
			return true;
		}
		if(root.data<key) {
			return search(root.right, key);
		}
		else {
			return search(root.left, key);
		}
	}
	
	
	
	public static node delete(node root,int val) {
		if(root.data < val) {
			root.right= delete(root.right, val);
		}
		else if(root.data>val){
			root.left = delete(root.left, val);
		}
		
		else {//voila
			// case 1 - leaft node
			if(root.left==null &&root.right==null)	{
			return null;	
			}
			
			// case 2 - one child
			if(root.left == null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			
			//case 3 - both childern
			
		    node IS = findInorderSuccesssor(root.right);
		    root.data= IS.data; 
			root.right = delete(root.right, IS.data);
		}
		
		return root;
		
	}
	
	public static node findInorderSuccesssor(node root) {
		while(root.left !=null) {
			root = root.left;
		}
		return root;
	}
	
	
	
	
	public static void printInRange(node root,int k1,int k2) {
		
		if(root==null) {
			return;
		}
		if(root.data>=k1 && root.data<=k2) {
			printInRange(root.left, k1, k2);
			System.out.println(root.data+" ");
			printInRange(root.right, k1, k2);
		}
		else if(root.data <k1) {
			printInRange(root.right, k1, k2);
		}
		else {
			printInRange(root.left, k1, k2);
		}
		
	} 
	
	public static void printpath(ArrayList<Integer>path) {
		for(int i=0;i<path.size();i++) {
			System.out.print(path.get(i)+" ");
		}
		System.out.println("Null");
	}
	
	public static void printRoot2leaf(node root,ArrayList<Integer>path) {
		
		if(root==null) {
			return;
		}
		
		path.add(root.data);
		if(root.left==null && root.right==null) {
			printpath(path);
		}
		printRoot2leaf(root.left, path);
		printRoot2leaf(root.right, path);
		path.remove(path.size()-1);
	}
	
	
  	public static boolean isvalidBst(node root,node min, node max) {
		if(root==null) {
			return true;
			
		}
		
		if(min!=null&& root.data<=min.data) {
			return false;
		}
		else if(max!=null && root.data>=max.data) {
			return false;
		}
		
		return isvalidBst(root.left, min, root) &&
				isvalidBst(root.right,root, max);
	}
	
	public static node createMirror(node root) {
		if(root==null) {
			return null;
		}
		node lm= createMirror(root.left);
		node rm= createMirror(root.right);
		
		root.left=rm;
		root.right=lm;
		return root;
	
	}
	
	public static void preorder(node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static node creatbst(int arr[],int st,int ed) {
		if(st>ed) {
			return null; 
			
		}
		
		int mid=(st+ed)/2;
		node root = new node(arr[mid]);
		root.left=creatbst(arr, st, mid-1);
		root.right =creatbst(arr, mid+1, ed);
		return root;
	}
	public static void getInorder(node root,ArrayList<Integer>inorder) {
		if(root==null) {
			return;
			
		}
		getInorder(root.left, inorder);
		inorder.add(root.data);
		getInorder(root.right, inorder);
		
	}
	
	public static node creatbST(ArrayList<Integer>inorder,int st,int ed) {
		if(st>ed) {
			return null; 
			
		}
		
		int mid=(st+ed)/2;
		node root = new node(inorder.get(mid));
		root.left=creatbST(inorder, st, mid-1);
		root.right =creatbST(inorder, mid+1, ed);
		return root;
	}
	
	public static  node balancebst(node root) {

		//inorder squence 
		ArrayList<Integer> inorder = new ArrayList<>();
		getInorder(root,inorder);
		
		// sorted inorder -> balanced bst
		root = creatbST(inorder, 0,inorder.size()-1 );
		
		return root;
	}
	
	
	
	
	static class info {
		boolean isBST;
		int size;
		int min;
		int max;
		
		public info(boolean isBST,int size,	int min,int max) {
			this.isBST= isBST;
			this.size=size;
			this.min=min;
			this.max=max;
		}
	}
	
	public static int maxBST = 0;
	public static info largestBST(node root) {
		
		if(root==null) {
	return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
				
		}
		
		info leftinfo = largestBST(root.left);
		info rightinfo = largestBST(root.right);
		int size = leftinfo.size + rightinfo.size+1;
		int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
		int max = Math.max(root.data, Math.max(leftinfo.max,rightinfo.max));
		
		if(root.data <= leftinfo.max || root.data>= rightinfo.min) {
			return new info(false, size, min, max);
		}
		if(leftinfo.isBST&& rightinfo.isBST) {
			maxBST = Math.max(maxBST, size);
			return new info(true, size, min, max);
		}
		return new info(false, size, min, max);
	}

	
	public static node mergeBSTs(node root1,node root2) {
		// step 1
		 ArrayList<Integer> arr1 = new ArrayList<>();
		 getInorder(root1, arr1);
		 
		 // step 2
		 ArrayList<Integer> arr2 = new ArrayList<>();
		 getInorder(root2, arr2);
		 
		 
		 // merge
		 int i=0,j=0;
		 ArrayList<Integer> finalArr = new ArrayList<>();  
		 while(i<arr1.size() && j<arr2.size()) {
			 if(arr1.get(i) <= arr2.get(j)) {
				 finalArr.add(arr1.get(i));
				 i++;
			 }
			 else {
				 finalArr.add(arr2.get(j)); 
				 j++;
			 }
		 }
		 
		 while(i<arr1.size()) {
			 finalArr.add(arr1.get(i));
			 i++;
		 }
		 
		 while(j<arr2.size()) {
			 finalArr.add(arr2.get(j)); 
			 j++;
		 }
		 
		 // sorted arrlist to balence tree
		 return creatbST(finalArr, 0, finalArr.size()-1);
	}
	
	
public static void main (String args[]) {
	//int values[] = {8,5,3,1,4,6,10,11,14};
	//int values[] = {1,1,1};
	//int arr[] = {3,5,6,8,10,11,12};
//	node root =null;
//	for(int i=0;i<values.length;i++) {
//		root=insert(root, values[i]);
//		
//	}
//	inorder(root);
//	System.out.println();
//	 
//	printInRange(root, 1, 5);
//	printRoot2leaf(root, new ArrayList<>());
//	
//	System.out.println(isvalidBst(root, null, null));

//	node root= creatbst(arr, 0, arr.length-1);
//	preorder(root);
	
//	node root = new node(50);
//	root.left = new node(30);
//	root.left.left = new node(5);
//	root.left.right = new node(20);
//	
//	
//	root.right = new node(60);
//	root.right.left = new node(45);
//	root.right.right = new node(70);
//	root.right.right.left = new node(65);
//	root.right.right.right = new node(80);
//	root = balancebst(root);
//	preorder(root);

//	info INFO = largestBST(root);
//	System.out.println(maxBST);
	
	node root1 = new node(2);
	root1.left = new node(1);
	root1.right= new node(4);

	  
	node root2 = new node(9);
	root2.left = new node(3);
	root2.right= new node(12);

	
	
	node root = mergeBSTs(root1 , root2);
	preorder(root);
}

}
