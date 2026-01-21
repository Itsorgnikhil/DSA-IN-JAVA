package DYNAMIC_PROGRAMMING;

public class Unbounded_knapsack {

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
	
	
	public static int coinChange(int coins[] , int sum) {
		int n = coins.length;
		int dp[] [] = new int [n+1] [sum+1];
		
		//initialize - sum is 0
		///i-> coins;j-> sum/change
		
		for(int i=0;i<n+1;i++) {
			dp[i][0] = 1;
		}
		for(int j=1;j<sum+1;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coins[i-1] <= j) {
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}
	
	public static int rodcutting(int val[],int wt[],int W) {
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
	public static void main (String args[]) {
		int val[] = {1,5,8,9,10,17,17,20};
		int wt[] = {1,2,3,4,5,6,7,8};
		int w=8;	
//		System.out.println(coinChange(val, w));
//		System.out.println(rodcutting(val, wt, w));
}}
