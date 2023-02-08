package com.kodilla.tictactoe;

public class Main {

    public static void main(String[] args) {

        Presentation presentation = new Presentation();
        Logic logic = new Logic();

        logic.setPlayer(Logic.CPU);
        presentation.gameStart();
        logic.chooseGameType();
        presentation.showBoard(logic.getBoard());

        while (!Logic.end) {

            logic.nextPlayer();
            logic.playerMove();
            presentation.showBoard(logic.getBoard());
            int check = logic.checkWinCon();
            presentation.winnerDisplay(check);

        }
    }
}
