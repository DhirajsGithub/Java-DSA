package com.Dhiraj.NQueens_nights_sudoko_solver;

public class NQueens {
    public static void main(String[] args) {
        // place n queens on nxn matrix such that no two queens element each other
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }
    static int queens(boolean[][] board, int row){
        if(row == board.length){
            // it means all queens are place on the board
            dispay(board);
            System.out.println();
            return 1;
        }
        
        // counting the number of ways we can place n queens on nxn board
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            // while entering the cell it will first safe fuction will first check if there is any possible queens place by precending iteration such that the queen must not be collid
            // safe fucntion will go upto possible cases to see if the queen is placed at any particular vertical/ left diag/ right diag
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row+1);

                // backtracking
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 0; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 0; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void dispay(boolean[][] board) {
        for(boolean row [] : board){
            for(boolean element : row){
                // queens are place are set to true on the board
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

/*
time complexity of O(N!) . Spatial Complexity: O(N)
 */
