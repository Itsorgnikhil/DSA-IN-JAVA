package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topology {
	
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
					graph[0].add(new Edge(0,3,1));
					graph[2].add(new Edge(2, 3,1));
				

					graph[3].add(new Edge(3, 1,1));

					graph[4].add(new Edge(4, 0,1));
					graph[4].add(new Edge(4, 1,1));

					graph[5].add(new Edge(5, 0,1));
					graph[5].add(new Edge(5, 2,1));

											
									
				}				
				// topological sort using dfs

				public static void top_sort_dfs(ArrayList<Edge> graph[] ) {
					boolean vis[] = new boolean[graph.length];
					Stack<Integer> s  = new Stack<>();
					for(int i=0;i<graph.length;i++) {
						if(!vis[i]) {
							top_sortUtil(graph, i, vis, s);
							
						}
					}
					while(!s.isEmpty()) {
						System.out.println(s.pop()+" ");
					}
				}
				public static void top_sortUtil(ArrayList<Edge>[] graph , int curr,boolean vis[] ,Stack<Integer> s) {
					vis[curr] = true;
					for(int i=0;i<graph[curr].size();i++) {
						Edge edge = graph[curr].get(i);
					if(!vis[edge.dest]) {
						top_sortUtil(graph, edge.dest, vis, s);
					}
					}
					s.push(curr);
				}
				
				// topological sort using bfs
				public static void calIndegree(ArrayList<Edge>[] graph,int indeg[]) {
					for(int i=0;i<graph.length;i++) {
						int v=i;
						for(int j=0;j<graph[v].size();j++) {
							Edge e = graph[v].get(j);
							indeg[e.dest]++;
							
						}
					}
				}
				
				public static  void top_sort_bfs(ArrayList<Edge>[] graph) {
					
					int indeg[]= new int [graph.length];
					calIndegree(graph, indeg);
					Queue<Integer> q = new LinkedList<>();
					
					for(int i=0;i<indeg.length;i++) {
						if(indeg[i] == 0) {
							q.add(i);
						}
					}
					
					//bfs
					while(!q.isEmpty()) {
						int curr = q.remove();
						System.out.print(curr+" ");// topological sort
						
						for(int i=0;i<graph[curr].size();i++) {
							Edge e =  graph[curr].get(i);
							indeg[e.dest]--;
							if(indeg[e.dest] == 0) {
								q.add(e.dest);
							}
						}
					}
					System.out.println();
 				}
				
				public static void printallpath(ArrayList<Edge> [] graph ,int src , int dest,String path) {
					if(src==dest) {
						System.out.println(path+dest);
						return;
					}
					for(int i=0;i<graph[src].size();i++) {
						Edge e =graph[src].get(i);
						printallpath(graph,e.dest,dest,path+src);
					}
				}
				public static void main (String args[]) {
						
						int V=6;
						ArrayList<Edge>[] graph = new ArrayList[V];
						
						CrateGraph(graph);
						
						int src=5,dest=1;
						printallpath(graph, src, dest,"");
						
					}
					}
					
				
			

