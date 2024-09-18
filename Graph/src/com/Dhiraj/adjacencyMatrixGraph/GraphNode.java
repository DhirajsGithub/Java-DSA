package com.Dhiraj.adjacencyMatrixGraph;

public class GraphNode {
    public String name;
    public int index;

    public boolean isVisited = false; // for BFS, DFS, topological sort

    public GraphNode parent; // for SSSPP

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
