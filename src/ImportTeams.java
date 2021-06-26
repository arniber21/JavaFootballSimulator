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

            Team.cb.name = "Xavien Howard";
            Team.cb.coverage = 20;
            Team.cb.playmake = 90;

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

            Team.cb.name = "Marcus Maye";
            Team.cb.coverage = 70;
            Team.cb.playmake = 30;

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

            Team.cb.name = "Marcus Peters";
            Team.cb.coverage = 90;
            Team.cb.playmake = 40;

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
            Team.rb.name = "Joe Mixon";
            Team.rb.speed = 90;
            Team.rb.elusive = 50;
            Team.rb.power = 10;

            Team.rb2.name = "Samje Perine";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 50;
            Team.rb2.power = 20;

            Team.rb3.name = "Trayvon Williams";
            Team.rb3.speed = 30;
            Team.rb3.elusive = 70;
            Team.rb3.power = 10;

            Team.lb.name = "Logan Wilson";
            Team.lb.power = 50;
            Team.lb.playmake = 30;

            Team.dt.name = "D.J. Reader";
            Team.dt.power = 80;
            Team.dt.playmake = 20;

            Team.cb.name = "Trae Waynes";
            Team.cb.coverage = 50;
            Team.cb.playmake = 60;

            Team.qb.name = "Joe Burrow";
            Team.qb.thp = 70;
            Team.qb.tha = 80;
            Team.qb.mob = 20;

            Team.wr.name = "JaMarr Chase";
            Team.wr.catching = 90;
            Team.wr.routerunning = 40;

            Team.wr2.name = "Tyler Boyd";
            Team.wr2.catching = 60;
            Team.wr2.routerunning = 50;

            Team.wr3.name = "Tee Higgins";
            Team.wr3.catching = 40;
            Team.wr3.routerunning = 80;

            Team.wr4.name = "Auden Tate";
            Team.wr4.catching = 50;
            Team.wr4.routerunning = 50;

            Team.wr5.name = "Mike Thomas";
            Team.wr5.catching = 90;
            Team.wr5.routerunning = 5;

            Team.wr6.name = "Trent Taylor";
            Team.wr6.catching = 20;
            Team.wr6.routerunning = 70;
        }
        if(Team.name.equals("Steelers")){
            Team.rb.name = "Najee Harris";
            Team.rb.speed = 60;
            Team.rb.elusive = 70;
            Team.rb.power = 70;

            Team.rb2.name = "Benny Snell";
            Team.rb2.speed = 90;
            Team.rb2.elusive = 10;
            Team.rb2.power = 10;

            Team.rb3.name = "Anthony McFarland";
            Team.rb3.speed = 50;
            Team.rb3.elusive = 50;
            Team.rb3.power = 30;

            Team.lb.name = "TJ Watt";
            Team.lb.power = 90;
            Team.lb.playmake = 40;

            Team.dt.name = "Tyson Alualu";
            Team.dt.power = 90;
            Team.dt.playmake = 20;

            Team.cb.name = "Minkah Fitzpatrick";
            Team.cb.coverage = 90;
            Team.cb.playmake = 50;

            Team.qb.name = "Ben Rothlesburger";
            Team.qb.thp = 60;
            Team.qb.tha = 90;
            Team.qb.mob = 10;

            Team.wr.name = "JuJu Smith-Schuster";
            Team.wr.catching = 50;
            Team.wr.routerunning = 90;

            Team.wr2.name = "Chase Claypool";
            Team.wr2.catching = 30;
            Team.wr2.routerunning = 70;

            Team.wr3.name = "Diontae Johnson";
            Team.wr3.catching = 60;
            Team.wr3.routerunning = 50;

            Team.wr4.name = "James Washington";
            Team.wr4.catching = 20;
            Team.wr4.routerunning = 90;

            Team.wr5.name = "Ray-Ray Mcloud";
            Team.wr5.catching = 30;
            Team.wr5.routerunning = 80;

            Team.wr6.name = "Mathew Sexton";
            Team.wr6.catching = 90;
            Team.wr6.routerunning = 5;
            
        }
        if(Team.name.equals("Browns")){
            Team.rb.name = "Nick Chubb";
            Team.rb.speed = 90;
            Team.rb.elusive = 70;
            Team.rb.power = 10;

            Team.rb2.name = "Kareem Hunt";
            Team.rb2.speed = 60;
            Team.rb2.elusive = 60;
            Team.rb2.power = 50;

            Team.rb3.name = "D'Ernest Johnson";
            Team.rb3.speed = 20;
            Team.rb3.elusive = 40;
            Team.rb3.power = 80;

            Team.lb.name = "Anthony Walker";
            Team.lb.power = 60;
            Team.lb.playmake = 60;

            Team.dt.name = "Myles Garett";
            Team.dt.power = 90;
            Team.dt.power = 60;

            Team.cb.name = "Denzel Ward";
            Team.cb.coverage = 90;
            Team.cb.playmake = 40;

            Team.qb.name = "Baker Mayfield";
            Team.qb.thp = 80;
            Team.qb.tha = 60;
            Team.qb.mob = 50;

            Team.wr.name = "Odell Beckham";
            Team.wr.catching = 90;
            Team.wr.routerunning = 50;

            Team.wr2.name = "Jarvis Landry";
            Team.wr2.catching = 50;
            Team.wr2.routerunning = 90;

            Team.wr3.name = "Rashard Higgins";
            Team.wr3.catching = 50;
            Team.wr.routerunning = 50;

            Team.wr4.name = "Donovan Peoples-Jones";
            Team.wr4.catching = 60;
            Team.wr4.routerunning = 50;

            Team.wr5.name = "Anthony Schwartz";
            Team.wr5.catching = 80;
            Team.wr5.routerunning = 10;

            Team.wr6.name = "KhaDarel Hodge";
            Team.wr6.catching = 30;
            Team.wr6.routerunning = 60;
        }
        if(Team.name.equals("Texans")){
            Team.rb.name = "David Johnson";
            Team.rb.speed = 90;
            Team.rb.elusive = 30;
            Team.rb.power = 5;

            Team.rb2.name = "Philip Lindsay";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 90;
            Team.rb2.power = 10;

            Team.rb3.name = "Melvin Ingram";
            Team.rb3.speed  = 50;
            Team.rb.elusive = 20;
            Team.rb.power = 70;

            Team.lb.name = "Zach Cunningham";
            Team.lb.power = 50;
            Team.lb.playmake = 70;

            Team.dt.name = "Maliek Collins";
            Team.dt.power = 50;
            Team.dt.playmake = 50;

            Team.cb.name = "Bradley Roby";
            Team.cb.coverage = 40;
            Team.cb.playmake = 70;

            Team.qb.name = "Deshaun Watson";
            Team.qb.thp = 80;
            Team.qb.tha = 70;
            Team.qb.mob = 70;

            Team.wr.name = "Brandin Cooks";
            Team.wr.routerunning = 90;
            Team.wr.catching = 40;

            Team.wr2.name = "Randall Cobb";
            Team.wr2.routerunning = 40;
            Team.wr2.catching = 70;

            Team.wr3.name = "Keke Coutee";
            Team.wr3.catching = 30;
            Team.wr3.routerunning = 90;

            Team.wr4.name = "Nico Collins";
            Team.wr4.catching = 90;
            Team.wr4.routerunning = 10;

            Team.wr5.name = "Chris Conley";
            Team.wr5.catching = 40;
            Team.wr5.routerunning = 40;

            Team.wr6.name = "Isaiah Coulter";
            Team.wr6.catching = 50;
            Team.wr6.routerunning = 30;
        }
        if(Team.name.equals("Colts")){
            Team.rb.name = "Jonathan Taylor";
            Team.rb.speed = 50;
            Team.rb.elusive = 50;
            Team.rb.power = 30;

            Team.rb2.name = "Marlon Mack";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 30;
            Team.rb2.power = 70;

            Team.rb3.name = "Nyheim Hines";
            Team.rb3.speed = 90;
            Team.rb3.elusive = 20;
            Team.rb3.power = 10;

            Team.lb.name = "Darius Leonard";
            Team.lb.power = 90;
            Team.lb.playmake = 70;

            Team.dt.name = "Deforeest Buckner";
            Team.dt.power = 90;
            Team.dt.playmake = 70;

            Team.cb.name = "Xavier Rhodes";
            Team.cb.coverage = 70;
            Team.cb.playmake = 40;

            Team.qb.name = "Carson Wentz";
            Team.qb.thp = 60;
            Team.qb.tha = 70;
            Team.qb.mob = 50;

            Team.wr.name = "TY Hilton";
            Team.wr.catching = 70;
            Team.wr.routerunning = 50;

            Team.wr2.name = "Paris Campbell";
            Team.wr2.catching = 30;
            Team.wr2.routerunning = 70;

            Team.wr3.name = "Michael Pitman";
            Team.wr3.catching = 50;
            Team.wr3.routerunning = 50;

            Team.wr4.name = "Zach Pascal";
            Team.wr4.catching = 40;
            Team.wr4.routerunning = 50;

            Team.wr5.name = "Ashton Dulin";
            Team.wr5.catching = 40;
            Team.wr5.routerunning = 50;

            Team.wr6.name = "DeMichael Harris";
            Team.wr6.catching = 70;
            Team.wr6.routerunning = 20;
        }
        if(Team.name.equals("Jaguars")){
            Team.rb.name = "James Robinson";
            Team.rb.speed = 30;
            Team.rb.elusive = 70;
            Team.rb.power = 80;

            Team.rb2.name = "Travis Etienne";
            Team.rb2.speed = 80;
            Team.rb2.elusive = 50;
            Team.rb2.power = 5;

            Team.rb3.name = "Carlos Hyde";
            Team.rb3.speed = 50;
            Team.rb3.elusive = 60;
            Team.rb3.power = 40;

            Team.lb.name = "Myles Jack";
            Team.lb.power = 70;
            Team.lb.playmake = 80;

            Team.dt.name = "Josh Allen";
            Team.dt.power = 80;
            Team.dt.playmake = 40;

            Team.cb.name = "Shaq Griffin";
            Team.cb.coverage = 80;
            Team.cb.playmake = 40;

            Team.qb.name = "Trevor Lawrence";
            Team.qb.thp = 90;
            Team.qb.tha = 90;
            Team.qb.mob = 10;

            Team.wr.name = "DJ Chark";
            Team.wr.catching = 50;
            Team.wr.routerunning = 50;

            Team.wr2.name = "Marvin Jones";
            Team.wr2.catching = 30;
            Team.wr2.routerunning = 70;

            Team.wr3.name = "Laviska Shenault";
            Team.wr3.catching = 70;
            Team.wr3.routerunning = 30;

            Team.wr4.name = "Colin Johnson";
            Team.wr4.catching = 10;
            Team.wr4.routerunning = 90;

            Team.wr5.name = "Philip Dorset";
            Team.wr5.catching = 50;
            Team.wr5.routerunning = 30;

            Team.wr6.name = "Jamal Agnew";
            Team.wr6.catching = 10;
            Team.wr6.routerunning = 70;
        }
        if(Team.name.equals("Titans")){
            Team.rb.name = "Derrick Henry";
            Team.rb.speed = 60;
            Team.rb.elusive = 30;
            Team.rb.power = 90;

            Team.rb2.name = "Jeremy McNichols";
            Team.rb2.speed = 70;
            Team.rb2.elusive = 10;
            Team.rb2.power = 10;

            Team.rb3.name = "Brian Hill";
            Team.rb3.speed = 60;
            Team.rb3.elusive = 30;
            Team.rb3.power = 40;

            Team.lb.name = "Rashaad Evans";
            Team.lb.power = 50;
            Team.lb.playmake = 60;

            Team.dt.name = "Jefery Simmons";
            Team.dt.power = 70;
            Team.dt.power = 30;

            Team.cb.name = "Kevin Byard";
            Team.cb.coverage = 90;
            Team.cb.playmake = 40;

            Team.qb.name = "Ryan Tanehill";
            Team.qb.thp = 50;
            Team.qb.tha = 90;
            Team.qb.mob = 30;

            Team.wr.name = "Julio Jones";
            Team.wr.catching = 90;
            Team.wr.routerunning = 50;

            Team.wr2.name = "AJ Brown";
            Team.wr2.catching = 80;
            Team.wr2.routerunning = 60;

            Team.wr3.name = "Josh Reynolds";
            Team.wr3.catching = 30;
            Team.wr3.routerunning = 80;

            Team.wr4.name = "Chester Rodgers";
            Team.wr4.catching = 80;
            Team.wr4.routerunning = 30;

            Team.wr5.name = "Dez Fitzpatrick";
            Team.wr5.catching = 30;
            Team.wr5.routerunning = 60;

            Team.wr6.name = "Cody Hollister";
            Team.wr6.catching = 70;
            Team.wr6.routerunning = 10;

        }
        if(Team.name.equals("Broncos")){
            Team.rb.name = "Melvin Gordon";
            Team.rb.speed = 60;
            Team.rb.elusive = 50;
            Team.rb.power = 50;

            Team.rb2.name = "Javonte Williams";
            Team.rb2.speed = 90;
            Team.rb2.elusive = 10;
            Team.rb2.power = 20;

            Team.rb3.name = "Royce Freeman";
            Team.rb3.speed = 40;
            Team.rb3.elusive = 20;
            Team.rb3.power = 90;

            Team.lb.name = "Von Miller";
            Team.lb.power = 90;
            Team.lb.playmake = 90;

            Team.dt.name = "Bradley Chubb";
            Team.dt.power = 90;
            Team.dt.playmake = 50;

            Team.cb.name = "Kyle Fuller";
            Team.cb.coverage = 90;
            Team.cb.playmake = 50;

            Team.qb.name = "Drew Lock";
            Team.qb.thp = 90;
            Team.qb.tha = 90;
            Team.qb.mob = 90;

            Team.wr.name = "Courtland Sutton";
            Team.wr.catching = 90;
            Team.wr.routerunning = 50;

            Team.wr2.name = "Jerry Jeudy";
            Team.wr2.catching = 60;
            Team.wr2.routerunning = 90;

            Team.wr3.name = "Tim Patrick";
            Team.wr3.catching = 50;
            Team.wr3.receptions = 50;

            Team.wr4.name = "KJ Hamler";
            Team.wr4.catching = 30;
            Team.wr4.routerunning = 60;

            Team.wr5.name = "Seth Williams";
            Team.wr5.catching = 90;
            Team.wr5.routerunning = 10;

            Team.wr6.name = "Diontae Spencer";
            Team.wr6.catching = 10;
            Team.wr6.routerunning = 90;
        }
        if(Team.name.equals("Chiefs")){
            Team.rb.name = "Clyde Edwards-Helaire";
            Team.rb.speed = 90;
            Team.rb.elusive = 10;
            Team.rb.power = 10;

            Team.rb2.name = "Darell Williams";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 50;
            Team.rb2.power = 20;

            Team.rb3.name = "Jerrick McKinnon";
            Team.rb3.speed = 60;
            Team.rb3.elusive = 10;
            Team.rb3.power = 40;

            Team.lb.name = "Nick Bolton";
            Team.lb.power = 40;
            Team.lb.playmake = 70;

            Team.dt.name = "Chris Jones";
            Team.dt.power = 90;
            Team.dt.playmake = 50;

            Team.cb.name = "Tyrann Matheiu";
            Team.cb.coverage = 60;
            Team.cb.playmake = 90;

            Team.qb.name = "Patrick Mahomes";
            Team.qb.thp = 90;
            Team.qb.tha = 90;
            Team.qb.mob = 50;

            Team.wr.name = "Tyreek Hill";
            Team.wr.catching = 40;
            Team.wr.routerunning = 100;

            Team.wr2.name = "Mecole Hardman";
            Team.wr2.catching = 10;
            Team.wr2.routerunning = 90;

            Team.wr3.name = "Demarcus Robinson";
            Team.wr3.catching = 40;
            Team.wr3.routerunning = 50;

            Team.wr4.name = "Byron Pringle";
            Team.wr4.catching = 70;
            Team.wr4.routerunning = 10;

            Team.wr5.name = "Cornell Powell";
            Team.wr5.catching = 30;
            Team.wr5.routerunning = 50;

            Team.wr6.name = "Marcus Kemp";
            Team.wr6.catching = 80;
            Team.wr6.routerunning = 5;

        }
        if(Team.name.equals("Chargers")){
            Team.rb.name = "Austin Ekeler";
            Team.rb.speed = 70;
            Team.rb.elusive = 30;
            Team.rb.power = 20;

            Team.rb2.name = "Justin Jackson";
            Team.rb2.speed = 50;
            Team.rb2.elusive = 40;
            Team.rb2.power = 50;

            Team.rb3.name = "Joshua Kelley";
            Team.rb3.speed = 90;
            Team.rb3.elusive = 10;
            Team.rb3.power = 5;

            Team.lb.name  = "Kenneth Murray";
            Team.lb.power = 60;
            Team.lb.playmake = 40;

            Team.dt.name  = "Joey Bosa";
            Team.dt.power = 90;
            Team.dt.playmake = 70;

            Team.cb.name = "Derwin James";
            Team.cb.coverage = 90;
            Team.cb.playmake = 40;

            Team.qb.name = "Justin Herbert";
            Team.qb.thp = 60;
            Team.qb.tha = 80;
            Team.qb.mob = 30;

            Team.wr.name = "Keenan Allen";
            Team.wr.routerunning = 40;
            Team.wr.catching = 90;

            Team.wr2.name = "Mike Williams";
            Team.wr2.catching = 40;
            Team.wr2.routerunning = 90;

            Team.wr3.name = "Jalen Gutyon";
            Team.wr3.catching = 50;
            Team.wr3.routerunning = 50;

            Team.wr4.name = "Tyron Johnson";
            Team.wr4.catching = 30;
            Team.wr4.routerunning = 70;

            Team.wr5.name = "Josh Palmer";
            Team.wr5.catching = 90;
            Team.wr5.routerunning = 10;

            Team.wr6.name = "Joe Reed";
            Team.wr6.catching = 10;
            Team.wr6.routerunning = 60;
        }
        if(Team.name.equals("Raiders")){
            Team.rb.name = "Josh Jacobs";
            Team.rb.speed = 90;
            Team.rb.elusive = 20;
            Team.rb.power = 10;

            Team.rb2.name = "Kenyan Drake";
            Team.rb2.speed = 60;
            Team.rb2.elusive = 40;
            Team.rb2.power = 40;

            Team.rb3.name = "Jalen Richard";
            Team.rb3.speed = 60;
            Team.rb3.elusive = 10;
            Team.rb3.power = 70;

            Team.lb.name = "Nicholas Morrow";
            Team.lb.power = 10;
            Team.lb.playmake = 50;

            Team.dt.name = "Max Crosby";
            Team.dt.power = 90;
            Team.dt.playmake = 40;

            Team.cb.name = "Trayvon Mullen";
            Team.cb.coverage = 20;
            Team.cb.playmake = 90;

            Team.qb.name = "Derek Carr";
            Team.qb.thp = 90;
            Team.qb.tha = 60;
            Team.qb.mob = 20;

            Team.wr.name = "Henry Ruggs";
            Team.wr.catching = 5;
            Team.wr.routerunning = 95;

            Team.wr2.name = "John Brown";
            Team.wr2.catching = 20;
            Team.wr2.routerunning = 90;

            Team.wr3.name = "Hunter Renfrow";
            Team.wr3.catching = 20;
            Team.wr3.routerunning = 80;

            Team.wr4.name = "";
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
