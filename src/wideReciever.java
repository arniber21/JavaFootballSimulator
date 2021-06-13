public class wideReciever extends player{
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