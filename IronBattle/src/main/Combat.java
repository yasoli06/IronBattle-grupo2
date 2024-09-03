package main;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    private Character player1;
    private Character player2;
    private boolean isDaytime;

    public Combat(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isDaytime = new Random().nextBoolean();


        if (isDaytime) {
            System.out.println("The two champions meet in an open field at midday, the sun shining brightly.");
        } else {
            System.out.println("Walking through the forest under the moonlight, the two characters find each other.");
        }
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe battle begins");

        while (player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("\nTurn of " + player1.getName());
            applyDayNightBuff(player1);
            player1.attack(player2);

            if (!player2.getIsAlive()) {
                System.out.println("\n" + player2.getName() + " has been defeated. " + player1.getName() + " is the winner!");
                break;
            }

            System.out.println("\nTurn of " + player2.getName());
            applyDayNightBuff(player2);
            player2.attack(player1);

            if (!player1.getIsAlive()) {
                System.out.println("\n" + player1.getName() + " has been defeated. " + player2.getName() + " is the winner!");
                break;
            }

            System.out.println(player1.getName() +" Do you want to continue the battle or would you rather escape? Type 'y' to continue or 'n' to escape.");
            String continueBattle = scanner.nextLine().trim().toLowerCase();

            if (continueBattle.equals("n")) {
                System.out.println("\n" + player1.getName() + " has decided to abandon the battle. " + player2.getName() + " is the winner!");
                return;
            }
        }

        scanner.close();
    }

    private void applyDayNightBuff(Character character) {
        int attackBonus = 2;

        if (isDaytime) {
            if (character instanceof Warrior || character instanceof Wizard) {
                System.out.println(character.getName() + " has a special glint in their eyes. Is it the sunlight? Their attack power increases by +2!");
                character.setAttack(character.getAttack() + attackBonus);
            }
        } else {
            if (character instanceof Werewolf || character instanceof DarkElf) {
                System.out.println(character.getName() + " has a special glint in their eyes. Is it the moonlight? Their attack power increases by +2!");
                character.setAttack(character.getAttack() + attackBonus);
            }
        }
    }
}
