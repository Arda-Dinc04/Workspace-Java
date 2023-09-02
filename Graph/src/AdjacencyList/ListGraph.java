package AdjacencyList;

import java.util.ArrayList;

public class ListGraph {
    ArrayList<ArrayList<Integer>> graph;

    ListGraph(int numOfElements){
        graph = new ArrayList<>(numOfElements);
        
        for(int i = 0; i< numOfElements; i++){
            graph.add(i,new ArrayList<>());
        }
    }
   
    public void insertEdge(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void removeEdge(int source, int destination){
        graph.get(source).remove(destination);
        graph.get(destination).remove(source);
    }
    
    public String toString(){
        String str = "";
        int iter = 0;
        for(ArrayList<Integer> arr : graph){
            str+="["+ iter++ + "]: ";
            for(Integer edges : arr){
                str += edges+", ";
            }
            str+="\n";
        }
        return str;
    }
    
}
