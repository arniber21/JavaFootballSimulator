import java.io.*;
import java.util.Scanner;
public class ImportTeams {
    String[] ListOfTeamNames = {"Bills","Dolphins","Patriots","Jets",
    "Ravens","Bengals","Browns","Steelers",
    "Texans","Colts","Jaguars","Titans",
    "Broncos","Chiefs","Raiders","Chargers",
    "Cowboys","Giants","Eagles","Redskins",
    "Bears","Lions","Packers","Vikings",
    "Falcons","Panthers","Saints","Buccaneers"
    ,"Cardinals","Rams","49ers","Seahawks"};
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

        Blue.qb.name = "Cam Newton";
        Blue.qb.thp = 80;
        Blue.qb.tha = 70;
        Blue.qb.mob = 70;

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
    public team createRandomTeam(String name){
        team Team = new team();
        Team.name = name;
        setPlayers(Team);
        return Team;
    }
    public void setPlayers(team Team){
        if(Team.name.equals("Bills")){
            Team.rb.name = "Devin Singletary";
            Team.rb.speed = 50;
            Team.rb.elusive = 40;
            Team.rb.power = 10;

            Team.rb2.name = "Zach Moss";
            Team.rb.speed = 50;
            Team.rb.elusive = 20;
            Team.rb.power = 30;

            Team.rb3.name = "Matt Breida";
            Team.rb3.speed = 70;
            Team.rb3.elusive = 10;
            Team.rb3.power = 10;

            Team.lb.name = "Tremaine Edmunds";
            Team.lb.playmake = 50;
            Team.lb.power = 90;

            Team.dt.name = "Ed Oliver";
            Team.dt.power = 90;
            Team.dt.playmake = 60;

            Team.cb.name = "Tredavious White";
            Team.cb.coverage = 90;
            Team.cb.playmake = 50;

            Team.qb.name = "Josh Allen";
            Team.qb.thp = 100;
            Team.qb.tha = 30;
            Team.qb.mob = 70;

            Team.wr.name = "Stephon Digs";
            Team.wr.catching = 20;
            Team.wr.routerunning = 90;

            Team.wr2.name = "Cole Beasly";
            Team.wr2.catching = 20;
            Team.wr2.routerunning = 70;

            Team.wr3.name = "Emmanuel Sanders";
            Team.wr3.catching = 90;
            Team.wr3.routerunning = 20;

            Team.wr4.name = "Isaiah Mckenzie";
            Team.wr4.catching = 30;
            Team.wr4.routerunning = 50;


            Team.wr5.name = "Gabriel Davis";
            Team.wr5.catching = 70;
            Team.wr.routerunning = 10;

            Team.wr6.name = "Jake Kumerow";
            Team.wr6.catching = 40;
            Team.wr6.routerunning = 40;
        }
        if(Team.name.equals("Dolphins")){
            Team.rb.name = "Myles Gaskin";
            Team.rb.speed = 50;
            Team.rb.elusive = 50;
            Team.rb.power = 50;

            Team.rb2.name = "Malcolm Brown";
            Team.rb3.speed = 80;
            Team.rb3.elusive = 40;
            Team.rb3.power = 10;

            Team.rb3.name = "Salvon Ahmed";
            Team.rb3.speed = 90;
            Team.rb3.elusive = 10;
            Team.rb3.power = 5;

            Team.lb.name = "Jerome Baker";
            Team.lb.playmake = 50;
            Team.lb.power = 50;

            Team.dt.name = "Raekwon Davis";
            Team.dt.power = 80;
            Team.dt.playmake = 40;

            Team.qb.name = "Tua Tagovailoa";
            Team.qb.thp = 60;
            Team.qb.tha = 80;
            Team.qb.mob = 20;

            Team.wr.name = "Devante Parker";
            Team.wr.catching = 50;
            Team.wr.routerunning = 50;

            Team.wr2.name = "Preston Williams";
            Team.wr2.catching = 30;
            Team.wr2.routerunning = 70;

            Team.wr3.name = "Jaylen Waddle";
            Team.wr3.catching = 20;
            Team.wr3.routerunning = 90;

            Team.wr4.name = "Jakeem Grant";
            Team.wr4.catching = 80;
            Team.wr4.routerunning = 20;

            Team.wr5.name = "Will Fuller";
            Team.wr5.routerunning = 90;
            Team.wr5.catching = 5;

            Team.wr6.name = "Albert Wilson";
            Team.wr6.catching = 50;
            Team.wr6.routerunning = 20;

        }
        if(Team.name.equals("Patriots")){
            Team.rb.name = "Damien Harris";
            Team.rb.speed = 90;
            Team.rb.elusive = 20;
            Team.rb.power = 10;

            Team.rb2.name = "James White";
            Team.rb2.speed = 70;
            Team.rb2.elusive = 90;
            Team.rb2.power = 40;

            Team.rb3.name = "Sony Michel";
            Team.rb3.speed = 50;
            Team.rb3.elusive = 50;
            Team.rb3.power = 10;

            Team.lb.name = "Donta Hightower";
            Team.lb.playmake = 80;
            Team.lb.power = 90;

            Team.dt.name = "Vince Wilfork";
            Team.dt.power = 70;
            Team.dt.playmake = 80;


            Team.cb.name = "Stephon Gilmore";
            Team.cb.coverage = 90;
            Team.cb.playmake = 90;

            Team.qb.name = "Cam Newton";
            Team.qb.thp = 80;
            Team.qb.tha = 70;
            Team.qb.mob = 70;

            Team.wr.name = "Julian Edelman";
            Team.wr.catching = 50;
            Team.wr.routerunning = 70;

            Team.wr2.name = "Nelson Agholor";
            Team.wr2.catching = 50;
            Team.wr2.routerunning = 80;

            Team.wr3.name = "Nkeal Harry";
            Team.wr3.catching = 90;
            Team.wr3.routerunning = 10;

            Team.wr4.name = "Jacobi Meyers";
            Team.wr4.catching = 20;
            Team.wr4.routerunning = 70;

            Team.wr5.name = "Wes Welker";
            Team.wr5.catching = 60;
            Team.wr5.routerunning = 50;

            Team.wr6.name = "Mathew Slater";
            Team.wr6.catching = 20;
            Team.wr6.routerunning = 90;
        }
        if(Team.name.equals("Jets")){
            Team.rb.name = "Frank Gore";
            Team.rb.speed = 40;
            Team.rb.elusive = 90;
            Team.rb.power = 70;

            Team.rb2.name = "Lamical Perine";
            Team.rb2.speed = 90;
            Team.rb2.elusive = 10;
            Team.rb3.power = 5;

            Team.rb3.name = "Michael Carter";
            Team.rb3.speed = 70;
            Team.rb3.elusive = 30;
            Team.rb3.power = 10;

            Team.lb.name = "CJ Mosley";
            Team.lb.playmake = 90;
            Team.lb.power = 40;

            Team.dt.name = "Quinen Williams";
            Team.dt.power = 90;
            Team.dt.playmake = 30;

            Team.qb.name = "Zach Wilson";
            Team.qb.tha = 40;
            Team.qb.thp = 90;
            Team.qb.mob = 40;

            Team.wr.name = "Corey Davis";
            Team.wr.catching = 90;
            Team.wr.routerunning = 30;

            Team.wr2.name = "Denzel Mims";
            Team.wr2.catching = 20;
            Team.wr3.routerunning = 70;

            Team.wr3.name = "Jamison Crowder";
            Team.wr3.catching = 90;
            Team.wr3.routerunning = 20;

            Team.wr4.name = "Elijah Moore";
            Team.wr4.catching = 20;
            Team.wr4.routerunning = 70;

            Team.wr5.name = "Keelan Cole";
            Team.wr5.catching = 30;
            Team.wr5.routerunning = 50;

            Team.wr6.name = "Braxton Berrios";
            Team.wr6.catching = 20;
            Team.wr6.routerunning = 50;

        }
        if(Team.name.equals("Ravens")){
            Team.rb.name = "JK Dobbins";
            Team.rb.speed = 90;
            Team.rb.elusive = 10;
            Team.rb.power = 10;

            Team.rb2.name = "Gus Edwards";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 40;
            Team.rb2.power = 30;

            Team.rb3.name = "Justice Hill";
            Team.rb3.speed = 20;
            Team.rb3.elusive = 20;
            Team.rb3.power = 80;

            Team.lb.name = "Patrick Queen";
            Team.lb.power = 90;
            Team.lb.playmake = 10;

            Team.dt.name = "Derek Wolfe";
            Team.dt.power = 90;
            Team.dt.playmake = 10;

            Team.qb.name = "Lamar Jackson";
            Team.qb.tha = 20;
            Team.qb.thp = 50;
            Team.qb.mob = 90;

            Team.wr.name = "Marquise Brown";
            Team.wr.catching = 5;
            Team.wr.routerunning = 90;

            Team.wr2.name = "Devin Duvernay";
            Team.wr2.catching = 50;
            Team.wr2.routerunning = 50;
            
            Team.wr3.name = "Sammy Watkins";
            Team.wr3.catching = 20;
            Team.wr3.routerunning = 60;

            Team.wr4.name = "Rashod Bateman";
            Team.wr4.catching = 10;
            Team.wr4.routerunning = 80;

            Team.wr5.name = "Miles Boykin";
            Team.wr5.catching = 10;
            Team.wr5.routerunning = 50;

            Team.wr6.name = "James Proche II";
            Team.wr6.catching = 90;
            Team.wr6.routerunning = 5;  
        }
        if(Team.name.equals("Bengals")){
            
        }
        if(Team.name.equals("Steelers")){
            
        }
        if(Team.name.equals("Browns")){
            
        }
        if(Team.name.equals("Texans")){
            
        }
        if(Team.name.equals("Colts")){
            
        }
        if(Team.name.equals("Jaguars")){
            
        }
        if(Team.name.equals("Titans")){
            
        }
        if(Team.name.equals("Broncos")){
            
        }
        if(Team.name.equals("Chiefs")){
            
        }
        if(Team.name.equals("Chargers")){
            
        }
        if(Team.name.equals("Raiders")){
            
        }
        if(Team.name.equals("Cowboys")){
            
        }
        if(Team.name.equals("Eagles")){
            
        }

        if(Team.name.equals("Giants")){
            
        }
        if(Team.name.equals("Footbal Team")){
            
        }
        if(Team.name.equals("Bears")){
            
        }
        if(Team.name.equals("Lions")){
            
        }
        if(Team.name.equals("Packers")){
            
        }
        if(Team.name.equals("Vikings")){
            
        }
        if(Team.name.equals("Falcons")){
            
        }
        if(Team.name.equals("Panthers")){
            
        }
        if(Team.name.equals("Saints")){
            
        }
        if(Team.name.equals("Buccaneers")){
            Team.rb.name = "Leonard Fournette";
            Team.rb.speed = 90;
            Team.rb.elusive = 20;
            Team.rb.power = 10;

            Team.rb2.name = "Ronald Jones";
            Team.rb2.speed = 60;
            Team.rb2.elusive = 50;
            Team.rb2.power = 70;

            Team.rb3.name = "LeShaun McCoy";
            Team.rb3.speed = 30;
            Team.rb3.elusive = 30;
            Team.rb3.power = 90;

            Team.lb.name = "Lavonte David";
            Team.lb.playmake = 70;
            Team.lb.power = 70;


            Team.dt.name = "Ndamukong Suh";
            Team.dt.power = 70;
            Team.dt.playmake = 80;

            Team.cb.name = "Carlton Davis";
            Team.cb.coverage = 90;
            Team.cb.playmake = 90;

            Team.qb.name = "Tom Brady";
            Team.qb.thp = 60;
            Team.qb.tha = 90;
            Team.qb.mob = 10;


            Team.wr.name = "Chris Godwin";
            Team.wr.catching = 80;
            Team.wr.routerunning = 30;

            Team.wr2.name = "Mike Evans";
            Team.wr2.catching = 90;
            Team.wr2.routerunning = 10;

            Team.wr3.name = "Scotty Miller";
            Team.wr3.catching = 10;
            Team.wr3.routerunning = 90;

            Team.wr4.name = "Antonio Brown";
            Team.wr4.catching = 50;
            Team.wr4.routerunning = 50;

            Team.wr5.name = "Tyler Johnson";
            Team.wr5.catching = 70;
            Team.wr5.routerunning = 10;

            Team.wr6.name = "Justin Watson";
            Team.wr6.catching = 10;
            Team.wr6.routerunning = 70;
        }
        if(Team.name.equals("Cardinals")){
            
        }
        if(Team.name.equals("Rams")){
            
        }
        if(Team.name.equals("49ers")){
            
        }
        if(Team.name.equals("Seahawks")){
            
        }
        if(Team.name.equals("Bills")){
            
        }
        if(Team.name.equals("Bills")){
            
        }
    }

}
