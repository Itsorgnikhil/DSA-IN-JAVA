package Segment_trees;

public class segment_tree{
	static int tree[];
	public static void init(int n) {
		tree = new int[2*n-1];
	}
	public static int buildST(int arr[],int stI,int start,int end){ // O(n)
	
		if(start == end) {
			tree[stI] =arr[start];
			return arr[start];
		}///                       sti means segment tree ith index
		int mid=(start+end)/2;
		buildST(arr, 2*stI+1, start, mid);//left subtree - 2*i+1
		buildST(arr, 2*stI+2, mid+1, end);// right subtree -2*i+2
		
		tree[stI]= tree[2*stI+1]+tree[2*stI+2];
		return tree[stI];
	}
		public static int getsumutil(int i, int si ,int sj , int qi , int qj){ //O(logn)
			if(qj<=si || qi>=sj) {// non overlapping
				return 0;
			}else if(si>=qi && sj <=qj){// complete overlap
				return tree[i];
			}else {// partial overlap
				int mid = (si+sj)/2 ;
				int left =getsumutil(2*i+1, si, mid, qi, qj);
				int right = getsumutil(2*i+2, mid+1, sj, qi, qj);
				
				return left+right;
			}
		}
		
		
		public static int getsum(int arr[],int qi,int qj) {
			int n =arr.length;
			return getsumutil(0, 0, n-1, qi, qj);
		}
	
	
	
	
	public static void updateutil(int i,int si,int sj ,int idx, int diff) { // log(n)
		if(idx> sj || idx < si) {
			return;
		}
		tree[i] +=diff;
		if(si != sj) {
			//non -leaf
			int mid = (si+sj)/2;
			updateutil(2*i+1, si, mid, idx, diff);//left
			updateutil(2*i+2, mid+1, sj, idx, diff);// right
		}
	}
		
	public static void update(int arr[] , int idx, int newval) {
		int n = arr.length;
		int diff = newval - arr[idx];
		arr[idx] = newval;
		updateutil(0, 0, n-1, idx, diff);  // segment tree updation
	}
	
	
	
	
	public static int Max_subarry(int arr[],int stI,int start,int end){ // O(n)
		
		if(start == end) {
			tree[stI] =arr[start];
			return arr[start];
		}///                       sti means segment tree ith index
		int mid=(start+end)/2;
		Max_subarry(arr, 2*stI+1, start, mid);//left subtree - 2*i+1
		Max_subarry(arr, 2*stI+2, mid+1, end);// right subtree -2*i+2
		
		tree[stI]= Math.max(tree[2*stI+1],tree[2*stI+2]);
		return tree[stI];
	}
	
	
	
	public static int getMax(int arr[],int qi,int qj) {
		int n= arr.length;
		return getmaxUtil(0, 0, n-1, qi, qj);
	}
	
	public static int getmaxUtil(int i,int si,int sj,int qi,int qj) {
		if(si>qj || sj<qi) { // no overlap
			return Integer.MIN_VALUE;
		}else if(si>=qi && sj<=qj) { // complete overlap
			return tree[i];
		}else {// partial overlap
			int mid = (si+sj)/2;
			int leftAns = getmaxUtil(2*i+1, si, mid, qi, qj) ;
			int rightAns = getmaxUtil(2*i+2, mid+1, sj, qi, qj);
			return Math.max(leftAns, rightAns);
		}
	}
	public static void updatemaxutil(int i,int si,int sj ,int idx, int newVal) { // log(n)
		if(idx> sj || idx < si) {
			return;
		}
		tree[i] =Math.max(tree[i], newVal);
		if(si != sj) {
			//non -leaf
			int mid = (si+sj)/2;
			updatemaxutil(2*i+1, si, mid, idx, newVal);//left
			updatemaxutil(2*i+2, mid+1, sj, idx, newVal);// right
		}
		/// fro minimum 
		///tree[i] =Math.max(tree[i], newVal);
		///this condition will be under the non leaf and 
		///add new condition 
		///if(si==sj){
		///tree[i] =newVal;
		///}
		
	}
	
	public static void updatemax(int arr[] , int idx, int newval) {
		
		arr[idx] = newval;
		int n = arr.length;
		updatemaxutil(0, 0, n-1, idx, newval);  // segment tree updation
	}
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5,6,7,8};
		int n= arr.length;
		
		init(n);
		buildST(arr, 0, 0, n-1);//
		
		
		
		for(int i=0;i<tree.length;i++) {
			System.out.print(tree[i]+  " ");
		}
		System.out.println();
		
		System.out.println(getsum(arr, 2, 5));
		update(arr, 2, 2);
		System.out.println(getsum(arr, 2, 5));
		
		int rr[] = {6,8,-1,2,17,1,3,2,4};
		int m= arr.length;
		init(m);
		System.out.println(Max_subarry(rr, 0, 0, m-1));;
		System.out.println(getMax(rr, 2, 5));
		
		}
	
}