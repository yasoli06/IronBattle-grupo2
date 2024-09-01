package IronBattle.src.main;
import java.util.Random;
import java.util.UUID;

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
        this.Id = generateId();
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

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }


    public String generateId() {
        return UUID.randomUUID().toString();
    }


    public int generateHp() {
        return new Random().nextInt(101) + 100;
    }

    public abstract void reset();



}