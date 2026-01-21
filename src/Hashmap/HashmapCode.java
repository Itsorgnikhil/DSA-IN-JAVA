package Hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashmapCode {
	static class HashMap<K,V>{
		private class node{
			K key;
			V value;
			public node(K key,V value) {
				this.key= key;
				this.value = value;
				
			}
			
		}
		
		private int n;
		private int N;
		private LinkedList<node> buckets[];
		
		@SuppressWarnings("unchecked")
		public HashMap() {
			this.N=4;
			this.buckets=new LinkedList[4];
			for(int i=0;i<4;i++) {
				this.buckets[i] = new LinkedList<>();
			}
		}
		
		
		
		private int hashFunction(K key) {
			int hc = key.hashCode();
			 return Math.abs(hc)%N;  
		}
		
		private int SearchInll(K key,int bi) {
			LinkedList<node>  ll = buckets[bi];
			int di=0;
			
			for(int i=0;i<ll.size();i++) {
				node Node = ll.get(i);
				if(Node.key == key) {
					return di;
				}
				di++;
			}
			return -1;
			
		}
		@SuppressWarnings("unchecked")
		private void rehash() {
			LinkedList<node> oldbuck[] = buckets;
			buckets =new LinkedList[N*2];
			N=2*n;
			for(int i=0;i<buckets.length; i++) {
				buckets[i] = new LinkedList<>();
			}
			
			// nodes -> add in bucket 
			for(int i=0;i<oldbuck.length; i++) {
				LinkedList<node> ll = oldbuck[i];
				for(int j=0;j<ll.size();j++) {
					node Node = ll.remove();
					put(Node.key,Node.value);
				}
			}
		}
		
		public void put(K key , V value) { // O(1)
			int bi = hashFunction(key); // 0 to 3
			int di = SearchInll(key, bi);// valid ; -1
			if (di!=-1) {
				 node Node = buckets[bi].get(di);
			 	 Node.value =value;
			}else {
				buckets[bi].add(new node(key, value));
				n++;
			}
			
			double lambda = (double)n/N;
			if(lambda>2.0) {
				rehash();
			}
		}
		
		public boolean containsKey(K key) {
			int bi = hashFunction(key); // 0 to 3
			int di = SearchInll(key, bi);// valid ; -1
			if (di!=-1) {
				return true;
			}else {
				return false;
			}
		}
		public V get(K key) {
			int bi = hashFunction(key); // 0 to 3
			int di = SearchInll(key, bi);// valid ; -1
			if (di!=-1) {
				 node Node = buckets[bi].get(di);
			 	return Node.value;
			}else {
				return null;			}
		}
		
		
		
		public V remove(K key) {
			int bi = hashFunction(key); // 0 to 3
			int di = SearchInll(key, bi);// valid ; -1
			if (di!=-1) {
				 node Node = buckets[bi].remove(di);
				 n--;
				 return Node.value;
			}else {
				return null;
			}
		}
		
		public ArrayList<K> keySet(){
			ArrayList<K> keys = new ArrayList<>();
			for(int i=0;i<buckets.length;i++) {
				LinkedList<node> ll = buckets[i];
				for(node Node:ll) {
					keys.add(Node.key);
				}
			}
			return keys;
		}
		public Boolean isEmpty() {
			return n==0;
		}
	}

}
