package DYNAMIC_PROGRAMMING;


public class knapsack_0_1 {
	public  static int kn_by_re(int val[],int wt[],int w,int n){ 
		if(w==0||n==0) {
			return 0;
		}
		if(wt[n-1]<=w) {//valid
			//include
	int ans1 =	val[n-1]+kn_by_re(val, wt, w-wt[n-1], n-1);
	
	//exclude
	int ans2 = kn_by_re(val, wt, w, n-1);
	return Math.max(ans1, ans2);
			
		}
		else {// not valid exclude
			return  kn_by_re(val, wt, w, n-1);
		
	}
	}
		
		public  static int kn_by_me(int val[],int wt[],int w,int n,int dp[] []){ 
			if(w==0||n==0) {
				return 0;
			}
			if(dp[n][w]!=-1) {
				return dp[n][w];
			}
			if(wt[n-1]<=w) {//valid
				//include
		int ans1 =	val[n-1]+kn_by_me(val, wt, w-wt[n-1], n-1,dp);
		
		//exclude
		int ans2 = kn_by_me(val, wt, w, n-1,dp);
		return  dp[n][w]=Math.max(ans1, ans2);
				
			}
			else {// not valid exclude
				return dp[n][w]= kn_by_me(val, wt, w, n-1,dp);
			
		}
}
	public static int kn_by_tab(int val[],int wt[],int W) {
		int n= val.length;
		int dp[] [] = new int[n+1] [W+1];
		for(int i=0;i<n+1;i++) {//oth col
			dp[i] [0] =0;
		}
		for(int j=0;j<W+1;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				int v=val[i-1];
				int w= wt[i-1];
				if(w<=j) {
					int incProfit = v+dp[i-1][j-w];
					int excProfit = dp[i-1][j];
					dp[i][j] = Math.max(incProfit, excProfit);
				}else {
					int excProfit = dp[i-1][j];
					dp[i][j] = excProfit;				}
			}
		}
		return dp[n][W];
	}
	public static boolean target_sum(int arr[],int sum) {//O(n*sum)
		int n=arr.length;
		boolean dp[] [] =new boolean[n+1][sum+1];
		// i=items & j= target sum
		for(int i=0;i<n+1;i++) {
			dp[i][0] = true;
		} 
		for(int j=0;j<n+1;j++) {
			dp[0][j] = true;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
			
				//include
				if(arr[i-1]<=j&&dp[i-1][j-arr[i-1]]  == true) {
					dp[i][j]=true;
				}
				//exclude
				else if(dp[i-1][j] == true) {
					dp[i][j] = true;
				}
			}
		}
		return dp[n][sum];
		
	}
	public static int unboundedkn_by_tab(int val[],int wt[],int W) {// O(N*W
		int n= val.length;
		int dp[] [] = new int[n+1] [W+1];
		for(int i=0;i<dp.length;i++) {//oth col
			dp[i] [0] =0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				int v=val[i-1];
				int w= wt[i-1];
				if(w<=j) {
					int incProfit = v+dp[i][j-w];
					int excProfit = dp[i-1][j];
					dp[i][j] = Math.max(incProfit, excProfit);
				}else {
					int excProfit = dp[i-1][j];
					dp[i][j] = excProfit;				}
			}
		}
		return dp[n][W];
	}
	
	public static int min_partition(int val[],int wt[]) {
		int n= val.length;
		int sum=0;
		for(int i=0;i<val.length;i++) {
			sum+=val[i];
		}
		
		int W1 =sum/2;
		int dp[] [] = new int[n+1] [W1+1];
		for(int i=0;i<dp.length;i++) {//oth col
			dp[i] [0] =0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W1+1;j++) {
				int v=val[i-1];
				int w= wt[i-1];
				if(w<=j) {
					int incProfit = v+dp[i-1][j-w];
					int excProfit = dp[i-1][j];
					dp[i][j] = Math.max(incProfit, excProfit);
				}else {
					int excProfit = dp[i-1][j];
					dp[i][j] = excProfit;				}
			}
		}
		int sum1 = dp[n][W1];
		int sum2 = sum-sum1;
		return Math.abs(sum2-sum1);
		}
	public static void main (String args[]) {
//		int val[] = {15,14,10,45,30};
//		int wt[] = {2,5,1,3,4};
//		int w=7;
//		int dp[][]= new int [val.length+1][w+1];
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				dp[i][j]=-1;
//			}
//		}
//		System.out.println(kn_by_re(val, wt, w, val.length));
//		System.out.println(kn_by_me(val, wt, w, val.length,dp));
//		System.out.println(kn_by_tab(val, wt, w));
//System.out.println(unboundedkn_by_tab(val, wt, w));
		int num[] = {1,6,11,5};
//		int target =10;
//		System.out.println(target_sum(num, target));
		System.out.println(min_partition(num, num));
	}
	

}
