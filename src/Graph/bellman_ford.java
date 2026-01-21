package Graph;

import java.util.ArrayList;

import Graph.MST.Edge;

public class bellman_ford {

	static class Edge{
		int src;
		int dest;
		int wt;
		public Edge(int s,int de,int w) {
			this.src=s;
			this.dest=de;
			this.wt=w;
			
		}
		
}static void CrateGraph(ArrayList<Edge> graph[]) {
	for(int i=0;i<graph.length;i++) {
		graph[i] = new ArrayList<>();
	}
	graph[0].add(new Edge(0 ,1, 2));
	graph[0].add(new Edge(0 ,2, 4));
	
	graph[1].add(new Edge(1 ,2, -4));
	
	
	graph[2].add(new Edge(2 ,3, 2));
	graph[3].add(new Edge(3 ,4, 4));
	
	graph[4].add(new Edge(4 ,1, -1));
	
										
	}

public static void bellman(ArrayList<Edge>[] graph,int src) {
	int dist[] = new int[graph.length];
	for(int i=0;i<dist.length;i++) {
		if(i!=src) {
			dist[i] = Integer.MAX_VALUE;
		}
	}
	int V=graph.length;
	//O(V*E)
	//algo - O(V)
	for(int i=0;i<V-1;i++) {
		// edge O(E)
		for(int j=0;j<graph.length;j++) {
			for(int k=0;k<graph[j].size();k++) {
				Edge edge = graph[j].get(k);
				
				int u= edge.src;
				int v= edge.dest;
				int wt = edge.wt;
				
				if(dist[u] != Integer.MAX_VALUE && dist[u]+ wt<dist[v]) {
					dist[v] = dist[u]+wt;
				}
			}
		}
	}
	for(int i=0;i<dist.length;i++) {
		System.out.println(dist[i]+" ");
	}
	System.out.println();
}
public static void main (String args[]) {
	
	int V=6;
	ArrayList<Edge>[] graph = new ArrayList[V];
	
	CrateGraph(graph);
bellman(graph, 0);
	
	

	
}
}