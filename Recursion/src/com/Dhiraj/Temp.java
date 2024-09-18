package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; // Add this import statement
import java.util.*;

public class Temp {
    public static int p = 0;

    public static void main(String[] args) {
        // int n = 4;
        // boolean[][] board = new boolean[n][n];
        // // System.out.println(queens(board, 0));
        // System.out.println(kNights(board, 0, 0, 4));
        // System.out.println("pp " + p);

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

    static int kNights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            p++;
            dispayK(board);
            System.out.println();
            return 1;
        }
        if (row == board.length - 1 && col == board.length) {
            return 0;
        }
        int count = 0;
        if (col == board.length) {
            count += kNights(board, row + 1, 0, knights);
            return count;
        }
        if (isSafeK(board, row, col)) {
            board[row][col] = true;
            count += kNights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        count += kNights(board, row, col + 1, knights);
        return count;

    }

    private static boolean isSafeK(boolean[][] board, int row, int col) {
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

    private static void dispayK(boolean[][] board) {
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

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            dispay(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = true;
                count += queens(board, row + 1);
                board[row][i] = false;
            }
        }
        return count;

    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        for (int i = 0; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        for (int i = 0; i <= Math.min(row, board.length - 1 - col); i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static void dispay(boolean[][] board) {
        for (boolean row[] : board) {
            for (boolean element : row) {
                // queens are place are set to true on the board
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static void pathRestriction(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            pathRestriction(p + "H", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathRestriction(p + "D", maze, r, c + 1);
        }

    }

    static int mazePathCounts(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = mazePathCounts(r - 1, c);
        int right = mazePathCounts(r, c - 1);
        return left + right;
    }

    public static void mazePaths(int r, int c, String p) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            mazePaths(r - 1, c, p + "V");
        }
        if (c > 1) {
            mazePaths(r, c - 1, p + "H");
        }

    }

    public static void mazePathsDiagonally(int r, int c, String p) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1 && c > 1) {
            mazePathsDiagonally(r - 1, c - 1, p + "D");
        }
        if (r > 1) {
            mazePaths(r - 1, c, p + "V");
        }
        if (c > 1) {
            mazePaths(r, c - 1, p + "H");
        }
    }

}