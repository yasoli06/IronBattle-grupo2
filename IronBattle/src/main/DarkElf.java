package IronBattle.src.main;

import java.util.Random;

public class DarkElf extends Character {

    private int initialHp;
    private int initialMana;
    private int initialCursedEnergy;
    private int initialCursedTurns;

    private int mana;
    private int cursedEnergy;
    private int cursedTurns;
    private int attack;

    public DarkElf(String name) {
        super(name, new Random().nextInt(101) + 150); // HP between 150-250
        this.mana = new Random().nextInt(41) + 10; // Mana between 10-50
        this.cursedEnergy = new Random().nextInt(50) + 1; // Cursed energy between 1-50
        this.attack = 2; // Base attack for a weak attack

        this.initialHp = this.getHp();
        this.initialMana = this.mana;
        this.initialCursedEnergy = this.cursedEnergy;
        this.initialCursedTurns = this.cursedTurns;
    }

    public void reset() {
        this.setHp(initialHp);
        this.mana = initialMana;
        this.cursedEnergy = initialCursedEnergy;
        this.cursedTurns = initialCursedTurns;
        this.setIsAlive(true);
        System.out.println("The character " + this.getName() + " has been reset.");
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getCursedEnergy() {
        return cursedEnergy;
    }

    public void setCursedEnergy(int cursedEnergy) {
        this.cursedEnergy = cursedEnergy;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void attack(Character enemy) {
        Random rand = new Random();
        boolean powerfulAttack = rand.nextBoolean();
        int damage;

        if (enemy.getIsAlive()) {
            if (this.mana >= 5 && powerfulAttack) {
                damage = this.cursedEnergy;
                enemy.setHp(enemy.getHp() - damage);
                this.mana -= 5;
                System.out.println(this.getName() + " has cast a curse and inflicted " + damage + " damage.");
                System.out.println("The enemy is cursed and will lose 1 additional HP next turn.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println(this.getName() + " has spent 5 mana points.");
                System.out.println("Remaining mana: " + this.mana);

                cursedTurns = 2;
            } else {
                damage = this.getAttack();
                enemy.setHp(enemy.getHp() - damage);
                this.mana += 1;
                System.out.println(this.getName() + " has cast a magical attack and inflicted " + damage + " damage.");
                System.out.println("Opponent's remaining health points: " + enemy.getHp());
                System.out.println("With the weak magical attack, " + this.getName() + " has recovered 1 mana point.");
                System.out.println("Current mana: " + this.mana);
            }

            if (cursedTurns > 0) {
                enemy.setHp(enemy.getHp() - 1);
                System.out.println("The opponent " + enemy.getName() + " has lost 1 HP due to the curse.");
                cursedTurns--;
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("The character " + enemy.getName() + " has been defeated.");
        }
    }

    @Override
    public void attack(Character enemy, boolean isDaytime) {

    }
}