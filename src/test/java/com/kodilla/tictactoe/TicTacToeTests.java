package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;

public class TicTacToeTests {

    @Test
    void WrongInputTest() {
        //Given & When
        String test = "xyz";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);
        //Then
        Assertions.assertThrows(Exception.class, () -> UserInput.userIntSelection(2));
    }

    @Test
    void HorizontalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.HUMAN);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.HUMAN);
        logic.putMoveOnBoard(1, 2, Logic.HUMAN);
        logic.putMoveOnBoard(1, 3, Logic.HUMAN);
        //Then
        Assertions.assertEquals(Logic.HUMAN, logic.checkWinCon());
    }

    @Test
    void VerticalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.HUMAN);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.HUMAN);
        logic.putMoveOnBoard(2, 1, Logic.HUMAN);
        logic.putMoveOnBoard(3, 1, Logic.HUMAN);
        //Then
        Assertions.assertEquals(Logic.HUMAN, logic.checkWinCon());
    }

    @Test
    void DiagonalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.HUMAN);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.HUMAN);
        logic.putMoveOnBoard(2, 2, Logic.HUMAN);
        logic.putMoveOnBoard(3, 3, Logic.HUMAN);
        //Then
        Assertions.assertEquals(Logic.HUMAN, logic.checkWinCon());
    }

    @Test
    void HorizontalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.CPU);
        logic.putMoveOnBoard(1, 2, Logic.CPU);
        logic.putMoveOnBoard(1, 3, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void VerticalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.CPU);
        logic.putMoveOnBoard(2, 1, Logic.CPU);
        logic.putMoveOnBoard(3, 1, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void DiagonalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(3);
        //When
        logic.putMoveOnBoard(1, 1, Logic.CPU);
        logic.putMoveOnBoard(2, 2, Logic.CPU);
        logic.putMoveOnBoard(3, 3, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void LimitReached3x3Test() {
        //Given
        String test = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);
        Logic logic = new Logic();
        logic.chooseGameType();
        logic.setPlayer(Logic.CPU);
        //When
        logic.putMoveOnBoard(1, 1, Logic.HUMAN);
        logic.putMoveOnBoard(2, 2, Logic.HUMAN);
        logic.putMoveOnBoard(1, 3, Logic.HUMAN);
        logic.putMoveOnBoard(2, 3, Logic.HUMAN);
        logic.putMoveOnBoard(3, 1, Logic.HUMAN);
        logic.putMoveOnBoard(2, 1, Logic.CPU);
        logic.putMoveOnBoard(1, 2, Logic.CPU);
        logic.putMoveOnBoard(3, 2, Logic.CPU);
        logic.putMoveOnBoard(3, 3, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.DRAW, logic.checkWinCon());
    }

    @Test
    void DiagonalOWins10x10Test1() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(5);
        //When
        logic.putMoveOnBoard(1, 1, Logic.CPU);
        logic.putMoveOnBoard(2, 2, Logic.CPU);
        logic.putMoveOnBoard(3, 3, Logic.CPU);
        logic.putMoveOnBoard(4, 4, Logic.CPU);
        logic.putMoveOnBoard(5, 5, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void DiagonalOWins10x10Test2() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(5);
        //When
        logic.putMoveOnBoard(1, 2, Logic.CPU);
        logic.putMoveOnBoard(2, 3, Logic.CPU);
        logic.putMoveOnBoard(3, 4, Logic.CPU);
        logic.putMoveOnBoard(4, 5, Logic.CPU);
        logic.putMoveOnBoard(5, 6, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void DiagonalOWins10x10Test3() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(5);
        //When
        logic.putMoveOnBoard(8, 1, Logic.CPU);
        logic.putMoveOnBoard(7, 2, Logic.CPU);
        logic.putMoveOnBoard(6, 3, Logic.CPU);
        logic.putMoveOnBoard(5, 4, Logic.CPU);
        logic.putMoveOnBoard(4, 5, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

    @Test
    void DiagonalOWins10x10Test4() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        logic.setPlayer(Logic.CPU);
        logic.setNeededToWin(5);
        //When
        logic.putMoveOnBoard(9, 2, Logic.CPU);
        logic.putMoveOnBoard(8, 3, Logic.CPU);
        logic.putMoveOnBoard(7, 4, Logic.CPU);
        logic.putMoveOnBoard(6, 5, Logic.CPU);
        logic.putMoveOnBoard(5, 6, Logic.CPU);
        //Then
        Assertions.assertEquals(Logic.CPU, logic.checkWinCon());
    }

}
