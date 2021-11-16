package com.Battleship;

import java.util.Scanner;

    public class GameManager {

        private final Player player1;
        private final Player player2;
        private Player playing;
        private Player opponent;

        GameManager() {
            player1 = new Player1();
            player2 = new Player2();
        }

        void manage() {
            playing = player2;
            opponent = player1;
            setShips();
            while (playing.hasShip() && opponent.hasShip()) {
                playing = opponent;
                opponent = opponent == player1 ? player2 : player1;
                printFields();
                playing.takeTurn(opponent);
                turnOver();
            }

            System.out.printf("\n You sank the last ship. You won. Congratulations!\n\n",
                    playing.getName(), playing.getName());
        }

        void setShips() {
            player1.setShip();
            turnOver();
            player2.setShip();
            turnOver();
        }

        void turnOver() {
            if (!playing.hasShip() || !opponent.hasShip()) {
                return;
            }

            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("\nPress Enter and pass the move to another player\n");
            do {
                input = scanner.nextLine();
            } while (!input.isEmpty());
        }

        void printFields() {
            opponent.field.printFoggyField();
            System.out.println("---------------------");
            playing.field.printField();
        }
    }
}
