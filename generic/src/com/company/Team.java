package com.company;

import java.util.ArrayList;

public class Team <T extends Player> implements  Comparable<Team<T>> {
    private String name;
    private int lost = 0;

    public String getName() {
        return name;
    }

    public Team(String name) {
        this.name = name;
    }

    private  int won = 0;
    private int tied = 0;
    private int played = 0;

    private ArrayList<T> members = new ArrayList<>();

    public boolean addPlayer(T player){

        if(members.contains(player)){
            System.out.println(player.getName()+ "already on list");
            return false;
        }
        else{
            members.add(player);
            System.out.println(player.getName()+ " selected for team "+ this.name);
            return true;
        }
    }
    public int numPlayer(){
        return this.members.size();
    }

    public void matchResult(Team<T> opp,int ourScore,int theirScore){
        String message;
        if(ourScore > theirScore){
            won++;
            message = "won";
        }else if(ourScore == theirScore){
            tied++;
            message = "draw";
        }else{
            lost++;
            message = "lost";
        }
        if(opp != null){
            System.out.println(this.getName()+ " "+message + " "+opp.getName() );
            opp.matchResult(null,ourScore,theirScore);
        }
    }

   public int ranking(){
        return (won * 2) + tied;
   }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        }else if (this.ranking() < team.ranking()){
            return 1;
        }else {
            return 0;
        }
    }
}
