//package start1;
//
//import java.util.*;
//
//public class Sub_arrays {
//	 public static void sub_arrays(int num[]) {
//		 int count=0;
//		 int maxvalue=Integer.MIN_VALUE;
//		for(int i=0;i<num.length;i++) {
//		int Start=i;
//		for(int j=i;j<num.length;j++) {
//			int end=j;
//			count=0;
//			for(int k=Start;k<=end;k++) {
//				
//				count+=num[k];}
//				System.out.println(count);
//				if(maxvalue<count) {
//					maxvalue=count;
//				}
//				
//			
//			System.out.println();
//			
//		}
//		System.out.println(); 
//		
//		
//		}
//		System.out.println("maximum value is"+maxvalue);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int num[]= {2,4,6,8,10};
//sub_arrays(num);
//	}
//
//}

package Arrays;

import java.util.*;

public class Sub_arrays {
	 public static void sub_arrays(int num[]) {
		 
//		 int maxvalue=Integer.MIN_VALUE;
		for(int i=0;i<num.length;i++) {
		int Start=i;
		for(int j=i;j<num.length;j++) {
			int end=j;
			for(int k=Start;k<=end;k++) {
				System.out.print(num[k]+" ");
			}
			
			System.out.println();
			
		}
		System.out.println(); 
		
		
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {2,4,6,8,10};
sub_arrays(num);
	}
 
} 
