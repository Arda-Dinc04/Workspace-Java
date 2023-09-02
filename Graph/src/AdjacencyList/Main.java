package AdjacencyList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(4);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 2);

        System.out.println(graph);
        
}