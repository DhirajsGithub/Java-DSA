package com.Dhiraj.Questions;
import com.Dhiraj.adjacencyListGraph.Graph;
import com.Dhiraj.adjacencyListGraph.GraphNode;

import java.util.*;

/*
     Route Between Nodes
    Given a directed graph and two nodes (S and E), design an algorithm to find out whether there is a route from S to E.
     */

public class RouteBetweenNodes {

    static ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public RouteBetweenNodes(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }



    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }



    public boolean search(GraphNode src, GraphNode des){
        // dfs will be used
        if(src == null || des == null){
            return true;
        }
        Stack<GraphNode> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            if(currentNode == des){
                return true;
            }
            for (GraphNode node: currentNode.neighbours){
                if(!node.isVisited){
                    stack.push(node);
                    node.isVisited = true;
                }
            }
        }
        return false;
    }


}
