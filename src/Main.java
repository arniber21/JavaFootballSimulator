import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game.initializeGame();
        Game.ball = 20;
        System.out.println("Welcome to Java Football Sim 1.1.0!");
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play both sides (with a friend) or play against an AI? B for both sides or A for AI. ");
        String inputter = input.next();
        if (inputter.equals("B")){
            while(true){
                if (Game.Reds.possesion){
                    Game.redPosession();
                }
                else{
                    Game.bluePossession();
                }
            }
        }
        else if (inputter.equals("A")){
            while(true){
                if (Game.Reds.possesion){
                    Game.redPossessionAI();
                }
                else{
                    Game.bluePossession();
                }
            }
        }
        else {
            System.out.println("Invalid answer chosen, exiting!");
        }



    }


}
