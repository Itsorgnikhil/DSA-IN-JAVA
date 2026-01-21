package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph.creation.Edge;

public class BFS_DFS {
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
	
	static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
	}
		// 0- vertex
					graph[0].add(new Edge(0, 1, 1));
					graph[0].add(new Edge(0, 2, 1));
					
					//1 -vertex
					graph[1].add(new Edge(1, 0, 1));
					graph[1].add(new Edge(1, 3, 1));
					
					
					//2-vertex 
					graph[2].add(new Edge(2, 0, 1));
					graph[2].add(new Edge(2, 4, 1));
					
					//3 - vertex
					graph[3].add(new Edge(3, 1, 1));
					graph[3].add(new Edge(3, 4, 1));
					graph[3].add(new Edge(3, 5, 1));
					
					//4-vertex
					graph[4].add(new Edge(4, 2, 1));
					graph[4].add(new Edge(4, 3, 1));
					graph[4].add(new Edge(4, 5, 1));
					
					graph[5].add(new Edge(5, 3, 1));
					graph[5].add(new Edge(5, 4, 1));
					graph[5].add(new Edge(5, 6, 1));
					
					graph[6].add(new Edge(6, 5, 1));
						
	}
	
	public static void  Bfs(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		for(int i=0;i<graph.length;i++) {
		if(!vis[i]) {
			Bfsutil(graph, vis);
		}}
	}
	public static void Bfsutil(ArrayList<Edge>[] graph , boolean vis[]) { //O(N)//O(V+E)f
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			
			int curr=q.remove();
			
			if(!vis[curr]) {
				System.out.print(curr+" ");
				vis[curr] =true;
				for(int i=0;i<graph[curr].size();i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	
	public static void Dfs(ArrayList<Edge> [] graph) {
		boolean vis[] = new boolean[graph.length];
		for(int i=0;i<graph.length;i++) {
		if(!vis[i]) {
			DfsUtil(graph, i, vis);
		}}
	}
	
	public static void DfsUtil(ArrayList<Edge> [] graph,int curr,boolean vis[]) {
		// vist
		System.out.println(curr + " ");
		vis[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge edge = graph[curr].get(i);
			if(!vis[edge.dest]) {
				DfsUtil(graph, edge.dest, vis);
				
			}
		}
		
	}
	
	public static boolean haspath(ArrayList<Edge>[] graph,int src,int dest,boolean vist[]) {
		if(src==dest) {
			return true;
			
		}
		   vist[src] = true;
		for(int i=0;i<graph[src].size();i++) {
			Edge edge= graph[src].get(i);
			//e.dest = neighbour
			if(!vist[edge.dest] && haspath(graph, edge.dest, dest, vist)) {
				return true;
			}
		}
		return false;
	}
		public static void main (String args[]) {
			
			int V=7;
			ArrayList<Edge>[] graph = new ArrayList[V];
			
			createGraph(graph);
			Bfs(graph);
			Dfs(graph);
			System.out.println(haspath(graph, 0, 5,new boolean[V]));
		
		
	}
}
