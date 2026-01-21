package Graph;

import java.util.ArrayList;

import Graph.BFS_DFS.Edge;



	public class Cycle_detection {
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
		
		static void CreateGraph(ArrayList<Edge> graph[]) {
			for(int i=0;i<graph.length;i++) {
				graph[i] = new ArrayList<>();
		}
//			// 0- vertex
//			graph[0].add(new Edge(0, 1, 1));
//			graph[0].add(new Edge(0, 2, 1));
//			
//			//1 -vertex
//			graph[1].add(new Edge(1, 0, 1));
//			graph[1].add(new Edge(1, 3, 1));
//			
//			
//			//2-vertex 
//			graph[2].add(new Edge(2, 0, 1));
//			graph[2].add(new Edge(2, 4, 1));
//			
//			//3 - vertex
//			graph[3].add(new Edge(3, 1, 1));
//			graph[3].add(new Edge(3, 4, 1));
//			graph[3].add(new Edge(3, 5, 1));
//			
//			//4-vertex
//			graph[4].add(new Edge(4, 2, 1));
//			graph[4].add(new Edge(4, 3, 1));
//			graph[4].add(new Edge(4, 5, 1));
//			
//			graph[5].add(new Edge(5, 3, 1));
//			graph[5].add(new Edge(5, 4, 1));
//			graph[5].add(new Edge(5, 6, 1));
//			
//			graph[6].add(new Edge(6, 5, 1));
//				
			graph[0].add(new Edge(0, 2, 1));
			graph[1].add(new Edge(1, 0, 1));
			graph[2].add(new Edge(2, 3, 1));
			graph[3].add(new Edge(3, 0, 1));// cyclic graph
			
		}
		
		public static boolean detectcycle_undirected(ArrayList<Edge> [] graph) {
			boolean vis[] = new boolean[graph.length];
			for(int i=0;i<graph.length;i++) {
				if(!vis[i]) {
					if(detectcycleutil(graph, vis,i,-1 )) {
					return true;
				}
			}
		}
			return false;
		}
		public static boolean detectcycleutil(ArrayList<Edge>[] graph , boolean vis[],int curr,int par) {
			  System.out.print(curr + " "); 
			vis[curr] = true;
			for(int i=0;i<graph[curr].size();i++) {
				Edge edge = graph[curr].get(i);
				// case-3
				 // Case 1: Unvisited neighbor - continue DFS
	            if(!vis[edge.dest]) {
	                if(detectcycleutil(graph, vis, edge.dest, curr)) {
	                    return true;
	                }
	            }
	            // Case 2: Visited neighbor that's not parent - cycle found!
	            else if(edge.dest != par) {
	                return true;
	            }
	            // Case 3: Visited neighbor is parent - ignore (came from there)
	        }
	        return false;
		}
		
		
		
		public static boolean deteccycle_directed(ArrayList<Edge> [] graph) {
			boolean vis[] = new boolean[graph.length];
			boolean stack[] = new boolean[graph.length];
			for(int i=0;i<graph.length;i++) {
				if(!vis[i]) {
					if(deteccycle_directed_util(graph, vis, i, stack)) {
						return true;
					}
				}
			}
			return false;
		}
		
		public static boolean deteccycle_directed_util(ArrayList<Edge>[] graph , boolean vis[],int curr,boolean stack[]) {
			
			vis[curr] = true ;
			stack[curr] = true;
			for(int i=0;i<graph[curr].size();i++) {
				Edge edge =graph[curr].get(i);
				if(stack[edge.dest]) {
					return true;
				}
				if(!vis[edge.dest] && deteccycle_directed_util(graph, vis, edge.dest, stack)) {
					return true;
				}
			}
			stack[curr] = false;
			return false;
			
		}
		
			public static void main (String args[]) {
				
				int V=4;
				ArrayList<Edge>[] graph = new ArrayList[V];
				
				CreateGraph(graph);
				System.out.println(deteccycle_directed(graph));
			
		}
	}


