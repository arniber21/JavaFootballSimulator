import java.io.*;
import java.util.Scanner;
public class ImportTeams {
    public static void importDefaultTeams(){

        Game.Reds.name = "Reds";
        Game.Blues.name = "Blues";
        Game.Reds.recieveAtHalf = false;
        Game.Reds.possesion = true;
        Game.Blues.recieveAtHalf = true;
        Game.Blues.possesion = false;
        Game.Reds.score = 0;
        Game.Blues.score = 0;


        Game.Reds.rb.name = "Leonard Fournette";
        Game.Reds.rb.speed = 90;
        Game.Reds.rb.elusive = 20;
        Game.Reds.rb.power = 10;

        Game.Reds.lb.name = "Lavonte David";
        Game.Reds.lb.playmake = 70;
        Game.Reds.lb.power = 70;

        Game.Reds.dt.name = "Ndamukong Suh";
        Game.Reds.dt.power = 70;
        Game.Reds.dt.playmake = 80;

        Game.Reds.cb.name = "Carlton Davis";
        Game.Reds.cb.coverage = 90;
        Game.Reds.cb.playmake = 90;

        Game.Reds.qb.name = "Tom Brady";
        Game.Reds.qb.thp = 60;
        Game.Reds.qb.tha = 90;
        Game.Reds.qb.mob = 10;


        Game.Reds.wr.name = "Chris Godwin";
        Game.Reds.wr.catching = 80;
        Game.Reds.wr.routerunning = 30;



        Game.Blues.rb.name = "Damien Harris";
        Game.Blues.rb.speed = 90;
        Game.Blues.rb.elusive = 20;
        Game.Blues.rb.power = 10;


        Game.Blues.lb.name = "Donta Hightower";
        Game.Blues.lb.playmake = 80;
        Game.Blues.lb.power = 90;

        Game.Blues.dt.name = "Vince Wilfork";
        Game.Blues.dt.power = 70;
        Game.Blues.dt.playmake = 80;


        Game.Blues.cb.name = "Stephon Gilmore";
        Game.Blues.cb.coverage = 90;
        Game.Blues.cb.playmake = 90;

        Game.Blues.qb.name = "Mac Jones";
        Game.Blues.qb.thp = 60;
        Game.Blues.qb.tha = 90;
        Game.Blues.qb.mob = 10;

        Game.Blues.wr.name = "Julian Edelman";
        Game.Blues.wr.catching = 80;
        Game.Blues.wr.routerunning = 30;
    }

}
