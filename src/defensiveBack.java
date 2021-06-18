public class defensiveBack extends player{
    int playmake;
    int coverage;
    int tackles = 0;
    int passdefelctions = 0;
    int interceptions = 0;
    public int totalRating(){
        return (playmake + coverage)/2;
    }
}