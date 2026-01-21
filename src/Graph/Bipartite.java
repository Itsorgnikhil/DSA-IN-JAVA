package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph.Cycle_detection.Edge;

public class Bipartite {
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
				graph[0].add(new Edge(0, 1,1));
				graph[0].add(new Edge(0, 2,1));

				graph[1].add(new Edge(1, 0,1));
				graph[1].add(new Edge(1, 3,1));

				graph[2].add(new Edge(2, 0,1));
				graph[2].add(new Edge(2, 4,1));

				graph[3].add(new Edge(3, 1,1));
				graph[3].add(new Edge(3, 4,1));

				graph[4].add(new Edge(4, 2,1));
				graph[4].add(new Edge(4, 3,1));
					
								
			}
			
			public static boolean isBipartiti(ArrayList<Edge> [] graph) {
				int colour[] = new int[graph.length];
				for(int i=0;i<graph.length;i++) {
					colour[i] = -1; // no colour 
;				}
				
				Queue<Integer> q = new LinkedList<>();
				
				for(int i=0;i<graph.length;i++) {
					if(colour[i] == -1) {//bfs
						q.add(i);
						colour[i]=0;
						while(!q.isEmpty()) {
							int curr =q.remove();
							for(int j=0;j<graph[curr].size();j++) {
								Edge edge = graph[curr].get(j);
								if(colour[edge.dest]== -1) {
									int nextcol =colour[curr] == 0?1:0;
									colour[edge.dest] =nextcol;
									q.add(edge.dest);
								}else if(colour[edge.dest] == colour[curr]) {
									return false; // not bipartite
								}
							}
						}
					}
				}  
				return true;
			}
			
				public static void main (String args[]) {
					
					int V=7;
					ArrayList<Edge>[] graph = new ArrayList[V];
					
					CreateGraph(graph);
					System.out.println(isBipartiti(graph));
				}
				}
				
			
		




