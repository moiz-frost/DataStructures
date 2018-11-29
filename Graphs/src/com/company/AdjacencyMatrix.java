package com.company;

public class AdjacencyMatrix {
    private int adjacencyMatrix[][];
    private Vertex vertexList[];
    private int counter = 0;

    public AdjacencyMatrix(int size) {
        vertexList = new Vertex[size];
        adjacencyMatrix = new int[size][size];
    }

    public void addVertex(String label) {
        if (counter >= vertexList.length) {
            System.out.println("Vertex list full");
            return;
        }
        vertexList[counter++] = new Vertex(label);
    }

    private int getIndexLabel(String label) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].label.compareTo(label) == 0) return i;
        }
        return -1;
    }

    public void addEdge(String labelOne, String labelTwo) {
        int indexOne = getIndexLabel(labelOne);
        int indexTwo = getIndexLabel(labelTwo);
        if (indexOne == -1 || indexTwo == -1) {
            System.out.println("Invalid Label(s)");
            return;
        }
        adjacencyMatrix[indexOne][indexTwo] = 1;
    }

    public void displayAdjacencyList() {
        for (Vertex vertex : vertexList) {
            System.out.print(vertex.label);
            System.out.print(" ");
        }

        for (int i = 0; i < vertexList.length; i++) {
            System.out.println();
            for (int j = 0; j < vertexList.length; j++) {
                System.out.print(adjacencyMatrix[i][j]);
            }
        }
    }

}
