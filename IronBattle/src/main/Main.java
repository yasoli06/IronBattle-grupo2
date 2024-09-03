package IronBattle.src.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the game 'I'll Beat You First'");
        System.out.println("It's time to choose your character. You can choose between Warrior, Mage, Werewolf, or DarkElf.");
        System.out.println("The Warrior performs heavy attacks as special attacks.");
        System.out.println("The Mage casts Fireball.");
        System.out.println("The Werewolf uses fury for deadly swipes.");
        System.out.println("The DarkElf uses cursed energy to inflict damage over time.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your first champion:");
        Character player1 = createCharacter(scanner);
        System.out.println("Choose your second champion:");
        Character player2 = createCharacter(scanner);

        System.out.println("Player 1: " + player1.getName() + " is ready for battle!");
        System.out.println("Player 2: " + player2.getName() + " is ready for battle!");

        Combat combat = new Combat(player1, player2);
        combat.startBattle();

        scanner.close();
    }

    public static Character createCharacter(Scanner scanner) {
        System.out.println("Which will be your champion? Choose 'w' for Warrior, 'm' for Mage, 'l' for Werewolf, or 'd' for DarkElf.");
        String userInput = scanner.nextLine().trim();

        if ("w".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Warrior.");
            System.out.println("Give your warrior a name:");
            String name = scanner.nextLine();
            return new Warrior(name);
        } else if ("m".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Mage.");
            System.out.println("Give your mage a name:");
            String name = scanner.nextLine();
            return new Wizard(name);
        } else if ("l".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Werewolf.");
            System.out.println("Give your werewolf a name:");
            String name = scanner.nextLine();
            return new Werewolf(name);
        } else if ("d".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the DarkElf.");
            System.out.println("Give your DarkElf a name:");
            String name = scanner.nextLine();
            return new DarkElf(name);
        } else {
            System.out.println("Invalid choice. Please respond with 'w' for Warrior, 'm' for Mage, 'l' for Werewolf, or 'd' for DarkElf.");
            return createCharacter(scanner);
        }
    }
}

