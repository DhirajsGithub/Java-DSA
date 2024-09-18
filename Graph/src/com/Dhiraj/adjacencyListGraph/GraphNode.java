package com.Dhiraj.adjacencyListGraph;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
//    public GraphNode next;    // for LL representation intead of arraylist neightbours

    public boolean isVisited = false;    // for BFS and DFS traversal, toplogical sort, SSSPP

    public GraphNode parent;   // for SSSPP


    public ArrayList<GraphNode> neighbours = new ArrayList<>();     // will contain nodes which are link to this node

    public GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }

}
