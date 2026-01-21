package DYNAMIC_PROGRAMMING;

import java.util.Arrays;

public class Minumum_partition {

	public static int min_partition(int arr[]) {
		int sum = Arrays.stream(arr).sum();
		int w=sum/2;
		int n= arr.length;
		int dp[] [] = new int[n+1][w+1];
		
		for(int i=0;i<n+1;i++) {//oth col
			dp[i] [0] =0;
		}
		for(int j=0;j<w+1;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				
				if(arr[i-1]<=j) {
					dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
					
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		int sum1 = dp[n][w];
		int sum2= sum-sum1;
		int diff = Math.abs(sum1-sum2);
		return diff;
	}
	public static void main(String args[]) {
		int num[] = {1,6,11,5};
		System.out.println(min_partition(num));
		
	}
}
