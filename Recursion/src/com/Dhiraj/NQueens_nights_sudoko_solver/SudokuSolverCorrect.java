package com.Dhiraj.NQueens_nights_sudoko_solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; // Add this import statement
import java.util.*;

class SudokuSolverCorrect {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board, 0);

        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    public static void solveSudoku(char[][] board, int row) {
        if (row == board.length) {
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == '.') {
                for (int num = 1; num <= 9; num++) {
                    char candidate = (char) (num + '0');
                    if (isSafeSudoku(board, row, col, candidate)) {
                        board[row][col] = candidate;
                        solveSudoku(board, row);
                        // If the board is completely solved, return immediately.
                        if (isBoardSolved(board)) {
                            return;
                        }
                        board[row][col] = '.';
                    }
                }
                return; // If no valid number is found, return to trigger backtracking.
            }
        }
        // Move to the next row if the current row is complete.
        solveSudoku(board, row + 1);
    }

    public static boolean isSafeSudoku(char[][] board, int row, int col, char num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-box
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBoardSolved(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

}