package Graph;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Graph.Topology.Edge;

public class Dijkstra_s_algo {


			static class Edge{
		int src;
		int dest;
		int wt;
		public Edge(int s,int de,int w) {
			this.src=s;
			this.dest=de;
			this.wt=w;
			
		}
		}
		
		static void CrateGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0 ,1, 2));
		graph[0].add(new Edge(0 ,2, 4));
		
		graph[1].add(new Edge(1 ,3, 7));
		graph[1].add(new Edge(1 ,2, 1));
		
		graph[2].add(new Edge(2 ,4, 3));
		
		
		graph[3].add(new Edge(3 ,5, 1));
		
		graph[4].add(new Edge(4 ,3, 2));
		graph[4].add(new Edge(4 ,5, 5));
		
											
		}				
		static class pair implements Comparable<pair>{
			int n;
			int path;
			
			public pair(int n,int path) {
				this.n= n;
				this.path = path;
			}
			@Override
			public int compareTo(pair p2) {
				return this.path - p2.path; //path based sorting for my pairs
			}
			
		}
		
		
		
		public static void dijkstra(ArrayList<Edge> graph[],int src) {
		
			int dist[] = new int[graph.length];
			for(int i=0;i<graph.length;i++) {
				if(i!=src) {
					dist[i]  = Integer.MAX_VALUE;
				}
			}
			boolean vis[] = new boolean[graph.length];
			PriorityQueue<pair> pq = new PriorityQueue<>();
			pq.add(new pair(src, 0));
			//loop
			while(!pq.isEmpty()) {
				pair curr = pq.remove();
				if(!vis[curr.n]) {
					vis[curr.n] = true;
					for(int i=0;i<graph[curr.n].size();i++) {
						Edge edge = graph[curr.n].get(i);
						int u = edge.src;
						int v = edge.dest;
						int wt = edge.wt;
						
						if(dist[u]+wt < dist[v]) {
							dist[v] = dist[u] + wt;
							pq.add(new pair(v, dist[v]));
						}
					}
				}
			}
			for(int i = 0; i < dist.length; i++) {
			    System.out.print(dist[i] + " ");  // print in one line
			}
			System.out.println();
		}
		
		public static void main (String args[]) {
			
			int V=6;
			ArrayList<Edge>[] graph = new ArrayList[V];
			
			CrateGraph(graph);
			int src = 0;
			dijkstra(graph, src);
			
		
			
		}
}
