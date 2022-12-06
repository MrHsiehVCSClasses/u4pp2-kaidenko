package u4pp;

public class DefenseMonster extends Monster{
    
    public int myDefense;

    public DefenseMonster(String name, int health, int attack, int exp, int defense){
        super(name, health, attack, exp);
        myDefense = defense;
    }

    public int getDefense(){
        return myDefense;
    }

    public void takeDamage(int damage){
        if (damage > getDefense()){
            super.takeDamage(damage - myDefense);
        }
        else{
            super.takeDamage(0);
        }
    }
}

// // - `public String toString()` - has everything that `Monster`'s `toString` does, plus the defense of this monster