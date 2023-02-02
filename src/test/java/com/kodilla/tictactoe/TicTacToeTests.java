package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TicTacToeTests {

    @Test
    void HorizontalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 1);
        logic.putMoveOnBoard(1, 2, 1);
        logic.putMoveOnBoard(1, 3, 1);
        //Then
        Assertions.assertEquals(1, logic.checkWinCon(1,1));
    }

    @Test
    void VerticalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 1);
        logic.putMoveOnBoard(2, 1, 1);
        logic.putMoveOnBoard(3, 1, 1);
        //Then
        Assertions.assertEquals(1, logic.checkWinCon(1,1));
    }

    @Test
    void DiagonalXWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 1);
        logic.putMoveOnBoard(2, 2, 1);
        logic.putMoveOnBoard(3, 3, 1);
        //Then
        Assertions.assertEquals(1, logic.checkWinCon(1,1));
    }
    @Test
    void HorizontalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 2);
        logic.putMoveOnBoard(1, 2, 2);
        logic.putMoveOnBoard(1, 3, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,1));
    }

    @Test
    void VerticalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 2);
        logic.putMoveOnBoard(2, 1, 2);
        logic.putMoveOnBoard(3, 1, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,1));
    }

    @Test
    void DiagonalOWins3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 2);
        logic.putMoveOnBoard(2, 2, 2);
        logic.putMoveOnBoard(3, 3, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,1));
    }

    @Test
    void LimitReached3x3Test() {
        //Given
        Logic logic = new Logic();
        logic.newBoard3x3();
        //When
        logic.putMoveOnBoard(1, 1, 1);
        logic.putMoveOnBoard(2, 2, 1);
        logic.putMoveOnBoard(1, 3, 1);
        logic.putMoveOnBoard(2, 3, 1);
        logic.putMoveOnBoard(3, 1, 1);
        logic.putMoveOnBoard(2, 1, 2);
        logic.putMoveOnBoard(1, 2, 2);
        logic.putMoveOnBoard(3, 2, 2);
        logic.putMoveOnBoard(3, 3, 2);
        //Then
        Assertions.assertEquals(0, logic.checkWinCon(2,1));
    }

    @Test
    void DiagonalOWins10x10Test1() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        //When
        logic.putMoveOnBoard(1, 1, 2);
        logic.putMoveOnBoard(2, 2, 2);
        logic.putMoveOnBoard(3, 3, 2);
        logic.putMoveOnBoard(4, 4, 2);
        logic.putMoveOnBoard(5, 5, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,2));
    }
    @Test
    void DiagonalOWins10x10Test2() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        //When
        logic.putMoveOnBoard(1, 2, 2);
        logic.putMoveOnBoard(2, 3, 2);
        logic.putMoveOnBoard(3, 4, 2);
        logic.putMoveOnBoard(4, 5, 2);
        logic.putMoveOnBoard(5, 6, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,2));
    }
    @Test
    void DiagonalOWins10x10Test3() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        //When
        logic.putMoveOnBoard(8, 1, 2);
        logic.putMoveOnBoard(7, 2, 2);
        logic.putMoveOnBoard(6, 3, 2);
        logic.putMoveOnBoard(5, 4, 2);
        logic.putMoveOnBoard(4, 5, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,2));
    }
    @Test
    void DiagonalOWins10x10Test4() {
        //Given
        Logic logic = new Logic();
        logic.newBoard10x10();
        //When
        logic.putMoveOnBoard(9, 2, 2);
        logic.putMoveOnBoard(8, 3, 2);
        logic.putMoveOnBoard(7, 4, 2);
        logic.putMoveOnBoard(6, 5, 2);
        logic.putMoveOnBoard(5, 6, 2);
        //Then
        Assertions.assertEquals(2, logic.checkWinCon(2,2));
    }

}
