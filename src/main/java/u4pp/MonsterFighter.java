package u4pp;
import java.util.Scanner;

public class MonsterFighter {
    
    static Scanner myScanner = new Scanner(System.in);
    public Monster[] monsters;

    public MonsterFighter(){

    }

    public void play(Scanner scanner){
        System.out.println("Welcome to Dungeon Fighter! To create your character please enter your name:");
        String fighterName = myScanner.nextLine();
        Fighter fighter = new Fighter (fighterName, 1, 1);
        System.out.println("Hmmm...your name is " + fighterName);
        System.out.println("In this game, you will try to overcome monsters, but fight them at your will. As you currently stand, here are your stats");
        fighter.toString();
        System.out.println("Adventurer it seems like you are ready to begin. ");
        System.out.println("Entering the dungeon...");
        System.out.println("");

        //first monster: tutorial

        System.out.println("Welcome to the most outer layer of the dungeon. We will first go through a tutorial to test your skills.");
        System.out.println("A monster will appear and it is your job to fight it or flee. In a fight, you will each take turns with monster in the fight to see who is stronger.");
        System.out.println("Choosing to fight will grant you three options: (1) Attack, (2) Block, (3) focus");
        System.out.println("You must wisely choose to win the fight.");
        System.out.println("Speaking of a fight...here is your first monster.");
        System.out.println(monsters[0].toString());
        System.out.println("Lets begin!");

        while (monsters[0].getHealth() <=0){
            if (InputHelper.getIntegerInput("Would you like to (1) Attack, (2) Block, (3) focus.", 1, 3) == 1){
                System.out.println("You chose to attack!");
                fighter.attack(monsters[0]);
            }
            else if (InputHelper.getIntegerInput("Would you like to (1) Attack, (2) Block, (3) focus.", 1, 3) == 1){
                System.out.println("You chose to block!");
                fighter.block();
            }
            else{
                System.out.println("You chose to focus!");
                fighter.focus();
            }
    
            System.out.println(fighterName + "'s stats: " + fighter.toString());
            System.out.println("monster stats: " + monsters[0].toString());

            System.out.println("It is now " + monsters[0].getName() + "'s turn.");
            monsters[0].takeTurn(fighter);

            if (fighter.getHealth() <= 0){
                System.out.println("You have been slain. But dont worry this the tutorial. I will still grant u your experience.");
                break;
            }
        }

        System.out.println("Congratulations!! You had finished your first tutorial.");
        fighter.gainEXP(monsters[0].getExpGiven());
        System.out.println("You gained some experience and leveled up.");
        System.out.println("Now your real adventure will begin!");
        System.out.println("You traverse down the dungeon.");

        boolean keepPlaying = true;
        int monsterNum = 1;

        while (keepPlaying = true){
            System.out.println("You have come across " + monsters[monsterNum]);
            System.out.println("His stats are: " + monsters[monsterNum].toString());
            System.out.println("Do you wish to fight him? (1)Yes, (2)No");
            if (InputHelper.getIntegerInput("Do you wish to fight him? (1)Yes, (2)No", 1, 2) == 1){
                while (monsters[monsterNum].getHealth() <=0){
                    if (InputHelper.getIntegerInput("Would you like to (1) Attack, (2) Block, (3) focus.", 1, 3) == 1){
                        System.out.println("You chose to attack!");
                        fighter.attack(monsters[0]);
                    }
                    else if (InputHelper.getIntegerInput("Would you like to (1) Attack, (2) Block, (3) focus.", 1, 3) == 1){
                        System.out.println("You chose to block!");
                        fighter.block();
                    }
                    else{
                        System.out.println("You chose to focus!");
                        fighter.focus();
                    }
            
                    System.out.println(fighterName + "'s stats: " + fighter.toString());
                    System.out.println("monster stats: " + monsters[0].toString());
        
                    System.out.println("It is now " + monsters[monsterNum].getName() + "'s turn.");
                    monsters[monsterNum].takeTurn(fighter);
                    monsterNum++;
        
                    if (fighter.getHealth() <= 0){
                        System.out.println("You have been slain.");
                        break;
                    }
                }
            keepPlaying = false;
            }
            else if (InputHelper.getIntegerInput("Do you wish to fight him? (1)Yes, (2)No", 1, 2) == 2){
                keepPlaying=false;
            }
        }
        System.out.println("Thank you for playing.");
        }
    }
    