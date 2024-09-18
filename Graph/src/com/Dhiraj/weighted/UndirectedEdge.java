package com.Dhiraj.weighted;

public class UndirectedEdge implements Comparable<UndirectedEdge>{
    public WeightedNode first;
    public WeightedNode second;
    public int weight;

    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return " "+this.first.name + "---" +this.weight + "---" + this.second.name + " ";
    }


    @Override
    public int compareTo(UndirectedEdge o) {
        return this.weight-o.weight;
    }
}
