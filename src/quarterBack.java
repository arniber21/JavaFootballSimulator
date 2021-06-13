public class quarterBack extends player{
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