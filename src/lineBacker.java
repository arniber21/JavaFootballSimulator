public class lineBacker extends player{
    String name;
    int power;
    int playmake;
    int tackles = 0;
    public void printStats(){
        System.out.println(name+"'s stats: ");
        System.out.println("Tackles: " + tackles);
    }

}