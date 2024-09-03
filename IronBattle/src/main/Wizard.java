package main;

import java.util.Random;

public class Wizard extends Character{
    private int initialHp;
    private int initialMana;
    private int initialIntelligence;

    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50);
        this.mana = new Random().nextInt(41) + 10;
        this.intelligence = new Random().nextInt(50) + 1;

        // Guardar los valores iniciales
        this.initialHp = this.getHp();
        this.initialMana = this.mana;
        this.initialIntelligence = this.intelligence;
    }

    public void reset() {
        this.setHp(initialHp);
        this.mana = initialMana;
        this.intelligence = initialIntelligence;
        this.setIsAlive(true);
    }

    @Override
    public void attack(Character enemy, boolean isDaytime) {

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public void attack(Character enemy) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean();
        int damage = 0;
        if (enemy.getIsAlive()) {
            if (this.mana >= 5 && fireball) {
                damage = this.intelligence;
                enemy.setHp(enemy.getHp() - damage);
                this.mana -= 5;
                System.out.println(this.getName()+" have performed a fireball and dealt " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println(this.getName()+" have spent 5 mana points, you have " + this.mana + " remaining.");
            } else {
                damage = 2;
                enemy.setHp(enemy.getHp() - damage);
                this.mana += 1;
                System.out.println(this.getName()+" have performed a staff strike and dealt " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println("With the weak attack, "+this.getName()+" have recovered 1 mana. Now you have " + this.mana + " mana.");
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("The character " + enemy.getName() + " has been defeated.");
        }
    }
}
