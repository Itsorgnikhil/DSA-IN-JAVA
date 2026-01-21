package Recursion;

import java.security.PublicKey;
import java.util.Map;

public class IMPQUESTION {
public static int tillingproblem(int n) {// 2*n(floor size)
	// base case
	if(n==0||n==1) {
		return 1;
	}
	// kaam karna hai 
	
	// vertical choice
	int fnm1=tillingproblem(n-1);
	
	// horizontal choice 
	int fnm2=tillingproblem(n-2);
	
	int totalways =fnm1 + fnm2 ;
	
	return totalways;
	
}

public static void removeduplicates(String str,
		                                      int idx,
		                                          StringBuilder newstr,
		                                                        boolean map[]) {
	
	// base case 
	if(idx == str.length()) {
		System.out.println(newstr);
		return ;
		
	}
	//kaam
	
	char currchar =str.charAt(idx);
	if(map[currchar-'a']==true) {
		// duplicate
		removeduplicates(str, idx+1, newstr,map);
		
	}else {
		map[currchar-'a'] =true;
		removeduplicates(str, idx+1, newstr.append(currchar),map);
	}
	
	
}
public static int frendspairing(int n) {
	if(n==1||n==0) {
		return n;
	}
	// choice
	// single 
	int fnm1 = frendspairing(n-1);
	
	// pair
	int fnm2= frendspairing(n-2);
	int pairways = (n-1)*fnm2;
	int totalways = fnm1+pairways;
	return totalways;
}
public static void binarystrings(int n,int lastplace,String str) {
	// base case 
	if(n==0) {
		System.out.println(str);
		return;
	}
	// kaam
	binarystrings(n-1, 0, str+"0");
	if(lastplace==0)
	{
		binarystrings(n-1, 1, str+"1");
	}
}
public static void main (String args[]) {
	binarystrings(3, 0, "");
}
}
