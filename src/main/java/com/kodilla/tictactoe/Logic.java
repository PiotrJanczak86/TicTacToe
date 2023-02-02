package com.kodilla.tictactoe;

import java.util.Random;

public class Logic {

    static boolean end = false;
    public int player = 1;
    public int[][] board;
    Random random = new Random();
    public int gameType;
    static int boardSize;
    public void newBoard3x3() {
        this.board = new int[3][3];
    }
    public void newBoard10x10() {
        this.board = new int[10][10];
    }

    public void chooseGameType() {
        gameType = UserInput.userIntSelection(2);
        if (gameType == 1) {
            newBoard3x3();
            boardSize = 3;
        }
        if (gameType == 2) {
            newBoard10x10();
            boardSize = 10;
        }
    }

    public void playerMove(int player, int boardSize) {
        while (true) {
            if (player == 1) {          //Player move
                int y = UserInput.rowSelection();
                int x = UserInput.columnSelection();
                if (board[y - 1][x - 1] != 0) {
                    System.out.println("Wrong input. Try again");
                } else {
                    putMoveOnBoard(x, y, player);
                    return;
                }
            } else {        //CPU move
                while (true) {
                    int y = random.nextInt(boardSize) + 1;
                    int x = random.nextInt(boardSize) + 1;
                    if (board[y - 1][x - 1] == 0) {
                        System.out.println("CPU moves");
                        putMoveOnBoard(x, y, player);
                        return;
                    }
                }
            }
        }
    }

    public void putMoveOnBoard(int x, int y, int player) {
        this.board[y - 1][x - 1] = player;
    }


    public void nextPlayer() {
        if (player == 1) player = 2;
        else player = 1;
    }

    public int checkWinCon(int player, int gameType) {

        int neededToWin;
        int boardMod;
        int count = 0;
        int boardLimit;

        if (gameType == 1) {
            neededToWin = 3;
            boardLimit = 9;
            boardMod = 2;
        } else {
            neededToWin = 5;
            boardLimit = 100;
            boardMod = 4;
        }

        //horizontalCheck
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }

        //verticalCheck
        count = 0;
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }

        // limitCheck
        count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) count++;
                if (count == boardLimit) return 0;
            }
        }

        // descendingDiagonal1
        for (int row = 0; row < board.length - boardMod; row++) {
            int j = 0;
            count = 0;
            for (int i = row; i < board.length - row; i++, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }

        // descendingDiagonal2
        for (int col = 1; col < board.length - boardMod; col++) {
            int i = 0;
            count = 0;
            for (int j = col; j < board.length - col; i++, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }

        // ascendingDiagonal1
        for (int row = board.length - 1; row > boardMod-1; row--) {
            int j = 0;
            count = 0;
            for (int i = row; i >= 0; i--, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }

        //ascendingDiagonal2
        for (int col = 1; col < board.length - boardMod; col++) {
            int i = board.length - 1;
            count = 0;
            for (int j = col; j < board.length - col; i--, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return player;
                } else count = 0;
            }
        }
        return 3;
    }
}


