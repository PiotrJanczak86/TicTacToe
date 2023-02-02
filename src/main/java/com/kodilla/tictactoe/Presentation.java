package com.kodilla.tictactoe;

public class Presentation {
    public void gameStart() {

        System.out.println("""
                Welcome to the game of Tic-Tac-Toe!.
                Please choose game type:
                Normal 3x3 - press '1'
                10x10 Board, need 5 to win - press '2'""");
    }

    public void showBoard(int[][] board) {
        StringBuilder gameState = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                gameState.append("|");
                if (i == 0) gameState.append(" ");
                if (i == 1) gameState.append("X");
                if (i == 2) gameState.append("O");
            }
            gameState.append("|\n");
        }
        System.out.println(gameState);
    }

    public void winnerDisplay(int winner) {
        if (winner == 1) {
            System.out.println("The winner is player 1");
            Logic.end = true;
        }
        if (winner == 2) {
            System.out.println("The winner is player 2 (CPU)");
            Logic.end = true;
        }
        if (winner == 0) {
            System.out.println("The game ends in a draw");
            Logic.end = true;
        }
    }
}