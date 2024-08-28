package main;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;

    // constructor
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
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
        int damage;
        if (enemy.getIsAlive()) { // Solo atacar si el enemigo está vivo
            if (this.stamina >= 5 && heavyAttack) { // Ataque pesado si hay suficiente stamina y se decide atacar pesado
                damage = this.strength;
                enemy.setHp(enemy.getHp() - damage); // Aplica daño completo al enemigo
                this.stamina -= 5;  // Consume 5 puntos de stamina
            } else { // Ataque débil o si no hay suficiente stamina para un ataque pesado
                damage = this.strength / 2;
                enemy.setHp(enemy.getHp() - damage); // Aplica la mitad del daño al enemigo
                this.stamina += 1;  // Recupera 1 punto de stamina
            }
        }
    }
// MIRAR EL METODO PARA IMPLEMENTAR EL GET IS ALIVE
}