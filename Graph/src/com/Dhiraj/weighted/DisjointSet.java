package com.Dhiraj.weighted;

import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

//    {{A}, {B}, {C}}       outer curly brac is this Set with list as nodeList
    public static void makeSet(ArrayList<WeightedNode> list){
        for (WeightedNode node : list){
            // and inner cursly brac like {A} is below set
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;     // pointing to set where it is belong i.e. A is pointing to {} s.t. {A}
        }
    }

    public static DisjointSet findSet(WeightedNode node){
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2){
        // no point of adding set A inside A, as set contains unique values
        if(node1.set.equals(node2)){
            return null;
        }
        DisjointSet firstSet = node1.set;
        DisjointSet secondSet = node2.set;

        if(firstSet.nodeList.size() > secondSet.nodeList.size()){
            // add all element of set2 in set1
            ArrayList<WeightedNode> nodeSet2 = secondSet.nodeList;
            for(WeightedNode nodeSecond : nodeSet2){
                nodeSecond.set = firstSet;      // first we will be changing pointer of each node of secondSet to firstSet then we will add them in firstSet
                firstSet.nodeList.add(nodeSecond);

            }
            return firstSet;
        }else{
            ArrayList<WeightedNode> nodeSet1 = firstSet.nodeList;
            for (WeightedNode nodeFirst: nodeSet1){
                nodeFirst.set = secondSet;
                secondSet.nodeList.add(nodeFirst);

            }
            return secondSet;
        }

    }

    public void printAllNodesOfThisSet(){
        System.out.println("Printing all nodes of the set: ");
        for (WeightedNode node: nodeList){
            System.out.print(node+ " ");
        }
        System.out.println();
    }
}
