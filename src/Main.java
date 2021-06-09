import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game.initializeGame();
        Game.ball = 20;
        System.out.println("Welcome to Java Football Sim 1.0!");
        while(true){
            if (Game.Reds.possesion){
                Game.redPosession();
            }
            else{
                Game.bluePossession();
            }
        }

    }


}
