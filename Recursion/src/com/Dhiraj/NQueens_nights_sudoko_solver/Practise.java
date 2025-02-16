package com.Dhiraj.NQueens_nights_sudoko_solver;

public class Practise {
    public static void main(String[] args) {

        int n = 4;
        boolean board [][] = new boolean[n][n];
        System.out.println(NQueens(board, 0));

    }
    public static int NQueens(boolean[][] board, int row){
        if(row == board.length){
            dispaly(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        for (int col = 0; col < board.length; col++) {      // placing the first queen in first row at different columns
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count = count + NQueens(board, row+1);
                // backtrack
                board[row][col]= false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void dispaly(boolean[][] board) {
        for (boolean [] row : board){
            for (boolean ele : row){
                if(ele){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
