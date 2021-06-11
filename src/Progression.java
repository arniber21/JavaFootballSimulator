import org.jetbrains.annotations.NotNull;

public class Progression {
    final static double gameAttemptThreshold = 0.7;
    final static int gamePassYardThreshold = 300;
    final static int gameQbRushThreshold = 10;


    final static int gameRushYardThreshold = 120;
    final static int gameRushAttemptThreshold = 27;

    final static int gamePassDeflectionThreshold = 15;
    final static int gameInterceptionThreshold = 2;

    public static void qbGameProgression(player.quarterBack target){
        if(target.completions/target.attempts >= gameAttemptThreshold){
            target.tha++;
        }
        else if (target.yards >= gamePassYardThreshold){
            target.thp++;
        }
        else if (target.rushYards >= gameQbRushThreshold){
            target.mob++;
        }
    }
    public static void rbGameProgression(player.runningBack target){
        if(target.yards >= gameRushYardThreshold){
            target.elusive++;
        }
        if(target.attempts >= gameAttemptThreshold){
            target.power++;
        }
    }
    public static void cbGameProgression(player.defensiveBack target){
        if(target.passdefelctions >= gamePassDeflectionThreshold){
            target.coverage++;
        }
        if(target.interceptions >= gameInterceptionThreshold){
            target.playmake++;
        }
    }
}
