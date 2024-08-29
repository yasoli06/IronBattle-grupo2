package main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the game I'll Beat You First");
        System.out.println("It's time to choose your character. You can choose between Warrior or Mage.");
        System.out.println("The Warrior performs heavy attacks as special attacks.");
        System.out.println("The Mage casts Fireball.");


        Scanner scanner = new Scanner(System.in);

        Character player1 = createCharacter(scanner);
        Character player2 = createCharacter(scanner);

        System.out.println("Player 1: " + player1.getName() + " is ready for battle!");
        System.out.println("Player 2: " + player2.getName() + " is ready for battle!");

        // Aquí es donde podrías comenzar la simulación de la batalla entre player1 y player2
        // Añadimos simulación de combate por turnos
        Combat combat = new Combat(player1, player2);
        combat.startBattle();

        scanner.close();
    }

    private static Character createCharacter(Scanner scanner) {
        System.out.println("Which will be your champion? A Warrior or a Mage. Respond with 'w' for Warrior or 'm' for Mage.");
        String userInput = scanner.nextLine().trim();

        if ("w".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Warrior.");
            System.out.println("Ponle nombre a tu guerrero:");
            String name = scanner.nextLine();
            return new Warrior(name);
        } else if ("m".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Mage.");
            System.out.println("Ponle nombre a tu mago:");
            String name = scanner.nextLine();
            return new Wizard(name);
        } else {
            System.out.println("Invalid choice. Please respond with 'w' for Warrior or 'm' for Mage.");
            return createCharacter(scanner); // Llamar recursivamente si la entrada es inválida
        }
    }
}
