package BFS;

import java.util.LinkedList;

public class BFS {
    LinkedList<Integer>[] adjList;
    int numVertices;
    
    BFS(int numVertices){
        adjList = new LinkedList[numVertices];
        this.numVertices = numVertices;

        for(int i = 0; i< numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void bfs(int vertex){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numVertices];
        visited[vertex] = true;
        queue.add(vertex);
        
        while(!queue.isEmpty()){
            vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for(int ver: adjList[vertex]){
                if (!visited[ver]) {
                    visited[ver] = true;
                    queue.add(ver);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        graph.bfs(0);
    }
}