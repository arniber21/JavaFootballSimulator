public class runningBack extends player{
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