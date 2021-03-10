package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        FootballPlayer footballPlayer = new FootballPlayer("Ebere");
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer("Johnny");
        HockerPlayer hockerPlayer = new HockerPlayer("Richard");

        Team <FootballPlayer> superStars = new Team<>("Football");
        superStars.addPlayer(footballPlayer);
        superStars.addPlayer(new FootballPlayer("Adele"));
        superStars.addPlayer(new FootballPlayer("Amara"));
        System.out.println(superStars.numPlayer());
        System.out.println(superStars.getName());


        Team <BaseBallPlayer> baseBallTeam2 = new Team<>("BaseBall2");
        Team <BaseBallPlayer> baseBallTeam = new Team<>("BaseBall");
        baseBallTeam .addPlayer(baseBallPlayer);
        baseBallTeam.addPlayer(new BaseBallPlayer("Tim"));
        baseBallTeam.matchResult(baseBallTeam2,6,3);
        System.out.println(baseBallTeam.numPlayer());


        Team <HockerPlayer> hockeyTeam = new Team<>("Hockey");
        hockeyTeam.addPlayer(hockerPlayer);
        System.out.println(hockeyTeam.numPlayer());

        //=====================League======================================//
        League<Team<FootballPlayer>> leagueFootball = new League<>("FIFA");
        Team <FootballPlayer> chelsea = new Team<>("chelsea ");
        Team <FootballPlayer> manu = new Team<>("manu");
        Team <FootballPlayer>  barcelone = new Team<>("barca");
        Team <FootballPlayer>  asernal = new Team<>("gunners");


        leagueFootball.addTeam(chelsea);
        leagueFootball.addTeam(manu);
        leagueFootball.addTeam(barcelone);
        leagueFootball.addTeam(asernal);
        leagueFootball.addTeam(chelsea);
        leagueFootball.showLeagueTable();










    }
}
