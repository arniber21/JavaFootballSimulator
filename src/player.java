import java.util.concurrent.ThreadLocalRandom;
public class player {
	String name;
	int age;
	public static player randomPlayer(player[] players){
		int index = ThreadLocalRandom.current().nextInt(0, players.length);
		return players[index];
	}
}
