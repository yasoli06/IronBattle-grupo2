package IronBattle.src.main;

import java.util.Scanner;

public class Combat {
    private Character player1;
    private Character player2;

    public Combat(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe battle begins");

        while (player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("\nTurn of " + player1.getName());
            player1.attack(player2);

            if (!player2.getIsAlive()) {
                System.out.println("\n" + player2.getName() + " has been defeated. " + player1.getName() + " is the winner!");
                break;
            }

            System.out.println("\nTurn of " + player2.getName());
            player2.attack(player1);

            if (!player1.getIsAlive()) {
                System.out.println("\n" + player1.getName() + " has been defeated. " + player2.getName() + " is the winner!");
                break;
            }

            System.out.println("Do you want to continue the battle or would you rather escape? Type 'y' to continue or 'n' to escape.");
            String continueBattle = scanner.nextLine().trim().toLowerCase();

            if (continueBattle.equals("n")) {
                System.out.println("\n" + player1.getName() + " has decided to abandon the battle. " + player2.getName() + " is the winner!");
                return;
            }
        }

        scanner.close();
    }
}
