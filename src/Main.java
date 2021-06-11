import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ImportTeams.importDefaultTeams();
        Game.ball = 20;

        System.out.println("Welcome to Java Football Sim 1.1.0!");
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play both sides (with a friend) or play against an AI? B for both sides or A for AI. ");
        String inputter = input.next();
        Game.inGame = true;
        if (inputter.equals("B")){
            while(Game.inGame){
                if (Game.Reds.possesion){
                    Game.redPosession();
                }
                else{
                    Game.bluePosession();
                }
            }
        }
        else if (inputter.equals("A")){
            while(Game.inGame){
                if (Game.Reds.possesion){
                    Game.redPossessionAI();
                }
                else{
                    Game.bluePosession();
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
            int blueTeamWins = 0;
            int redTeamWins = 0;
            for (int i = 0; i < 17; i++){
                while(Game.inGame){
                    if (Game.Reds.possesion){
                        Game.redPossessionAI();
                    }
                    else{
                        Game.bluePossessionAI();
                    }
                }
                if (Game.Blues.score >= Game.Reds.score){
                    blueTeamWins++;
                }
                else{
                    redTeamWins++;
                }
                Game.Reds.score = 0;
                Game.Blues.score = 0;
                Game.inGame = true;
                Game.gameClock = 900;
                Game.quarter = 1;
                System.out.println("Blue team record: " + blueTeamWins + "-" + redTeamWins);
                System.out.println("Red team record: " + redTeamWins + "-" + blueTeamWins);

            }
        }
        else if(inputter.equals("C")){
            int blueTeamWins = 0;
            int redTeamWins = 0;
            for (int i = 0; i < 340; i++){
                while(Game.inGame){
                    if (Game.Reds.possesion){
                        Game.redPossessionAI();
                    }
                    else{
                        Game.bluePossessionAI();
                    }
                }
                if (Game.Blues.score >= Game.Reds.score){
                    blueTeamWins++;
                }
                else{
                    redTeamWins++;
                }
                Game.Reds.score = 0;
                Game.Blues.score = 0;
                Game.inGame = true;
                Game.gameClock = 900;
                Game.quarter = 1;
                System.out.println("Blue team record: " + blueTeamWins + "-" + redTeamWins);
                System.out.println("Red team record: " + redTeamWins + "-" + blueTeamWins);


            }
        }
        else {
            System.out.println("Invalid answer chosen, exiting!");
        }



    }


}
