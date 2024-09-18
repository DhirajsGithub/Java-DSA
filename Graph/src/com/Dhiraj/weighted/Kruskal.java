package com.Dhiraj.weighted;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        WeightedNode first = nodeList.get(firstIndex);
        WeightedNode second = nodeList.get(secondIndex);
        UndirectedEdge edge = new UndirectedEdge(first, second, weight);
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    public void kruskalAlgo() {
        DisjointSet.makeSet(nodeList); // O(V)
        Collections.sort(edgeList); // O(Elog(E))
        // for (UndirectedEdge edge : edgeList){
        // System.out.print(edge);
        // }

        // edges will be taken greadly, first the edge with least weight is taken
        // following the second least one
        int cost = 0;
        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("\nTotal cost of MST " + cost);

    }

}
