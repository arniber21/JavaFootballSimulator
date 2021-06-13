public class noseTackle extends player{
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