package u4pp;

import java.lang.Math;

public class Fighter extends Combatant{
    
    public int level = 1;
    public int experience;
    public int focusStacks;
    public boolean blocking;

    public Fighter(String name, int maxHealth, int attack){
        super (name, maxHealth, attack);
        level = 1;
        experience = 0;
        focusStacks = 0;
        blocking = false;
    }

    public int getEXP(){
        return experience;
    }

    public int getFocusStacks(){
        return focusStacks;
    }
 
    public int getLevel(){
        return level;
    }

    public boolean getIsBlocking(){
        return blocking;
    }

    public void attack(Combatant target){
        if (focusStacks > 0){
            target.takeDamage(getAttackPower() * (int) Math.pow(2, focusStacks));
            focusStacks = 0;
        }
        else{
            target.takeDamage(this.getAttackPower());
        }
    }

    public void block(){
        blocking = true;
    }

    public void focus(){
        focusStacks++;
    }

    public void gainEXP(int exp){
        while (exp >= level){
            exp -= level;
            level++;
            this.setMaxHealth(getMaxHealth() + 5);
            this.setHealth(getMaxHealth());
            this.setAttackPower(this.getAttackPower() + 1);
            blocking = false;
        }
        experience += exp;
    }

    public void takeDamage(int damage){
        if (blocking == true){
            super.takeDamage(damage / 2);
            blocking = false;
        }
        else{
            super.takeDamage(damage);
        }
    }

    public String toString(){
        return ("Name: " + getName() + ", Health: " + getHealth() + ", Max Health: " + getMaxHealth() + ", Attack Power: " + getAttackPower() + "Experience given: " + experience);
    }

}
