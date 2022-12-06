package u4pp;

public class Monster extends Combatant{

    public int experience; 

    public Monster(String name, int health, int attack, int exp){
        super(name, health, attack);
        experience = exp;
    }

    public int getExpGiven(){
        if (experience < 0){
            return 0;
        }
        else{
            return experience;
        } 
    }

    public void takeTurn(Combatant target){
        target.takeDamage(this.getAttackPower());
    }

    public String toString(){
        return ("Name: " + getName() + ", Health: " + getHealth() + ", Max Health: " + getMaxHealth() + ", Attack Power: " + getAttackPower() + "Experience given: " + experience);
    }
}
