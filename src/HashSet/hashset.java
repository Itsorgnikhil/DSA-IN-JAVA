package HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class hashset{
	public static void main (String args[]) {
		HashSet<String> hs = new HashSet<>();

		hs.add("delhi");

		hs.add("Mumbai");
		hs.add("rajasthan");

		hs.add("up");
		hs.add("bihar");

		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
}
}