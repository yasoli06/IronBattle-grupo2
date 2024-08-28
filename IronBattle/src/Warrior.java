import org.w3c.dom.ls.LSOutput;

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

}


