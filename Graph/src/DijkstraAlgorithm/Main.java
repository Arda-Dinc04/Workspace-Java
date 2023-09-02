/**
 * Main
 */

package DijkstraAlgorithm;

public class Main {

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 0, 1, 2, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 },
                { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 }
        };
        
        Dijkstra T = new Dijkstra();
        T.dijkstra(graph, 0);
    }
}