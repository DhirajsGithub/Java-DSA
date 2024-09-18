package com.Dhiraj.Backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(mazePathCounts(3, 3));
        System.out.println(mazePathPrint("", 3, 3));
        System.out.println(mazePathDigonal("", 3, 3));
        boolean mazeResctiction[][] = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestriction("", mazeResctiction, 0, 0);
    }
    static int mazePathCounts (int r, int c){
        if(r ==1 || c==1){
            return 1;
        }
        int left = mazePathCounts(r-1, c);
        int right = mazePathCounts(r, c-1);
        return left + right;
    }

    static int mazePathPrint(String p, int r, int c){
//        if r ==1 or c==1 then there is only one way to go to the target
        // when we achieve the one way conditio then only decrease row or col until they become equals to 1
        if(r==1 && c==1){
            System.out.println(p);

            return 1;
        }
        int ans = 0;
        char right = 'R';
        char down = 'D';
        if(r == 1){
            ans += mazePathPrint(p+right, r, c-1);
        }
        if(c==1){
            ans+= mazePathPrint(p + down, r-1, c);
        }
        if(r > 1 && c>1){
            ans+= mazePathPrint(p + down, r-1, c);
            ans += mazePathPrint(p+right, r, c-1);

        }

        return ans;
    }
    static ArrayList<String> mazePathDigonal(String p, int r, int c){
//        if r ==1 or c==1 then there is only one way to go to the target
        // when we achieve the one way conditio then only decrease row or col until they become equals to 1
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1){
            ans.addAll(mazePathDigonal(p+'D', r-1, c));
        }
        if(c>1){
            ans.addAll(mazePathDigonal(p+'R',r, c-1));
        }
        if(r>1 && c>1){
            ans.addAll(mazePathDigonal(p+'V', r-1, c-1));
        }
        return ans;
    }

    static void pathRestriction (String p,boolean[][] maze, int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        // the obstacle set to false, other paths are set to true
        if(!maze[r][c]){
            return;
        }
        if(r< maze.length-1){
            pathRestriction(p+'D', maze, r+1, c);
        }
        if(c< maze[0].length-1){
            pathRestriction(p+'R', maze, r, c+1);
        }
    }
}
