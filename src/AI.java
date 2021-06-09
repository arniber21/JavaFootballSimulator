public class AI {
    public static String pickPlay(int clock, int playerScore, int aiScore, int down, int togo, int ball){
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
            if(simulator.randomBool(0.4)){
                return "pass";
            }
            else {
                return "run";
            }
        }
        else if ((simulator.inBetween(900, clock, 570) || simulator.inBetween(450,clock,120)) && !(aiScore >= playerScore)){
            if(simulator.randomBool(0.7)){
                return "pass";
            }
            else {
                return "run";
            }
        }
        else if (!(simulator.inBetween(900, clock, 570) || !(simulator.inBetween(450,clock,120)))){
            return "pass";
        }
        return "run";
    }
}
