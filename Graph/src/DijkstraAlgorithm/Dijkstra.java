package DijkstraAlgorithm;

public class Dijkstra {
   

    public void dijkstra(int graph[][], int startVertex){
        boolean visited[] = new boolean[graph.length];
        int minDistance[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            minDistance[i] = Integer.MAX_VALUE;
        }
        minDistance[startVertex] =0;

        for (int i = 0; i < graph.length; i++) {
            int u = findMinDistance(minDistance, visited);
            visited[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (!visited[v] && graph[u][v] != 0 && (minDistance[u] + graph[u][v] < minDistance[v])) {
                    minDistance[v] = minDistance[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < minDistance.length; i++) {
            System.out.println("Distance from " + startVertex + " to " + i + " is " + minDistance[i]);
        }

    }

    public int findMinDistance(int distance[], boolean visited[]){
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        
        return minDistanceVertex;
    }


}

