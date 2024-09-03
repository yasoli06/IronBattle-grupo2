package main;

import java.util.Random;

public class Warrior extends Character {

    private int initialHp;
    private int initialStamina;
    private int initialStrength;

    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100);
        this.stamina = new Random().nextInt(41) + 10;
        this.strength = new Random().nextInt(10) + 1;

        this.initialHp = this.getHp();
        this.initialStamina = this.stamina;
        this.initialStrength = this.strength;
    }

    public void reset() {
        this.setHp(initialHp);
        this.stamina = initialStamina;
        this.strength = initialStrength;
        this.setIsAlive(true);
    }

    @Override
    public void attack(Character enemy, boolean isDaytime) {

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
        boolean heavyAttack = rand.nextBoolean();
        int damage = 0;
        if (enemy.getIsAlive()) {
            if (this.stamina >= 5 && heavyAttack) {
                damage = this.strength;
                enemy.setHp(enemy.getHp() - damage);
                this.stamina -= 5;
                System.out.println(this.getName()+" have performed a heavy attack and dealt " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println(this.getName()+" have spent 5 stamina points, you have " + this.stamina + " remaining.");
            } else {
                damage = this.strength / 2;
                enemy.setHp(enemy.getHp() - damage);
                this.stamina += 1;
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