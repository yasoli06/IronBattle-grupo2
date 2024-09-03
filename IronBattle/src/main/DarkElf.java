package IronBattle.src.main;

import java.util.Random;

public class DarkElf extends Character {
    // Variables para guardar valores iniciales
    private int initialHp;
    private int initialMana;
    private int initialEnergiaMaldita;
    private int initialTurnosMaldito;

    private int mana;
    private int energiaMaldita;
    private int turnosMaldito;
    private int attack; // Añadido para manejar el ataque base

    // Constructor
    public DarkElf(String name) {
        super(name, new Random().nextInt(101) + 150); // HP entre 150-250
        this.mana = new Random().nextInt(41) + 10; // Mana entre 10-50
        this.energiaMaldita = new Random().nextInt(50) + 1; // Energía maldita entre 1-50
        this.attack = 2; // Ataque base para un ataque débil

        // Guardar valores iniciales
        this.initialHp = this.getHp();
        this.initialMana = this.mana;
        this.initialEnergiaMaldita = this.energiaMaldita;
        this.initialTurnosMaldito = this.turnosMaldito;
    }

    public void reset() {
        this.setHp(initialHp);
        this.mana = initialMana;
        this.energiaMaldita = initialEnergiaMaldita;
        this.turnosMaldito = initialTurnosMaldito;
        this.setIsAlive(true);
        System.out.println("The character " + this.getName() + " has been reset.");
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getEnergiaMaldita() {
        return energiaMaldita;
    }

    public void setEnergiaMaldita(int energiaMaldita) {
        this.energiaMaldita = energiaMaldita;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void attack(Character enemy) {
        Random rand = new Random();
        boolean powerfulAttack = rand.nextBoolean(); // Decide si el ataque es poderoso o débil
        int damage;


        if (enemy.getIsAlive()) { // Solo ataca si el enemigo está vivo
            if (this.mana >= 5 && powerfulAttack) {
                damage = this.energiaMaldita; // Daño base del ataque poderoso
                enemy.setHp(enemy.getHp() - damage); // Aplica daño
                this.mana -= 5; // Consume mana
                System.out.println(this.getName() + " ha lanzado una maldición y ha infligido " + damage + " puntos de daño.");
                System.out.println("El enemigo está maldito y en el siguiente turno perderá 1 HP adicional.");
                System.out.println("Puntos de salud restantes del oponente: " + enemy.getHp());
                System.out.println(this.getName() + " ha gastado 5 puntos de mana.");
                System.out.println("Mana restante: " + this.mana);

                //enemy.setHp(enemy.getHp() - 1); // Aplica daño adicional por la maldición
                //System.out.println("The opponent " + enemy.getName() + " ha perdido 1 HP por la maldición.");
                turnosMaldito = 2;
            } else { // Ataque débil si no hay suficiente mana
                damage = this.getAttack(); // Usa el valor de ataque actualizado
                enemy.setHp(enemy.getHp() - damage); // Aplica daño
                this.mana += 1; // Recupera mana
                System.out.println(this.getName() + " ha lanzado un ataque mágico y ha infligido " + damage + " puntos de daño.");
                System.out.println("Puntos de salud restantes del oponente: " + enemy.getHp());
                System.out.println("Con el ataque mágico débil, " + this.getName() + " ha recuperado 1 punto de mana.");
                System.out.println("Mana actual: " + this.mana);
            }

            if (turnosMaldito > 0) {
                enemy.setHp(enemy.getHp() - 1);
                System.out.println("The opponent " + enemy.getName() + " ha perdido 1 HP por la maldición.");
                turnosMaldito--;
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("El personaje " + enemy.getName() + " ha sido derrotado.");
        }
    }
    @Override
    public void attack(Character enemy, boolean isDaytime) {

    }

}