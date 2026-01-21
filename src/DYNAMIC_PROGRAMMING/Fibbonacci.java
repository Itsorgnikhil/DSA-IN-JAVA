package DYNAMIC_PROGRAMMING;
public class Fibbonacci{
	
	public static int counting_stairs_by_memotization(int n , int ways[]){
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0 ;
		}
		if(ways[n]!=0) {
			return ways[n];
		}
		return  ways[n] =counting_stairs_by_memotization(n-1,ways)+counting_stairs_by_memotization(n-2,ways);
	}
	public static int counting_stairs_by_tabulation(int n ) {
		 int dp[]=new int [n+1];
	      dp[0]=1;
	        dp[1]=1;
		 for(int i=2;i<=n;i++) {
//			 if(i==1) {
//				 dp[i] = dp[i-1];
//			 }
//			 else {
			 dp[i]=dp[i-1]+dp[i-2];
		 }
		 return dp[n];
		
	}
public static void main(String args[]) {
	int n=5;
	int ways[]=new int[n+1];
	System.out.println(counting_stairs_by_memotization(n,ways));
	System.out.println(counting_stairs_by_tabulation(n));
}}