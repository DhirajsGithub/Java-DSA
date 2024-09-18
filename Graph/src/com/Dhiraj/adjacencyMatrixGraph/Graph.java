package com.Dhiraj.adjacencyMatrixGraph;
import com.Dhiraj.adjacencyMatrixGraph.GraphNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjanceyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjanceyMatrix = new int[nodeList.size()][nodeList.size()];

    }


    public void addUndirectedEdge(int src, int des) {
        this.adjanceyMatrix[src][des] = 1;
        this.adjanceyMatrix[des][src] = 1;
    }

    public void addDirectedEdge(int src, int des){
        this.adjanceyMatrix[src][des] = 1;
    }

    public void printGraph() {
        System.out.print("   ");
        for (int i = 0; i < this.nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + " ");
        }
        System.out.println();
        for (int i = 0; i < this.nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + ": ");
            for (int j = 0; j < this.adjanceyMatrix[i].length; j++) {
                System.out.print(this.adjanceyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // get neighbours of a graph
    public ArrayList<GraphNode> getNeighbours(GraphNode node){
        ArrayList<GraphNode> list = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjanceyMatrix.length; i++) {
            if(adjanceyMatrix[nodeIndex][i] == 1){
                list.add(this.nodeList.get(i));
            }
        }
        return list;
    }

    private void BFS(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            GraphNode presentNode = queue.poll();
            System.out.print(presentNode.name+ " ");
            presentNode.isVisited = true;
            ArrayList<GraphNode> neighbours = getNeighbours(presentNode);
            for (int i = 0; i < neighbours.size(); i++) {
                if(!neighbours.get(i).isVisited){
                    queue.offer(neighbours.get(i));
                    // this condition is curicial as some neighbours are in the queue and they haven't remove from queue they also added one more time coz they are being neighbout to another nodes
                    // use pen and paper
                    neighbours.get(i).isVisited = true;
                }
            }
        }
    }

    public void BSF(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                BFS(node);
            }
        }
    }

    private void dfsTraversal(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            System.out.print(currentNode.name+ " ");
            currentNode.isVisited = true;
            ArrayList<GraphNode> neighbours = getNeighbours(node);
            for (GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void DFS(){
        System.out.print("DFS :  ");
        for (GraphNode node : nodeList){
            if (!node.isVisited){
                dfsTraversal(node);
            }
        }
    }

    // topolofical sort
    private void topologicalVisite(GraphNode node, Stack<GraphNode> stack){
        for (GraphNode neighbour : this.getNeighbours(node)){
            if(!neighbour.isVisited){
                topologicalVisite(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList){
            if (!node.isVisited){
                topologicalVisite(node, stack);
            }
        }

        System.out.print("topological sort :  ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }

    // helper for SSSPP
    public void pathPrint(GraphNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    // SSSPP
    // 1. BFS
    public void SSSPP_BFS(GraphNode node){
        Queue <GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print("Printing SSSPP for "+ currentNode.name+ " :  ");
            pathPrint(currentNode);
            System.out.println();
            for(GraphNode neighbour : this.getNeighbours(currentNode)){
                if(!neighbour.isVisited){
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                    queue.offer(neighbour);
                }
            }
        }
    }
}
