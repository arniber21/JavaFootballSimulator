
public class player {
	String name;
	int age;
	public  player randomPlayer(player player1, player player2){
		if(simulator.randomBool(0.5)){
			return player1;
		}
		return player2;
	}
}
