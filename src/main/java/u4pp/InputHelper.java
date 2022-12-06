package u4pp;

import java.util.Scanner;

public class InputHelper {

    static Scanner myScanner = new Scanner(System.in);

    public static int getIntegerInput(String prompt, int min, int max){

        System.out.println(prompt);
        String input = myScanner.nextLine();
        int userNum = Integer.valueOf(input);
  
        while (userNum  < min || userNum > max){
            System.out.println(prompt);
            System.out.println("Your input is " + input);
            System.out.println("Please type in a correct number.");
            input = myScanner.nextLine();
            userNum = Integer.parseInt(input);
        }
        return userNum;
    }
}