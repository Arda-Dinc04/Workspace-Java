package DFS;

import java.util.LinkedList;

public class DFS {
    LinkedList<Integer>[] adjList;
    boolean visited[];
   
    DFS(int vertices) {
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int index = 0; index < vertices; index++) {
            adjList[index] = new LinkedList<>();
            visited[index] = false;
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void dfs(int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for(int value : adjList[vertex]){
            if(!visited[value])
                dfs(value);
        }
    }
    
    public static void main(String[] args) {
        DFS dfs = new DFS(5);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 4);

        dfs.dfs(0); // 0 ?
    }
}
