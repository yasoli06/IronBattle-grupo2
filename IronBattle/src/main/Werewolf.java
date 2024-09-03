package IronBattle.src.main;

import java.util.Random;

public class Werewolf extends Character{
    private int furia;
    private int uniasAfiladas;

    // Constructor
    public Werewolf(String name) {
        super(name, new Random().nextInt(101) + 100); // HP entre 100 y 200
        this.furia = new Random().nextInt(41) + 10; // Furia entre 10 y 50
        this.uniasAfiladas = new Random().nextInt(11) + 10; // Uñas Afiladas entre 10 y 20
    }

    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
    }

    public int getUniasAfiladas() {
        return uniasAfiladas;
    }

    public void setUniasAfiladas(int uniasAfiladas) {
        this.uniasAfiladas = uniasAfiladas;
    }

    public void attack(Character enemy) {
        Random rand = new Random();
        boolean zarpazoLetal = rand.nextBoolean(); // Decide aleatoriamente si se realiza el ataque zarpazo letal
        int damage = 0;

        if (enemy.getIsAlive()) { // Solo atacar si el enemigo está vivo
            if (this.furia >= 5 && zarpazoLetal) { // Zarpazo letal si hay suficiente furia y se decide realizarlo
                damage = (int)(this.uniasAfiladas * 0.75); // Daño es 3/4 del valor de uñas afiladas
                enemy.setHp(enemy.getHp() - damage); // Aplica daño al enemigo
                this.furia -= 5;  // Consume 5 puntos de furia

                // Aplica el sangrado
                System.out.println("Has realizado un zarpazo letal, causando " + damage + " de daño.");
                System.out.println("El oponente está sangrando y perderá 1 punto de vida en el siguiente turno.");
                System.out.println("Te quedan " + this.furia + " puntos de furia.");

                // Reduce 1 HP del enemigo en el siguiente turno
                enemy.setHp(enemy.getHp() - 1);
                System.out.println("El oponente " + enemy.getName() + " ha perdido 1 punto de vida debido al sangrado.");
            } else { // Ataque arañazo si no hay suficiente furia o no se decide realizar el zarpazo letal
                damage = this.uniasAfiladas / 4; // El daño del arañazo es 1/4 del valor de uñas afiladas
                enemy.setHp(enemy.getHp() - damage); // Aplica daño al enemigo
                this.furia += 1;  // Recupera 1 punto de furia
                System.out.println("Has realizado un arañazo, causando " + damage + " de daño.");
                System.out.println("Has recuperado 1 punto de furia. Ahora tienes " + this.furia + " puntos de furia.");
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("El personaje " + enemy.getName() + " ha sido derrotado.");
        }
    }


    @Override
    public void reset() {

    }
}
