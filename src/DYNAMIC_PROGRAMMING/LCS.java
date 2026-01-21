package DYNAMIC_PROGRAMMING;

import java.util.Arrays;
import java.util.Collections;

public class LCS {
	
	public static int lcs_rec(String str1,String str2,int n,int m) {
		if(n==0||m==0) {
		return 0;	
		}
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			return lcs_rec(str1, str2, n-1, m-1)+1;
		}else {
			
			int a1 = lcs_rec(str1, str2, n-1, m); // in this str1 elemnet is decresing 
			int a2 = lcs_rec(str1, str2, n, m-1); // int this str 2 element is decreasing
			int a = Math.max(a1, a2);
			return a;
			
		}
		}
	public static int lcs_memo(String str1,String str2,int n,int m,int dp[] []) {
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				dp[i][j] =  -1;
			}
		}
		if(n==0||m==0) {
			return 0;	
			}
		
		if(dp[n][m] !=-1) {
			return dp[n][m];
		}
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			return dp[n][m] =lcs_rec(str1, str2, n-1, m-1)+1;
		}else {
			
			int a1 = lcs_memo(str1, str2, n-1, m,dp); // in this str1 elemnet is decresing 
			int a2 = lcs_memo(str1, str2, n, m-1,dp); // int this str 2 element is decreasing
			dp[n][m]= Math.max(a1, a2);
			return dp[n][m];
			
		}
	}
	public static int lcs_tab(String str1,String str2,int n,int m,int dp[] []) {
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0||j==0) {
					dp[i][j] =  0;
				}
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					
				}
				else {
					int a1= dp[i-1][j];
					int a2 = dp[i][j-1];
					 dp[i][j] = Math.max(a1, a2);
				}
				
			}
		}
		return dp[n][m] ;
	}
	
		public static int lcSubstring(String s1,String s2,int n,int m,int dp[][]) {
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<m+1;j++) {
					if(i==0||j==0) {
						dp[i][j] =  0;
					}
				}
			}
			int ans=0;
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<m+1;j++) {
					
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						 dp[i][j] = dp[i-1][j-1]+1;
					ans = Math.max(dp[i][j], ans) ;
						
					}
					else {
						
						 dp[i][j] = 0;
					}
					
				}
			}
			return ans ;
		}
		
public static int l_increasing_s(int arr[],int arr2[],int dp[][],int n,int m) {
	
	for(int i=0;i<n+1;i++) {
		for(int j=0;j<m+1;j++) {
			if(i==0||j==0) {
				dp[i][j] =  0;
			}
		}
	}
	
	for(int i=1;i<n+1;i++) {
		for(int j=1;j<m+1;j++) {
			
			if(arr[i-1]==arr2[j-1]) {
				dp[i][j] = dp[i-1][j-1]+1;
				
			}
			else {
				
				 dp[i][j] =  Math.max(dp[i][j-1], dp[i-1][j]);
			}
			
		}
	}
	return dp[n][m] ;
}


public static int edit_distance(String s1,String s2,int n,int m,int dp[][]) {
	for(int i=0;i<n+1;i++) {
		for(int j=0;j<m+1;j++) {
		  if(i==0) {
			  dp[i][j] = j;
		  }
		  if(j==0) {
			  dp[i][j] = i;
		  }
		}
	}
	
	for(int i=1;i<n+1;i++) {
		for(int j=1;j<m+1;j++) {
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				dp[i][j] = dp[i-1][j-1];
				
			}
			else {
				int add= dp[i][j-1]+1;
				int delete= dp[i-1][j]+1;
				int replace = dp[i-1][j-1]+1;
				 dp[i][j] = Math.min(replace, Math.min(add, delete));
			}

		}

	}
	return dp[n][m];
	
}


public static int String_conversion(String s1,String s2,int n,int m,int dp[][]) {
	for(int i=0;i<n+1;i++) {
		for(int j=0;j<m+1;j++) {
		  if(i==0) {
			  dp[i][j] = j;
		  }
		  if(j==0) {
			  dp[i][j] = i;
		  }
		}
	}
	
	for(int i=1;i<n+1;i++) {
		for(int j=1;j<m+1;j++) {
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				dp[i][j] = dp[i-1][j-1];
				
			}
			else {
				int add= dp[i][j-1]+1;
				int delete= dp[i-1][j]+1;
				 dp[i][j] = Math.min(add, delete);
			}

		}

	}
	return dp[n][m];
	
}

public static boolean wildcard_matching(String s,String p) {
	int n=s.length();	
	int m=p.length();
	boolean dp[][] = new boolean[n+1][m+1];
	
	//intialize
	dp[0][0]=true;
	for(int i=1;i<n+1;i++) {
		dp[i][0] =false;
	}
	for(int j=1;j<m+1;j++) {
		if(p.charAt(j-1)=='*') {
			dp[0][j] = dp[0][j-1];
		}
	} 	
	
	for(int i=1;i<n+1;i++) {
		for(int j=1;j<m+1;j++) {
			// if string== pattern and pattern j-1 ==?
			if(s.charAt(i-1) == p.charAt(j-1)|| p.charAt(j-1) == '?') {
				dp[i][j] = dp[i-1][j-1];
			}
			else if(p.charAt(j-1) == '*') {
				dp[i][j] = dp[i-1] [j] || dp[i][j-1];
			}else {
				dp[i][j] = false;
			}
			
		}
	}
	//String ->n,pattern->m
	return dp[n][m];
}
	public static void main (String args[] ) {
		
//		int arr[]= {50,3,10,7,8,9,40,80};
//		int[] arr2 = arr.clone();
//		Arrays.sort(arr2);
//		int n=arr.length;
//		int m=arr2.length;
//		
//		int dp[][] = new int[n+1][m+1];
//		System.out.println(l_increasing_s(arr, arr2, dp, n, m));
//		String str1="abcdge";
//		String str2="abedg";//
//		 int n=str1.length();
//		 int m=str2.length();
//		 int dp[] [] = new int [n+1][m+1];  
//		 System.out.println(lcs_rec(str1, str2, n, m));
//		 System.out.println(lcs_memo(str1, str2, n, m, dp));
//		 System.out.println(lcs_tab(str1, str2, n, m, dp));
//		 System.out.println(lcSubstring(str1, str2, n, m, dp));
		
//		String str1="intention";
//     	String str2="execution";//
//     	System.out.println(edit_distance(str1, str2, n, m, dp));
		
		
//		String s1 ="pear";
//		String s2 ="sea";
//		int dp[][] = new int[n+1][m+1];
//		System.out.println(String_conversion(s1, s2, n, m, dp));
		String s1="baaabab";
		String s2="a*ab";
	
		System.out.println(wildcard_matching(s1, s2));
	}
	

}
