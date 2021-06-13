public class defensiveBack extends player{
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