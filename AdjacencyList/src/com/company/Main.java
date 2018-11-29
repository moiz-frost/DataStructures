package com.company;

public class Main {

    public static void main(String[] args) {
        AdjacencyList adjList = new AdjacencyList(10);
        Vertex v1 = new Vertex("Samk  nub", 5);
        Vertex v2 = new Vertex("intell  nub", 5);
        Vertex v3 = new Vertex("dell  nub", 5);
        Vertex v4 = new Vertex("fanta  nub", 5);
        Vertex v5 = new Vertex("cocke  nub", 5);
        adjList.addVertex(v1);
        adjList.addVertex(v2);
        adjList.addVertex(v3);
        adjList.addVertex(v4);
        adjList.addVertex(v5);
        adjList.addEdge(v1, v5);
        adjList.addEdge(v1, v3);
        adjList.addEdge(v1, v2);
        adjList.addEdge(v2, v1);
        adjList.addEdge(v4, v5);
        adjList.addEdge(v4, v2);
        adjList.deleteVertex(v2);
        adjList.deleteEdge(v1, v5);
        adjList.print();
    }
}
