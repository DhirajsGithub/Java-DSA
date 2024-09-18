package com.Dhiraj.adjacencyListGraph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> list = new ArrayList<>();
        list.add(new GraphNode("A", 0));
        list.add(new GraphNode("B", 1));
        list.add(new GraphNode("C", 2));
        list.add(new GraphNode("D", 3));
        list.add(new GraphNode("F", 4));

        Graph graph = new Graph(list);
        graph.addUnDirectedEdge(0, 1);
        graph.addUnDirectedEdge(0, 2);
        graph.addUnDirectedEdge(0, 3);
        graph.addUnDirectedEdge(1, 4);
        graph.addUnDirectedEdge(2, 3);
        graph.addUnDirectedEdge(3, 4);
        graph.printGraph();
//        graph.BFS();
//        graph.DFS();

        ArrayList<GraphNode> nodeList2 = new ArrayList<>();
        nodeList2.add(new GraphNode("A", 0));
        nodeList2.add(new GraphNode("B", 1));
        nodeList2.add(new GraphNode("C", 2));
        nodeList2.add(new GraphNode("D", 3));
        nodeList2.add(new GraphNode("E", 4));
        nodeList2.add(new GraphNode("F", 5));
        nodeList2.add(new GraphNode("G", 6));
        nodeList2.add(new GraphNode("H", 7));


        Graph graph2 = new Graph(nodeList2);
        // making edges
        graph2.addDirectedEdge(0, 2);
        graph2.addDirectedEdge(2, 4);
        graph2.addDirectedEdge(4, 7);
        graph2.addDirectedEdge(4, 5);
        graph2.addDirectedEdge(3, 5);
        graph2.addDirectedEdge(1, 2);
        graph2.addDirectedEdge(1, 3);
        graph2.addDirectedEdge(5, 6);
    //    graph2.topologicalSort();


        ArrayList<GraphNode> nodeList3 = new ArrayList<>();
        nodeList3.add(new GraphNode("A", 0));
        nodeList3.add(new GraphNode("B", 1));
        nodeList3.add(new GraphNode("C", 2));
        nodeList3.add(new GraphNode("D", 3));
        nodeList3.add(new GraphNode("E", 4));
        nodeList3.add(new GraphNode("F", 5));
        nodeList3.add(new GraphNode("G", 6));

        Graph graph3 = new Graph(nodeList3);

        graph3.addUnDirectedEdge(0, 1);
        graph3.addUnDirectedEdge(0, 2);
        graph3.addUnDirectedEdge(1, 3);
        graph3.addUnDirectedEdge(1, 6);
        graph3.addUnDirectedEdge(2, 3);
        graph3.addUnDirectedEdge(2, 4);
        graph3.addUnDirectedEdge(3, 5);
        graph3.addUnDirectedEdge(4, 5);
        graph3.addUnDirectedEdge(5, 6);
        graph3.ssspBFS(nodeList3.get(0));
        // graph3.SSSPP_BFS(nodeList3.get(0));
        // SSSPP



    }
}
