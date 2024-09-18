package com.Dhiraj.weighted;
import com.Dhiraj.weighted.WeightedNode;
import com.Dhiraj.weighted.WeightedGraph;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph graph = new WeightedGraph(nodeList);
        graph.addWeightedEdge(0, 1, 2);
        graph.addWeightedEdge(0, 2, 5);
        graph.addWeightedEdge(1, 2, 6);
        graph.addWeightedEdge(1, 3, 1);
        graph.addWeightedEdge(1, 4, 3);
        graph.addWeightedEdge(2, 5, 8);
        graph.addWeightedEdge(3, 4, 4);
        graph.addWeightedEdge(4, 6, 9);
        graph.addWeightedEdge(5, 6, 7);

//        graph.dijkstra(nodeList.get(0));
        // graph.dijkstra2(nodeList.get(0));
        // graph.bellmanFord(nodeList.get(nodeList.size()-1));

        // WeightedNode node0 = new WeightedNode("A", Integer.MAX_VALUE);
        // WeightedNode node1 = new WeightedNode("B", Integer.MAX_VALUE);
        // WeightedNode node2 = new WeightedNode("C", Integer.MAX_VALUE);
        // WeightedNode node3 = new WeightedNode("D", Integer.MAX_VALUE);
        // WeightedNode node4 = new WeightedNode("E", Integer.MAX_VALUE);
        // WeightedNode node5 = new WeightedNode("F", Integer.MAX_VALUE);
        // WeightedNode node6 = new WeightedNode("G", Integer.MAX_VALUE);
        // ArrayList<WeightedNode> nodeList2 = new ArrayList<>();
        // nodeList2.add(node0);
        // nodeList2.add(node1);
        // nodeList2.add(node2);
        // nodeList2.add(node3);
        // nodeList2.add(node4);
        // nodeList2.add(node5);
        // nodeList2.add(node6);

        // WeightedGraph g = new WeightedGraph(nodeList2);
        // g.addWeightedEdge(0, 3, -6);
        // g.addWeightedEdge(0, 2, 6);
        // g.addWeightedEdge(1, 0, 3);
        // g.addWeightedEdge(2, 3, 1);
        // g.addWeightedEdge(3, 2, 2);
        // g.addWeightedEdge(4, 3, 2);
        // g.addWeightedEdge(4, 1, 4);
        // g.addWeightedEdge(3, 1, 1);

//        System.out.println("Printing Bellman ford for destination : G");
//        System.out.println("-----------------------------------");
//        g.bellmanFord(nodeList2.get(nodeList2.size()-1));

        // Floyd warshall algorithm
        ArrayList<WeightedNode> nodeList3 = new ArrayList<>();
        nodeList3.add(new WeightedNode("A", 0));
        nodeList3.add(new WeightedNode("B", 1));
        nodeList3.add(new WeightedNode("C", 2));
        nodeList3.add(new WeightedNode("D", 3));

        WeightedGraph graph3 = new WeightedGraph(nodeList3);
        graph3.addWeightedEdge(0, 1, 8);
        graph3.addWeightedEdge(0, 3, 1);
        graph3.addWeightedEdge(1, 2, 1);
        graph3.addWeightedEdge(2, 0, 4);
        graph3.addWeightedEdge(3, 1, 2);
        graph3.addWeightedEdge(3, 2, 9);

       System.out.println("Printing Floyd Warshall Algo");
       graph3.floydWarshall();


        // ArrayList<WeightedNode> nodeList4 = new ArrayList<>();
        // nodeList4.add(new WeightedNode("A"));
        // nodeList4.add(new WeightedNode("B"));
        // nodeList4.add(new WeightedNode("C"));
        // nodeList4.add(new WeightedNode("D"));
        // DisjointSet.makeSet(nodeList4);
        // WeightedNode firstNode = nodeList4.get(0);
        // WeightedNode secondNode = nodeList4.get(1);
        // // finding set of secondNode
        // DisjointSet output = DisjointSet.findSet(secondNode);
        // output.printAllNodesOfThisSet();

        // DisjointSet.union(firstNode, secondNode);
        // output = DisjointSet.findSet(secondNode);
        // output.printAllNodesOfThisSet();



        // kruskal algo
        // System.out.println("Kruskal algorithm");
        // ArrayList<WeightedNode> nodeList5 = new ArrayList<>();
        // nodeList5.add(new WeightedNode("A"));
        // nodeList5.add(new WeightedNode("B"));
        // nodeList5.add(new WeightedNode("C"));
        // nodeList5.add(new WeightedNode("D"));
        // nodeList5.add(new WeightedNode("E"));

        // Kruskal kruskalGraph = new Kruskal(nodeList5);
        // // see notes for the edges relation
        // kruskalGraph.addWeightedUndirectedEdge(0, 1, 5);
        // kruskalGraph.addWeightedUndirectedEdge(0, 2, 13);
        // kruskalGraph.addWeightedUndirectedEdge(0, 4, 15);
        // kruskalGraph.addWeightedUndirectedEdge(1, 3, 8);
        // kruskalGraph.addWeightedUndirectedEdge(1, 2, 10);
        // kruskalGraph.addWeightedUndirectedEdge(3, 2, 6);
        // kruskalGraph.addWeightedUndirectedEdge(2, 4, 20);
        // kruskalGraph.kruskalAlgo();


        // Prims algo
        // ArrayList<WeightedNode> nodeList6 = new ArrayList<>();
        // nodeList6.add(new WeightedNode("A"));
        // nodeList6.add(new WeightedNode("B"));
        // nodeList6.add(new WeightedNode("C"));
        // nodeList6.add(new WeightedNode("D"));
        // nodeList6.add(new WeightedNode("E"));

        // Prims primsGraph = new Prims(nodeList6);
        // primsGraph.addWeightedUndirectedEdge(0, 1, 10);
        // primsGraph.addWeightedUndirectedEdge(0, 2, 20);
        // primsGraph.addWeightedUndirectedEdge(1, 3, 5);
        // primsGraph.addWeightedUndirectedEdge(1, 2, 30);
        // primsGraph.addWeightedUndirectedEdge(3, 2, 15);
        // primsGraph.addWeightedUndirectedEdge(3, 4, 8);
        // primsGraph.addWeightedUndirectedEdge(4, 2, 6);
        // primsGraph.primsAlgo(nodeList6.get(4));      // E as source


    }
}
