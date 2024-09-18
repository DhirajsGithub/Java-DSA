package com.Dhiraj.NQueens_nights_sudoko_solver;

public class Practise2 {
    public static void main(String[] args) {
        int n = 4;
        boolean board [][] = new boolean[n][n];
        kNights(board, 0, 0, 4);
    }

    public static void kNights(boolean [][] board, int row, int col, int knights){
        if(knights == 0){
            dispaly(board);         // all knights are placed!
            System.out.println();
        }

        if(row == board.length-1 && col == board.length){
            return;
        }

        // used instead of for loop
        if(col == board.length){
            kNights(board, row+1, 0, knights);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            kNights(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        kNights(board, row, col+1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row-2, col-1)){
            // knight will element another knight at
            if(board[row-2][col-1]){
                return false;
            }
        }
        if (isValid(board, row-2, col+1)){
            // knight will element another knight at
            if(board[row-2][col+1]){
                return false;
            }
        }
        if (isValid(board, row-1, col+2)){
            // knight will element another knight at
            if(board[row][col]){
                return false;
            }
        }
        if (isValid(board, row-1, col-2)){
            // knight will element another knight at
            if(board[row][col]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean [][] board, int row, int col){
        if(board.length > row && row >=0 && col >=0 && col < board.length){
            return true;
        }
        return false;
    }

    private static void dispaly(boolean[][] board) {
        for (boolean [] row : board){
            for (boolean ele : row){
                if(ele){
                    System.out.print("K ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}
