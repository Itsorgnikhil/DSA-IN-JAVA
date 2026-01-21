package Graph;

import java.lang.reflect.Parameter;

public class Disjoint_set_ds {

	static int n=7;
	static int par[]=new int [n];
	static int rank[] = new int[n];
	
	public static void init() { // this is a  intialization funation to intialize funation 
		for(int i=0;i<n;i++) {
			par[i] = i;
			
		}
	}
	public static int find(int x) { // in this we find the final leader of the node
		if(x == par[x]) {
			return x;
		}
		
		return find(par[x]);
	}
	public static void union(int a,int b) {
		int par_A =find(a);
		int par_B = find(b);
		
		if(rank[par_A]==rank[par_B]) {
			par[par_B] = par_A;
			rank[par_A]++;
		}
		else if(rank[par_A] < rank[par_B]) {
			par[par_A] = par_B;
			}
		else {
			par[par_B] = par_A;
		}
	}
	//path comprestion optimazation 
	 
	
	public static void main(String args[]) {
		init();
		union(1, 3);
		System.out.println(find(3));
		union(2, 4);
		union(3, 6);
		union(1, 4);
		System.out.println(find(3));
		System.out.println(find(4));
		union(1, 5);
	}
	}
