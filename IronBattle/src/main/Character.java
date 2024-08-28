package main;

public abstract class Character implements Attacker {
    private String Id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    // Constructor
    public Character(String name, int hp) {
        if(hp <= 0){
            hp = 1;
        }
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        // Actualiza el estado de isAlive basado en el valor de hp
        if(this.hp > 0) {
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}