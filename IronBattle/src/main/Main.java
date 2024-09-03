package IronBattle.src.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the game 'I'll Beat You First'");
        System.out.println("It's time to choose your character. You can choose between Warrior or Mage.");
        System.out.println("The Warrior performs heavy attacks as special attacks.");
        System.out.println("The Mage casts Fireball.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your first champion");
        Character player1 = createCharacter(scanner);
        System.out.println("Choose your second champion");
        Character player2 = createCharacter(scanner);

        System.out.println("Player 1: " + player1.getName() + " is ready for battle!");
        System.out.println("Player 2: " + player2.getName() + " is ready for battle!");


        Combat combat = new Combat(player1, player2);
        combat.startBattle();

        scanner.close();
    }

    public static Character createCharacter(Scanner scanner) {
        System.out.println("Which will be your champion? A Warrior or a Mage. Respond with 'w' for Warrior or 'm' for Mage.");
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
        } else {
            System.out.println("Invalid choice. Please respond with 'w' for Warrior or 'm' for Mage.");
            return createCharacter(scanner);
        }
    }
}

