import java.util.concurrent.ThreadLocalRandom;
public class player {
	String name;
	int age;
	int stamina = 100;
	public static player randomPlayer(player[] players){
		int index = ThreadLocalRandom.current().nextInt(0, players.length);
		return players[index];
	}
	public void setStamina(){
		if (this.stamina > 100){
			this.stamina = 100;
		}
	}
}
