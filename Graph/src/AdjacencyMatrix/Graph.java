package AdjacencyMatrix;

public class Graph {
    boolean [][] arr;
    int numVertices;

    Graph(int numVertices){
        arr = new boolean[numVertices][numVertices];
    }

    public void insertEdgde(int source, int destination){
        arr[source][destination] = true;
        arr[destination][source] = true;
    }

    public void deleteEdge(int source, int destination){
        arr[source][destination] = false;
        arr[destination][source] = false;
    }

    public String toString(){
        String str = "";
        for(boolean[] row : arr){
            for(boolean col : row){
                str += (col ? 1 : 0) + " ";
            }
            str+="\n";
        }
        return str;
    }
    
}