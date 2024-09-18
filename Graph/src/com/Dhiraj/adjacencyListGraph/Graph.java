package com.Dhiraj.adjacencyListGraph;
import com.Dhiraj.adjacencyListGraph.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();      // will contain all nodes of the graph

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addUnDirectedEdge(int i, int j){
        GraphNode first = this.nodeList.get(i);
        GraphNode second = this.nodeList.get(j);
//
        first.neighbours.add(second);       // adding the links
        second.neighbours.add(first);       // since un-directed

//         or with linkedList

//        let say GraphNode has one more field as GraphNode next;
//        GraphNode firstNew = new GraphNode(second.name, second.index);
//        firstNew.next = first.next;
//        first.next = firstNew;
//
//        GraphNode secondNew = new GraphNode(first.name, first.index);
//        secondNew.next = second.next;
//        second.next = secondNew;

    }
    public void addDirectedEdge(int src, int desc){
        GraphNode srcNode = this.nodeList.get(src);
        GraphNode desNode = this.nodeList.get(desc);
        srcNode.neighbours.add(desNode);
    }

    public void printGraph(){
        for (int i = 0; i < this.nodeList.size(); i++) {
            GraphNode presentNode = this.nodeList.get(i);
            System.out.print(presentNode.name +"  -> ");
            for (int j = 0; j < presentNode.neighbours.size(); j++) {
                GraphNode presentNodeNeigh = presentNode.neighbours.get(j);
                if (j != presentNode.neighbours.size()-1){
                    System.out.print(presentNodeNeigh.name+ " -> ");
                }else{
                    System.out.print(presentNodeNeigh.name);
                }

            }
//            while (presentNode != null){
//                System.out.print(presentNode.name + " -> ");
//                presentNode = presentNode.next;
//            }
            System.out.println();
        }
    }

    // time = space = O(V + E)
    public void BFS(){
        System.out.print("BFS :  ");
        for (GraphNode node : nodeList){
            if(!node.isVisited){
                bfsTraversal(node);
            }
        }
    }

    private void bfsTraversal(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            GraphNode presentNode = queue.poll();
            node.isVisited = true;
            System.out.print(presentNode.name+ " ");
            ArrayList<GraphNode> neighbours = presentNode.neighbours;
            for (GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    queue.offer(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    private void dfsTraversal(GraphNode node){
        //  + time :  O(V)  from DFS since we are checking all the vertices
        // using stack
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        // while loop in worst case time = O(V)
        while (!stack.isEmpty()){
            GraphNode presentNode = stack.pop();
            System.out.print(presentNode.name + " ");
            presentNode.isVisited = true;
            // loop will go on for all adjacency nodes hence time is O(Adj)
            for (GraphNode neighbour : presentNode.neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }

        // total time = O(V) + O(V*Adj) = O(V + E)  E is edge

        // using recursion
//        System.out.print(node.name+ " ");
//        node.isVisited = true;
//        ArrayList<GraphNode> neighbours = node.neighbours;
//        for (GraphNode neighbour : neighbours){
//            if(!neighbour.isVisited){
//                dfsTraversal(neighbour);
//                neighbour.isVisited = true;
//            }
//        }
    }

    // time = space = O(V + E)
    public void DFS(){
        System.out.print("DFS :  ");
        // time :  O(V)
        for (GraphNode node : nodeList){
            if(!node.isVisited){
                dfsTraversal(node);
            }
        }
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        // + time O(V) since we are calling topologicalVisit for every vertex
        // this for loop will run O(Adj) time
        for (GraphNode neighbour : node.neighbours){
            if(!neighbour.isVisited){
                topologicalVisit(neighbour, stack); // this will take O(V) time
                neighbour.isVisited = true;
            }
        }
        // finally H will be arrived which has no neighbours hence it will be pushed in stack, then it will backtrack to E then goes to F then G
        // G has no neighbour then it will be arrived here and pushed into stack
        // then it will backtrack to F again, all the neighbours of F are visited then F will arrive here, and it will be pushed into stack
        node.isVisited = true;
        stack.push(node);

    }

    // time = O(V + E) = space
    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        System.out.print("Topological Sort :  ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }

    public void printPathSSP(GraphNode node){
        if (node.parent != null) {
            printPathSSP(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void ssspBFS(GraphNode node){
        node.isVisited = true;
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            System.out.print(current.name+ " -> ");
            printPathSSP(current);
            System.out.println();
            current.isVisited = true;
            for(GraphNode neigh : current.neighbours){
                if(!neigh.isVisited){
                    queue.offer(neigh);
                    neigh.parent = current;
                    neigh.isVisited = true;
                }
            }

        }

    }


    // path print helper
    public void pathPrint(GraphNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    // SSSPP
    // 1. BFS  time O(E) space O(V)
    public void SSSPP_BFS(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);

        // time O(V)
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print("printing path for "+ currentNode.name + " :  ");
            pathPrint(currentNode);
            System.out.println();
            // time O(Adj)
            for (GraphNode neighbour : currentNode.neighbours){
                if (!neighbour.isVisited){
                    queue.offer(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }

        }
    }


}
