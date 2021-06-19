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

        Red.rb3.name = "LeShaun McCoy";
        Red.rb3.speed = 30;
        Red.rb3.elusive = 30;
        Red.rb3.power = 90;

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

        Red.wr3.name = "Scotty Miller";
        Red.wr3.catching = 10;
        Red.wr3.routerunning = 90;

        Red.wr4.name = "Antonio Brown";
        Red.wr4.catching = 50;
        Red.wr4.routerunning = 50;

        Red.wr5.name = "Tyler Johnson";
        Red.wr5.catching = 70;
        Red.wr5.routerunning = 10;

        Red.wr6.name = "Justin Watson";
        Red.wr6.catching = 10;
        Red.wr6.routerunning = 70;


        Blue.rb.name = "Damien Harris";
        Blue.rb.speed = 90;
        Blue.rb.elusive = 20;
        Blue.rb.power = 10;

        Blue.rb2.name = "James White";
        Blue.rb2.speed = 70;
        Blue.rb2.elusive = 90;
        Blue.rb2.power = 40;

        Blue.rb3.name = "Sony Michel";
        Blue.rb3.speed = 50;
        Blue.rb3.elusive = 50;
        Blue.rb3.power = 10;

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
        Blue.wr.catching = 50;
        Blue.wr.routerunning = 70;

        Blue.wr2.name = "Nelson Agholor";
        Blue.wr2.catching = 50;
        Blue.wr2.routerunning = 80;

        Blue.wr3.name = "Nkeal Harry";
        Blue.wr3.catching = 90;
        Blue.wr3.routerunning = 10;

        Blue.wr4.name = "Jacobi Meyers";
        Blue.wr4.catching = 20;
        Blue.wr4.routerunning = 70;

        Blue.wr5.name = "Wes Welker";
        Blue.wr5.catching = 60;
        Blue.wr5.routerunning = 50;

        Blue.wr6.name = "Mathew Slater";
        Blue.wr6.catching = 20;
        Blue.wr6.routerunning = 90;
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
