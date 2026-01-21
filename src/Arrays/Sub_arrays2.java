package Arrays;

import java.util.*;

public class Sub_arrays2 {
	 public static void preefix_sum(int num[]) {
		 int currsum=0;
		 int maxvalue=Integer.MIN_VALUE;
		 int prefix[]=new int[num.length];
		 prefix[0]=num[0];
		 
		 for(int i=1;i<prefix.length;i++) {
			 prefix[i]=prefix[i-1]+num[i];
		 }
		 
		 
		 
		for(int i=0;i<num.length;i++) {
		int Start=i;
		for(int j=i;j<num.length;j++) {
			int end=j;
			currsum=0;
			currsum=Start == 0?prefix[end]:prefix[end]-prefix[Start-1];
				if(maxvalue<currsum) {
					maxvalue=currsum;
				}
				
		}
	
		}
		System.out.println("maximum value is"+maxvalue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {2,-4,6,-8,10};
preefix_sum(num);
	}

}
