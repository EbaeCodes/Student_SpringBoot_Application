package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;

    public League(String name) {
        this.name = name;
    }

    ArrayList <T> teams = new ArrayList<>();

    public boolean addTeam(T players){
        if(this.teams.contains(players)){
            System.out.println(players.getName() + "already on team");
            return false;
        }else{
            teams.add(players);
            System.out.println(players.getName() + " added successfully ");
            return true;
        }
    }
    public void showLeagueTable(){
        Collections.sort(teams);
    for(T t : teams) {
            System.out.println(t.getName());
        }
    }

}
