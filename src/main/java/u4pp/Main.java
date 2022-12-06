package u4pp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MonsterFighter me = new MonsterFighter();
        Scanner myScanner = new Scanner(System.in);
        me.play(myScanner);
    }
}
