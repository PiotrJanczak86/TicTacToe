package com.kodilla.tictactoe;

import java.util.Random;

public class Logic {

    private int boardSize;
    private int player;
    private int[][] board;
    private int gameType;
    private int neededToWin;
    static boolean end = false;
    static final int BOARD3x3 = 1;
    static final int BOARD10x10 = 2;
    static final int HUMAN = 1;
    static final int CPU = 2;
    static final int DRAW = 0;
    Random random = new Random();

    public void setNeededToWin(int neededToWin) {
        this.neededToWin = neededToWin;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int[][] getBoard() {
        return board;
    }

    public void newBoard3x3() {
        this.board = new int[3][3];
    }

    public void newBoard10x10() {
        this.board = new int[10][10];
    }

    public void chooseGameType() {
        gameType = UserInput.userIntSelectionExceptionCheck(2);
        if (gameType == BOARD3x3) {
            neededToWin = 3;
            newBoard3x3();
            boardSize = 3;
        } else if (gameType == BOARD10x10) {
            neededToWin = 5;
            newBoard10x10();
            boardSize = 10;
        }
    }

    public void playerMove() {
        if (player == HUMAN) {
            humanMove();
        } else {
            cpuMove(boardSize);
        }
    }

    private void cpuMove(int boardSize) {
        while (true) {
            int y = random.nextInt(boardSize) + 1;
            int x = random.nextInt(boardSize) + 1;
            if (board[y - 1][x - 1] == 0) {
                putMoveOnBoard(y, x, CPU);
                return;
            }
        }
    }

    private void humanMove() {
        while (true) {
            int y = UserInput.rowSelection(boardSize);
            int x = UserInput.columnSelection(boardSize);
            if (board[y - 1][x - 1] != 0) {
                Presentation.placeIsTaken();
            } else {
                putMoveOnBoard(y, x, HUMAN);
                return;
            }
        }
    }

    public void putMoveOnBoard(int y, int x, int player) {
        this.board[y - 1][x - 1] = player;
    }


    public void nextPlayer() {
        if (player == HUMAN) {
            player = CPU;
        }
        else if (player == CPU){
            player = HUMAN;
        }
        Presentation.whoseTurnDisplay(player);
    }

    public int checkWinCon() {
        if (horizontalCheck()) return player;
        if (verticalCheck()) return player;
        if (descendingDiagonalByRowCheck()) return player;
        if (descendingDiagonalByColCheck()) return player;
        if (ascendingDiagonalByRowCheck()) return player;
        if (ascendingDiagonalByColCheck()) return player;
        if (limitCheck()) return DRAW;
        else return 3;
    }

    public boolean limitCheck() {
        int boardLimit;
        if (gameType == BOARD3x3) {
            boardLimit = 9;
        } else {
            boardLimit = 100;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) count++;
                if (count == boardLimit) return true;
            }
        }
        return false;
    }

    public boolean horizontalCheck() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }

    public boolean verticalCheck() {
        int count = 0;
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }


    public boolean descendingDiagonalByRowCheck() {
        for (int row = 0; row < board.length - neededToWin + 1; row++) {
            int j = 0;
            int count = 0;
            for (int i = row; i < board.length - row; i++, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }

    public boolean descendingDiagonalByColCheck() {
        for (int col = 1; col < board.length - neededToWin + 1; col++) {
            int i = 0;
            int count = 0;
            for (int j = col; j < board.length - col; i++, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }

    public boolean ascendingDiagonalByRowCheck() {
        for (int row = board.length - 1; row > neededToWin - 2; row--) {
            int j = 0;
            int count = 0;
            for (int i = row; i >= 0; i--, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }

    public boolean ascendingDiagonalByColCheck() {
        for (int col = 1; col < board.length - neededToWin + 1; col++) {
            int i = board.length - 1;
            int count = 0;
            for (int j = col; j < board.length - col; i--, j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == neededToWin) return true;
                } else count = 0;
            }
        }
        return false;
    }
}