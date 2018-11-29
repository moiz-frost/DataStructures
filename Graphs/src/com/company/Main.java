package com.company;

public class Main {

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(8);
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addVertex("Four");
        graph.addVertex("Five");
        graph.addVertex("Six");
        graph.addVertex("Seven");
        graph.addVertex("Eight");
        graph.addEdge("One", "Six");
        graph.addEdge("One", "Seven");
        graph.addEdge("One", "Four");
        graph.displayAdjacencyList();
    }
}
