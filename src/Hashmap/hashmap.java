package Hashmap;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Set;

public class hashmap {
	public static void main(String args[]) {
		HashMap<String, Integer>hm = new HashMap<>();
		hm.put("indai",100);
		hm.put("china",150);
		hm.put("inonasia",50);
		hm.put("thailand",10);
		hm.put("us",190);
		hm.put("Nepal",120);
		
		// iterate 
		 Set<String> keys = hm.keySet();
		 System.out.println(keys);
		 
		 for(String k: keys) {
			 System.out.println("key = "+k+" "+"value = "+hm.get(k));
		 }
	}
}