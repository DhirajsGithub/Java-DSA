package com.Dhiraj.Backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean mazeResctiction[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        traversingAppPath("", mazeResctiction, 0, 0);

        int [] [] path = new int [mazeResctiction.length][mazeResctiction[0].length];
        traversingAppPathPrint("", mazeResctiction, 0, 0, path, 1);
    }

    static void traversingAppPath(String p,boolean[][] maze, int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        // the obstacle set to false, other paths are set to true
        // make a change
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;   // blocking those paths which we are already traversed
        if(r< maze.length-1){
            traversingAppPath(p+'D', maze, r+1, c);
        }
        if(c< maze[0].length-1){
            traversingAppPath(p+'R', maze, r, c+1);
        }
        if(r > 0){
            traversingAppPath(p+'U', maze, r-1, c);
        }
        if(c > 0){
            traversingAppPath(p+'L', maze, r, c-1);
        }

        // this line is where the function get's over so before the function gets over remove all the marking whihc was done initally to prevent the unnecessary calls to the function
        // revert the change
        maze[r][c] = true;
    }

    static void traversingAppPathPrint(String p,boolean[][] maze, int r, int c, int [][] path, int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for (int i = 0; i < path.length; i++) {
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        path[r][c] = step;

        // the obstacle set to false, other paths are set to true
        // make a change
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;   // blocking those paths which we are already traversed

        if(r< maze.length-1){
            traversingAppPathPrint(p+'D', maze, r+1, c, path, step+1);
        }
        if(c< maze[0].length-1){
            traversingAppPathPrint(p+'R', maze, r, c+1, path, step+1);
        }
        if(r > 0){
            traversingAppPathPrint(p+'U', maze, r-1, c, path, step+1);
        }
        if(c > 0){
            traversingAppPathPrint(p+'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function get's over so before the function gets over remove all the marking whihc was done initally to prevent the unnecessary calls to the function
        // revert the change
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
