package IronBattle.src.main;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;

    // constructor
    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100);
        this.stamina = new Random().nextInt(41) + 10; // Stamina entre 10-50
        this.strength = new Random().nextInt(10) + 1;  // Strength entre 1-10
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Character enemy) {
        Random rand = new Random();
        boolean heavyAttack = rand.nextBoolean(); // Decidir aleatoriamente si el ataque es pesado o débil
        int damage = 0;
        if (enemy.getIsAlive()) { // Solo atacar si el enemigo está vivo
            if (this.stamina >= 5 && heavyAttack) { // Ataque pesado si hay suficiente stamina y se decide atacar pesado
                damage = this.strength;
                enemy.setHp(enemy.getHp() - damage); // Aplica daño completo al enemigo
                this.stamina -= 5;  // Consume 5 puntos de stamina
                System.out.println(this.getName()+" have performed a heavy attack and dealt " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println(this.getName()+" have spent 5 stamina points, you have " + this.stamina + " remaining.");

            } else { // Ataque débil o si no hay suficiente stamina para un ataque pesado
                damage = this.strength / 2;
                enemy.setHp(enemy.getHp() - damage); // Aplica la mitad del daño al enemigo
                this.stamina += 1;  // Recupera 1 punto de stamina
                System.out.println(this.getName()+" have performed a weak attack and dealt " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println("With the weak attack, "+this.getName()+" have recovered 1 stamina. Now you have " + this.stamina + " stamina.");
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("The character " + enemy.getName() + " has been defeated.");
        }
    }
}