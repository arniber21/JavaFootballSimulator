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
        Game.inGame = true;
        if (inputter.equals("B")){
            while(Game.inGame){
                if (!Game.inGame){
                    break;
                }
                else if (Game.Reds.possesion){
                    Game.redPosession();
                }
                else{
                    Game.bluePossession();
                }
            }
        }
        else if (inputter.equals("A")){
            while(Game.inGame){
                if (Game.Reds.possesion){
                    Game.redPossessionAI();
                }
                else{
                    Game.bluePossession();
                }
            }
        }
        else if(inputter.equals("S")){
            while(Game.inGame){
                if (Game.Reds.possesion){
                    Game.redPossessionAI();
                }
                else{
                    Game.bluePossessionAI();
                }
            }
        }
        else if(inputter.equals("F")){
            for (int i = 0; i < 17; i++){
                while(Game.inGame){
                    if (Game.Reds.possesion){
                        Game.redPossessionAI();
                    }
                    else{
                        Game.bluePossessionAI();
                    }
                }
                Game.initializeGame();
                Game.inGame = true;

            }
        }
        else {
            System.out.println("Invalid answer chosen, exiting!");
        }



    }


}
