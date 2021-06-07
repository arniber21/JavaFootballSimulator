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
		double LB = (((lb.playmake + lb.power)/2)/100)/20 + 0.6;
		double TFL = (((nt.playmake + nt.power)/2 )/100)/20 + 0.1;
		if (randomBool(TFL)){
			nt.tfl++;
			yardsGained = (int) randomNum(-1,-5);
			rb.yards -= yardsGained;
			rb.attempts++;
			Game.gameClock -= 30;
			System.out.println("A loss of " + yardsGained + " by " + rb.name);
			return yardsGained;
		} 
		else if (randomBool(LB)){
			lb.tackles++;
			rb.attempts++;
			yardsGained = (int) randomNum(1,(((lb.playmake + lb.power)/2)/100)*7);
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
		double catchProb = ((qb.tha + wr.routerunning - 0.5*cb.coverage)/100);
		double yardsGained;
		if(randomBool(catchProb)) {
			yardsGained = randomNum(30+(qb.thp/100),4);
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
		else if (randomBool(cb.playmake*0.4/100)){
			qb.interceptions++;
			cb.interceptions++;
			qb.attempts++;
			System.out.println("Pass is intercepted by " + cb.name + "!");
			Game.flipPosessions();

			return 0;
		}
		else if (randomBool(0.4)){
			yardsGained = 0;
			qb.attempts++;
			cb.passdefelctions++;
			Game.gameClock -= 10;
			System.out.println(qb.name + " pass batted away by " + cb.name);
			return 0;
		}
		else if(randomBool(qb.mob * 4/100)){
			qb.rushAttempts++;
			yardsGained = randomNum(qb.mob/100 * 20, -3);
			System.out.println(qb.name + " scrambles for a ");
			qb.rushYards += yardsGained;
			return yardsGained;
		}
		else if(randomBool(dt.power * 0.02)){
			yardsGained = -8;
			System.out.println(qb.name + " is sacked by " + dt.name + "for a loss of " + yardsGained + "!");
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
		// Else 70% incompletion chance, the other 30% fluctuates by playmake whether it is intercepted or not.
		// QB throw power for depth of catch
	}

}

