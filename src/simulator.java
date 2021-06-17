import java.util.Scanner;
public class simulator {
	public static double randomNum(double max, double min)
	{
		return Math.floor(Math.random()*(max-min+1)+min);
	}

	public static boolean randomBool(double weight)
	{
		return Math.random() < weight;
	}
	public static double runPlay(GameUI gui, Game game, runningBack rb, lineBacker lb, noseTackle nt, defensiveBack db)
	{
		double yardsGained;
		double LB = (((lb.playmake + lb.power)/2)/100)/20 + 0.5;
		double TFL = ((((nt.playmake + nt.power)/2 )/100)/20/5) + 0.2;
		if (randomBool(TFL)){
			nt.tfl++;
			yardsGained = (int) randomNum(3,-5);
			rb.yards += yardsGained;
			rb.attempts++;
			game.gameClock -= 30;
			gui.setLastPlay("A loss of " + yardsGained + " by " + rb.name);
			return yardsGained;
		} 
		else if (randomBool(LB)){
			lb.tackles++;
			rb.attempts++;
			yardsGained = (int) randomNum(3,(((lb.playmake + lb.power)/2)/100)*7);
			rb.yards += yardsGained;
			game.gameClock -= 30;
			gui.setLastPlay(yardsGained + " yard rush by " + rb.name);
			return yardsGained;
		} 
		else{
			db.tackles++;
			rb.attempts++;
			yardsGained =  (int) randomNum(15,(((rb.speed+rb.elusive)/2)/100)*20);
			rb.yards += yardsGained;
			game.gameClock -= 30;
			gui.setLastPlay(yardsGained + " yard rush by " + rb.name);
			return yardsGained;
		}
	}
	public static double passPlay(GameUI gui, Game game, quarterBack qb, wideReciever wr, defensiveBack cb, noseTackle dt){
		// (QB accuracy + route running - coverage) to find the probability of a catch
		double catchProb = ((1.1*qb.tha + wr.routerunning - 0.7*cb.coverage)/100);
		double yardsGained;
		if(randomBool(catchProb)) {
			yardsGained = randomNum(15+(qb.thp/10.0),4);
			qb.attempts++;
			qb.completions++;
			cb.tackles++;
			qb.yards += yardsGained;
			wr.receptions++;
			wr.yards += yardsGained;
			gui.setLastPlay(qb.name + " throw to " + wr.name + " for " + yardsGained + " yards");
			return yardsGained;
		}
		else if (randomBool(cb.playmake*0.05/100)){
			qb.interceptions++;
			cb.interceptions++;
			qb.attempts++;
			gui.setLastPlay("Pass is intercepted by " + cb.name + "!");
			game.flipPosessions();
			game.ball = Math.abs(100-game.ball);
			return 0;
		}
		else if(randomBool(0.2*qb.mob/100.0)){
			qb.rushAttempts++;
			yardsGained = randomNum(qb.mob/100.0 * 20, -3);
			gui.setLastPlay(qb.name + " scrambles for a gain of "+yardsGained);
			qb.rushYards += yardsGained;
			game.gameClock -= 30;
			return yardsGained;
		}
		else if(randomBool(dt.power * 0.0019)){
			yardsGained = -8;
			gui.setLastPlay(qb.name + " is sacked by " + dt.name + " for a loss of " + yardsGained + "!");
			dt.sack++;
			game.gameClock -= 30;
			return yardsGained;
		}
		else {
			yardsGained = 0;
			qb.attempts++;
			cb.passdefelctions++;
			game.gameClock -= 10;
			gui.setLastPlay(qb.name + " pass batted away by " + cb.name);
			return 0;
		}
	}
	public static void punt(GameUI gui, Game game){
		game.ball = Math.abs(100-(40+game.ball));
		gui.setLastPlay(game.hasBall.name + " punts!");
	}
	public static boolean fieldGoal(GameUI gui, Game game){
		if (randomBool((100-(100-game.ball-20))/100)){
			gui.setLastPlay("Field Goal Made!");
			return true;
		}
		else{
			gui.setLastPlay("Field Goal Missed!");
			return false;
		}

	}
	public static boolean inBetween(int x,int a,int y){
		return a > x && x < y;
	}

}

