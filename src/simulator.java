import java.util.Scanner;
public class simulator {
	static int position = 0;
	static int quarterTime = 900;
	static int quarter = 1;
	public void main(String[] args)
	{
		System.out.println("What're you doing????????");
	}
	public static double randomNum(double max, double min)
	{
		return Math.floor(Math.random()*(max-min+1)+min);
	}

	public static boolean randomBool(double weight)
	{
		return Math.random() < weight;
	}

	public static double runPlay(player.runningBack rb, player.lineBacker lb, player.noseTackle nt, player.defensiveBack db)
	{

		double yardsGained;
		double LB = (((lb.playmake + lb.power)/2)/100)/20 + 0.5;
		double TFL = ((((nt.playmake + nt.power)/2 )/100)/20/5);
		if (randomBool(TFL)){
			nt.tfl++;
			yardsGained = (int) randomNum(3,-5);
			rb.yards -= yardsGained;
			rb.attempts++;
			Game.gameClock -= 30;
			System.out.println("A loss of " + yardsGained + " by " + rb.name);
			return yardsGained;
		} 
		else if (randomBool(LB)){
			lb.tackles++;
			rb.attempts++;
			yardsGained = (int) randomNum(3,(((lb.playmake + lb.power)/2)/100)*7);
			rb.yards += yardsGained;
			Game.gameClock -= 30;
			System.out.println(yardsGained + " yard rush by " + rb.name);
			return yardsGained;
		} 
		else{
			db.tackles++;
			rb.attempts++;
			yardsGained =  (int) randomNum(15,(((rb.speed+rb.elusive)/2)/100)*20);
			rb.yards += yardsGained;
			Game.gameClock -= 30;
			System.out.println(yardsGained + " yard rush by " + rb.name);
			return yardsGained;
		}
	}
	public static double passPlay(player.quarterBack qb, player.wideReciever wr, player.defensiveBack cb, player.noseTackle dt){
		// (QB accuracy + route running - coverage) to find the probability of a catch
		double catchProb = ((qb.tha + wr.routerunning - 0.7*cb.coverage)/100);
		double yardsGained;
		if(randomBool(catchProb)) {
			yardsGained = randomNum(20+(qb.thp/10.0),4);
			qb.attempts++;
			qb.completions++;
			cb.tackles++;
			qb.yards += yardsGained;
			wr.receptions++;
			wr.yards += yardsGained;
			Game.gameClock -= 10;
			System.out.println(qb.name + " throw to " + wr.name + " for " + yardsGained + " yards");
			return yardsGained;
		}
		else if (randomBool(cb.playmake*0.1/100)){
			qb.interceptions++;
			cb.interceptions++;
			qb.attempts++;
			System.out.println("Pass is intercepted by " + cb.name + "!");
			Game.flipPosessions();
			Game.ball = Math.abs(100-Game.ball);
			return 0;
		}
		else if(randomBool(0.4*qb.mob/100.0)){
			qb.rushAttempts++;
			yardsGained = randomNum(qb.mob/100.0 * 20, -3);
			System.out.println(qb.name + " scrambles for a gain of "+yardsGained);
			qb.rushYards += yardsGained;
			Game.gameClock -= 30;
			return yardsGained;
		}
		else if(randomBool(dt.power * 0.005)){
			yardsGained = -8;
			System.out.println(qb.name + " is sacked by " + dt.name + " for a loss of " + yardsGained + "!");
			dt.sack++;
			return yardsGained;
		}
		else {
			yardsGained = 0;
			qb.attempts++;
			cb.passdefelctions++;
			Game.gameClock -= 10;
			System.out.println(qb.name + " pass batted away by " + cb.name);
			return 0;
		}
	}
	public static void punt(){
		Game.flipPosessions();
		Game.ball = Math.abs(100-(40+Game.ball));
	}
	public static boolean fieldGoal(){
		if (randomBool((100-(100-Game.ball-20))/100)){
			System.out.println("Field Goal Made!");
			return true;
		}
		else{
			System.out.println("Field Goal Missed!");
			return false;
		}

	}

}

