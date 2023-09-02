package NodeBasedDijkstraAlg;

import java.util.ArrayList;

public class Dijkstra {

    ArrayList<ArrayList<Node>> graph;
    int[] minDistanceFromNode;
    boolean[] visited;

    Dijkstra(int numOfElements) {
        graph = new ArrayList<>(numOfElements);
        minDistanceFromNode = new int[numOfElements];
        visited = new boolean[numOfElements];

        for (int i = 0; i < numOfElements; i++) {
            graph.add(i, new ArrayList<>());
            minDistanceFromNode[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
    }

    public void insertEdge(int source, int destination, int weight) {
        graph.get(source).add(new Node(destination, weight));
        graph.get(destination).add(new Node(source, weight));
    }

    public int getMinDistanceVertex() {
        int minIndex = -1;
        for (int i = 0; i < minDistanceFromNode.length; i++) {
            if (!visited[i] && (minIndex == -1 || minDistanceFromNode[i] < minDistanceFromNode[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void findMinDistance(int source) {
        minDistanceFromNode[source] = 0;

        for (int i = 0; i < minDistanceFromNode.length; i++) {
            int minIndex = getMinDistanceVertex();
            visited[minIndex] = true;

            for (Node neighborNode : graph.get(minIndex)) {
                if (!visited[neighborNode.destination] && (minDistanceFromNode[minIndex] != Integer.MAX_VALUE)
                        && minDistanceFromNode[minIndex]
                                + neighborNode.weight < minDistanceFromNode[neighborNode.destination]) {
                                    minDistanceFromNode[neighborNode.destination] = minDistanceFromNode[minIndex] + neighborNode.weight;
                }
            }
        }
        printDijkstra(source);
    }

    private void printDijkstra(int source) {
        System.out.println("Node \t\t Distance from Source");
        for(int i = 0; i < minDistanceFromNode.length; i++){
            System.out.println(i + "\t\t" + minDistanceFromNode[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(7);
        // dijkstra.insertEdge(0, 2, 1);
        // dijkstra.insertEdge(0, 3, 2);
        // dijkstra.insertEdge(1, 5, 3);
        // dijkstra.insertEdge(1, 2, 2);
        // dijkstra.insertEdge(2, 0, 1);
        // dijkstra.insertEdge(2, 4, 3);
        // dijkstra.insertEdge(2, 1, 2);
        // dijkstra.insertEdge(2, 3, 1);
        // dijkstra.insertEdge(3, 0, 2);
        // dijkstra.insertEdge(3, 6, 1);
        // dijkstra.insertEdge(3, 2, 1);
        // dijkstra.insertEdge(4, 2, 3);
        // dijkstra.insertEdge(4, 5, 2);
        // dijkstra.insertEdge(3, 2, 1);
        // dijkstra.insertEdge(3, 2, 1);
        // dijkstra.insertEdge(3, 2, 1);
        
        // dijkstra.findMinDistance(0);

        dijkstra.insertEdge(0, 2, 1);
        dijkstra.insertEdge(0, 3, 2);
        dijkstra.insertEdge(1, 2, 2);
        dijkstra.insertEdge(1, 5, 3);
        dijkstra.insertEdge(2, 0, 1);
        dijkstra.insertEdge(2, 1, 2);
        dijkstra.insertEdge(2, 3, 1);
        dijkstra.insertEdge(2, 4, 3);
        dijkstra.insertEdge(3, 0, 2);
        dijkstra.insertEdge(3, 2, 1);
        dijkstra.insertEdge(3, 6, 1);
        dijkstra.insertEdge(4, 2, 3);
        dijkstra.insertEdge(4, 5, 2);
        dijkstra.insertEdge(5, 1, 3);
        dijkstra.insertEdge(5, 4, 2);
        dijkstra.insertEdge(5, 6, 1);
        dijkstra.insertEdge(6, 3, 1);
        dijkstra.insertEdge(6, 5, 1);

        dijkstra.findMinDistance(0);
    }
}
