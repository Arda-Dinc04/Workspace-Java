package AdjacencyMatrix;
public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(4);

        graph.insertEdgde(0,1);
        graph.insertEdgde(0,2);
        graph.insertEdgde(0,3);
        graph.insertEdgde(1,2);

        //System.out.println("   0 1 2 3");
        //System.out.println("   ‾ ‾ ‾ ‾");
        System.out.println(graph);
    }
}
