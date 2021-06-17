import java.util.Scanner;

public class Main {
    static Game game = new Game();
    public static void main(String[] args) {
        GameUI gui = new GameUI("Java Football Sim", game);
        ImportTeams.initializeTeam(game.Reds, "Reds","Tom Brady", "Leonard Fournette", "Mike Evans", "Lavonte David", "Ndamukong Suh", "Carlton Davis");
        ImportTeams.initializeTeam(game.Blues, "Blues","Mac Jones", "Damien Harris", "Nelson Agholor", "Donta Hightower", "Vince Wilfork", "Stephon Gilmore");
        game.ball = 20;
        game.Reds.name = "Reds";
        game.Blues.name = "Blues";
        System.out.println("Welcome to Java Football Sim 1.2.0!");
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play both sides (with a friend) or play against an AI? B for both sides or A for AI. ");
        String inputter = input.next();
        game.inGame = true;
        if (inputter.equals("B")){
            while(game.inGame){
                game.posession(game, gui);
            }
        }
        else if (inputter.equals("A")){
            while(game.inGame){
                if (game.RedBall){
                    game.possessionAI(game, gui);
                }
                else{
                    game.posession(game, gui);
                }
            }
        }
        else if(inputter.equals("S")){
            while(game.inGame){
                game.possessionAI(game, gui);
            }
        }
        else if(inputter.equals("F")){
            int blueTeamWins = 0;
            int redTeamWins = 0;
            for (int i = 0; i < 17; i++){
                while(game.inGame){
                    game.possessionAI(game, gui);
                }
                if (game.Bluescore >= game.Redscore){
                    blueTeamWins++;
                }
                else{
                    redTeamWins++;
                }
                game.Redscore = 0;
                game.Bluescore = 0;
                game.inGame = true;
                game.gameClock = 900;
                game.quarter = 1;
                System.out.println("Blue team record: " + blueTeamWins + "-" + redTeamWins);
                System.out.println("Red team record: " + redTeamWins + "-" + blueTeamWins);

            }
        }
        else if(inputter.equals("C")){
            int blueTeamWins = 0;
            int redTeamWins = 0;
            for (int i = 0; i < 340; i++){
                while(game.inGame){
                    game.possessionAI(game, gui);
                }
                if (game.Bluescore >= game.Redscore){
                    blueTeamWins++;
                }
                else{
                    redTeamWins++;
                }
                game.Redscore = 0;
                game.Bluescore = 0;
                game.inGame = true;
                game.gameClock = 900;
                game.quarter = 1;
                System.out.println("Blue team record: " + blueTeamWins + "-" + redTeamWins);
                System.out.println("Red team record: " + redTeamWins + "-" + blueTeamWins);


            }
        }
        else {
            System.out.println("Invalid answer chosen, exiting!");
        }



    }


}
