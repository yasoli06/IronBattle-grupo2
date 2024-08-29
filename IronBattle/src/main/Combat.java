package main;

public class Combat {
    private Character player1;
    private Character player2;

    public Combat(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle() {
        while (player1.getIsAlive() && player2.getIsAlive()) {
            System.out.println("\nTurno de " + player1.getName());
            player1.attack(player2);

            if (!player2.getIsAlive()) break;

            System.out.println("\nTurno de " + player2.getName());
            player2.attack(player1);
        }

        System.out.println("\nEl combate ha terminado.");
        if (player1.getIsAlive()) {
            System.out.println(player1.getName() + " es el ganador!");
        } else {
            System.out.println(player2.getName() + " es el ganador!");
        }
    }
}
