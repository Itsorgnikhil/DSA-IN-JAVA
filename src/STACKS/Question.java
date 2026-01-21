package STACKS;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Stack;

public class Question {
public static void stockspan(int stocks[],int span[]) {
	Stack<Integer>  s = new Stack<>();
	span[0] = 1;
	s.push(0);
	for(int i=1;i<stocks.length;i++) {
		int currprice = stocks[i];
		while(!s.isEmpty()&&currprice>stocks[s.peek()]) {
			s.pop();
		}
		if(s.isEmpty()) {
			span[i]=i+1;
		}
		else {
			int prevhigh = s.peek();
			span[i]=i-prevhigh;
		}
		s.push(i);
		
	}	
}

//public static void main(String args[]) {
//	int stocks[] = {100,80,60,70,60,85,100};
//	int span[] = new int[stocks.length];
//	stockspan(stocks, span);
//	for(int i=0;i<span.length;i++) {
//		System.out.println(span[i]+" ");
//	}
//}


public static boolean is_valid_parentesis(String str) {
	Stack<Character> s = new Stack<>();
	
	for(int i=0;i<str.length();i++) {
		char ch = str.charAt(i);
		if(ch=='('||ch=='{'||ch=='[') { //opening
			s.push(ch);
		}
		else {
			//closing
			if(s.isEmpty()) {
				return false;
			}
			if((s.peek()=='('&& ch==')')  //()
					||(s.peek()=='{'&& ch=='}')
					||(s.peek()=='['&& ch==']')){
				s.pop();
				
			}
			else {
				return false;
			}
		}
	}
	if(s.isEmpty()) {
		return true;
	}else {
		return false;
	}
	
}








public static boolean is_duplicate_parenthesis(String str) {
Stack<Character> s = new Stack<>();
	
	for(int i=0;i<str.length();i++) {
	char ch = str.charAt(i);
	
	//closing
	if(ch==')') {
		int count =0;
		while(s.peek()!='(') {
			s.pop();
			count++;
		}
		if(count<1) {
			return true;//duplicate
		}
		else {
			s.pop();
			
		}
		
	}else {
		//opening 
		s.push(ch);
		
	}
	
	}
	
	return false;
	
}


public static void max_area_in_histogram(int arr[]) {
	int maxArea = 0;
	int nsr[] = new int[arr.length];
	int nsl[] = new int[arr.length];
	
	// next smaller right 
	Stack<Integer> s = new Stack<>();
    
    for (int i = arr.length - 1; i >= 0; i--) {
        while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
            s.pop();
        }
        if (s.isEmpty()) {
            nsr[i] = arr.length;
        } else {
            nsr[i] = s.peek();
        }
        s.push(i);
    }
    
    
    // next smaller left
    
    s=new Stack<>();
    for (int i = 0; i<arr.length; i++) {
        while (!s.isEmpty() && arr[s.peek()] >= arr[i]) { 
        	// this condition is for checking smaller
            s.pop();
        }
        if (s.isEmpty()) {
            nsl[i] = -1;
        } else {
            nsl[i] = s.peek();
        }
        s.push(i);
    }
    
 	//current area : width j-i-1 = nsr[i]-nsl[i] -1;
    
    for(int i=0;i<arr.length;i++) {
    	int height = arr[i];
    	int width = nsr[i]-nsl[i] -1;
    	int currArea = height * width;
    	maxArea= Math.max(currArea, maxArea);
    	
    }
    System.out.println("max area in the histogram = "+ maxArea);
}





public static void main (String args[]) {
	String str = "((a+b))";  //True
	String str3 ="(a-b)";     // false
	//System.out.println(is_duplicate_parenthesis(str3));
	
	int arr[] = {2,1,5,6,2,3};
	//highest in histogram
	max_area_in_histogram(arr);
	
	
	
}

}
