package com.Dhiraj.weighted;
import com.Dhiraj.weighted.WeightedNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraph {
    public ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int src, int des, int distance){
        WeightedNode srcNode = nodeList.get(src);
        WeightedNode desNode = nodeList.get(des);
        srcNode.neighbours.add(desNode);
        srcNode.weightMap.put(desNode, distance);
    }

    public void printPath(WeightedNode node){
        if (node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name + " ");
    }

    /*
    Why Dijkstra’s Algorithm uses a Priority Queue?
    We use min heap in Dijkstra’s Algorithm because a node can have multiple weighted edges but for the shortest path,
    we have to consider the smallest weighted edge associated with a node. For this,
    we use a priority queue (min-heap) which gives us the minimum element on the top of the priority queue.
     */

    // note we are just focuing on updating the parent of node, which is at smallest possible distance
    void dijkstra(WeightedNode node){
        // we are using priority queue coz we need that node always whose distance is minimum
        PriorityQueue<WeightedNode> pq = new PriorityQueue<>();
        node.distance = 0;
        pq.addAll(nodeList);
        // except for the node here rest all node distance id infinity, hence when we remove an element from pq it will be this node, let say A
        while (!pq.isEmpty()){
            WeightedNode currentNode = pq.poll();
            for (WeightedNode neighbour : currentNode.neighbours){
                if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)){
                    neighbour.distance = currentNode.distance + currentNode.weightMap.get(neighbour);
                    neighbour.parent = currentNode;
                    // refreshing the pq
                    pq.remove(neighbour);
                    pq.add(neighbour);

                    // so look at it like this, we have all nodes in PQ, ima not specifying the order here coz it is heap, the first node will
                    // be the one with smallest distance
                    // so once A(distance is set to 0) is removed we are adding his neighbours B and C and updating there distnace as 2 and 5, rest all node
                    // distance is inifinity so which node will be pop up from pq, it will be B
                }
            }
        }

        System.out.println("Checking Minimum path from "+ node + " to : ");
        for (WeightedNode nodeToCheck : nodeList){
            System.out.print("Node "+ nodeToCheck + " ,distance " + nodeToCheck.distance + " ,path: ");
            printPath(nodeToCheck);
            System.out.println();
        }

    }

    // bellman ford algo
    public void bellmanFord( WeightedNode sourceNode) {
        sourceNode.distance = 0; // Set the source node distance to 0

        // Step 1: Relax all edges (V-1) times
        int V = nodeList.size();
        for (int i = 0; i < V - 1; i++) {
            for (WeightedNode node : nodeList) {
                for (WeightedNode neighbour : node.neighbours) {
                    int newDist = node.distance + node.weightMap.get(neighbour);
                    if (neighbour.distance > newDist) {
                        neighbour.distance = newDist;
                        neighbour.parent = node;
                    }
                }
            }
        }

        // Step 2: Check for negative-weight cycles
        for (WeightedNode node : nodeList) {
            for (WeightedNode neighbour : node.neighbours) {
                if (neighbour.distance > node.distance + node.weightMap.get(neighbour)) {
                    System.out.println("Negative cycle detected!");
                    return; // Negative cycle detected
                }
            }
        }

        // Step 3: Print the shortest path and distances
        System.out.println("No negative cycle detected. Shortest paths:");
        for (WeightedNode node : nodeList) {
            System.out.println("Node " + node.name + ", Distance: " + node.distance + ", Path:");
            printPath(node);
            System.out.println();
        }
    }


    // floyd warshall algo
    public void floydWarshall(){
        int size = nodeList.size();
        int [][] V = new int[size][size];
        // we will be updating this matrix based on the distances between the vertex

        // with given data, first form a given V
        for (int i=0; i<size; i++){
            // go with row wise, check notes. let say first = A
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                // second will be A, then B then C, then D, so we are calculating distance as A-->A, then A-->B, then A-->C, then A-->D
                // A-->A will be set to 0
                if(i == j){
                    V[i][j] = 0;
                }else if(first.weightMap.containsKey(second)){
                    // checking if there is direct root from src to destination i.e. A-->B
                    V[i][j] = first.weightMap.get(second);

                }else{
                    // no direct route from src to destination hence updating that cell to infinity
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }

        // number of vertex iterations
        // this loop will check for iterations, which contains viaX
        // e.g. A having index 0, B(1) and C(2)
        // we are going as C-->B via A

        // i--> viaX i.e. got to B-->C via A, via B, via C, ...
        // j--> sources
        // k--> destination
        // j-->k  i.e. A-->B, A-->C, ... then B--A, B--D, ...
        // via i implie A-->B via A then A-->B via B, then A-->C via C, ...
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    // V[j][k] is C to B cell, so we are checking if C to B cell is greater than C to A ( V[j][i]) + A to B (V[i][k]) cell
                    if(V[j][k] > V[j][i] + V[i][k]){
                        V[j][k] = V[j][i] + V[i][k];
                    }
                }
            }
        }

        // printing short paths
        System.out.print("\t\t\t\t    ");
        for (int i = 0; i < size; i++) {
            System.out.print(nodeList.get(i)+ " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node "+ nodeList.get(i)+ " : ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }


}
