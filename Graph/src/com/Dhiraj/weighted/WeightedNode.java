package com.Dhiraj.weighted;
import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {
    public String name;
    public ArrayList<WeightedNode> neighbours = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
    public int index;

    // pointer to the set in which this node belongs
    public DisjointSet set;

    public WeightedNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }

    // for Disjoint set
    public WeightedNode(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(WeightedNode o){
        return this.distance - o.distance;
    }
}
