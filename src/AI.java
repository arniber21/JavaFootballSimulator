public class AI {
    public static String pickPlay(Game game, int clock, int playerScore, int aiScore, int down, int togo, int ball){
        game.playPicked = true;
        if (down == 4 && ball > 70){
            return "fg";
        }
        else if (down == 4 && ball < 70){
            return "punt";
        }
        else if (down == 3 && togo < 2){
            return "run";
        }
        else if (down == 3 && togo > 2){
            return "pass";
        }
        else if ((simulator.inBetween(900, clock, 570) || simulator.inBetween(450,clock,120)) && aiScore > playerScore){
            if(simulator.randomBool(0.7)){
                return "pass";
            }
            else {
                return "run";
            }
        }
        else if ((simulator.inBetween(900, clock, 570) || simulator.inBetween(450,clock,120)) && !(aiScore <= playerScore)){
            if(simulator.randomBool(0.9)){
                return "pass";
            }
            else {
                return "run";
            }
        }
        else if (!(simulator.inBetween(900, clock, 570) || !(simulator.inBetween(450,clock,120)))){
            return "pass";
        }
        else if (simulator.randomBool(0.6)){
            return "pass";
        }
        else {
            return "run";
        }
    }
}
