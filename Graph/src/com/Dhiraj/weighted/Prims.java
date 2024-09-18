package com.Dhiraj.weighted;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    ArrayList<WeightedNode> nodelist = new ArrayList<>();

    public Prims(ArrayList<WeightedNode> nodelist) {
        this.nodelist = nodelist;
    }

    public void addWeightedUndirectedEdge(int i, int j, int weight){
        WeightedNode first = nodelist.get(i);
        WeightedNode second = nodelist.get(j);
//        UndirectedEdge edge = new UndirectedEdge(first, second, weight );
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    // prims alogrithm
    // so the uddesh is we will be updating parent of a node, s.t. the edge weight is minimum
    // we will be using priority queue coz we need the minimum edge at every level
    // read notes lazy ass
    public void primsAlgo(WeightedNode sourceNode){
        // setting all nodes distance to infinity as initial step
        for (WeightedNode node : this.nodelist){
            node.distance = Integer.MAX_VALUE;
        }

        // setting source node distance to 0
        sourceNode.distance = 0;

        PriorityQueue<WeightedNode> pq = new PriorityQueue<>();
        pq.addAll(nodelist);
        while (!pq.isEmpty()){
            WeightedNode currentNode = pq.poll();
            // currenet will be source node as it's distance is 0;

            for (WeightedNode neighbour : currentNode.neighbours){
                if (pq.contains(neighbour)){
                    if(neighbour.distance > currentNode.weightMap.get(neighbour)){
                        // if the distance of current node exceeds current edge we are updating that distance
                        neighbour.distance = currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        // refreshing priority queue
                        pq.remove(neighbour);
                        pq.add(neighbour);
                    }
                }
            }

            int cost = 0;
            for (WeightedNode nodeToCheck : nodelist){
                System.out.println("Node "+ nodeToCheck + ", key " + nodeToCheck.distance + " Parent : "+ nodeToCheck.parent);
                cost += nodeToCheck.distance;
            }
            System.out.println("Total cost of MST : " + cost);

        }
    }
}
