package main;

public class Combat {
    private Character player1;
    private Character player2;

    public Combat(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle() {
        int round = 1;
        boolean battleOver = false;

        while (!battleOver) {
            System.out.println("\n--- Round " + round + " ---");
            player1.attack(player2); // atacan los 2 a la vez
            player2.attack(player1);

            if (!player1.getIsAlive() && !player2.getIsAlive()) {
                System.out.println("The battle ends in a draw! Restarting the battle...\n");
                player1.reset();  // Reiniciar Player 1
                player2.reset();  // Reiniciar Player 2
                round = 0; // Reiniciar las rondas
            } else if (!player1.getIsAlive()) {
                System.out.println("Player 2 wins! " + player2.getName() + " is victorious!");
                battleOver = true;
            } else if (!player2.getIsAlive()) {
                System.out.println("Player 1 wins! " + player1.getName() + " is victorious!");
                battleOver = true;
            }
            round++;
        }
    }
    }
