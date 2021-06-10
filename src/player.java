
public class player {
	String name;
	int age;
	public static class quarterBack{
		String name;
		int thp;
		int tha;
		int mob;
		int interceptions = 0;
		int attempts = 0;
		int completions = 0;
		double yards = 0;
		int rushAttempts = 0;
		int rushYards = 0;
		int td = 0;
		public void printStats(){
			System.out.println(name+"'s stats: ");
			System.out.println("Attempts: " + attempts);
			System.out.println("Completions: " + completions);
			System.out.println("Yards: " + yards);
			System.out.println("Touchdowns: " + td);
			System.out.println("Interceptions: " + interceptions);

			if (attempts != 0){
				System.out.println("Completion %: " + (100 * completions/attempts));
				System.out.println("Yards per attempt: " + (yards/attempts));
			}
			System.out.println("Rush Attempts: " + rushAttempts);
			System.out.println("Rush Yards: " + rushYards);

		}
	}
	public static class wideReciever{
		String name;
		int catching;
		int routerunning;
		int receptions = 0;
		double yards = 0;
		int td = 0;
		public void printStats(){
			System.out.println(name+"'s stats: ");
			System.out.println("Receptions: " + receptions);
			System.out.println("Yards: " + yards);
			System.out.println("TDs: " + td);
		}
		
	}
	public static class runningBack{
		String name;
		int speed;
		int power;
		int elusive;
		int attempts = 0;
		double yards = 0;
		int td = 0;
		public void printStats() {
			System.out.println(name+"'s stats: ");
			System.out.println("Attempts: " + attempts);
			System.out.println("Yards: " + yards);
			System.out.println("YPC: " + (yards/attempts));
			System.out.println("TDs: " + td);
		}
	}
	public static class tightEnd{
		String name;
		int catching;
		int power;
		int block;
	}
	public static class oLineman{
		String name;
		int block;
	}
	public static class defensiveBack{
		String name;
		int playmake;
		int coverage;
		int tackles = 0;
		int passdefelctions = 0;
		int interceptions = 0;
		public void printStats(){
			System.out.println(name+"'s stats: ");
			System.out.println("Tackles: " + tackles);
			System.out.println("Pass Deflections: " + passdefelctions);
			System.out.println("Interceptions: " + interceptions);

		}
	}
	public static class lineBacker{
		String name;
		int power;
		int playmake;
		int tackles = 0;
		public void printStats(){
			System.out.println(name+"'s stats: ");
			System.out.println("Tackles: " + tackles);
		}

	}
	public static class edgeRusher{
		String name;
		int power;
		int speed;
	}
	public static class noseTackle{
		String name;
		int power;
		int playmake;
		int tfl = 0;
		int sack = 0;
		public void printStats(){
			System.out.println(name+"'s stats: ");
			System.out.println("TFLs: " + tfl);
			System.out.println("Sacks: " + sack);
		}
	}
	
}
