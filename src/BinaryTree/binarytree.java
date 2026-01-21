package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.MinimalHTMLWriter;

import STACKS.stacks_by_ll;

public class binarytree {

	static class node{
		int data;
		node left;
		node right;
		
		node (int data){
			this.data = data;
			this.left = null;
			this.right =null;
			
		}		
	}
	
	static class Binarytree{
		static int idx=-1;
		public static node buildtree(int nodes[]) {
		idx++;
		if(nodes[idx] == -1) {
			return null;
		}
		node newnode = new node(nodes[idx]);
		newnode.left=buildtree(nodes);
		newnode.right=buildtree(nodes);
		return newnode;
	}}
	
	
	public static void preorder(node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	public static void postorder(node root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	
	public static void level_order(node root) {
		if(root == null) {
			return;
		}
		
		Queue<node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		
		while(!q.isEmpty()) {
			node currnode = q.remove();
			if(currnode==null) {
				System.out.println();
				
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				System.out.print(currnode.data+"  ");
				if(currnode.left!=null) {
					q.add(currnode.left);
				}
				if(currnode.right!=null) {
					q.add(currnode.right);
				}
			}
		}
	}
	
	public static int height(node root) {
		if(root == null) {
			return 0;
		}
		
		int lh = height(root.left);
		int rh = height( root.right);
		return Math.max(lh, rh)+1;
	}
	
	public static int count(node root) {
		if(root == null) {
			return 0;
		}
		int lc =count(root.left);
		int rc = count(root.right);
		return lc+rc+1;
	}
	
	public static int sum(node root) {
		if(root == null) {
			return 0;
		}
		int ls =sum(root.left);
		int rs = sum(root.right);
		return ls+rs+root.data;
	}

	
	public static int diameter2(node root) {
		if(root==null) {
			return 0;
		}
		
		int leftdiam= diameter2(root.left);
		int rightdiam =diameter2(root.right);
		int lht=height(root.left);
		int rht=height(root.right);
		
		return Math.max(Math.max(rightdiam, leftdiam), lht+rht+1);
	}
	
//	
//	static class Info{
//		int dia;
//		int ht;
//		public Info(int dia,int ht) {
//			this.dia=dia;
//			this.ht=ht;
//		}
//	}
//	
//    public static Info diameter(node root) {
//    	if(root==null) {
//    		return new Info(0, 0);
//    	}
//    	Info leftInfo=diameter(root.left);
//    	Info rightInfo=diameter(root.right);
//    	int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
//    	int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
//    	
//    	return new Info(dia, ht);
//    }
//	
//	
    
    
    // check subtree of another tree
    public static boolean isidentical(node root,node subroot) {
    	if(root==null&&subroot==null) {
    		return true;
    	}
    	else if(root==null||subroot==null|root.data!=subroot.data){
    		return false;
    		}
    	if(!isidentical(root.left,subroot.left)){
    		return false;
    	}
    	if(!isidentical(root.right,subroot.right)){
    		return false;
    	}
    	return true;
    	}
	
    
    public static boolean issubtree(node root,node subroot) {
    	if(root==null) {
    		return false;
    	}
    	
    	if(root.data==subroot.data) {
    		if(isidentical(root, subroot)) {
    			return true;
    		}
    	}
    	return issubtree(root.left, subroot)||issubtree(root.right, subroot);
    }
    
    
    
    
    
 // top view of a tree
    static class info{
    	node root;
    	int hd;
    	public info(node root,int hd) {
    		this.root=root;
    		this.hd=hd;
    		
    	}
    }
    public static void topview(node root) {
    	// level order
    	Queue<info> q =new LinkedList<>();
    	HashMap<Integer,node> map = new HashMap<>();
    	int min =0;int max=0;
    	q.add(new info(root, 0));
    	q.add(null);
    	
    	while(!q.isEmpty()) {
    		info curr =q.remove();
    		if(curr==null) {
    			if(q.isEmpty()) {
    				break;
    			}else {
    				q.add(null);
    			}
    		} else {
    			if(!map.containsKey(curr.hd)) {//first time my hd is occure
    				map.put(curr.hd,curr.root);
    			}
    			if(curr.root.left!=null) {
    				q.add(new info(curr.root.left, curr.hd-1));
    				min=Math.min(min, curr.hd-1);	
    			}
    			if(curr.root.right!=null) {
    				q.add(new info(curr.root.right, curr.hd+1));
    				max=Math.max(max, curr.hd+1);	
    			}
    		}
    	}
    	for(int i=min;i<=max;i++) {
    		System.out.print(map.get(i).data+" ");
    	}
    }
    
    
    
    // lowest common ansester
    
    // therer are two methodes to do that 
    public static node lca(node root,int n1,int n2) {
    	
    	if(root==null||root.data==n1||root.data==n2) {
    		return root;
    	}
    	
    	node leftlca=lca(root.left, n1, n2);
    	node rightlca=lca( root.right, n1, n2);
    	
    	// left lca ==val or right lca ==null 
    	//yani hame left main variable mill gaya hai lekin rihght main nhi mila hai
    	
    	if(rightlca==null) {
    		return leftlca ;
    		
    	}
    	//same for here
    	if(leftlca==null) {
    		return rightlca ;
    	}
    	
    	return root;
    }
    
    
    
   // second method using arraylist
    public static node lca2(node root,int n1,int n2) {
    	ArrayList<node> path1= new ArrayList<>();
     	ArrayList<node> path2= new ArrayList<>();
     	
     	getpath(root, n1, path1);
     	getpath(root, n2, path2);
     	//lat common ansester
     	int i=0;
     	for(; i<path1.size()&&i<path2.size();i++) {
     		if(path1.get(i)!=path2.get(i)) {
     			break;
     			
     		}
 
     	}
        //last equal node i+1th
 		node lca2=path1.get(i-1);
 		 return lca2;
     	
    }
    public static boolean getpath(node root,int n,ArrayList<node> path) {
    	if(root==null) {
    		return false;
    	}
    	path.add(root);
    	if(root.data==n) {
    		return true;
    	}
    	boolean foundlt=getpath(root.left, n, path);
    	boolean foundrt=getpath(root.right, n, path);
    	
    	if(foundlt||foundrt) {
    		return true;
    	}
    	path.remove(path.size()-1);
    	return false;
    	}
    
    
    // kth level of the tree
    public static void klevel(node root,int level,int k) {
    	if(root==null) {
    		return;
    	}
    	if(level==k) {
    		System.out.print(root.data+" ");
    	}
    	klevel(root.left, level+1, k);
    	klevel(root.right, level+1, k);
    }

    
    // min distance betwwen the nodes
    public static int mindist(node root,int n1,int n2) {
    	node lca = lca(root, n1, n2);
    	int dist1=lcadist(lca,n1);
    	int dist2=lcadist(lca,n2);
    	return dist1+dist2;
    }
    public static int lcadist(node root,int n) {
    	if(root==null) 
    		return-1;
    	
    	if(root.data==n)
    		return 0;
    	int leftDist =lcadist(root.left, n);
    	int rightDist=lcadist(root.right, n);	
    	if(leftDist==-1&&rightDist==-1) {
    		return -1;
    	}
    	else if(leftDist==-1) {
    		return rightDist+1;
    		
    	}
    	else {
    		return leftDist+1;
    	}
    }
    
    
    // kth ansester
    public static int kansester(node root,int n,int k) {
        if (root == null) return -1;  // <-- check null first
    	if(root.data==n) {
    		return 0;
    	}
    	
    	int leftdist=kansester(root.left, n, k);
    	int rightdist=kansester(root.right, n, k);
    	if(leftdist==-1&&rightdist==-1) {
    		return -1;
    		}
    	int max=Math.max(leftdist, rightdist);
    	if(max+1==k) {
    		System.out.print(root.data);
    	}
    	return max+1;

    }
    
    public static int transform(node root) {
    	if(root==null) {
    		return 0;
    	}
    	int leftchild=transform(root.left);
    	int rightchild=transform(root.right);
    	int data = root.data;
    	int newleft=root.left==null?0:root.left.data;
    	int newright=root.right==null?0:root.right.data;
    	
    	root.data=newleft +leftchild+newright+rightchild;
    	return data;
    }
    
	public static void main(String args[]) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,};
		Binarytree tree =new Binarytree();
		node root= tree.buildtree(nodes);
		System.out.println(root.data);
		postorder(root);
		System.out.println();
//		preorder(root);
//		System.out.println();
//		inorder(root);
//		System.out.println();
//		level_order(root);
//		
//node root =new node(1);
//root.left=new node(2);
//root.right=new node(3);
//root.left.left=new node(4);
//root.left.right=new node(5);
//root.right.left=new node(6);
//root.right.right=new node(7);
//
//kansester(root, 5,1 );
//System.out.println();
//transform(root);
//preorder(root);
//System.out.println(mindist(root, 4, 6));
//System.out.println(lca(root, 4, 6).data);
//klevel(root, 1,3 );
//System.out.println(height(root));
//System.out.println(count(root));
//System.out.println(sum(root));
//System.out.println(diameter2(root));
//System.out.println(diameter(root).ht);
//topview(root);
//
//node subroot= new node(2);
// subroot.left= new node(7);
// subroot.right=new node(5);
// 
// System.out.println(issubtree(root, subroot));

	}
}