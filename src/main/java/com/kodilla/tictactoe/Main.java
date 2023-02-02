package com.kodilla.tictactoe;

public class Main {

    public static void main(String[] args) {

        Presentation presentation = new Presentation();
        Logic logic = new Logic();

        presentation.gameStart();
        logic.chooseGameType();
        presentation.showBoard(logic.board);

        while (!Logic.end) {

            logic.playerMove(logic.player, Logic.boardSize);
            presentation.showBoard(logic.board);
            int check = logic.checkWinCon(logic.player, logic.gameType);
            presentation.winnerDisplay(check);
            logic.nextPlayer();
        }
    }
}
