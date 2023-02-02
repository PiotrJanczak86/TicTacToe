package com.kodilla.tictactoe;

import java.util.Scanner;

public class UserInput {

    static int rowSelection() {
        System.out.println("Player moves.");
        System.out.println("Which row do you choose?");
        return userIntSelection(Logic.boardSize);
    }

    static int columnSelection() {
        System.out.println("Which column?");
        return userIntSelection(Logic.boardSize);
    }

    static int userIntSelection(int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String sc = scanner.nextLine();
            try {
                int r = Integer.parseInt(sc);
                if (r > 0 && r <= max) {
                    return r;
                } else {
                    System.out.println("Wrong input. Try again");
                }
            } catch (Exception e) {
                System.out.println("Wrong input. Try again");
            }
        }
    }
}