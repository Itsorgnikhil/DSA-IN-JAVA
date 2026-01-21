//package Hashmap;
//
//import java.util.HashMap;
//import java.util.Set;
//
//public class Question {
//
//	
//	public static void main(String arg[]) {
//		int arr[] = {1,3,2,5,1,3,1,5,1};
//		HashMap<Integer, Integer> map = new HashMap<>();
//		
//		
//		for(int i=0;i<arr.length;i++) {
//			if(map.containsKey(arr[i])) {
//				map.put(arr[i], map.get(arr[i]) +1);
//			}else {
//				map.put(arr[i], 1);
//			}
//		}
//		
//		Set<Integer> keySet = map.keySet();
//		for(Integer key : keySet) {
//		if(map.get(key)>arr.length/3) {
//			  System.out.println(key);
//		}}
//		
//	}
//}



//package Hashmap;
//
//import java.util.HashMap;
//
//
//public class Question {
//	public static boolean isAnagram(String s,String t) {
//		
//		if(s.length()!=t.length()) {
//			return false;
//		}
//		HashMap<Character,Integer> map = new HashMap<>();
//		
//		for (int i=0;i<s.length();i++) {
//			char ch= s.charAt(i);
//			map.put(ch, map.getOrDefault(ch, 0)+1);
//		}
//		
//		for (int i=0;i<t.length();i++) {
//			char ch= t.charAt(i);
//			if(map.get(ch)!= null) {
//				if(map.get(ch)==1) {
//					map.remove(ch);
//				}else {
//					map.put(ch, map.get(ch)-1);
//				}
//			}else {
//				return false;
//	 		}
//		}
//		
//		return map.isEmpty();
//	}
//	public static void main (String args[]) {
//		
//		String s ="tulip";	
//	String t = 	"lipid";
//	
//	System.out.println(isAnagram(s, t));
//	}
//}


//package Hashmap;
//
//import java.util.HashMap;
//
//public class Question {
//
//	public static String getStart(HashMap<String, String>map) {
//		HashMap<String,String> revmap = new HashMap<>();
//
//		for(String key : map.keySet()) {
//			revmap.put(map.get(key),key);
//		}
//		
//		for(String key : map.keySet()) {
//			if(!revmap.containsKey(key)) {
//				return key; // starting point
//			}
//		}
//		return null;
//	}
//	public static void main(String arg[]) {
//		
//		HashMap<String,String> map = new HashMap<>();
//	map.put("chenneai", "Bengluru");
//	map.put("mumbai", "delhi");
//	map.put("goa", "chenneai");
//	map.put("delhi", "goa");
//
//	
//	String start = getStart(map);
//	System.out.println(start );
//	for(String key : map.keySet()) {
//		System.out.println(map.get(start));
//		start = map.get(start);
//	}  
//	System.out.println();
//	}
//	} 

//package Hashmap;
//import java.util.HashMap;
//
//
//public class Question {
//
//	
//	public static void main(String arg[]) {
//		int arr[] = {15,-2,2,-8,1,7,10,23};
//		HashMap<Integer, Integer> map = new HashMap<>();
//        //(sum,idx)
//		
//		int sum=0;
//		int len=0;
//
//          for(int j=0;j<arr.length;j++) {
//        	  sum+=arr[j];
//        	  if(map.containsKey(sum)) {
//        		  len = Math.max(len, j-map.get(sum));
//        	  }else {
//        		  map.put(sum,j);
//        	  }
//          }
//System.out.println(len);
//	}}


package Hashmap;
import java.util.HashMap;

public class Question {
	
	public static void main(String args[]) {
		int arr[] = {10,2,-2,-20,10};
		int k=-10;
	
	HashMap<Integer, Integer> map = new HashMap<>();
	// sum,count
	map.put(0, 1); 
	int sum =0;
	int ans=0;
	
	for(int j=0;j<arr.length;j++) {
		sum+=arr[j];
		if(map.containsKey(sum-k)) {
			ans+=map.get(sum-k);
		}
		map.put(sum, map.getOrDefault(sum, 0)+1);
	}
	System.out.println(ans);
}}






