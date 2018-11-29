package com.company;

public class AdjacencyList {

    Vertex[] adjacencyList;
    int count;

    public AdjacencyList (int size) {
        adjacencyList = new Vertex[size];
        count = 0;
    }

    private int getIndex (Vertex v) {
        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i].name.compareTo(v.name) == 0 &&
                    adjacencyList[i].age == v.age) return i;
        }
        return -1;
    }

    private void removeHolesFromList () {
        Vertex[] newAdjacencyList = new Vertex[adjacencyList.length];
        for (int i = 0, j = 0; i < count; i++) {
            if (adjacencyList[i] != null) {
                newAdjacencyList[j++] = adjacencyList[i];
            }
        }
        adjacencyList = newAdjacencyList;
    }

    public void addVertex (Vertex v) {
        if (count >= adjacencyList.length) {
            System.out.println("List full");
            return;
        }
        adjacencyList[count++] = v;
    }

    public void addEdge (Vertex source, Vertex dest) {
        int sourceIndex = getIndex(source);
        int destIndex = getIndex(dest);
        if (sourceIndex == -1 || destIndex == -1) {
            System.out.println("Invalid Vertices");
            return;
        }
        adjacencyList[sourceIndex].edges.add(adjacencyList[destIndex]);
    }

    public void deleteVertex (Vertex v) {
        if (count <= 0) {
            System.out.println("List Empty");
            return;
        }
        int foundIndex = getIndex(v);
        if (foundIndex == -1) {
            System.out.println("Invalid Vertex");
            return;
        }
        for (Vertex edge : v.edges) {
            deleteEdge(edge, v);
        }
        adjacencyList[foundIndex] = null;
        removeHolesFromList();
        count--;
    }

    public void deleteEdge (Vertex source, Vertex dest) {
        int sourceIndex = getIndex(source);
        int destIndex = getIndex(dest);
        if (sourceIndex == -1 || destIndex == -1) {
            System.out.println("Invalid Vertices");
            return;
        }
        adjacencyList[sourceIndex].edges.remove(adjacencyList[destIndex]);
    }

    public Vertex FindVertex (Vertex v){
        int index = getIndex(v);
        if (index == -1) {
            System.out.println("Invalid Vertices");
            return null;
        }
        return adjacencyList[index];
    }

    public void print() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.println(adjacencyList[i].name + " " + adjacencyList[i].age);
            for (Vertex edge : adjacencyList[i].edges) {
                System.out.println(edge.name + " " + edge.age);
            }
        }
    }


}
