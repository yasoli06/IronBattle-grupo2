# IronBattle Project

"IronBattle" is an exciting role-playing game developed in Java that immerses players in a world of epic battles between unique characters such as Elves, warriors, wizards, and others.

## Project Description

"IronBattle" is a turn-based role-playing game where two characters face off in combat. The player can choose between four distinct character types, each with special abilities and unique characteristics:

- Warrior: A brave warrior with great physical strength
- Wizard: A powerful sorcerer with devastating magical abilities
- Werewolf: A mythological being with lunar transformations
- Dark Elf: A dark elf with stealth abilities and deadly poisons

Each character has random statistics at the start of the game, ensuring a unique experience in each match. The objective is to defeat your opponent before they defeat you, using strategy and taking advantage of your character's special abilities.

## Main Features

### Turn-Based Combat System

- Characters take turns attacking or defending
- Each action consumes energy, limiting actions per turn
- The game ends when a character reaches zero health points

### Special Abilities

Each character has a unique ability that can be used at strategic moments during combat:

- Warrior: Critical Hit (doubles normal attack damage)
- Wizard: Magic Shield (reduces damage received during a turn)
- Werewolf: Lunar Transformation (increases strength and speed for several turns)
- Dark Elf: Silent Poison (applies a poison effect that gradually reduces the opponent's health)

### Bonuses Based on Time of Day

The game includes a day/night cycle system that affects character statistics:

- Warriors are stronger during the day
- Wizards have greater magical power at night
- Werewolves become more powerful during full moon
- Dark Elves are stealthier and deadlier in nighttime darkness

### Escape System

Players can attempt to escape from combat, but this carries risks:

- There's a random chance of success
- If it fails, the opponent gets an extra turn as punishment

## Technologies Used

This project leverages the following Java technologies and concepts:

- Object-oriented programming (OOP)
- Interfaces and abstract classes for modular structure
- Standard input/output handling for user interaction
- Random number generation to create unique statistics and unpredictable outcomes
- Use of enums to represent constants such as character types and actions

## Project Structure

The project is organized into the following main classes:

### Character.java

Abstract base class that defines common properties of all characters:

- Name
- Character type
- Level
- Health points
- Energy
- Strength
- Defense
- Speed

Abstract methods for basic and special attacks.

### Warrior.java, Wizard.java, Werewolf.java, DarkElf.java

Specific subclasses that extend Character and override methods to implement unique abilities:

- Implement character-specific basic and special attacks
- Override methods to calculate bonuses based on time of day

### Combat.java

Class responsible for managing combat flow:

- Manages alternating turns between the two characters
- Applies game rules such as energy limits and effects of special abilities
- Determines the winner when a character reaches zero health points

### Attacker.java

Interface that defines the contract for any object capable of performing attacks:

- Methods to calculate damage and apply secondary effects

### Main.java

Entry point of the program:

- Creates character instances
- Initializes combat
- Manages user interaction via the console

## How to Run the Project

To run the project, follow these steps:

1. Clone this repository to your local machine:


bash git clone https://github.com/your-user/IllBeatYouFirst.git



2. Open the project in your IntelliJ IDE

3. Compile all .java files:

bash javac *.java


4. Run the Main.java class:

bash java Main


5. Follow on-screen instructions to select characters and play

## Unit Tests

The project includes a CombatTest.java class with JUnit tests to verify basic combat functionality:

- Testing of basic and special attacks
- Successful and failed escape attempts

To run unit tests:

bash javac -cp "junit.jar" CombatTest.java java -cp ".;junit.jar" org.junit.runner.JUnitCore CombatTest



