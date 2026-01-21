package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Question {

	public static void main (String arg[]) {
		
		int arr1[] = {7,3,9};
		int arr2[] = {6,3,9,2,9,4};
		
		HashSet<Integer> set = new HashSet<>();
		/// for uniion
	for(int i=0;i<arr1.length;i++) {
		set.add(arr1[i]);
	}
	
	for(int i=0;i<arr2.length;i++) {
		set.add(arr2[i]);
	}
	
		System.out.println(set.size());
		
		set.clear();
		//intersection
		for(int i=0;i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		int count=0;
		for(int i=0;i<arr2.length;i++) {
			if(set.contains(arr2[i])) {
				count++;
				set.remove(arr2[i]);
			}
		}
		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//////////////count distinct element //////////////////
	}
//		int num[] = {4,3,2,5,6,7,3,4,2,1};
//		HashSet<Integer> hs = new HashSet<>();
//		for(int i=0;i<num.length;i++) {
//			hs.add(num[i]);
//		}
//		
//		System.out.println(hs.size());
//	}
}
