package main;

import java.util.Random;

public class Werewolf extends Character {

    private int initialHp;
    private int initialFury;
    private int initialSharpClaws;
    private int initialBleendingTurns;

    private int fury;
    private int sharpClaws;
    private int bleedingTurns;


    public Werewolf(String name) {
        super(name, new Random().nextInt(101) + 100);
        this.fury = new Random().nextInt(41) + 10;
        this.sharpClaws = new Random().nextInt(11) + 10;
        this.bleedingTurns = 0;

        //valores iniciales
        this.initialHp = this.getHp();
        this.initialFury = this.fury;
        this.initialSharpClaws = this.sharpClaws;
        this.initialBleendingTurns = this.bleedingTurns;
    }

    public int getFury() {
        return fury;
    }

    public void setFury(int fury) {
        this.fury = fury;
    }

    public int getSharpClaws() {
        return sharpClaws;
    }

    public void setSharpClaws(int sharpClaws) {
        this.sharpClaws = sharpClaws;
    }

    public void attack(Character enemy) {
        Random rand = new Random();
        boolean lethalSwipe = rand.nextBoolean();
        int damage = 0;

        if (enemy.getIsAlive()) {
            if (this.fury >= 5 && lethalSwipe) {
                damage = (int)(this.sharpClaws * 0.75);
                enemy.setHp(enemy.getHp() - damage);
                this.fury -= 5;

                System.out.println("You have performed a lethal swipe, causing " + damage + " damage.");
                System.out.println("Puntos de salud restantes del oponente: " + enemy.getHp());
                System.out.println("The opponent is bleeding and will lose 1 HP on the next turn.");
                System.out.println(this.getName()+" ha gastado 5 puntos de furia.");
                System.out.println("Furia restante " + this.fury);

                bleedingTurns = 1;
            } else {
                damage = this.sharpClaws / 4;
                enemy.setHp(enemy.getHp() - damage);
                this.fury += 1;
                System.out.println("You have performed a scratch, causing " + damage + " damage.");
                System.out.println("You have recovered 1 fury point. Now you have " + this.fury + " fury points.");
            }
        }

        if (bleedingTurns > 0) {
            enemy.setHp(enemy.getHp() - 1);
            this.setHp(this.getHp() + 1);
            System.out.println("The opponent " + enemy.getName() + " has lost 1 HP due to bleeding.");
            System.out.println(this.getName() + " has healed 1 HP.");
            bleedingTurns--;
        }

        if (enemy.getHp() <= 0) {
            System.out.println("The character " + enemy.getName() + " has been defeated.");
        }
    }


    public void reset() {
        this.setHp(initialHp);
        this.fury = initialFury;
        this.sharpClaws = initialSharpClaws;
        this.bleedingTurns = initialBleendingTurns;
        this.setIsAlive(true);
        System.out.println("The character " + this.getName() + " has been reset.");
    }

    @Override
    public void attack(Character enemy, boolean isDaytime) {

    }
}