import java.io.*;
import java.util.Scanner;
public class ImportTeams {
    public static void importDefaultTeams(team Red, team Blue){

        Red.name = "Red";
        Blue.name = "Blue";


        Red.rb.name = "Leonard Fournette";
        Red.rb.speed = 90;
        Red.rb.elusive = 20;
        Red.rb.power = 10;

        Red.rb2.name = "Ronald Jones";
        Red.rb2.speed = 60;
        Red.rb2.elusive = 50;
        Red.rb2.power = 70;

        Red.lb.name = "Lavonte David";
        Red.lb.playmake = 70;
        Red.lb.power = 70;


        Red.dt.name = "Ndamukong Suh";
        Red.dt.power = 70;
        Red.dt.playmake = 80;

        Red.cb.name = "Carlton Davis";
        Red.cb.coverage = 90;
        Red.cb.playmake = 90;

        Red.qb.name = "Tom Brady";
        Red.qb.thp = 60;
        Red.qb.tha = 90;
        Red.qb.mob = 10;


        Red.wr.name = "Chris Godwin";
        Red.wr.catching = 80;
        Red.wr.routerunning = 30;

        Red.wr2.name = "Mike Evans";
        Red.wr2.catching = 90;
        Red.wr2.routerunning = 10;


        Blue.rb.name = "Damien Harris";
        Blue.rb.speed = 90;
        Blue.rb.elusive = 20;
        Blue.rb.power = 10;

        Blue.rb2.name = "James White";
        Blue.rb2.speed = 70;
        Blue.rb2.elusive = 90;
        Blue.rb2.power = 40;

        Blue.lb.name = "Donta Hightower";
        Blue.lb.playmake = 80;
        Blue.lb.power = 90;

        Blue.dt.name = "Vince Wilfork";
        Blue.dt.power = 70;
        Blue.dt.playmake = 80;


        Blue.cb.name = "Stephon Gilmore";
        Blue.cb.coverage = 90;
        Blue.cb.playmake = 90;

        Blue.qb.name = "Mac Jones";
        Blue.qb.thp = 60;
        Blue.qb.tha = 90;
        Blue.qb.mob = 10;

        Blue.wr.name = "Julian Edelman";
        Blue.wr.catching = 80;
        Blue.wr.routerunning = 30;

        Blue.wr2.name = "Nelson Agholor";
        Blue.wr2.catching = 50;
        Blue.wr2.routerunning = 80;
    }
    public static void initializeTeam(team Red, String name, String qbName, String rbName, String wrName, String lbName, String dtName, String dbName){
        Red.name = name;
        Red.rb.name = rbName;
        Red.rb.speed = 90;
        Red.rb.elusive = 20;
        Red.rb.power = 10;

        Red.lb.name = lbName;
        Red.lb.playmake = 70;
        Red.lb.power = 70;

        Red.dt.name = dtName;
        Red.dt.power = 70;
        Red.dt.playmake = 80;

        Red.cb.name = dbName;
        Red.cb.coverage = 90;
        Red.cb.playmake = 90;

        Red.qb.name = qbName;
        Red.qb.thp = 60;
        Red.qb.tha = 90;
        Red.qb.mob = 10;


        Red.wr.name = wrName;
        Red.wr.catching = 80;
        Red.wr.routerunning = 30;
    }
    public team[] defaultFullTeamImport(team reds, team blues){

        team[] listofteams = {reds,blues};

        return listofteams;
    }

}
