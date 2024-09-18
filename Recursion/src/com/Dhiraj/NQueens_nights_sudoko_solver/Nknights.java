package com.Dhiraj.NQueens_nights_sudoko_solver;

public class Nknights {
    public static int p = 0;

    public static void main(String[] args) {
        int n = 4;
        boolean board[][] = new boolean[n][n];
        nKnights(board, 0, 0, 4);
        System.out.println("p " + p);

    }

    static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            p++;
            dispay(board);
            System.out.println();
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            nKnights(board, row + 1, 0, knights);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);

            // backtrack
            board[row][col] = false;
        }
        // not safe to put it hence move ahead
        nKnights(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            // knight will element another knight at
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            // knight will element another knight at
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            // knight will element another knight at
            if (board[row][col]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            // knight will element another knight at
            if (board[row][col]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (board.length > row && row >= 0 && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void dispay(boolean[][] board) {
        for (boolean row[] : board) {
            for (boolean element : row) {
                // queens are place are set to true on the board
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}
