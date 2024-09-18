package com.Dhiraj.Questions;

import java.util.*;

public class LeetCodeQuestions {
    public static void main(String[] args) {
        int arr[][] = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(arr));




    }


//    https://leetcode.com/problems/all-paths-from-source-to-target/description/
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < graph[0].length; i++) {
            temp.add(0);
            allPathsSourceTargetHelper(graph, ans, temp, 0, i);
            temp.remove(0);
        }
        return ans;
    }

    private static void allPathsSourceTargetHelper(int[][] graph, List<List<Integer>> ans, List<Integer> temp, int row, int col) {
        if (row >= graph.length || col >= graph[row].length) {
            return;
        }
        int currentElement = graph[row][col];
        int[] elementRow = graph[currentElement];
        temp.add(currentElement);
        if (elementRow.length == 0) {
            // Create a copy of temp to avoid modifications during backtracking
            List<Integer> path = new ArrayList<>(temp);
            ans.add(path);
        }
        for (int k = 0; k < elementRow.length; k++) {
            allPathsSourceTargetHelper(graph, ans, temp, currentElement, k);
        }
        // Remove the current element from the path when backtracking
        temp.remove(temp.size() - 1);
    }



//    https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
//      We only have to count the number of nodes with zero incoming edges. think about it for a second
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (List<Integer> edge : edges){
            if (set.contains(edge.get(1))){
                set.remove(edge.get(1));
            }
        }
        for (int k : set){
            temp.add(k);
        }
        return temp;
    }


//    https://leetcode.com/problems/keys-and-rooms/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // it is simple dfs, see room[i] will contains all the neighbour of node i
        // so visit temp add them in set;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        canVisitAllRoomsHelper(rooms, 0, set);
        // all rooms will be visited if set size if rooms size
        return set.size() == rooms.size();

        // deince hash set check if set contains index i, if not return false if then enter the keys of ith root in set
        // bad idea
        // Set<Integer> set = new HashSet<>();

        // set.add(0);     // since 0th room will be open
        // for(int i=0; i<rooms.size(); i++){
        //     if(!set.contains(i)){
        //         return false;
        //     }
        //     for(int j=0; j<rooms.get(i).size(); j++){
        //         set.add(rooms.get(i).get(j));
        //     }
        // }
        //  System.out.println(set);

        // return true;


    }
    public void canVisitAllRoomsHelper(List<List<Integer>> rooms, int source, Set<Integer> set){
        set.add(source);
        for(int j=0; j<rooms.get(source).size(); j++){
            if(!set.contains(rooms.get(source).get(j))){
                canVisitAllRoomsHelper(rooms, rooms.get(source).get(j), set);
                set.add(rooms.get(source).get(j));
            }

        }
    }


//    https://leetcode.com/problems/find-if-path-exists-in-graph/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        bfs(graph, source, visited);
        return visited.contains(destination);
    }

    public void bfs(List<List<Integer>> graph, int source, Set<Integer> visited){
        visited.add(source);

        for(int i : graph.get(source)){
            if(!visited.contains(i)){
                bfs(graph, i, visited);
            }
        }

    }

}
