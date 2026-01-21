package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class kruskals_algo {
static class Edge implements Comparable<Edge> {
	int src;
	int dest;
	int wt;
	public Edge(int s,int d,int w) {
		this.src= s;
		this.dest=d;
		this.wt=w;
		
	}
	@Override
	public int compareTo(Edge e2) {
		return this.wt-e2.wt;
	}
}

static void creategraph(ArrayList<Edge>edges) {
	edges.add(new Edge(0, 1, 10));
	edges.add(new Edge(0, 2, 15));
	edges.add(new Edge(0, 3, 30));
	edges.add(new Edge(0, 3, 40));
	edges.add(new Edge(0, 3, 50));

}
static int n=4;
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

public static void kruskalsmst(ArrayList<Edge> edge,int V) {
	init();
	Collections.sort(edge);
	int mstcost = 0;
	int count = 0;
	
	for(int i=0;count<V-1;i++) {
		Edge e = edge.get(i);
		//(SRC,DEST<WT)
		
		int parA = find(e.src); //src=a
		int parB = find(e.dest);
		if(parA !=parB) {
			union(e.src, parB);
			mstcost += e.wt;
			count++;
			}
		}
	System.out.println(mstcost);
	}
public static void main(String args[]) {
	int v=4;
	ArrayList<Edge> edges = new ArrayList<>();
	creategraph(edges);
	kruskalsmst(edges, v);
}
}
