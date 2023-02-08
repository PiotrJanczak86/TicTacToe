package com.kodilla.tictactoe;

public class Presentation {

    public void gameStart() {

        System.out.println("""
                Welcome to the game of Tic-Tac-Toe!
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

    static void whoseTurnDisplay(int player) {
        if (player == Logic.HUMAN) {
            System.out.println("Player moves.");
        }
        if (player == Logic.CPU) {
            System.out.println("CPU moves.");
        }
    }

    public void winnerDisplay(int winner) {
        if (winner == Logic.HUMAN) {
            System.out.println("The winner is player 1 (HUMAN)\nThank you for playing!");
            Logic.end = true;
        }
        if (winner == Logic.CPU) {
            System.out.println("The winner is player 2 (CPU)\nThank you for playing!");
            Logic.end = true;
        }
        if (winner == Logic.DRAW) {
            System.out.println("The game ends in a draw\nThank you for playing!");
            Logic.end = true;
        }
    }

    static void placeIsTaken() {
        System.out.println("This place is already taken. Try again");
    }

}