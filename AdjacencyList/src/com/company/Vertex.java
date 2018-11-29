package com.company;

import java.util.LinkedList;

public class Vertex {
    String name;
    int age;

    LinkedList<Vertex> edges = new LinkedList<Vertex>();

    public Vertex(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
