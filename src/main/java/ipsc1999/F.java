package ipsc1999;

import java.util.Random;
import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int currentScore = scoreFor(board), bestSeenScore = currentScore;
        int iterationsOfBestScore = 0;
        final Random r = new Random();
        while (true) {
            if (iterationsOfBestScore > 1_000_000 && currentScore == bestSeenScore) {
                System.out.println(bestSeenScore);
                makeColumnsOptimal(board);
                for (int i = 0; i < n; i++) {
                    System.out.print(board[i][0]);
                    for (int j = 1; j < n; j++) {
                        System.out.print(" " + board[i][j]);
                    }
                    System.out.println();
                }
                break;
            }

            int randomRow = r.nextInt(n);
            int newScore = scoreWithFlippedRow(board, randomRow);
            boolean highProbability = r.nextInt(10) < 8;
            if (newScore < bestSeenScore && highProbability) {
                currentScore = bestSeenScore = newScore;
                iterationsOfBestScore = 0;
                System.err.println("Found better score: " + bestSeenScore);
            } else if (newScore >= bestSeenScore && !highProbability) {
                currentScore = newScore;
                iterationsOfBestScore++;
            } else {
                flipRow(board[randomRow]);
                iterationsOfBestScore++;
            }
        }
    }

    private static void makeColumnsOptimal(int[][] board) {
        for (int column = 0; column < board.length; column++) {
            int ones = 0;
            for (int[] row : board) {
                ones += row[column];
            }
            if (ones > board.length - ones) {
                for (int[] row : board) {
                    row[column] = 1 - row[column];
                }
            }
        }
    }

    private static int scoreWithFlippedRow(int[][] board, int randomRow) {
        flipRow(board[randomRow]);
        return scoreFor(board);
    }

    private static void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 1 - row[i];
        }
    }

    private static int scoreFor(int[][] board) {
        int totalOnes = 0;
        for (int column = 0; column < board.length; column++) {
            int ones = 0;
            for (int[] row : board) {
                ones += row[column];
            }
            totalOnes += Math.min(ones, board.length - ones);
        }
        return totalOnes;
    }

}
