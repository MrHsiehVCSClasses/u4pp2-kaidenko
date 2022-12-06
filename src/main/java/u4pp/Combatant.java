package u4pp;

public class Combatant {

    private String myName;
    private int myHealth;
    private int myMaxHealth;
    private int myAttack;

    public Combatant(String name, int maxHealth, int attack){
        myName = name;
        myHealth = maxHealth;
        myMaxHealth = maxHealth;
        myAttack = attack;
    }

    public String getName(){
        return myName;
    }

    public int getHealth(){
        return myHealth;
    }

    public int getMaxHealth(){
        return myMaxHealth;
    }

    public int getAttackPower(){
        return myAttack;
    }

    public void setHealth(int health){
        if (health > myMaxHealth){
            myHealth = myMaxHealth;
        }
        if (health < 0){
            myHealth = 0;
        }
        else if (health >= 0 && health <= myMaxHealth){
            myHealth = health;
        }
    }

    public void setMaxHealth(int health){
        if (health >= myMaxHealth){
            myHealth = myMaxHealth;
            myMaxHealth = health;
        }
        else {
            myMaxHealth = health;
            myHealth = myMaxHealth;
        } 
        if (health < 1) {
            myMaxHealth = 1;
            myHealth = myMaxHealth;
        }
    }

    public void setAttackPower(int attackPower){
        if (attackPower >= 0){
            myAttack = attackPower;
        }
        else {
           myAttack = 0;
        }
    }

    public void takeDamage(int d){
        if (d > 0){
            setHealth(myHealth - d);
        }
    }

    public boolean canFight(){
        if (myHealth > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        return("Name - " + myName + "\nCurrent Health - " + myHealth + "/" + myMaxHealth + "\nMax Health - " + myMaxHealth + "\nAttack Power - " + myAttack);
    }
}
