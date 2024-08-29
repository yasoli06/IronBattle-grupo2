package main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the game I'll Beat You First");
        System.out.println("It's time to choose your character. You can choose between Warrior or Mage.");
        System.out.println("The Warrior performs heavy attacks as special attacks.");
        System.out.println("The Mage casts Fireball.");


        System.out.println("Which will be your champion? A Warrior or a Mage. Respond with 'w' for Warrior or 'm' for Mage.");


        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().trim();


        if ("w".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Warrior.");
            //crear un guerrero

            System.out.println("Ponle nombre a tu guerrero");
            String nameWarrior1 = scanner.nextLine();

            Warrior warrior1 = new Warrior(nameWarrior1);

            System.out.println("Warrior created with Name: " + warrior1.getName() +
                    ", HP: " + warrior1.getHp() +
                    ", Strength: " + warrior1.getStrength() +
                    ", Stamina: " + warrior1.getStamina());

        } else if ("m".equalsIgnoreCase(userInput)) {
            System.out.println("You have chosen the Mage.");

            System.out.println("Ponle nombre a tu Mage");
            String nameWizard1 = scanner.nextLine();
            Wizard wizard1 = new Wizard(nameWizard1);

            System.out.println("Warrior created with Name: " + wizard1.getName() +
                    ", HP: " + wizard1.getHp() +
                    ", Strength: " + wizard1.getMana() +
                    ", Stamina: " + wizard1.getIntelligence());
        } else {
            System.out.println("Invalid choice. Please respond with 'w' for Warrior or 'm' for Mage.");
        }


        scanner.close();
    }
}
