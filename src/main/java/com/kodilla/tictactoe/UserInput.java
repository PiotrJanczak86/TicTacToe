package com.kodilla.tictactoe;

import java.util.Scanner;

public class UserInput {

    static int rowSelection(int boardLimit) {
        System.out.println("Which row do you choose?");
        return userIntSelectionExceptionCheck(boardLimit);
    }

    static int columnSelection(int boardLimit) {
        System.out.println("Which column?");
        return userIntSelectionExceptionCheck(boardLimit);
    }

    static int userIntSelectionExceptionCheck(int max) {
        while (true) {
            try {
                return userIntSelection(max);
            } catch (Exception e) {
                System.out.println("Wrong input. Try again");
            }
        }
    }

    static int userIntSelection(int max) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int r = Integer.parseInt(input);
        if (r > 0 && r <= max) {
            return r;
        } else {
            throw new Exception();
        }
    }

}